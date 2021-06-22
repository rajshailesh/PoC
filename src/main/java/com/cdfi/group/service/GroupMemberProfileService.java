package com.cdfi.group.service;

import com.cdfi.group.Error.DataNotFoundException;
import com.cdfi.group.Error.JsonValidationError;
import com.cdfi.group.domain.SHGProfile;
import com.cdfi.group.filter.JWTTokenNeeded;
import com.cdfi.group.model.CircularQueuePointerEntity;
import com.cdfi.group.model.LookUpMasterEntity;
import com.cdfi.group.model.ProcessingJsonEntity;
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
                                  @Context HttpHeaders headers) throws JsonProcessingException, JsonValidationError {
        ObjectMapper Obj = new ObjectMapper();

        String strJson =  Obj.writeValueAsString(shgProfile);
        try {
            Set<ValidationMessage> validationMessages = validateJson(strJson);
            if(!validationMessages.isEmpty()){
                StringBuilder sb = new StringBuilder();
                for (ValidationMessage val : validationMessages) {
                    sb.append(val).append(",");
                }
                return Response.status(Response.Status.EXPECTATION_FAILED).entity("Json has validation error " + sb).build();
            }
        } catch (IOException e) {
            return Response.status(Response.Status.EXPECTATION_FAILED).entity(e.getMessage()).build();
        }

        String userId = headers.getHeaderString("User");
        logger.info("SHG Name: " + shgProfile.getShg_name());
        shgProfile.setUploaded_by(userId);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String strDate = formatter.format(new Date());
        // Following line will be commented as calling program will set transaction id in Json
        shgProfile.setTransaction_id(strDate);
        logger.info("SHG Profile Uploaded By: " + shgProfile.getUploaded_by());
        StringBuilder fileDetails = new StringBuilder();

        /* Save multiple files */
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
                path);

        return Response.ok().entity("Message added to Mobile Queue : " + fileDetails).build();
    }
    private void saveFile(InputStream file, String name, String dirPath) throws IOException {

        /* Change directory path */
            java.nio.file.Path path = FileSystems.getDefault().getPath(dirPath + File.separator + name);
            /* Save InputStream as file */
            Files.copy(file, path, StandardCopyOption.REPLACE_EXISTING);

    }
    private void createJson(String json, String transactionId,
                            String path) throws DataNotFoundException {
        ProcessingJsonEntity processingJsonEntity = new ProcessingJsonEntity();
        setIdInProcessingJsonEntity(processingJsonEntity);
        processingJsonEntity.setJson(json);
        processingJsonEntity.setCboType(LookUpMasterEntity.shgLookupVal);
        processingJsonEntity.setFlag(ProcessingJsonEntity.noReadFlag);
        processingJsonEntity.setCreatedDate(LocalDateTime.now());
        processingJsonEntity.setTransactionId(transactionId);
        processingJsonEntity.setFiles(path);
        em.persist(processingJsonEntity);

    }
    private Set<ValidationMessage> validateJson(String strJson) throws IOException {
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
        return schema.validate( json );
    }
    private void setIdInProcessingJsonEntity(ProcessingJsonEntity processingJsonEntity) throws DataNotFoundException {
        Optional<CircularQueuePointerEntity> circularQueuePointer =  circularQueuePointerRepository.findById(1);
        CircularQueuePointerEntity circularQueuePointerEntity;
        if(circularQueuePointer.isPresent()){
            circularQueuePointerEntity = circularQueuePointer.get();
        }else {
            throw new DataNotFoundException("No record found in CircularQueuePointerEntity");
        }
        BigInteger front = circularQueuePointerEntity.getFront();
        BigInteger rear = circularQueuePointerEntity.getRear();
        BigInteger capacity = circularQueuePointerEntity.getCapacity();
        BigInteger zeroBigInteger = new BigInteger("0");
        BigInteger oneBigInteger = new BigInteger("1");


        //ENQUEUE
        if(front.equals(zeroBigInteger) && rear.equals(zeroBigInteger))   // condition to check queue is empty
        {
            processingJsonEntity.setId(front);
        }
        else if((rear.add(oneBigInteger)).mod(capacity).equals(front) ) // condition to check queue is full
        {
            rear=oneBigInteger;
            processingJsonEntity.setId(front);
            circularQueuePointerEntity.setRear(rear);
            logger.info("Queue is overflow,Resetting Queue");
        }
        else
        {
            rear=(rear).mod(capacity);       // rear is incremented
            processingJsonEntity.setId(rear.add(oneBigInteger));
            circularQueuePointerEntity.setRear(rear.add(oneBigInteger));
        }
        em.persist(circularQueuePointerEntity);

    }
}
