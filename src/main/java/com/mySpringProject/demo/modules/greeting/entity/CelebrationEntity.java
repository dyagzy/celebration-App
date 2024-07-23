package com.mySpringProject.demo.modules.greeting.entity;

import com.mySpringProject.demo.modules.greeting.enums.CelebrationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "celebrations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CelebrationEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "celebration_name")
  private String name;

  @Column(name = "date_of_celebration", nullable = false)
  private String dateOfCelebration;

  @Column(name = "time_of_celebration", nullable = false)
  private String timeOfCelebration;

  @NotNull private String message;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "celebrant_id", nullable = false)
  private CelebrantEntity celebrant;

  @NotNull
  @Column(name = "celebration_type", nullable = false)
  @Enumerated(EnumType.STRING)
  private CelebrationType celebrationType;

  @Column(name = "alias_name")
  private String alias;

  public CelebrationEntity(
      CelebrationType type, String message, String date, String time, CelebrantEntity celebrant) {

    this.celebrationType = type;
    this.timeOfCelebration = time;
    this.dateOfCelebration = date;
    this.message = message;
    this.celebrant = celebrant;
  }
}
