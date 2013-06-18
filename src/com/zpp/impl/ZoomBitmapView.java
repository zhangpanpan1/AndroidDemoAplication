package com.zpp.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.view.View;

import com.zpp.activity.R;

public class ZoomBitmapView extends View  
{  
  public ZoomBitmapView(Context context)  
  {  
      super(context);  
  }  

  //��дonDraw����  
  public void onDraw(Canvas canvas)  
  {  
      // ��ȡ��Դ�ļ�������res  
      Resources res = getResources();  
      // ��ȡͼ����Դ�ļ�  
      Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.qq);  
      // ����canvas��������Ϊ��ɫ  
      canvas.drawColor(Color.BLACK);  
      // �ڻ����ϻ�������֮ǰ��λͼ�������Ա�  
      //��Ļ�ϵ�λ��������0,0  
      canvas.drawBitmap(bmp, 0, 0, null);  
      // ����������  
      Matrix matrix = new Matrix();  
      // ����ԭͼ  
      matrix.postScale(0.5f, 0.3f);  
      //bmp.getWidth(), bmp.getHeight()�ֱ��ʾ���ź��λͼ���  
      Bitmap dstbmp = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(),  
              matrix, true);  
      // �ڻ����ϻ�����ת���λͼ  
      //��������Ϊ60,460��λ��  
      canvas.drawBitmap(dstbmp, 60, 460, null);  
  }  
}  