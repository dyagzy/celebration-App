package com.mySpringProject.demo.modules.greeting.controller;

import com.mySpringProject.demo.modules.CelebrationUrls;
import com.mySpringProject.demo.modules.greeting.interactors.CelebrantUseCase;
import com.mySpringProject.demo.modules.greeting.models.AddCelebrantDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CelebrationUrls.CelebrantController.PATH)
public class CelebrantController {
  private final CelebrantUseCase celebrantUseCase;

  public CelebrantController(CelebrantUseCase celebrantUseCase) {
    this.celebrantUseCase = celebrantUseCase;
  }

  @PostMapping(CelebrationUrls.CelebrantController.POST_CELEBRANT)
  public AddCelebrantDTO.Output add(
      @RequestBody AddCelebrantDTO.Input input, @PathVariable Long userId) {

    return celebrantUseCase.add(input, userId);
  }
}
