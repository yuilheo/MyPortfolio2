package com.myportfolio.web.controller;

import com.myportfolio.web.domain.UserDto;
import com.myportfolio.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String signup2(UserDto userDto, RedirectAttributes rattr){
        String msg;
        try {
            userService.signUp(userDto);
            msg = "회원가입에 성공했습니다";
            rattr.addFlashAttribute("msg",msg);
            return "redirect:/";
        } catch (Exception e) {
            msg = "회원가입에 실패했습니다";
            rattr.addFlashAttribute("msg",msg);
            return "redirect:/signup";
        }
    }
}
