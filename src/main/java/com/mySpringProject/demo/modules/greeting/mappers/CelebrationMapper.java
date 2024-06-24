package com.mySpringProject.demo.modules.greeting.mappers;

import com.mySpringProject.demo.modules.greeting.entity.CelebrantEntity;
import com.mySpringProject.demo.modules.greeting.models.AddCelebrationDTO;
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

  public static AddCelebrationDTO.Output convert(CelebrantEntity entity) {
    if (entity == null) {
      return new AddCelebrationDTO.Output();
    }
    var celebrations =
        entity.getCelebrations().stream()
            .map(x -> new Celebration(x.getCelebrationType(), x.getMessage(), "2020-01"))
            .toList();

    return new AddCelebrationDTO.Output(
        entity.getId(),
        entity.getFirstName(),
        entity.getLastName(),
        entity.getEmailAddress(),
        entity.getPhoneNumber(),
        celebrations);
  }
}
