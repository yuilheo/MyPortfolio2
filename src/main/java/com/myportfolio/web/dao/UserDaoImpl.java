package com.myportfolio.web.dao;

import com.myportfolio.web.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
   private SqlSession session;
   private String namespace ="com.myportfolio.web.dao.UserMapper.";
    @Override
    public int delete(String id) throws Exception {
        return session.delete(namespace+"delete",id);
    }
//    @Override
//    public int deleteAll() throws Exception{
//        return session.delete(namespace+"deleteAll");
//    }
    @Override
    public UserDto selectUser(String id) throws Exception {
        return session.selectOne(namespace+"selectUser",id);
    }
    @Override
    public int selectCnt()throws Exception{
        return session.selectOne(namespace+"selectCnt");
    }
    @Override
    public int insertUser(UserDto userDto)throws Exception{
        return session.insert(namespace+"insertUser",userDto);
    }

    @Override
    public int update(String id,String pwd,String nick_name,String email,String adress) throws Exception{
        Map map = new HashMap();
        map.put("id",id);
        map.put("pwd",pwd);
        map.put("nick_name",nick_name);
        map.put("email",email);
        map.put("adress",adress);
        return session.update(namespace+"update",map);
    }
    @Override
    public int updateGrade(String id) throws Exception{
        return session.update(namespace+"updateGrade",id);
    }

}
