package com.myportfolio.web.controller;

import com.myportfolio.web.domain.UserDto;
import com.myportfolio.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(String id, String pwd){
        try {
            UserDto userDto = userService.selectUser(id);
            if(userDto.getPwd().equals(pwd)){
                return "index";
            }
        } catch (Exception e) {
            return "index";
        }
        return "index";
    }
}
