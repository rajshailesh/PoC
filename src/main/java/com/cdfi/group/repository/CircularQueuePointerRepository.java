package com.cdfi.group.repository;

import com.cdfi.group.model.CircularQueuePointerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CircularQueuePointerRepository extends JpaRepository<CircularQueuePointerEntity, Integer> {
}
