package com.mySpringProject.demo.modules.greeting.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "celebrant")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CelebrantEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotNull
  @Column(name = "first_name", nullable = false)
  private String firstName;

  @NotNull
  @Column(name = "last_name")
  private String lastName;

  @NotNull
  @Column(name = "email_address")
  private String emailAddress;

  @NotNull
  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "alias")
  private String alias;

  @OneToMany(
      mappedBy = "celebrant",
      fetch = FetchType.LAZY,
      cascade = {CascadeType.ALL})
  private Set<CelebrationEntity> celebrations;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

  public CelebrantEntity(
      UserEntity user,
      String firstName,
      String lastName,
      String emailAddress,
      String phoneNumber,
      String alias) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
    this.phoneNumber = phoneNumber;
    this.alias = alias;
    this.user=user;
  }

  public CelebrantEntity addCelebration(
      Set<CelebrationEntity> celebrations) {

    this.celebrations=celebrations;
    return  this;
  }

  // add user api
  // add celebrant
  // add celebration api

  // user a can add a celebrant and each celebrant can have multiple celebrations

}
