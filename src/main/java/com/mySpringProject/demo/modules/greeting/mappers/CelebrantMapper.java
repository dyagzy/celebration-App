package com.mySpringProject.demo.modules.greeting.mappers;

import com.mySpringProject.demo.modules.greeting.entity.CelebrantEntity;
import com.mySpringProject.demo.modules.greeting.shared.Celebrant;

public class CelebrantMapper {
  public static Celebrant convert(CelebrantEntity entity) {

    if (entity == null) {

      return new Celebrant();
    }
    return new Celebrant(
        entity.getId(),
        entity.getFirstName(),
        entity.getLastName(),
        entity.getEmailAddress(),
        entity.getPhoneNumber(),
        entity.getAlias());
  }

  // brokerageteam@afrinvest.com
}
