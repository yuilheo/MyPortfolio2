package com.myportfolio.web.service;

import com.myportfolio.web.domain.UserDto;

public interface UserService {
    int remove(String id) throws Exception;

    UserDto selectUser(String id) throws Exception;

    int selectUserHap() throws Exception;

    int signUp(UserDto userDto) throws Exception;

    int updateUser(String id, String pwd, String nick_name, String email, String adress) throws Exception;

    int updateGrade(String id) throws Exception;
}
