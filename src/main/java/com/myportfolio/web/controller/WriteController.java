package com.myportfolio.web.controller;

import com.myportfolio.web.domain.BoardDto;
import com.myportfolio.web.domain.UserDto;
import com.myportfolio.web.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class WriteController {
    @Autowired
    BoardService boardService;

    @PostMapping("/modify")
    public String modifyE(Integer bno,String title,String content,Model m,HttpSession session,RedirectAttributes rattr){
        String writer = (String)session.getAttribute("nick_name");
        String b_id = (String)session.getAttribute("id");
        BoardDto boardDto = new BoardDto(title,content,writer,b_id);
        boardDto.setBno(bno);

        try {
            int rowCnt=boardService.modify(boardDto);
            rattr.addFlashAttribute("msg","WRT_OK");
            return "redirect:/";
        } catch (Exception e) {
            m.addAttribute(boardDto);
            m.addAttribute("msg","WRT_ERR");
            return "board";
        }

    }
    @PostMapping("/write")
    public String writE(String title,String content,Model m,HttpSession session,RedirectAttributes rattr){
        String writer = (String)session.getAttribute("nick_name");
        String b_id = (String)session.getAttribute("id");
       BoardDto boardDto = new BoardDto(title,content,writer,b_id);

        try {
            int rowCnt=boardService.write(boardDto);
            rattr.addFlashAttribute("msg","WRT_OK");
            return "redirect:/";
        } catch (Exception e) {
            m.addAttribute(boardDto);
            m.addAttribute("msg","WRT_ERR");
            return "board";
        }

    }
    @GetMapping("/write")
    public String write(Model m, HttpServletRequest request, RedirectAttributes rattr){
        String msg;
        if(loginCheck(request)) {
            m.addAttribute("mode", "new");
            return "board";
        }
        else {
            msg = "로그인 하시길 바랍니다";
            rattr.addFlashAttribute("msg",msg);
            return "redirect:/";
        }
    }

    private boolean loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute("id")!=null;
    }
}
