package com.myportfolio.web.dao;

import com.myportfolio.web.domain.BoardDto;
import com.myportfolio.web.domain.SearchCondition;
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
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }
    @Override
    public BoardDto select(int bno) throws Exception{
       return session.selectOne(namespace+"select",bno);
    }
    @Override
    public List<BoardDto> selectTitle(String title) throws Exception{
        return session.selectList(namespace+"selectTitle",title);
    }
    @Override
    public List<BoardDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    }
    @Override
    public List<BoardDto> selectPage(Map map) throws Exception {
        return session.selectList(namespace+"selectPage",map);
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
    public int deleteAll()throws Exception{
        return session.delete(namespace+"deleteALl");
    }
    @Override
    public int delete(Integer bno, String writer)throws Exception{
        Map map = new HashMap();
        map.put("bno",bno);
        map.put("writer",writer);
        return session.delete(namespace+"delete",map);
    }

    @Override
    public List<BoardDto> searchSelectPage(SearchCondition sc) throws Exception {
        return session.selectList(namespace+"searchSelectPage",sc);
    }
    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception {
        return session.selectOne(namespace+"searchResultCnt",sc);
    }

}
