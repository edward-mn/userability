package com.spring.userability.utils;

import com.spring.userability.model.User;
import com.spring.userability.repository.UserabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class fakeData {

  @Autowired
  UserabilityRepository userRepository;

  @PostConstruct
  public void savePosts(){
    List<User> userList = new ArrayList<>();

    User firstUser = new User();
    firstUser.setName("Edward Moreira");
    firstUser.setPermission("Super Admin");
    firstUser.setDate(LocalDate.now());


    User secondUser = new User();
    secondUser.setName("Roger Melo");
    secondUser.setPermission("Admin");
    secondUser.setDate(LocalDate.now());

    userList.add(firstUser);
    userList.add(secondUser);

    System.out.println("The List --- " + userList);

    for(User user: userList){
      User userSaved = userRepository.save(user);
      System.out.println("User ID: " + userSaved.getId());
    }
  }
}
