package com.spring.userability.service.serviceImpl;

import com.spring.userability.model.User;
import com.spring.userability.repository.UserabilityRepository;
import com.spring.userability.service.UserabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserabilityServiceImpl implements UserabilityService {

  @Autowired
  UserabilityRepository userRepository;

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User findById(long id) {
    return userRepository.findById(id).get();
  }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public void delete(long id) {
    userRepository.deleteById(id);
  }
}
