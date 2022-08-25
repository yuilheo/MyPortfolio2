package com.myportfolio.web.service;

import com.myportfolio.web.dao.BoardDao;
import com.myportfolio.web.domain.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceimpl implements BoardService {
    @Autowired
    private BoardDao boardDao;
     @Override
     public int remove(Integer bno, String writer) throws Exception{//글삭제
        return boardDao.delete(bno,writer);
    }
    @Override
    public int write(BoardDto boardDto)throws Exception{ //글쓰기
         return boardDao.insert(boardDto);
    }
    @Override
    public int getCount() throws Exception{ // 글 총개수
         return boardDao.count();
    }
    @Override
    public List<BoardDto> getList() throws Exception{
         return boardDao.selectAll();
    }
    @Override
    public List<BoardDto> getTitle(String title) throws Exception{
         return boardDao.selectTitle(title);
    }
    @Override
    public BoardDto read(Integer bno) throws Exception{
         BoardDto boardDto = boardDao.select(bno);
         boardDao.inVCnt(bno);
         return boardDto;
    }
    @Override
    public List<BoardDto> getPage(Map map) throws Exception{
         return boardDao.selectPage(map);
    }
    @Override
    public int modify(BoardDto boardDto) throws Exception{
         return boardDao.update(boardDto);
    }


}
