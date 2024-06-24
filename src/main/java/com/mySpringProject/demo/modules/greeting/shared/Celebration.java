package com.mySpringProject.demo.modules.greeting.shared;

import com.mySpringProject.demo.modules.greeting.enums.CelebrationType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Celebration {
  private Long id;
  private String title;
  private String dateOfCelebration;
  private CelebrationType celebrationType;
  private String remark;
}
