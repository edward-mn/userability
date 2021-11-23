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
public class FakeData {

  @Autowired
  UserabilityRepository userRepository;

//  @PostConstruct
  public void savePosts(){
    List<User> userList = new ArrayList<>();

//    User firstUser = new User(
//        "Vagner Souza",
//        "User",
//        LocalDate.now());
//
//    User secondUser = new User(
//        "Roger Melo",
//        "User",
//        LocalDate.now());

//    userList.add(firstUser);
//    userList.add(secondUser);

    for(User user: userList){
      User userSaved = userRepository.save(user);
      System.out.println(userSaved.toString() + "\n");
    }
  }
}
