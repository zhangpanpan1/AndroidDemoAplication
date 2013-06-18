package com.zpp.projectactivity;

import com.zpp.activity.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.widget.ImageView;

public class ThumbnailActivity extends Activity {
    private Bitmap bitmap = null;  
    private ImageView image;  
     @Override    
     public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);    
        setContentView(R.layout.thumbail);    
        image = (ImageView) findViewById(R.id.image);    
        //�õ�ԭͼƬ  
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.qq);  
        //�õ�����ͼ  
        bitmap = ThumbnailUtils.extractThumbnail(bitmap, 100, 100);    
        image.setImageBitmap(bitmap);
    }    
}  