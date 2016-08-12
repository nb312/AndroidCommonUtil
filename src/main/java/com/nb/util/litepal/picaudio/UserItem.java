package com.nb.util.litepal.picaudio;


import org.litepal.crud.DataSupport;

/**
 * Created by niebin on 2016/7/17.
 * user_name
 user_password
 phone
 email

 */

public class UserItem extends DataSupport {
    public final static  String USER_NAME="user_name";
    public final static  String USER_PASSWORD="user_password";
    public final static  String PHONE="phone";
    public final static  String EMAIL="email";
    private String user_name;
    private String user_password;
    private String phone;
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
