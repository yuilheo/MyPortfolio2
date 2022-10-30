package com.myportfolio.web.controller;

import com.myportfolio.web.domain.BoardDto;
import com.myportfolio.web.domain.PageHandler;
import com.myportfolio.web.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @PostMapping("/remove")
    public String remove(Integer bno, Integer page , Integer pageSize, Model m, HttpSession session){
        String writer = (String)session.getAttribute("nick_name");
        try {
            boardService.remove(bno,writer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        m.addAttribute("page");
        m.addAttribute("pageSize");
        return "redirect:/";

    }
    @GetMapping("/read")
    public String read(Integer bno,Integer page ,Integer pageSize,Model m){
        try {
            BoardDto boardDto = boardService.read(bno);
            m.addAttribute("boardDto",boardDto);
            m.addAttribute("page",page);
            m.addAttribute("pageSize",pageSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "board";
    }
    @GetMapping("/")
    public String list(Integer page, Integer pageSize, Model m,HttpServletRequest request){
        if(page==null) page = 1;
        if(pageSize==null) pageSize = 10;
        try{
            int totalCnt = boardService.getCount();
            PageHandler pageHandler = new PageHandler(totalCnt,page,pageSize);
            Map map = new HashMap();
            map.put("offset",(page-1)*pageSize);
            map.put("pageSize",pageSize);

            List<BoardDto> list = boardService.getPage(map);
            m.addAttribute("list",list);
            m.addAttribute("ph",pageHandler);
            m.addAttribute("page",page);
            m.addAttribute("pageSize",pageSize);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "index";
    }
}
