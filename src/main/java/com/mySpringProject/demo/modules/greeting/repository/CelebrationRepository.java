package com.mySpringProject.demo.modules.greeting.repository;

import com.mySpringProject.demo.modules.greeting.entity.CelebrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CelebrationRepository extends JpaRepository<CelebrationEntity, Long> {
}
