package com.spring.userability.service.serviceImpl;

import com.spring.userability.model.User;
import com.spring.userability.repository.UserabilityRepository;
import com.spring.userability.service.UserabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

  @Override
  public User update(long id, User user) {
    User aUser = findById(id);
    aUser.setName(user.getName());
    aUser.setPermission(user.getPermission());
    aUser.setDate(LocalDate.now());
    return userRepository.save(aUser);
  }

  @Override
  public User refresh(long id, Map<String, Object> request) {
    // String, Object -> key : value (JSON)

    /*User aUser = userRepository.findById(id).orElseThrow(() -> {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID not found.");
    });

    request.forEach((key, value) -> {
      Field field = ReflectionUtils.findField(User.class, key);
      field.setAccessible(true);
      ReflectionUtils.setField(field, aUser, value);
    });

    return userRepository.save(aUser);*/
    return null;
  }

}

