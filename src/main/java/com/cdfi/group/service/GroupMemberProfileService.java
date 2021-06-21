package com.cdfi.group.service;

import com.cdfi.group.domain.SHGProfile;
import com.cdfi.group.filter.JWTTokenNeeded;
import com.cdfi.group.model.CircularQueuePointerEntity;
import com.cdfi.group.model.LookUpMasterEntity;
import com.cdfi.group.model.ProcessingJsonEntity;
import com.cdfi.group.model.TransactionStatusEntity;
import com.cdfi.group.repository.CircularQueuePointerRepository;
import com.cdfi.group.repository.ProcessingJsonRepository;
import com.cdfi.group.repository.TransactionStatusRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import org.glassfish.jersey.media.multipart.BodyPartEntity;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@Service
@Path("/group")
@Transactional
public class GroupMemberProfileService {
    @PersistenceContext
    private EntityManager em;

    private static final Logger logger = Logger.getLogger(GroupMemberProfileService.class.getName());
    ProcessingJsonRepository processingJsonRepository;
    TransactionStatusRepository transactionStatusRepository;
    CircularQueuePointerRepository circularQueuePointerRepository;


    public GroupMemberProfileService(ProcessingJsonRepository processingJsonRepository,
                                     TransactionStatusRepository transactionStatusRepository,
                                     CircularQueuePointerRepository circularQueuePointerRepository) {
        this.processingJsonRepository = processingJsonRepository;
        this.transactionStatusRepository = transactionStatusRepository;
        this.circularQueuePointerRepository = circularQueuePointerRepository;
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    @RolesAllowed({"SHG Bookkeeper", "VPRP CRP"})
    @JWTTokenNeeded
    public Response uploadProfile(@FormDataParam("shgProfile") SHGProfile shgProfile,
                                  @FormDataParam("files") List<FormDataBodyPart> files,
                                  @Context HttpHeaders headers) throws JsonProcessingException {
        ObjectMapper Obj = new ObjectMapper();

        String strJson =  Obj.writeValueAsString(shgProfile); ;
        try {
            validateJson(strJson);
        } catch (IOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        String userId = headers.getHeaderString("User");
        logger.info("SHG Profile" + shgProfile.getShg_name());
        shgProfile.setUploaded_by(userId);
        shgProfile.setTransaction_id("2021052117143123");
        logger.info("SHG Profile" + shgProfile.getUploaded_by());
        StringBuilder fileDetails = new StringBuilder();

        /* Save multiple files */
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy-hh-mm-ss");
        Date date = new Date();
        String strDate = formatter.format(date);
        String defaultBaseDir = System.getProperty("java.io.tmpdir");
        String path = defaultBaseDir.concat(strDate);
        for (FormDataBodyPart bodyPart : files){
            /*
             * Casting FormDataBodyPart to BodyPartEntity, which can give us
             * InputStream for uploaded file
             */
            BodyPartEntity bodyPartEntity = (BodyPartEntity) bodyPart.getEntity();
            String fileName = bodyPart.getContentDisposition().getFileName();

            try {
                File file = new File(path);
                if(!file.exists() && !file.mkdirs()){
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Unable to copy file on File System at " + path).build();
                }
                saveFile(bodyPartEntity.getInputStream(), fileName, path);
            } catch (IOException e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
            }
            fileDetails.append(" File saved at ").append(path).append(":").append(fileName);
        }

        createJson(strJson, shgProfile.getTransaction_id(),
                userId, path);

        return Response.ok().entity("Message added to Mobile Queue : " + fileDetails).build();
    }
    private void saveFile(InputStream file, String name, String dirPath) throws IOException {

        /* Change directory path */
            java.nio.file.Path path = FileSystems.getDefault().getPath(dirPath + File.separator + name);
            /* Save InputStream as file */
            Files.copy(file, path, StandardCopyOption.REPLACE_EXISTING);

    }
    private void createJson(String json, String transactionId, String userId,
                            String path){
        ProcessingJsonEntity processingJsonEntity = new ProcessingJsonEntity();
        setIdInProcessingJsonEntity(processingJsonEntity);
        processingJsonEntity.setJson(json);
        processingJsonEntity.setCboType(LookUpMasterEntity.shgLookupVal);
        processingJsonEntity.setFlag(ProcessingJsonEntity.noReadFlag);
        processingJsonEntity.setCreatedDate(LocalDateTime.now());
        processingJsonEntity.setTransactionId(transactionId);
        processingJsonEntity.setFiles(path);
        em.persist(processingJsonEntity);

        if(transactionId!=null) {
            TransactionStatusEntity transactionStatusEntity =
                    new TransactionStatusEntity();
            transactionStatusEntity.setReadFlag(Boolean.FALSE);
            transactionStatusEntity.setStatus(TransactionStatusEntity.pending);
            transactionStatusEntity.setTransactionId(transactionId);
            transactionStatusEntity.setUserId(userId);
            em.persist(transactionStatusEntity);
        }
    }
    private Response validateJson(String strJson) throws IOException {
        InputStream jsonStream = new ByteArrayInputStream(strJson.getBytes());
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream schemaStream = classLoader.getResourceAsStream("group-profile-json-schema.json");
        // create instance of the ObjectMapper class
        ObjectMapper objectMapper = new ObjectMapper();
        // create an instance of the JsonSchemaFactory using version flag
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance( SpecVersion.VersionFlag.V201909 );
        // read data from the stream and store it into JsonNode
        JsonNode json = objectMapper.readTree(jsonStream);

        // get schema from the schemaStream and store it into JsonSchema
        JsonSchema schema = schemaFactory.getSchema(schemaStream);

        // create set of validation message and store result in it
        Set<ValidationMessage> validationResult = schema.validate( json );
        if(!validationResult.isEmpty()){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(validationResult).build();
        }else{
            return Response.ok().build();
        }

    }
    private void setIdInProcessingJsonEntity(ProcessingJsonEntity processingJsonEntity){
        Optional<CircularQueuePointerEntity> circularQueuePointerEntity =  circularQueuePointerRepository.findById(1);
        BigInteger front = circularQueuePointerEntity.get().getFront();
        BigInteger rear = circularQueuePointerEntity.get().getRear();
        BigInteger capacity = circularQueuePointerEntity.get().getCapacity();
        BigInteger zeroBigInteger = new BigInteger("0");
        BigInteger oneBigInteger = new BigInteger("1");


        //ENQUEUE
        if(front.equals(zeroBigInteger) && rear.equals(zeroBigInteger))   // condition to check queue is empty
        {
            front=oneBigInteger;
            rear=oneBigInteger;
            processingJsonEntity.setId(front);
        }
        else if((rear.add(oneBigInteger)).mod(capacity).equals(front) ) // condition to check queue is full
        {
            front=oneBigInteger;
            rear=oneBigInteger;
            processingJsonEntity.setId(front);
            logger.info("Queue is overflow,Resetting Queue");
        }
        else
        {
            rear=(rear).mod(capacity);       // rear is incremented
            processingJsonEntity.setId(rear.add(oneBigInteger));
            circularQueuePointerEntity.get().setRear(rear.add(oneBigInteger));

        }

    }
}
