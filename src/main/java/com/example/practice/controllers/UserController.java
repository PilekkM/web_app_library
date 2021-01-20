package com.example.practice.controllers;

import com.example.practice.entities.User;
import com.example.practice.services.UserService;
import org.dom4j.rule.Mode;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    UserController(UserService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findAllUsers(ModelAndView model){
        model.addObject("users", service.getUsers());
        model.setViewName("users");
        return model;
    }

    @RequestMapping(value="/new", method=RequestMethod.POST)
    public ModelAndView addUser(@RequestParam String name, @RequestParam String surname, @RequestParam(value = "personal_id") String personalId, @RequestParam int age, ModelAndView model){
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setPersonalId(personalId);
        user.setAge(age);
        service.addUser(user);
        model.addObject("users", service.getUsers());
        model.setViewName("users");
        return model;
    }

    @RequestMapping(value = "/new")
    public String newUser(){
        return "add_user_form";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ModelAndView deleteUser(@RequestBody String body, ModelAndView modelAndView){
        JSONObject jsonObject = new JSONObject(body);
        User user = new User();
        user.setName(jsonObject.getString("name"));
        user.setSurname(jsonObject.getString("surname"));
        user.setAge(jsonObject.getInt("age"));
        user.setPersonalId(jsonObject.getString("personal_id"));
        user.setId(jsonObject.getInt("id"));
        service.deleteUser(user);
        modelAndView.addObject("users", service.getUsers());
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @RequestMapping("/update/{userId}")
    public ModelAndView prepareUpdateUser(@PathVariable int userId, ModelAndView model){
        User user = service.getUserById(userId);

        model.addObject("user", user);
        model.setViewName("update_user_form");
        return model;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ModelAndView updateUser(@RequestBody String body, ModelAndView model){
        JSONObject jsonObject = new JSONObject(body);
        User user = new User();
        user.setId(jsonObject.getInt("userId"));
        user.setName(jsonObject.getString("name"));
        user.setSurname(jsonObject.getString("surname"));
        user.setAge(jsonObject.getInt("age"));
        user.setPersonalId(jsonObject.getString("personalId"));
        service.updateUser(user);

        model.addObject("users", service.getUsers());
        model.setViewName("users");
        return model;
    }

}
