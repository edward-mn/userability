package com.spring.userability.controller;

import com.spring.userability.model.User;
import com.spring.userability.repository.UserabilityRepository;
import com.spring.userability.service.UserabilityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "API REST - User")
@CrossOrigin(origins = "*")
public class UserabilityResource {

  @Autowired
  UserabilityRepository userRepository;

  @Autowired
  UserabilityService userService;

  @GetMapping("/users")
  @ApiOperation(value= "Return a list of Users")
  public List<User> allUsers(){
    return userRepository.findAll();
  }

  @GetMapping("/user/{id}")
  @ApiOperation(value= "Return a specific A User")
  public User onlyUser(@PathVariable long id){
    return userRepository.findById(id).get();
  }

  @DeleteMapping("/user/{id}")
  @ResponseStatus
  @ApiOperation(value= "Delete a specific user")
  public User deleteUser(@PathVariable long id){
    User deletingUser = userRepository.findById(id).get();
    userRepository.delete(deletingUser);

    return deletingUser;
  }

  @PostMapping("/user")
  @ApiOperation(value= "Create a new user")
  public User newUser(@RequestBody User user){
    return userRepository.save(user);
  }

  @PutMapping("/user/{id}")
  @ApiOperation(value= "Update a specific user")
  public User updateUser(@PathVariable long id, @RequestBody User user){
    return userService.update(id, user);
  }

  @PatchMapping("/user/{id}")
  public User updateUser(@PathVariable long id, @RequestBody Map<String, Object> request){
    return userService.update(id, (User) request);
    }
}
