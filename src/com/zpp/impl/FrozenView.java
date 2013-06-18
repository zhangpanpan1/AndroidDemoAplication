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

public class FrozenView extends ImageView {

	private Paint myPaint = null;
	private Bitmap bitmap = null;
	private int width, height;
	private int[] oldPixels;
	private int[] newPixels;
	private int color, color2;
	private int pixelsR, pixelsG, pixelsB, pixelsA, pixelsR2, pixelsG2,
			pixelsB2;
	private Bitmap newbitmap = null;
	public FrozenView(Context context, AttributeSet attrs) {
		super(context, attrs);
		bitmap = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.qq);
		width = bitmap.getWidth();
		height = bitmap.getHeight();
		oldPixels = new int[width * height];
		newPixels = new int[width * height];
        newbitmap=Bitmap.createBitmap(width,height,Bitmap.Config.RGB_565);

		invalidate();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// 获取像素
		bitmap.getPixels(oldPixels, 0, width, 0, 0, width, height);

		for (int i = 1; i < height * width; i++) {
			color = oldPixels[i];
			// 获取RGB分量
			pixelsA = Color.alpha(color);
			pixelsR = Color.red(color);
			pixelsG = Color.green(color);
			pixelsB = Color.blue(color);
			// R
			int pixel = pixelsR - pixelsG - pixelsB;
			pixel = pixel * 3 / 2;
			if (pixel < 0) {
				pixel = -pixel;
			}
			if (pixel > 255) {
				pixel = 255;
			}
			pixelsR = pixel; // 计算后重置R值，以下类同
			// G
			pixel = pixelsG - pixelsR - pixelsB;
			pixel = pixel * 3 / 2;
			if (pixel < 0) {
				pixel = -pixel;
			}
			if (pixel > 255) {
				pixel = 255;
			}
			pixelsG = pixel;
			// B
			pixel = pixelsB - pixelsR - pixelsG;
			pixel = pixel * 3 / 2;
			if (pixel < 0) {
				pixel = -pixel;
			}
			if (pixel > 255) {
				pixel = 255;
			}
			pixelsB = pixel;

			// 根据新的RGB生成新像素
			newPixels[i] = Color.argb(pixelsA, pixelsR, pixelsG, pixelsB);

		}
		// 根据新像素生成新图片
		newbitmap.setPixels(newPixels, 0, width, 0, 0, width, height);
		canvas.drawBitmap(newbitmap, 0, 0, myPaint);
	}
}
