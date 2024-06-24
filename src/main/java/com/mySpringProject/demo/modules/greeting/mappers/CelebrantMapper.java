package com.mySpringProject.demo.modules.greeting.mappers;

import com.mySpringProject.demo.modules.greeting.entity.CelebrantEntity;
import com.mySpringProject.demo.modules.greeting.shared.Celebrant;

public class CelebrantMapper {
  public static Celebrant convert(CelebrantEntity celebrant) {

    if (celebrant == null) {
      return new Celebrant();
    }
    return new Celebrant(
        celebrant.getId(),
        celebrant.getFirstName(),
        celebrant.getLastName(),
        celebrant.getEmailAddress(),
        celebrant.getPhoneNumber());
  }

  // brokerageteam@afrinvest.com
}
