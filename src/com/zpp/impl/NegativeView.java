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
 
  
public class NegativeView extends ImageView {
	 private Paint myPaint = null;  
	    private Bitmap bitmap = null;
	    private int width,height;  
	    private int[] oldPixels;    
	    private int[] newPixels;    
	    private int color,color2;  
	    private int pixelsR,pixelsG,pixelsB,pixelsA,pixelsR2,pixelsG2,pixelsB2;  
	      
	    public NegativeView(Context context)  
	    {  
	        super(context);  
	       
	        
	    }  
	    @Override  
	    protected void onDraw(Canvas canvas) {  
	        super.onDraw(canvas);   
	        //��ȡ����
	        bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.qq);   
	        width = bitmap.getWidth();    
	        height = bitmap.getHeight();  
	        oldPixels = new int[width*height];   
	        newPixels = new int[width*height];  
	       
	        bitmap.getPixels(oldPixels, 0, width, 0, 0, width, height);  
	        Bitmap newbitmap=Bitmap.createBitmap(width,height,Bitmap.Config.RGB_565);
	        for(int i = 1;i < height*width; i++){  
	                color = oldPixels[i];  
	                //��ȡRGB����  
	                pixelsA = Color.alpha(color);  
	                pixelsR = Color.red(color);  
	                pixelsG = Color.green(color);  
	                pixelsB = Color.blue(color);  
	                  
	                //ת��  
	                pixelsR = (255 - pixelsR);  
	                pixelsG = (255 - pixelsG);  
	                pixelsB = (255 - pixelsB);  
	                //��С�ڵ���255���ڵ���0  
	                if(pixelsR > 255){  
	                    pixelsR = 255;  
	                }  
	                else if(pixelsR < 0){  
	                    pixelsR = 0;  
	                }  
	                if(pixelsG > 255){  
	                    pixelsG = 255;  
	                }  
	                else if(pixelsG < 0){   
	                    pixelsG = 0;  
	                }  
	                if(pixelsB > 255){  
	                    pixelsB = 255;  
	                }  
	                else if(pixelsB < 0){  
	                    pixelsB = 0;  
	                }  
	                //�����µ�RGB����������  
	                newPixels[i] = Color.argb(pixelsA, pixelsR, pixelsG, pixelsB);  
	                  
	        }  
	        //����������������ͼƬ  
	        newbitmap.setPixels(newPixels, 0, width, 0, 0, width, height);  
	        canvas.drawBitmap(newbitmap,0,0,myPaint);  
	    }  
	}  