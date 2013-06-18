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

	// 重写onDraw方法
	public void onDraw(Canvas canvas) {
		// 获取资源文件的引用res
		Resources res = getResources();
		// 获取图形资源文件
		Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.qq);
		// 设置canvas画布背景为白色
		canvas.drawColor(Color.BLACK);
		// 在画布上绘制缩放之前的位图，以做对比
		// 屏幕上的位置坐标是0,0
		canvas.drawBitmap(bmp, 0, 0, null);
		// 定义矩阵对象
		// Matrix的操作，总共分为translate（平移），rotate（旋转），scale（缩放）和skew（倾斜）
		Matrix matrix = new Matrix();
		// 缩放原图
		matrix.postScale(0.5f, 0.7f);
		// 向左旋转45度，参数为正则向右旋转
		matrix.postRotate(-45);
		// bmp.getWidth(), 300分别表示重绘后的位图宽高
		Bitmap dstbmp = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), 300,matrix, true);
		// 在画布上绘制旋转后的位图
		// 放在坐标为0,200的位置
		canvas.drawBitmap(dstbmp, 0, 200, null);
	}
}
