package com.nb.util.media;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;

/**
 * Created by niebin on 2016/8/7.
 */
public class CameraUtil {
    /**值必须在 0-1之间*/
    private static final int VIDEO_QUALITY=1;
    private static final String IMG_TYPE="image/*";
    /**
        调用默认的系统相机拍照
     * */
    public static Intent getTakePicIntent(File file){
        Intent intent=new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,VIDEO_QUALITY);
        return intent;
    }
    public static Intent getTakePicIntent(){
        Intent intent=new Intent(Intent.ACTION_GET_CONTENT);//ACTION_OPEN_DOCUMENT
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType(IMG_TYPE);
        return intent;
    }
    /**
     * 获取从本地图库返回来的时候的URI解析出来的文件路径
     * @return
     */
    public static String getPhotoPathByLocalUri(Context context, Intent data) {
        Uri selectedImage = data.getData();
        String[] filePathColumn = { MediaStore.Images.Media.DATA };
        Cursor cursor = context.getContentResolver().query(selectedImage,
                filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        cursor.close();
        return picturePath;
    }
}
