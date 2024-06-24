package com.mySpringProject.demo.modules.greeting.models;

import com.mySpringProject.demo.modules.greeting.enums.CelebrationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CelebrantModel {

  private CelebrationType celebrationType;
  private String dateOfCelebration;
  private String timeOfCelebration;
  private int frequencyOfCelebration;
  private String message;

}
