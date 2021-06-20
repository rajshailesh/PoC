package com.cdfi.group.service;

import com.cdfi.group.domain.SHGProfile;
import org.glassfish.jersey.media.multipart.BodyPartEntity;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
@Path("/group")
public class GroupMemberProfileService {
    private static final Logger logger = Logger.getLogger(GroupMemberProfileService.class.getName());

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("application/json")
    @RolesAllowed("Admin")
    public Response uploadProfile(@FormDataParam("shgProfile") SHGProfile shgProfile,
                                  @FormDataParam("files") List<FormDataBodyPart> files,
                                  @Context HttpHeaders headers) {

        logger.info("SHG Profile" + shgProfile.getShg_name());
        shgProfile.setUploaded_by(headers.getHeaderString("User"));
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

        return Response.ok().entity("Message added to Mobile Queue : " + fileDetails).build();
    }
    private void saveFile(InputStream file, String name, String dirPath) throws IOException {

        /* Change directory path */
            java.nio.file.Path path = FileSystems.getDefault().getPath(dirPath + File.separator + name);
            /* Save InputStream as file */
            Files.copy(file, path, StandardCopyOption.REPLACE_EXISTING);

    }
}
