package com.myportfolio.web.controller;

import com.myportfolio.web.domain.UserDto;
import com.myportfolio.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/login")
    public String loginForm(){
        return "/";
    }

    @PostMapping("/login")
    public String login(String id, String pwd, boolean rememberId,
                        HttpServletRequest request
                        ,HttpServletResponse response) throws UnsupportedEncodingException {
        String msg = null;
        if(rememberId){
            Cookie cookie = new Cookie("id",id);
            response.addCookie(cookie);
        }else{
            Cookie cookie = new Cookie("id",id);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        try {
            UserDto userDto = userService.selectUser(id);
            if(userDto.getPwd().equals(pwd)){
                HttpSession session = request.getSession();
                session.setAttribute("id",id);
                return "redirect:/";
            }
            else{
                msg= URLEncoder.encode("비밀번호가 틀렸습니다","utf-8");
                return "redirect:/?msg="+msg;
            }
        } catch (Exception e) {
            msg= URLEncoder.encode("id가 틀립니다","utf-8");
        return "redirect:/?msg="+msg;

        }

    }
}
