package com.mySpringProject.demo.modules.greeting.interactors;

import com.mySpringProject.demo.modules.greeting.models.AddCelebrantDTO;
import com.mySpringProject.demo.modules.greeting.models.AddCelebrationDTO;
import com.mySpringProject.demo.modules.greeting.models.AddUserDTO;
import com.mySpringProject.demo.modules.greeting.models.ListCelebrationDTO;

public interface CelebrantUseCase {
  AddCelebrantDTO.Output add(AddCelebrantDTO.Input input, Long userId);
  AddCelebrationDTO.Output addCelebration(AddCelebrationDTO.Input input, Long celebrationId);
  AddUserDTO.Output addUser(AddUserDTO.Input input);

  ListCelebrationDTO.Output listCelebrations(Long celebrantId);
}
