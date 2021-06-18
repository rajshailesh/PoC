package com.cdfi.group.service;

import com.cdfi.group.filter.JWTTokenNeeded;
import com.cdfi.group.model.BlockMasterEntity;
import com.cdfi.group.repository.BlockMasterRepository;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.Optional;


@Service
//@XmlAccessorType(XmlAccessType.NONE)
//@XmlRootElement(name = "users")
@Path("/blockmaster")
public class BlockMasterService {
	
	
	BlockMasterRepository blockMasterRepository;
	
	
	
	public BlockMasterService(BlockMasterRepository repository) {

	    this.blockMasterRepository = repository;
	}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<BlockMasterEntity> getBlockMaster() {

	    return blockMasterRepository.findAll();
    }
	@RolesAllowed({"SHG Bookkeeper", "VPRP CRP"})
    @GET
    @Path("jwt/{id}")
    @Produces("application/json")
    @JWTTokenNeeded
    public Response getBlockMasterById(@PathParam("id") BigInteger id) {
        Optional<BlockMasterEntity> bm = blockMasterRepository.findById(id);
        if(!bm.isPresent()) {
            return Response.status(404).build();
        }
        return Response
                .status(200)
                .entity(bm).build();
        
    }

}
