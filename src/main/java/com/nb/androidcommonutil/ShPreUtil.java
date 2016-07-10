package com.nb.util;

import android.app.Service;
import android.content.Context;
import android.content.SharedPreferences;

public class ShPreUtil {
	private static final String SHARE_NAME="heart_audio";
	private static SharedPreferences getSP(Context ctx){
		SharedPreferences sp=ctx.getSharedPreferences(SHARE_NAME,Service.MODE_PRIVATE);
		return sp;
	}
	public static void putString(Context ctx,String key,String value){
		SharedPreferences.Editor editor=getSP(ctx).edit();
		editor.putString(key, value);
		editor.apply();
	}
	public static String getString(Context ctx,String key,String defaultV){
		SharedPreferences sp=getSP(ctx);
		return sp.getString(key, defaultV);
	}
	/**
	 * @return 默认返回""
	 */
	public static String getString(Context ctx,String key){
		return getString(ctx, key, "");
	}
	public static void putBoolean(Context ctx,String key,boolean value){
		SharedPreferences.Editor editor=getSP(ctx).edit();
		editor.putBoolean(key, value);
		editor.apply();
	}
	public static boolean getBoolean(Context ctx,String key,boolean defaultV){
		SharedPreferences sp=getSP(ctx);
		return sp.getBoolean(key, defaultV);
	}
	/**
	 * @return 默认返回 false
	 */
	public static boolean getBoolean(Context ctx,String key){
		return getBoolean(ctx, key, false);
	}
		
	public static void putInt(Context ctx,String key,int value){
		SharedPreferences.Editor editor=getSP(ctx).edit();
		editor.putInt(key, value);
		editor.apply();
	}
	public static int getInt(Context ctx,String key,int defaultV){
		SharedPreferences sp=getSP(ctx);
		return sp.getInt(key, defaultV);
	}
	/**
	 * @return 默认返回  0
	 */
	public static int getInt(Context ctx,String key){
		return getInt(ctx, key, 0);
	}
	public static void putLong(Context ctx,String key,long value){
		SharedPreferences.Editor editor=getSP(ctx).edit();
		editor.putLong(key, value);
		editor.apply();
	}
	public static long getLong(Context ctx,String key,long defaultV){
		SharedPreferences sp=getSP(ctx);
		return sp.getLong(key, defaultV);
	}
	/**
	 * @return 默认返回  0
	 */
	public static long getLong(Context ctx,String key){
		return getLong(ctx, key, 0);
	}
	
}
