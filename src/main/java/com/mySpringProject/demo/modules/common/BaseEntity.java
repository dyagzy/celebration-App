package com.mySpringProject.demo.modules.common;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import java.time.Instant;
import java.util.UUID;
import lombok.EqualsAndHashCode;

public abstract class BaseEntity {
  @Id
  @Column(name = "id", nullable = false)
  @EqualsAndHashCode.Include
  private UUID id;

  @Column(name = "created_at", nullable = false, updatable = false)
  private long createdAt;

  @Column(name = "modified_at", nullable = false)
  private long modifiedAt;

  protected BaseEntity( UUID id,  Instant createdAt) {
    this.id = id;
    this.createdAt = createdAt.toEpochMilli();
  }

  protected BaseEntity() {
    this(UUID.randomUUID(), Instant.now());
  }

  protected BaseEntity( UUID id) {
    this(id, Instant.now());
  }
}
