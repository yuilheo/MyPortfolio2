package com.myportfolio.web.controller;

import com.myportfolio.web.domain.UserDto;
import com.myportfolio.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                        , HttpServletResponse response,
                        RedirectAttributes rattr){
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
                session.setAttribute("nick_name",userDto.getNick_name());
                return "redirect:/";
            }
            else{
                msg= "비밀 번호가 틀렸스빈다";
                rattr.addFlashAttribute("msg",msg);
                return "redirect:/";
            }
        } catch (Exception e) {
            msg= "id가 틀림";
            rattr.addFlashAttribute("msg",msg);
        return "redirect:/";

        }

    }
}
