package com.nb.util.common;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by niebin on 2016/6/14.
 */
public class LogUtil {
    private static  final String LINE="-------------------------------";
    public static void logString(Object oj,String msg){
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
    public static void logArray(Object oj,String msg,ArrayList<String> aList) {
        if (oj == null) Log.i("NULL", LINE);
        else {
            String cN = oj.getClass().getName();
            String[] cNs = null;
            if (cN == null || cN.equals("")) Log.i("Name", LINE);
            else {
                if (cN.contains(".")) {
                    cNs = cN.split("\\.");
                    cN = cNs[cNs.length - 1];
                }
                if (cN.contains("\\$")) {
                    cNs = cN.split("\\$");
                    cN = cNs[0];
                }
                if (aList == null) {
                    Log.i(cN, msg + ".List=NULL");
                } else {

                    Log.i(cN, msg + "--------List!=null-----start");
                    if (aList.size() == 0) {
                        Log.i(cN, "--List.size=" + 0 + "------end ");
                        return;
                    }
                    for (int i = 0; i < aList.size(); i++) {
                        String s = aList.get(i);
                        Log.i(cN, "list" + "_" + i + s);
                    }
                    Log.i(cN, "--List.size=" + aList.size() + "------end ");
                }
            }
        }
    }
    public static void logString(Class c,String msg){
        if(CommonUtil.isNull(c)){
            Log.i("NULL",LINE);
            return ;
        }
        Log.i(c.getSimpleName(),msg);
    }
}
