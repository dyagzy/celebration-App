package com.mySpringProject.demo.modules.greeting.models;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AddUserDTO {
  private AddUserDTO() {
    throw new IllegalArgumentException();
  }

  @Getter
  @Setter
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
    private UUID id;
    private String firstName;
    private String lastName;

  }

}
