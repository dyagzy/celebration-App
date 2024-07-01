package com.mySpringProject.demo.modules.greeting.repository;

import com.mySpringProject.demo.modules.greeting.entity.CelebrantEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CelebrantRepository extends JpaRepository<CelebrantEntity, UUID> {
}
