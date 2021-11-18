package com.spring.userability.controller;

import com.spring.userability.model.User;
import com.spring.userability.service.UserabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserabilityController {

  @Autowired
  UserabilityService userService;

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public ModelAndView getPosts(){
    ModelAndView mv = new ModelAndView("users");
    List<User> allUsers = userService.findAll();
    mv.addObject("users", allUsers);
    return mv;
  }
}
