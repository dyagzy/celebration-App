package com.mySpringProject.demo.modules.greeting.shared;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Celebrant {
  private Long id;
  private String firstName;
  private String lastName;
  private String emailAddress;
  private String phoneNumber;
}
