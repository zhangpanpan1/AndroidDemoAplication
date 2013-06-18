package com.zpp.impl;

import com.zpp.activity.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.view.View;

public class TurnBitmapView extends View {
	public TurnBitmapView(Context context) {
		super(context);
	}

	// ��дonDraw����
	public void onDraw(Canvas canvas) {
		// ��ȡ��Դ�ļ�������res
		Resources res = getResources();
		// ��ȡͼ����Դ�ļ�
		Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.qq);
		// ����canvas��������Ϊ��ɫ
		canvas.drawColor(Color.BLACK);
		// �ڻ����ϻ�������֮ǰ��λͼ�������Ա�
		// ��Ļ�ϵ�λ��������0,0
		canvas.drawBitmap(bmp, 0, 0, null);
		// ����������
		// Matrix�Ĳ������ܹ���Ϊtranslate��ƽ�ƣ���rotate����ת����scale�����ţ���skew����б��
		Matrix matrix = new Matrix();
		// ����ԭͼ
		matrix.postScale(0.5f, 0.7f);
		// ������ת45�ȣ�����Ϊ����������ת
		matrix.postRotate(-45);
		// bmp.getWidth(), 300�ֱ��ʾ�ػ���λͼ���
		Bitmap dstbmp = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), 300,matrix, true);
		// �ڻ����ϻ�����ת���λͼ
		// ��������Ϊ0,200��λ��
		canvas.drawBitmap(dstbmp, 0, 200, null);
	}
}
