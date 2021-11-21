package com.spring.userability.controller;

import com.spring.userability.model.User;
import com.spring.userability.repository.UserabilityRepository;
import com.spring.userability.service.UserabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class UserabilityResource {

  @Autowired
  UserabilityRepository userRepository;

  @Autowired
  UserabilityService userService;

  @GetMapping("/users")
  public List<User> allUsers(){
    return userRepository.findAll();
  }

  @GetMapping("/user/{id}")
  public User onlyUser(@PathVariable long id){
    return userRepository.findById(id).get();
  }

  @DeleteMapping("/user/{id}")
  @ResponseStatus
  public User deleteUser(@PathVariable long id){
    User deletingUser = userRepository.findById(id).get();
    userRepository.delete(deletingUser);

    return deletingUser;
  }

  @PostMapping("/user")
  public User newUser(@RequestBody User user){
    return userRepository.save(user);
  }

  @PutMapping("/user/{id}")
  public User updateUser(@PathVariable long id, @RequestBody User user){
    return userService.update(id, user);
  }

  @PatchMapping("/user/{id}")
  public User updateUser(@PathVariable long id, @RequestBody Map<String, Object> request){
    return userService.update(id, (User) request);
    }
}
