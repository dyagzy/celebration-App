package com.mySpringProject.demo.modules.greeting.interactors;

import com.mySpringProject.demo.modules.greeting.models.AddCelebrantDTO;
import com.mySpringProject.demo.modules.greeting.models.AddCelebrationDTO;
import com.mySpringProject.demo.modules.greeting.models.AddUserDTO;
import com.mySpringProject.demo.modules.greeting.models.ListCelebrationDTO;
import java.util.UUID;

public interface CelebrantUseCase {
  AddCelebrantDTO.Output add(AddCelebrantDTO.Input input, UUID userId);
  AddCelebrationDTO.Output addCelebration(AddCelebrationDTO.Input input, UUID celebrationId);
  AddUserDTO.Output addUser(AddUserDTO.Input input);

  ListCelebrationDTO.Output listCelebrations(UUID celebrantId);
}
