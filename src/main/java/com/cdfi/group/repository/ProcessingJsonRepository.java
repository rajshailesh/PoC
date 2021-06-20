package com.cdfi.group.repository;

import com.cdfi.group.model.ProcessingJsonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ProcessingJsonRepository extends JpaRepository<ProcessingJsonEntity, BigInteger> {
}
