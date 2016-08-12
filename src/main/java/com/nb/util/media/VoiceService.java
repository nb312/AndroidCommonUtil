package com.nb.util.media;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.os.RemoteException;

import com.google.protobuf.InvalidProtocolBufferException;
import com.nb.util.IVoiceCallback;
import com.nb.util.IVoiceService;
import com.nb.util.common.LogUtil;
import com.nb.util.file.FileHelper;
import com.nb.util.protocbuffer.BuildStringUtil;
import com.nb.util.protocbuffer.ServiceItem;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class VoiceService extends Service implements OnPreparedListener,OnCompletionListener{
    private MediaPlayer mPlayer = null;  
    private MediaRecorder mRecorder = null;
    public static final String ACTION_START_RECORD="com.nb.util.media.VoiceService.ACTION_START_RECORD";
    public static final String ACTION_STOP_RECORD="com.nb.util.media.VoiceService.ACTION_STOP_RECORD";
    public static final String ACTION_START_PALY="com.nb.util.media.VoiceService.ACTION_START_PALY";
    public static final String ACTION_STOP_PLAY="com.nb.util.media.VoiceService.ACTION_STOP_PLAY";
    private File mFile;
    private long sTime=0;
    private int len=0;
    private boolean isHanding=false;
	private IVoiceCallback mVoiceCallback=null;
	@Override
	public void onCreate() {
		super.onCreate();
		LogUtil.logString(this, "onCreate");
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		stopPlay();
		stopRecorder();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
			LogUtil.logString(this, "onStartCommand");
			if(intent==null)return START_STICKY;
			String act=intent.getAction();
			LogUtil.logString(this, "onStartCommand.action="+act);
			if(ACTION_START_RECORD.equals(act)){
				LogUtil.logString(this, "ACTION_START_RECORD");
				startRecorder();
			}else if(ACTION_STOP_RECORD.equals(act)){
				LogUtil.logString(this, "ACTION_STOP_RECORD");
				stopRecorder();
			}else if(ACTION_START_PALY.equals(act)){
				if(isHanding)return START_STICKY;
				isHanding=true;
				LogUtil.logString(this, "ACTION_START_PALY");
				String path=intent.getStringExtra("path");
				startPlay(path);
			}else if(ACTION_STOP_PLAY.equals(act)){
				LogUtil.logString(this, "ACTION_STOP_PLAY");
				stopPlay();
			}
		return START_STICKY;
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return binder.asBinder();
	}

	private IVoiceService binder=new IVoiceService.Stub() {
		@Override
		public void sendSeviceMessage(String msg) throws RemoteException {
			try {
				ServiceItem.VoiceServiceMessage voiceMsg= ServiceItem.VoiceServiceMessage.parseFrom(msg.getBytes());
				ServiceItem.VoiceCmd cmd=voiceMsg.getVoiceCmd();
				if(cmd.equals(ServiceItem.VoiceCmd.START_RECORDER)){
					startRecorder();
				}else if(cmd.equals(ServiceItem.VoiceCmd.STOP_RECORDER)){
					stopRecorder();
				}else if(cmd.equals(ServiceItem.VoiceCmd.START_PLAY_MUSIC)){
					startPlay();
				}else if(cmd.equals(ServiceItem.VoiceCmd.STOP_PLAY_MUSIC)){
					stopPlay();
				}
			} catch (InvalidProtocolBufferException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void setCallback(IVoiceCallback callback) throws RemoteException {
			mVoiceCallback=callback;
		}
	};
	private void startRecorder(){
		String msg=BuildStringUtil.getVoiceCallbackMsg(ServiceItem.VoiceState.START);
		try {
			mVoiceCallback.sendBackMessage(msg);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(mRecorder==null){
				initVideo();
		}
		try {
			mRecorder.prepare();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mRecorder.start();
		sTime=new Date().getTime();
	}
	private void initVideo(){
		mRecorder = new MediaRecorder();
		mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		try {
			mFile = FileHelper.createMp3File();
			LogUtil.logString(this,"mFile="+(mFile ==null?null: mFile.getAbsolutePath()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		mRecorder.setOutputFile(mFile.getAbsolutePath());
		mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
	}
	private void stopRecorder(){
		if(mRecorder==null)return;
		if(mFile !=null){
			String path= mFile.getAbsolutePath();
			String msg= BuildStringUtil.getVoiceCallbackMsg(ServiceItem.VoiceState.STOP,path);
			try {
				mVoiceCallback.sendBackMessage(msg);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		mRecorder.stop();
		mRecorder.release();
		mRecorder=null;
		len=(int)(new Date().getTime()-sTime)/1000;
		LogUtil.logString(this, "stopRecorder.len="+len);
	}
	private void initPlayer(){
		 mPlayer = new MediaPlayer();  
		 mPlayer.setOnPreparedListener(this);
		 mPlayer.setOnCompletionListener(this);
	}
	private void startPlay(){
		if(mFile ==null)return;
		if(mPlayer==null)initPlayer();
         try{  
             mPlayer.setDataSource(mFile.getAbsolutePath());
//             LogUtil.logTag(this, "startPlay="+mFile.getAbsolutePath()+" len="+mPlayer.getDuration());
             mPlayer.prepareAsync();  
         }catch(IOException e){  
         }  
	}
	private void startPlay(String path){
		if(mFile ==null)return;
		if(mPlayer==null)initPlayer();
		try{  
			mPlayer.setDataSource(path);  
//             LogUtil.logTag(this, "startPlay="+mFile.getAbsolutePath()+" len="+mPlayer.getDuration());
			mPlayer.prepareAsync();  
		}catch(IOException e){  
		}  
	}
	private void stopPlay(){
		if(mPlayer==null)return;
		mPlayer.stop();
		mPlayer.release();
		mFile =null;
		mPlayer=null;
	}
	@Override
	public void onPrepared(MediaPlayer player) {
		player.start(); 
	}

	@Override
	public void onCompletion(MediaPlayer player) {
		stopPlay();
		isHanding=false;
	}

}
