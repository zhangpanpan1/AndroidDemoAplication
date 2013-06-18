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
        //��ȡͼƬ�����أ�һά���飩  
        /* 
         * pixels      ����λͼ��ɫֵ������  
         * offset      д�뵽pixels[]�еĵ�һ����������ֵ  
         * stride      pixels[]�е��м�����ֵ(������ڵ���λͼ���)������Ϊ����  
         * x          ��                    ��λͼ�ж�ȡ�ĵ�һ�����ص�x����ֵ��  
         * y           ��λͼ�ж�ȡ�ĵ�һ�����ص�y����ֵ  
         * width    �� ��ÿһ���ж�ȡ�����ؿ��  
         * height ���� ��ȡ������   
         */  
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);    
        //��ȡһ����height��width��ͼƬ����  
        for (int i = 0; i < height; i++)    
        {    
            for (int j = 0; j < width; j++)    
            {    
                pixColor = pixels[width * i + j];   
                //�ȼ���(pixColor >> 16) & 0xFF  ��ȡһ�����ص�R  
                pixR = Color.red(pixColor);  
                //�ȼ���(pixColor >> 8) & 0xFF   ��ȡһ�����ص�G  
                pixG = Color.green(pixColor);   
                //�ȼ���(pixColor) & 0xFF   ��ȡһ�����ص�B  
                pixB = Color.blue(pixColor);    
                //�����㷨��ԭͼ��RGB�����µ�RGB  
                newR = (int) (0.393 * pixR + 0.769 * pixG + 0.189 * pixB);    
                newG = (int) (0.349 * pixR + 0.686 * pixG + 0.168 * pixB);    
                newB = (int) (0.272 * pixR + 0.534 * pixG + 0.131 * pixB);   
                //��RGB����һ������  
                //������argb (int alpha, int red, int green, int blue)   
                int newColor = Color.argb(255, newR > 255 ? 255 : newR, newG > 255 ? 255 : newG, newB > 255 ? 255 : newB);    
                pixels[width * i + j] = newColor;    
            }    
        }    
        //�����µ�ͼƬ  
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);   
         //�軭��������ͼƬ��  
        canvas.drawBitmap(bitmap,0,0,myPaint);  
    }  

}
