package com.spring.userability.controller;

import com.spring.userability.model.User;
import com.spring.userability.service.UserabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
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

  @RequestMapping(value = "/newuser", method = RequestMethod.GET)
  public String newUser(){
    return "newUser";
  }

  @RequestMapping(value = "/newuser", method = RequestMethod.POST)
  public String saveUser(@Valid User user, BindingResult result, RedirectAttributes attributes){
    if(result.hasErrors()){
      return "redirect:/newuser";
    }
    user.setDate(LocalDate.now());
    userService.save(user);

    return "redirect:/users";
  }

  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public String deleteUser(long id){
    User user = userService.findById(id);
    userService.delete(user.getId());

    return "redirect:/users";
  }

  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
  public ModelAndView userDetails(@PathVariable("id") long id){
    ModelAndView mv = new ModelAndView("userDetails");
    User user = userService.findById(id);
    mv.addObject("user", user);
    return mv;
  }

  @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
  public String updateUser(@Valid User user, BindingResult result, RedirectAttributes attributes){
    if(result.hasErrors()){
      return "redirect:/user/{id}";
    }
    user.setDate(LocalDate.now());
    userService.save(user);

    return "redirect:/users";
  }

}
