package com.myportfolio.web.controller;

import com.myportfolio.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginInfoController {
    @Autowired
    UserService userService;

    @GetMapping("/find")
    public String find(){
        return "logininfo";
    }
    @PostMapping("/idinfo")
    public String idinfo(String emaill){
        try {
            userService.selectUserID(emaill);
        } catch (Exception e) {
            return "index";
        }
        return "index";
    }

    @PostMapping("/pwdinfo")
    public String pwdinfo(String id,String emaill){
        try {
            userService.selectUserPwd(id);
        } catch (Exception e) {
            return "index";
        }
        return "index";
    }
}
