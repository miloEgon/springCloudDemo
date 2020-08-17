package com.fg.redis.pojo;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;
    private String nickname;
    private String age;
    private String gender;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
