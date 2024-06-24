package com.mySpringProject.demo.modules.greeting.models;

import com.mySpringProject.demo.modules.greeting.shared.Celebrant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AddCelebrantDTO {
  private AddCelebrantDTO() {
    throw new IllegalArgumentException();
  }

  @Getter
  public static class Input {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String alias;
    private List<CelebrantModel> celebrations;
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Output {
    private Celebrant celebrant;
  }
}
