package com.myportfolio.web.controller;

import com.myportfolio.web.domain.BoardDto;
import com.myportfolio.web.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/list")
    public String list(Integer page, Integer pageSize, Model m,HttpServletRequest request){
        try{
            Map map = new HashMap();
            map.put("offset",(page-1)*pageSize);
            map.put("pageSize",pageSize);

            List<BoardDto> list = boardService.getPage(map);
            m.addAttribute("list",list);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "list";
    }
}
