package com.nb.util.view;

import android.app.Activity;
import android.view.View;

/**
 * Created by niebin on 2016/7/17.
 */
public class BaseView {
    protected Activity mAct;
    protected View mContentView;

    public BaseView(Activity act,View view){
        this.mAct=act;
        this.mContentView=view;
    }
    public BaseView(Activity act){
        this(act,null);
    }
    public BaseView(View view){
        this(null,view);
    }
    protected void initView(){};
    protected View findViewById(int id){
        if(mContentView!=null){
            return mContentView.findViewById(id);
        }else{
            return mAct.findViewById(id);
        }
    }
    public View getContentView() {
        return mContentView;
    }

    public void setContentView(View mContentView) {
        this.mContentView = mContentView;
    }
}
