package com.mySpringProject.demo.modules.greeting.models;

import com.mySpringProject.demo.modules.greeting.shared.Celebration;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AddCelebrationDTO {
  private AddCelebrationDTO() {
    throw new IllegalArgumentException();
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  public static class Input {
    private List<CelebrantModel> celebrations;
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Setter
  @Getter
  public static class Output {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private List<Celebration> celebrations;
  }
}
