package com.example.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private Integer id;
    private String username;
    private String realName;
    private String password;
    private String salt;
    //性别 1：女   2：男
    private int gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    //1管理员 2经理 3普通用户
    private int userType;

    public User(Integer id, String username, String realName, String password, String salt, int gender, Date birthday, int userType) {
        this.id = id;
        this.username = username;
        this.realName = realName;
        this.password = password;
        this.salt = salt;
        this.gender = gender;
        this.birthday = birthday;
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", userType=" + userType +
                '}';
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
