package com.nb.util;
import com.nb.util.IVoiceCallback;

interface IVoiceService {
   void sendSeviceMessage(String msg);
   void setCallback(IVoiceCallback callback);
}
