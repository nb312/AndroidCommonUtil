package com.nb.util.litepal.picaudio;

import org.litepal.crud.DataSupport;

/**
 * Created by niebin on 2016/7/17.
 * user_name
 sex
 nick_name
 age
 borthday
 adress
 star
 height
 weigth
 description
 head_img
 */
public class UserInfoItem extends DataSupport {
    public final static  String USER_NAME="user_name";
    public final static  String SEX="sex";
    public final static  String NICK_NAME="nick_name";
    public final static  String AGE="age";
    public final static  String BORTHDAY="borthday";
    public final static  String ADRESS="adress";
    public final static  String STAR="star";
    public final static  String HEIGHT="height";
    public final static  String WEIGTH="weigth";
    public final static  String DESCRIPTION="description";
    public final static  String HEAD_IMG="head_img";
    private String user_name;
    private String sex;
    private String nick_name;
    private String age;
    private String borthday;
    private String adress;
    private String star;
    private String height;
    private String weigth;
    private String description;
    private String head_img;

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBorthday() {
        return borthday;
    }

    public void setBorthday(String borthday) {
        this.borthday = borthday;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeigth() {
        return weigth;
    }

    public void setWeigth(String weigth) {
        this.weigth = weigth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

}
