package com.nb.util;

import android.util.Log;

/**
 * Created by niebin on 2016/6/14.
 */
public class LogUtil {
    private static  final String LINE="-------------------------------";
    public static void logTag(Object oj,String msg){
        if(oj==null)Log.i("NULL",LINE);
        else{
            String cN=oj.getClass().getName();
            String[] cNs=null;
            if(cN==null||cN.equals(""))Log.i("Name",LINE);
            else{
                if(cN.contains(".")){
                    cNs=cN.split("\\.");
                    cN=cNs[cNs.length-1];
                }
                if(cN.contains("\\$")){
                    cNs=cN.split("\\$");
                    cN=cNs[0];
                }
                Log.i(cN, msg);
            }
        }
    }
}
