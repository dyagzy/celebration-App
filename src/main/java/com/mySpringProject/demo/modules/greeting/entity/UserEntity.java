package com.mySpringProject.demo.modules.greeting.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserEntity {

  @OneToMany(
      mappedBy = "user",
      fetch = FetchType.LAZY,
      cascade = {CascadeType.ALL})
  Set<CelebrantEntity> celebrants;
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)

  @Column(name = "id", updatable = false, nullable = false, length = 36)
  private UUID id;
  @NotNull
  @Column(name = "first_name")
  private String firstName;
  @NotNull
  @Column(name = "last_name")
  private String lastName;
  @NotNull
  @Column(name = "password")
  private String password;
  @Column(name = "email")
  @NotNull
  private String email;

  public UserEntity(String firstName, String lastName, String password, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.email = email;
  }
}
