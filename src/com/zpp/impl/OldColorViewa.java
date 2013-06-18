package com.zpp.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.zpp.activity.R;

public class OldColorViewa extends ImageView {
	
	private Paint myPaint = null;  
    private Bitmap bitmap = null;  
    private int width,height;  
     
    public OldColorViewa(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs);  
        bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.qq);   
        width = bitmap.getWidth();    
        height = bitmap.getHeight();  
        invalidate();  
	}
    @Override  
    protected void onDraw(Canvas canvas) {  
        super.onDraw(canvas);  
           
        int pixColor = 0;    
        int pixR = 0;    
        int pixG = 0;    
        int pixB = 0;    
        int newR = 0;    
        int newG = 0;    
        int newB = 0;    
        int[] pixels = new int[width * height];    
        //获取图片的像素（一维数组）  
        /* 
         * pixels      接收位图颜色值的数组  
         * offset      写入到pixels[]中的第一个像素索引值  
         * stride      pixels[]中的行间距个数值(必须大于等于位图宽度)。可以为负数  
         * x          　                    从位图中读取的第一个像素的x坐标值。  
         * y           从位图中读取的第一个像素的y坐标值  
         * width    　 从每一行中读取的像素宽度  
         * height 　　 读取的行数   
         */  
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);    
        //获取一个高height宽width的图片像素  
        for (int i = 0; i < height; i++)    
        {    
            for (int j = 0; j < width; j++)    
            {    
                pixColor = pixels[width * i + j];   
                //等价于(pixColor >> 16) & 0xFF  获取一个像素的R  
                pixR = Color.red(pixColor);  
                //等价于(pixColor >> 8) & 0xFF   获取一个像素的G  
                pixG = Color.green(pixColor);   
                //等价于(pixColor) & 0xFF   获取一个像素的B  
                pixB = Color.blue(pixColor);    
                //根据算法由原图的RGB生成新的RGB  
                newR = (int) (0.393 * pixR + 0.769 * pixG + 0.189 * pixB);    
                newG = (int) (0.349 * pixR + 0.686 * pixG + 0.168 * pixB);    
                newB = (int) (0.272 * pixR + 0.534 * pixG + 0.131 * pixB);   
                //由RGB生成一个像素  
                //函数：argb (int alpha, int red, int green, int blue)   
                int newColor = Color.argb(255, newR > 255 ? 255 : newR, newG > 255 ? 255 : newG, newB > 255 ? 255 : newB);    
                pixels[width * i + j] = newColor;    
            }    
        }    
        //生成新的图片  
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);   
         //描画（处理后的图片）  
        canvas.drawBitmap(bitmap,0,0,myPaint);  
    }  

}
