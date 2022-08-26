package com.myportfolio.web.domain;

import java.util.Date;
import java.util.Objects;

public class UserDto {
    private String id;
    private String pwd;
    private String nick_name;
    private String email;
    private String adress;
    private Date reg_date;
    private String grade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    public UserDto(){}
    public UserDto(String id, String pwd, String nick_name, String email, String adress) {
        this.id = id;
        this.pwd = pwd;
        this.nick_name = nick_name;
        this.email = email;
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) && Objects.equals(pwd, userDto.pwd) && Objects.equals(nick_name, userDto.nick_name) && Objects.equals(email, userDto.email) && Objects.equals(adress, userDto.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pwd, nick_name, email, adress);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + adress + '\'' +
                ", reg_date=" + reg_date +
                ", grade='" + grade + '\'' +
                '}';
    }
}
