package com.mySpringProject.demo.modules.greeting.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AddUserDTO {
  private AddUserDTO() {
    throw new IllegalArgumentException();
  }

  @Getter
  public static class Input {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Data
  public static class Output{
    private Long id;
    private String firstName;
    private String lastName;

  }

}
