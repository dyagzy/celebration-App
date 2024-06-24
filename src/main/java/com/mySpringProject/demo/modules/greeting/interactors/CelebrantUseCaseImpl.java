package com.mySpringProject.demo.modules.greeting.interactors;

import com.mySpringProject.demo.modules.greeting.entity.CelebrantEntity;
import com.mySpringProject.demo.modules.greeting.entity.UserEntity;
import com.mySpringProject.demo.modules.greeting.mappers.CelebrantMapper;
import com.mySpringProject.demo.modules.greeting.mappers.CelebrationMapper;
import com.mySpringProject.demo.modules.greeting.models.AddCelebrantDTO;
import com.mySpringProject.demo.modules.greeting.models.AddCelebrationDTO;
import com.mySpringProject.demo.modules.greeting.models.AddUserDTO;
import com.mySpringProject.demo.modules.greeting.models.ListCelebrationDTO;
import com.mySpringProject.demo.modules.greeting.repository.CelebrantRepository;
import com.mySpringProject.demo.modules.greeting.repository.CelebrationRepository;
import com.mySpringProject.demo.modules.greeting.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class CelebrantUseCaseImpl implements CelebrantUseCase {
  private CelebrantRepository celebrantRepository;
  private CelebrationRepository celebrationRepository;
  private UserEntityRepository userRepository;

  public CelebrantUseCaseImpl(
      CelebrantRepository celebrantRepository,
      CelebrationRepository celebrationRepository,
      UserEntityRepository userRepository) {
    this.celebrantRepository = celebrantRepository;
    this.celebrationRepository = celebrationRepository;
    this.userRepository = userRepository;
  }

  @Override
  public AddCelebrantDTO.Output add(AddCelebrantDTO.Input input, Long userId) {

    if (userRepository.findById(userId).isEmpty()) {
      // todo throw
    }
    var celebrant = new CelebrantEntity(userRepository.findById(userId).get(), null);
    celebrantRepository.save(celebrant);

    return new AddCelebrantDTO.Output(CelebrantMapper.convert(celebrant));
  }

  @Override
  public AddCelebrationDTO.Output addCelebration(
      AddCelebrationDTO.Input input, Long celebrationId) {

    if (celebrantRepository.findById(celebrationId).isEmpty()) {

      // todo throw a exception
    }
    var celebrant = celebrantRepository.findById(celebrationId).get();
    var celebration =
        celebrant.addCelebration(
            input.getTitle(),
            input.getDateOfCelebration(),
            input.getCelebrationMessage(),
            input.getCelebrationType());
    celebrationRepository.save(celebration);

    return new AddCelebrationDTO.Output(CelebrationMapper.convert(celebration));
  }

  @Override
  public AddUserDTO.Output addUser(AddUserDTO.Input input) {
    var user =
        new UserEntity(
            input.getFirstName(), input.getLastName(), input.getPassword(), input.getEmail());
    userRepository.save(user);
    return new AddUserDTO.Output(user.getId(), user.getFirstName(), user.getLastName());
  }

  @Override
  public ListCelebrationDTO.Output listCelebrations(Long celebrantId) {
    var celebrations = celebrantRepository.findById(celebrantId).get().getCelebrations();
    return null;
  }
  // get all celebrations for a particular celebrant

}
