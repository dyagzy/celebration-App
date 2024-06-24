package com.mySpringProject.demo.modules.greeting.models;

import com.mySpringProject.demo.modules.greeting.enums.CelebrationType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CelebrantModel {

  private CelebrationType celebrationName;
  private String dateOfCelebration;
  private String timeOfCelebration;
  private int frequencyOfCelebration;
  private String message;

}
