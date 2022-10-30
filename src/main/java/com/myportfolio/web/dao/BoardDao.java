package com.myportfolio.web.dao;

import com.myportfolio.web.domain.BoardDto;
import com.myportfolio.web.domain.SearchCondition;

import java.util.List;
import java.util.Map;

public interface BoardDao {
    int count() throws Exception;
    BoardDto select(int bno) throws Exception;

    List<BoardDto> selectTitle(String title) throws Exception;

    List<BoardDto> selectAll() throws Exception;

    List<BoardDto> selectPage(Map map) throws Exception;
    int insert(BoardDto dto) throws Exception;

    int update(BoardDto dto) throws Exception;

    int inVCnt(int bno) throws Exception;

    int inCCnt(int bno) throws Exception;

    int deleteAll();

    int delete(Integer bno, String writer) throws Exception;
     List<BoardDto> searchSelectPage(SearchCondition sc) throws Exception;
    int searchResultCnt() throws Exception;
}

