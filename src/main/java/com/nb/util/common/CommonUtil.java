package com.nb.util.common;

import java.util.List;

public class CommonUtil {
	public static boolean isNull(Object obj){
		if(obj==null)return true;
		if(obj instanceof String){
			String s=(String)obj;
			if(s.equals(""))return true;
		}else if( obj instanceof List){
			List l=(List)obj;
			if(l.size()==0)return true;
		}
		return false;
	}
	public static String getObjectName(Object o){
		if(o==null)return "NULL";
		else{
			String cN=o.getClass().getName();
			String[] cNs=null;
			if(cN==null||cN.equals(""))return "NULL";
			else{
				if(cN.contains(".")){
					cNs=cN.split("\\.");
					cN=cNs[cNs.length-1];
				}
				if(cN.contains("\\$")){
					cNs=cN.split("\\$");
					cN=cNs[0];
				}
				return cN;
			}
		}
	}
}
