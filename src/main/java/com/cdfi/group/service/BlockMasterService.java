package com.cdfi.group.service;

import com.cdfi.group.filter.JWTTokenNeeded;
import com.cdfi.group.model.BlockMasterEntity;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.math.BigInteger;


@Service
@Path("/blockmaster")
public class BlockMasterService {


    @PersistenceContext
    private EntityManager em;


    @RolesAllowed({"SHG Bookkeeper", "VPRP CRP"})
    @GET
    @Path("jwt/{id}")
    @Produces("application/json")
    @JWTTokenNeeded
    public Response getBlockMasterById(@PathParam("id") BigInteger id) {
        BlockMasterEntity bm = em.find(BlockMasterEntity.class, id);
        if(bm == null) {
            return Response.status(404).build();
        }
        return Response
                .status(200)
                .entity(bm).build();
        
    }

}
