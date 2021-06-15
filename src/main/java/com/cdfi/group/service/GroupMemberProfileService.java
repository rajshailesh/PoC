package com.cdfi.group.service;

import com.cdfi.group.domain.SHGProfile;

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
import java.io.InputStream;
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
                                  @FormDataParam("file") List<InputStream> files,
                                  @Context HttpHeaders headers) {

        logger.info("SHG Profile" + shgProfile.getShg_name());
        shgProfile.setUploaded_by(headers.getHeaderString("User"));
        logger.info("SHG Profile" + shgProfile.getUploaded_by());
        return Response.ok().build();
    }
}
