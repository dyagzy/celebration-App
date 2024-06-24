package com.mySpringProject.demo.modules.greeting.entity;

import com.mySpringProject.demo.modules.greeting.enums.CelebrationType;
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
import java.util.Set;
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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email_address")
  private String emailAddress;

  @Column(name = "phone_number")
  private String phoneNumber;

  @OneToMany(
      mappedBy = "celebrant",
      fetch = FetchType.LAZY,
      cascade = {CascadeType.ALL})
  private Set<CelebrationEntity> celebrations;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

  public CelebrantEntity(UserEntity user, Set<CelebrationEntity> celebrations) {
    this.user = user;
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
    this.phoneNumber = phoneNumber;
  }

  public CelebrationEntity addCelebration(
      String name, String dateOfCelebration, String message, CelebrationType celebrationType) {

    var celebration =
        new CelebrationEntity(this, name, dateOfCelebration, message, celebrationType);

    this.celebrations.add(celebration);
    return celebration;
  }

  // add user api
  // add celebrant
  // add celebration api

  // user a can add a celebrant and each celebrant can have multiple celebrations

}
