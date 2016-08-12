package com.nb.util.file;

import java.io.File;
import java.io.IOException;

import android.os.Environment;

public class FileHelper {
	private static final String DEFAULT_FOLDER="picaudio";
	private static final String DEFAULT_FOLDER_MP3=DEFAULT_FOLDER+"/MP3";

	private static boolean isSdCardExist(){
		return Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
	}

	private static String getSdDir(){
		return Environment.getExternalStorageDirectory().getAbsolutePath();
	}

	/**
	 * @param folder
	 * @param name
	 * @return 指定文件夹下创建文件
	 * @throws IOException
	 */
	public static File createFileExist(String folder,String name) throws IOException{
		if(!isSdCardExist())return null;
		String path=getSdDir();
		path+="/"+folder;
		File file=new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
		path+="/"+name;
		File f1=new File(path);
		if(!f1.exists()){
			f1.createNewFile();
		}
		return f1;
	}
	/**
	 * @param name
	 * @return　在默认路径下创建文件
	 * @throws IOException
	 */
	public static File createDefautFile(String name) throws IOException{
		File f=createFileExist(DEFAULT_FOLDER,name);
		return f;
	}
	/**
	 * @param name 不需要带mp3后缀
	 * @return 创建mp3文件，
	 * @throws IOException 
	 */
	public static File createMp3File() throws IOException{
		long t=System.currentTimeMillis();
		String name=t+".mp3";
		File f=createFileExist(DEFAULT_FOLDER_MP3,name);
		return f;
	}
}
