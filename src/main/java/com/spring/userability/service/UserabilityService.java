package com.spring.userability.service;

import com.spring.userability.model.User;

import java.util.List;

public interface UserabilityService {
  List<User> findAll();
  User findById(long id);
  User save(User user);
  void delete(long id);
}
