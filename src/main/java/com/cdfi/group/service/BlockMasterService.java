package com.cdfi.group.service;

import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.cdfi.group.filter.JWTTokenNeeded;
import com.cdfi.group.model.BlockMaster;
import com.cdfi.group.repository.BlockMasterRepository;
import org.springframework.stereotype.Service;


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
    public Iterable<BlockMaster> getBlockMaster() {

	    return blockMasterRepository.findAll();
    }
	@GET
    @Path("jwt/{id}")
    @Produces("application/json")
    @JWTTokenNeeded
    public Response getBlockMasterById(@PathParam("id") BigInteger id) throws URISyntaxException
    {
        Optional<BlockMaster> bm = blockMasterRepository.findById(id);
        if(bm == null) {
            return Response.status(404).build();
        }
        return Response
                .status(200)
                .entity(bm).build();
        
    }

}
