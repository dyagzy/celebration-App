package com.mySpringProject.demo.modules.greeting.controller;

import com.mySpringProject.demo.modules.CelebrationUrls.CelebrationController;
import com.mySpringProject.demo.modules.greeting.interactors.CelebrantUseCase;
import com.mySpringProject.demo.modules.greeting.models.AddCelebrationDTO;
import com.mySpringProject.demo.modules.greeting.models.ListCelebrationDTO;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CelebrationController.PATH)
public class CelebrationsController {
  private final CelebrantUseCase celebrantUseCase;

  public CelebrationsController(CelebrantUseCase celebrantUseCase) {
    this.celebrantUseCase = celebrantUseCase;
  }

  @PostMapping(CelebrationController.POST_CELEBRATION)
  public AddCelebrationDTO.Output addCelebration(
      @RequestBody AddCelebrationDTO.Input input, @PathVariable ("celebrantId") UUID celebrantId) {
    return celebrantUseCase.addCelebration(input, celebrantId);
  }

  @GetMapping(CelebrationController.GET_LIST_CELEBRATION)
  public ListCelebrationDTO.Output listCelebrations(@PathVariable("celebrantId") UUID celebrantId){

    return celebrantUseCase.listCelebrations(celebrantId);

  }
}

//@PathVariable("templateId") UUID templateId
