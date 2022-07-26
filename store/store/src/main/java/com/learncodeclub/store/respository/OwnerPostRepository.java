package com.learncodeclub.store.respository;

import com.learncodeclub.store.entity.OwnerPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerPostRepository extends JpaRepository<OwnerPostEntity, Long> {
}
