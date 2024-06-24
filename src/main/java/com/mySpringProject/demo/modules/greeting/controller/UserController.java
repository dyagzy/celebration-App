package com.mySpringProject.demo.modules.greeting.controller;

import com.mySpringProject.demo.modules.CelebrationUrls;
import com.mySpringProject.demo.modules.greeting.interactors.CelebrantUseCase;
import com.mySpringProject.demo.modules.greeting.models.AddUserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CelebrationUrls.UserController.PATH)
public class UserController {
  private final CelebrantUseCase celebrantUseCase;

  public UserController(CelebrantUseCase celebrantUseCase) {
    this.celebrantUseCase = celebrantUseCase;
  }

  @PostMapping
  public AddUserDTO.Output add(@RequestBody AddUserDTO.Input input){
    return celebrantUseCase.addUser(input);

  }
}
