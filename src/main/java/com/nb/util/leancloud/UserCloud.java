package com.nb.util.leancloud;

import android.os.Handler;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.SaveCallback;
import com.avos.avoscloud.SignUpCallback;
import com.nb.util.common.CommonUtil;
import com.nb.util.litepal.picaudio.UserInfoItem;
import com.nb.util.litepal.picaudio.UserItem;

/**
 * Created by niebin on 2016/7/17.
 */

public class UserCloud {
    public final  static  int ERROR_MSG=-1;
    public void register(final Handler hander, final int what, UserItem item){
        AVUser user=new AVUser();
        user.setUsername(item.getUser_name());
        user.setPassword(item.getUser_password());
        user.setMobilePhoneNumber(item.getPhone());
        user.setEmail(item.getEmail());
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(AVException e) {
                sendMessage(hander,what,e);
            }
        });
    }

    public void login(final Handler hander, final int what, UserItem item){
        AVUser user=new AVUser();
        AVUser.logInInBackground(item.getUser_name(), item.getUser_password(), new LogInCallback<AVUser>() {
            @Override
            public void done(AVUser avUser, AVException e) {
                sendMessage(hander,what,e);
            }
        });
    }
    /**
     * * user_name
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
     * */
    public void uploadUserInfo(final Handler hander, final int what, UserInfoItem item){
        AVObject o=new AVObject(CommonUtil.getObjectName(item));
        o.add(UserInfoItem.USER_NAME,item.getUser_name());
        o.add(UserInfoItem.SEX,item.getSex());
        o.add(UserInfoItem.NICK_NAME,item.getNick_name());
        o.add(UserInfoItem.AGE,item.getAge());
        o.add(UserInfoItem.BORTHDAY,item.getBorthday());
        o.add(UserInfoItem.ADRESS,item.getAdress());
        o.add(UserInfoItem.STAR,item.getStar());
        o.add(UserInfoItem.HEIGHT,item.getHeight());
        o.add(UserInfoItem.WEIGTH,item.getWeigth());
        o.add(UserInfoItem.DESCRIPTION,item.getDescription());
        o.add(UserInfoItem.HEAD_IMG,item.getHead_img());
        o.saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                sendMessage(hander,what,e);
            }
        });
    }
    private void sendMessage(Handler handler,int what,AVException e){
        if(e==null){
            handler.sendEmptyMessage(what);
        }else{
            handler.sendEmptyMessage(ERROR_MSG);
        }
    }

}
