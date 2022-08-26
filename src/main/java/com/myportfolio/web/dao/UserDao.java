package com.myportfolio.web.dao;

import com.myportfolio.web.domain.UserDto;

public interface UserDao {
    int delete(String id) throws Exception;
//
//    int deleteAll() throws Exception;

    UserDto selectUser(String id) throws Exception;

    int selectCnt() throws Exception;

    int insertUser(UserDto userDto) throws Exception;



    int update(String id,String pwd,String nick_name,String email,String adress) throws Exception;

    int updateGrade(String id) throws Exception;
    }
