package com.myportfolio.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class WriteController {
    @GetMapping("/write")
    public String write(HttpServletRequest request) throws UnsupportedEncodingException {
        String msg;
        if(!loginCheck(request)) {
            msg = URLEncoder.encode("로그인 하세영","utf-8");
            return "redirect:/?msg="+msg;
        }
        return "write";
    }

    private boolean loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute("id")!=null;
    }
}
