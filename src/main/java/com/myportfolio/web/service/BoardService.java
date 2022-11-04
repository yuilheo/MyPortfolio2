package com.myportfolio.web.service;

import com.myportfolio.web.domain.BoardDto;
import com.myportfolio.web.domain.SearchCondition;

import java.util.List;
import java.util.Map;

public interface BoardService {
    int remove(Integer bno, String writer) throws Exception;

    int write(BoardDto boardDto) throws Exception;

    int getCount() throws Exception;

    List<BoardDto> getList() throws Exception;

    List<BoardDto> getTitle(String title) throws Exception;

    BoardDto read(Integer bno) throws Exception;

    List<BoardDto> getPage(Map map) throws Exception;

    int modify(BoardDto boardDto) throws Exception;

    List<BoardDto> getSearchResultPage(SearchCondition sc) throws Exception;


    int getSearchResultCnt(SearchCondition sc)throws Exception;
}
