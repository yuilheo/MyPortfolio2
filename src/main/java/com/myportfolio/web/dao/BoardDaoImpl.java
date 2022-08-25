package com.myportfolio.web.dao;

import com.myportfolio.web.domain.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class BoardDaoImpl implements BoardDao {
    @Autowired
    private SqlSession session;
    private String namespace="com.myportfolio.web.dao.BoardMapper.";
    @Override
    public BoardDto select(int bno) throws Exception{
       return session.selectOne(namespace+"select",bno);
    }
    @Override
    public List<BoardDto> selectTitle(String title) throws Exception{
        return session.selectOne(namespace+"selectTitle",title);
    }
    @Override
    public int insert(BoardDto dto) throws Exception{
        return session.insert(namespace+"insert",dto);
    }
    @Override
    public int update(BoardDto dto) throws Exception{
        return session.update(namespace+"update",dto);
    }
    @Override
    public int inVCnt(int bno) throws Exception{
        return session.update(namespace+"inVCnt",bno);
    }
    @Override
    public int inCCnt(int bno) throws Exception{
        return session.update(namespace+"inCCnt",bno);
    }
    @Override
    public int deleteAll(){
        return session.delete(namespace+"deleteALl");
    }
    @Override
    public int delete(Integer bno, String writer)throws Exception{
        Map map = new HashMap();
        map.put("bno",bno);
        map.put("writer",writer);
        return session.delete(namespace+"delete",map);
    }



}
