package com.mySpringProject.demo.modules.greeting.interactors;

import com.mySpringProject.demo.modules.greeting.entity.CelebrantEntity;
import com.mySpringProject.demo.modules.greeting.entity.CelebrationEntity;
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
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CelebrantUseCaseImpl implements CelebrantUseCase {
  private final CelebrantRepository celebrantRepository;
  private final CelebrationRepository celebrationRepository;
  private final UserEntityRepository userRepository;

  public CelebrantUseCaseImpl(
      CelebrantRepository celebrantRepository,
      CelebrationRepository celebrationRepository,
      UserEntityRepository userRepository) {
    this.celebrantRepository = celebrantRepository;
    this.celebrationRepository = celebrationRepository;
    this.userRepository = userRepository;
  }

  @Override
  public AddCelebrantDTO.Output add(AddCelebrantDTO.Input input, UUID userId) {

    if (userRepository.findById(userId).isEmpty()) {
      // todo throw
    }

    var user = userRepository.findById(userId).get();
    var celebrant =
        new CelebrantEntity(
            user,
            input.getFirstName(),
            input.getLastName(),
            input.getEmail(),
            input.getPhoneNumber(),
            input.getAlias());
    celebrantRepository.save(celebrant);

    return new AddCelebrantDTO.Output(CelebrantMapper.convert(celebrant));
  }

  @Override
  public AddCelebrationDTO.Output addCelebration(AddCelebrationDTO.Input input, UUID celebrantId) {

    if (celebrantRepository.findById(celebrantId).isEmpty()) {

      // todo throw a exception
    }
    var celebrant = celebrantRepository.findById(celebrantId).get();
    var celebrations =
        input.getCelebrations().stream()
            .map(
                celebration ->
                    new CelebrationEntity(
                        celebration.getCelebrationType(),
                        celebration.getMessage(),
                        celebration.getDateOfCelebration(),
                        celebration.getTimeOfCelebration(),
                        celebrant))
            .collect(Collectors.toSet());
    celebrationRepository.saveAll(celebrations);
    celebrant.addCelebration(celebrations);
    celebrantRepository.save(celebrant);
    return CelebrationMapper.convert(celebrant);
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
  public ListCelebrationDTO.Output listCelebrations(UUID celebrantId) {
    var celebrations = celebrantRepository.findById(celebrantId).get().getCelebrations();
    return null;
  }
  // get all celebrations for a particular celebrant

}
