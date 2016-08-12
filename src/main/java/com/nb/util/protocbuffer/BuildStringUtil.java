package com.nb.util.protocbuffer;

/**
 * Created by niebin on 2016/8/7.
 */
public class BuildStringUtil {
     public static String getVoiceServiceMsg(ServiceItem.VoiceCmd cmd){
         ServiceItem.VoiceServiceMessage msg=ServiceItem.VoiceServiceMessage.newBuilder().
                 setVoiceCmd(cmd).build();
        return new String(msg.toByteArray());
     }
     public static String getVoiceServiceMsg(ServiceItem.VoiceCmd cmd,String content){
         ServiceItem.VoiceServiceMessage msg=ServiceItem.VoiceServiceMessage.newBuilder().
                 setVoiceCmd(cmd)
                 .setContent(content)
                 .build();
         return new String(msg.toByteArray());
     }
     public static String getVoiceCallbackMsg(ServiceItem.VoiceState state,String content){
         ServiceItem.VoiceCallbackMessage msg=ServiceItem.VoiceCallbackMessage.newBuilder()
                 .setVoiceState(state)
                 .setContent(content)
                 .build();
        return new String(msg.toByteArray());
     }
     public static String getVoiceCallbackMsg(ServiceItem.VoiceState state){
         ServiceItem.VoiceCallbackMessage msg=ServiceItem.VoiceCallbackMessage.newBuilder()
                 .setVoiceState(state)
                 .build();
        return new String(msg.toByteArray());
     }
}
