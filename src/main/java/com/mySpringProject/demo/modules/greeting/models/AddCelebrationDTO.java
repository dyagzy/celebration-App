package com.mySpringProject.demo.modules.greeting.models;

import com.mySpringProject.demo.modules.greeting.shared.Celebration;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
  public static class Output {

    private Celebration celebration;
  }
}
