package com.example.common_interface_demo;

/**
 * author:  ycl
 * date:  2019/09/06 16:52
 * desc:
 */
public class User {
    private String username;
    private String pwd;

    public User(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
