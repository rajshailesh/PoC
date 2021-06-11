package com.cdfi.group.config;

import com.cdfi.group.filter.JWTTokenNeededFilter;
import com.cdfi.group.service.BlockMasterService;
import com.cdfi.group.service.GroupMemberProfileService;
import com.cdfi.group.service.UserEndpoint;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.Provider;


@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(BlockMasterService. class);
        register(UserEndpoint. class);
        register(JWTTokenNeededFilter. class);
        register(GroupMemberProfileService.class);
        register(MultiPartFeature.class);
    }
}
