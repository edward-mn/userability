package com.spring.userability.service;

import com.spring.userability.model.User;

import java.util.List;
import java.util.Map;

public interface UserabilityService {
  List<User> findAll();
  User findById(long id);
  User save(User user);
  void delete(long id);
  User update(long id, User user);
  User refresh(long id, Map<String, Object> request);
}
