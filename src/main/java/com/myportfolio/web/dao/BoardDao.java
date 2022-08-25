package com.myportfolio.web.dao;

import com.myportfolio.web.domain.BoardDto;

import java.util.List;

public interface BoardDao {
    BoardDto select(int bno) throws Exception;

    List<BoardDto> selectTitle(String title) throws Exception;

    int insert(BoardDto dto) throws Exception;

    int update(BoardDto dto) throws Exception;

    int inVCnt(int bno) throws Exception;

    int inCCnt(int bno) throws Exception;

    int deleteAll();

    int delete(Integer bno, String writer) throws Exception;
}
