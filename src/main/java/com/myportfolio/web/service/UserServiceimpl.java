package com.myportfolio.web.service;

import com.myportfolio.web.dao.UserDao;
import com.myportfolio.web.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public int remove(String id) throws Exception{
        return userDao.delete(id);
    }

    @Override
    public UserDto selectUser(String id) throws Exception{
        return userDao.selectUser(id);
    }
    @Override
    public int selectUserHap() throws Exception{
        return userDao.selectCnt();
    }
    @Override
    public String selectUserID(String email) throws Exception{
        return userDao.selectID(email);
    }
    @Override
    public String selectUserPwd(String id) throws Exception{
        return userDao.selectPwd(id);
    }
    @Override
    public int signUp(UserDto userDto)throws Exception{
        return userDao.insertUser(userDto);
    }
    @Override
    public int updateUser(String id, String pwd, String nick_name, String email, String adress)throws Exception{
        return userDao.update(id,pwd,nick_name,email,adress);
    }
    @Override
    public int updateGrade(String id) throws Exception{
        return userDao.updateGrade(id);
    }
}
