package com.mySpringProject.demo.modules.greeting.mappers;

import com.mySpringProject.demo.modules.greeting.entity.CelebrationEntity;
import com.mySpringProject.demo.modules.greeting.shared.Celebration;

public class CelebrationMapper {
//  public static Celebrant convert(CelebrantEntity celebrant) {
//
//    if (celebrant == null) {
//      return new Celebrant();
//    }
//    return new Celebrant(
//        celebrant.getId(),
//        celebrant.getFirstName(),
//        celebrant.getLastName(),
//        celebrant.getEmailAddress(),
//        celebrant.getPhoneNumber());
//  }


  public static Celebration convert(CelebrationEntity entity) {
    if (entity == null) {
      return new Celebration();
    }

    return new Celebration(
        entity.getId(),
        entity.getName(),
        entity.getDateOfCelebration(),
        entity.getCelebrationType(),
        null);
  }
}
