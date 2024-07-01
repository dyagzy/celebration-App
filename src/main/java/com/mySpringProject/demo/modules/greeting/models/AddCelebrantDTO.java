package com.mySpringProject.demo.modules.greeting.models;

import com.mySpringProject.demo.modules.greeting.shared.Celebrant;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AddCelebrantDTO {
  private AddCelebrantDTO() {
    throw new IllegalArgumentException();
  }

  @Getter
  @Setter
  public static class Input {
    @NotNull private String firstName;
    @NotNull private String lastName;
    @NotNull private String email;
    @NotNull private String phoneNumber;
    private String alias;
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Output {
    private Celebrant celebrant;
  }
}
