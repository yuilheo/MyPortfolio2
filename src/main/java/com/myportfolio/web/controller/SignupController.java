package com.myportfolio.web.controller;

import com.myportfolio.web.domain.UserDto;
import com.myportfolio.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class SignupController {

    @Autowired
    UserService userService;
    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signup2(UserDto userDto) throws UnsupportedEncodingException {
        String msg;
        try {
            userService.signUp(userDto);
            msg = URLEncoder.encode("회원가입에 성공했습니다","utf-8");
            return "redirect:/?msg="+msg;
        } catch (Exception e) {
            msg = URLEncoder.encode("회원가입에 실패했습니다","utf-8");
            return "redirect:/signup?msg="+msg;
        }
    }
}
