package com.mySpringProject.demo.modules.greeting.shared;

import com.mySpringProject.demo.modules.greeting.enums.CelebrationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Celebration {
  private CelebrationType celebrationType;
  private String message;
  private String date;
}
