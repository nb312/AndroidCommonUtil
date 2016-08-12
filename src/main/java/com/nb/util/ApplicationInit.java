package com.nb.util;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.umeng.analytics.MobclickAgent;

import org.litepal.LitePalApplication;

import de.greenrobot.common.ListMap;
import de.greenrobot.common.StringUtils;
import de.greenrobot.common.io.FileUtils;
import de.greenrobot.common.io.IoUtils;
import de.greenrobot.common.io.LimitedInputStream;

/**
 * Created by niebin on 2016/7/17.
 */

public class ApplicationInit {
    private final static String LEARN_CLOUD_APP_ID="EERCoqX23jahTxHkw62MjjLB-gzGzoHsz";
    private final static String LEARN_CLOUD_APP_KEY="5T1qlNFNp29x5m3uLonI6BEw";
    private final static String UMENG_APP_KEY="57a6d5e467e58ed7bd00305b";
    private final static String UMENG_CHANNEL="360";
    public static void init(Application instance){
        initLitePal(instance);
        initLeancloud(instance);
        initUmeng(instance);
    }

    private static  void initLitePal(Application instance){
        LitePalApplication.initialize(instance);
    }

    private static  void initLeancloud(Application instance){
        AVOSCloud.initialize(instance,LEARN_CLOUD_APP_ID,LEARN_CLOUD_APP_KEY);
        // 启用北美节点
        // AVOSCloud.useAVCloudUS();
    }
    private static void initUmeng(Application instance){
        MobclickAgent.UMAnalyticsConfig config=new MobclickAgent.UMAnalyticsConfig(instance,UMENG_APP_KEY,UMENG_CHANNEL);
        MobclickAgent.startWithConfigure(config);
    }

}
