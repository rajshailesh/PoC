package com.cdfi.group.config;

import com.cdfi.group.filter.JWTTokenNeededFilter;
import com.cdfi.group.service.BlockMasterService;
import com.cdfi.group.service.UserEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.Provider;


@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        //packages("com.cdfi.group.service");
        //packages("com.cdfi.group.filter");
        register(BlockMasterService. class);
        register(UserEndpoint. class);
        register(JWTTokenNeededFilter. class);
    }
}
