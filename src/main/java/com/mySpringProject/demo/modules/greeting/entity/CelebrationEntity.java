package com.mySpringProject.demo.modules.greeting.entity;

import com.mySpringProject.demo.modules.greeting.enums.CelebrationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "celebrations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CelebrationEntity {
  @Id private Long id;
  @Column(name = "celebration_name")
  private String name;

  @Column(name = "date_of_celebration", nullable = false)
  private String dateOfCelebration;

  private String message;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "celebrant_id", nullable = false)
  private CelebrantEntity celebrant;

  @Column(name = "celebration_type", nullable = false)
  @Enumerated(EnumType.STRING)
  private CelebrationType celebrationType;

  @Column(name = "alias_name")
  private String alias;

  public CelebrationEntity(
      CelebrantEntity celebrant,
      String name,
      String dateOfCelebration,
      String message,
      CelebrationType celebrationType) {
    this.name = name;
    this.dateOfCelebration = dateOfCelebration;
    this.message = message;
    this.celebrant = celebrant;
    this.celebrationType = celebrationType;
  }
}
