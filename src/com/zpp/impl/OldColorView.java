package com.zpp.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.zpp.activity.R;

public class OldColorView extends ImageView {

	public OldColorView(Context context, AttributeSet attrs) {
	    super(context, attrs);  
        bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.qq);   
        invalidate();   
	}

	
	
	    private Paint myPaint = null;  
	    private Bitmap bitmap = null;  
	    private ColorMatrix myColorMatrix = null;  
	    //设置颜色值  
	    private float[] colorArray = {(float) 0.393,(float) 0.768,(float) 0.189,0,0,   
	            (float) 0.349,(float) 0.686,(float) 0.168,0,0,   
	            (float) 0.272,(float) 0.534,(float) 0.131,0,0,   
	            0,0,0,1,0};  
	      
	    
	    @Override  
	    protected void onDraw(Canvas canvas) {  
	        super.onDraw(canvas);  
	        //新建画笔对象  
	        myPaint = new Paint();     
	        //描画（原始图片）      
	        canvas.drawBitmap(bitmap,0, 0, myPaint);        
	        //新建颜色矩阵对象      
	        myColorMatrix = new ColorMatrix();  
	        //设置颜色矩阵的值  
	        myColorMatrix.set(colorArray);             
	        //设置画笔颜色过滤器      
	        myPaint.setColorFilter(new ColorMatrixColorFilter(myColorMatrix));     
	         //描画（处理后的图片）  
	        canvas.drawBitmap(bitmap,0,0,myPaint);  
	        invalidate();   
	    }  
}
