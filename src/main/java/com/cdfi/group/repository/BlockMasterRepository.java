package com.cdfi.group.repository;


import com.cdfi.group.model.BlockMaster;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface BlockMasterRepository extends CrudRepository<BlockMaster, BigInteger>{

}
