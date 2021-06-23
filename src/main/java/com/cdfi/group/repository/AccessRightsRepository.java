package com.cdfi.group.repository;


import com.cdfi.group.model.AccessRightsEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface AccessRightsRepository extends CrudRepository<AccessRightsEntity, BigInteger>{

}
