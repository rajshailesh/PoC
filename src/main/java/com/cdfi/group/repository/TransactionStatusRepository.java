package com.cdfi.group.repository;

import com.cdfi.group.model.TransactionStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface TransactionStatusRepository extends JpaRepository<TransactionStatusEntity, BigInteger> {


}
