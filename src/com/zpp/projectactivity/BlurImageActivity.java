package com.zpp.projectactivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.zpp.activity.R;

public class BlurImageActivity extends Activity {
	private ImageView iv;
	Bitmap bitmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.blurimage);
		iv = (ImageView) findViewById(R.id.blur);
		bitmap = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.qq);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(menu.NONE, 1, 1, "��˹ģ��").setIcon(
				android.R.drawable.ic_menu_add);
		menu.add(menu.NONE, 2, 2, "����Ч��").setIcon(
				android.R.drawable.ic_menu_add);
		menu.add(menu.NONE, 3, 3, "��Ч��").setIcon(
				android.R.drawable.ic_menu_add);

		menu.add(menu.NONE, 4, 4, "����Ч��").setIcon(
				android.R.drawable.ic_menu_add);
	 

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (1 == item.getItemId()) {
			iv.setImageBitmap(blurImageAmeliorate(bitmap));
		} else if (2 == item.getItemId()) {
			iv.setImageBitmap(oldRemeber(bitmap));
		} else if (3 == item.getItemId()) {
			iv.setImageBitmap(sharpenImageAmeliorate(bitmap));
		} else if (4 == item.getItemId()) {
			iv.setImageBitmap(halo(bitmap, 100, 100, 200));
		}

		return true;
	}

	/**
	 * �ữЧ��(��˹ģ��)
	 * 
	 * @param bmp
	 * @return
	 */
	private Bitmap blurImageAmeliorate(Bitmap bmp) {
		long start = System.currentTimeMillis();
		// ��˹����
		int[] gauss = new int[] { 1, 2, 1, 2, 4, 2, 1, 2, 1 };

		int width = bmp.getWidth();
		int height = bmp.getHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height,Bitmap.Config.RGB_565);

		int pixR = 0;
		int pixG = 0;
		int pixB = 0;

		int pixColor = 0;

		int newR = 0;
		int newG = 0;
		int newB = 0;

		int delta = 16; // ֵԽСͼƬ��Խ����Խ����Խ��

		int idx = 0;
		int[] pixels = new int[width * height];
		bmp.getPixels(pixels, 0, width, 0, 0, width, height);
		for (int i = 1, length = height - 1; i < length; i++) {
			for (int k = 1, len = width - 1; k < len; k++) {
				idx = 0;
				for (int m = -1; m <= 1; m++) {
					for (int n = -1; n <= 1; n++) {
						pixColor = pixels[(i + m) * width + k + n];
						pixR = Color.red(pixColor);
						pixG = Color.green(pixColor);
						pixB = Color.blue(pixColor);

						newR = newR + (int) (pixR * gauss[idx]);
						newG = newG + (int) (pixG * gauss[idx]);
						newB = newB + (int) (pixB * gauss[idx]);
						idx++;
					}
				}

				newR /= delta;
				newG /= delta;
				newB /= delta;

				newR = Math.min(255, Math.max(0, newR));
				newG = Math.min(255, Math.max(0, newG));
				newB = Math.min(255, Math.max(0, newB));

				pixels[i * width + k] = Color.argb(255, newR, newG, newB);

				newR = 0;
				newG = 0;
				newB = 0;
			}
		}

		bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
		long end = System.currentTimeMillis();
		Log.d("may", "used time=" + (end - start));
		return bitmap;
	}

	/**
	 * ����Ч��(���֮ǰ�����Ż���һ��)
	 * 
	 * @param bmp
	 * @return
	 */
	private Bitmap oldRemeber(Bitmap bmp) {
		// �ٶȲ���
		long start = System.currentTimeMillis();
		int width = bmp.getWidth();
		int height = bmp.getHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.RGB_565);
		int pixColor = 0;
		int pixR = 0;
		int pixG = 0;
		int pixB = 0;
		int newR = 0;
		int newG = 0;
		int newB = 0;
		int[] pixels = new int[width * height];
		bmp.getPixels(pixels, 0, width, 0, 0, width, height);
		for (int i = 0; i < height; i++) {
			for (int k = 0; k < width; k++) {
				pixColor = pixels[width * i + k];
				pixR = Color.red(pixColor);
				pixG = Color.green(pixColor);
				pixB = Color.blue(pixColor);
				newR = (int) (0.393 * pixR + 0.769 * pixG + 0.189 * pixB);
				newG = (int) (0.349 * pixR + 0.686 * pixG + 0.168 * pixB);
				newB = (int) (0.272 * pixR + 0.534 * pixG + 0.131 * pixB);
				int newColor = Color.argb(255, newR > 255 ? 255 : newR,
						newG > 255 ? 255 : newG, newB > 255 ? 255 : newB);
				pixels[width * i + k] = newColor;
			}
		}

		bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
		long end = System.currentTimeMillis();
		Log.d("may", "used time=" + (end - start));
		return bitmap;
	}

	/**
	 * ���㷨���ֱ��ȡ��ǰ���ص�Ͱ˸���Χ���ص��RGBֵ�� �������ǰ���ص��RGBֵ��˸����ص�RGBֵ�ĺ͵�ƽ������
	 * �ٳ�����Ӧ��ϵ����Ȼ�����뵱ǰ���ص�֮�͡�
	 * 
	 * ͼƬ�񻯣�������˹�任��
	 * 
	 * @param bmp
	 * @return
	 */
	private Bitmap sharpenImageAmeliorate(Bitmap bmp) {
		long start = System.currentTimeMillis();
		// ������˹����
		int[] laplacian = new int[] { -1, -1, -1, -1, 9, -1, -1, -1, -1 };

		int width = bmp.getWidth();
		int height = bmp.getHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.RGB_565);

		int pixR = 0;
		int pixG = 0;
		int pixB = 0;

		int pixColor = 0;

		int newR = 0;
		int newG = 0;
		int newB = 0;

		int idx = 0;
		float alpha = 0.3F;
		int[] pixels = new int[width * height];
		bmp.getPixels(pixels, 0, width, 0, 0, width, height);
		for (int i = 1, length = height - 1; i < length; i++) {
			for (int k = 1, len = width - 1; k < len; k++) {
				idx = 0;
				for (int m = -1; m <= 1; m++) {
					for (int n = -1; n <= 1; n++) {
						pixColor = pixels[(i + n) * width + k + m];
						pixR = Color.red(pixColor);
						pixG = Color.green(pixColor);
						pixB = Color.blue(pixColor);

						newR = newR + (int) (pixR * laplacian[idx] * alpha);
						newG = newG + (int) (pixG * laplacian[idx] * alpha);
						newB = newB + (int) (pixB * laplacian[idx] * alpha);
						idx++;
					}
				}

				newR = Math.min(255, Math.max(0, newR));
				newG = Math.min(255, Math.max(0, newG));
				newB = Math.min(255, Math.max(0, newB));

				pixels[i * width + k] = Color.argb(255, newR, newG, newB);
				newR = 0;
				newG = 0;
				newB = 0;
			}
		}

		bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
		long end = System.currentTimeMillis();
		Log.d("may", "used time=" + (end - start));
		return bitmap;
	}

	/**
	 * ����Ч��
	 * 
	 * @param bmp
	 * @param x
	 *            �������ĵ���bmp�е�x����
	 * @param y
	 *            �������ĵ���bmp�е�y����
	 * @param r
	 *            ���εİ뾶
	 * @return
	 */
	public Bitmap halo(Bitmap bmp, int x, int y, float r) {
		long start = System.currentTimeMillis();
		// ��˹����
		int[] gauss = new int[] { 1, 2, 1, 2, 4, 2, 1, 2, 1 };

		int width = bmp.getWidth();
		int height = bmp.getHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.RGB_565);

		int pixR = 0;
		int pixG = 0;
		int pixB = 0;

		int pixColor = 0;

		int newR = 0;
		int newG = 0;
		int newB = 0;

		int delta = 18; // ֵԽСͼƬ��Խ����Խ����Խ��

		int idx = 0;
		int[] pixels = new int[width * height];
		bmp.getPixels(pixels, 0, width, 0, 0, width, height);
		for (int i = 1, length = height - 1; i < length; i++) {
			for (int k = 1, len = width - 1; k < len; k++) {
				idx = 0;
				int distance = (int) (Math.pow(k - x, 2) + Math.pow(i - y, 2));
				// ������������ĵ���ģ������
				if (distance > r * r) {
					for (int m = -1; m <= 1; m++) {
						for (int n = -1; n <= 1; n++) {
							pixColor = pixels[(i + m) * width + k + n];
							pixR = Color.red(pixColor);
							pixG = Color.green(pixColor);
							pixB = Color.blue(pixColor);

							newR = newR + (int) (pixR * gauss[idx]);
							newG = newG + (int) (pixG * gauss[idx]);
							newB = newB + (int) (pixB * gauss[idx]);
							idx++;
						}
					}

					newR /= delta;
					newG /= delta;
					newB /= delta;

					newR = Math.min(255, Math.max(0, newR));
					newG = Math.min(255, Math.max(0, newG));
					newB = Math.min(255, Math.max(0, newB));

					pixels[i * width + k] = Color.argb(255, newR, newG, newB);

					newR = 0;
					newG = 0;
					newB = 0;
				}
			}
		}

		bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
		long end = System.currentTimeMillis();
		Log.d("may", "used time=" + (end - start));
		return bitmap;
	}

	/**
	 * ��ƬЧ��
	 * 
	 * @param bmp
 
	 * @return
	 */
	public Bitmap negative(Bitmap bmp) {
		long start = System.currentTimeMillis();

		Bitmap bitmap = null;
		int width, height;
		int[] oldPixels;
		int[] newPixels;
		int color;

		int pixelsR, pixelsG, pixelsB, pixelsA;

		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.qq);
		
	

		width = bitmap.getWidth();
		height = bitmap.getHeight();
		oldPixels = new int[width * height];
		newPixels = new int[width * height];
		//�½�һ������isMutable��Bitmap
    	Bitmap newbitmap = Bitmap.createBitmap(width, height,Bitmap.Config.RGB_565);

		for (int i = 1; i < height * width; i++) {
			color = oldPixels[i];
			// ��ȡRGB����
			pixelsA = Color.alpha(color);
			pixelsR = Color.red(color);
			pixelsG = Color.green(color);
			pixelsB = Color.blue(color);

			// ת��
			pixelsR = (255 - pixelsR);
			pixelsG = (255 - pixelsG);
			pixelsB = (255 - pixelsB);
			// ��С�ڵ���255���ڵ���0
			if (pixelsR > 255) {
				pixelsR = 255;
			} else if (pixelsR < 0) {
				pixelsR = 0;
			}
			if (pixelsG > 255) {
				pixelsG = 255;
			} else if (pixelsG < 0) {
				pixelsG = 0;
			}
			if (pixelsB > 255) {
				pixelsB = 255;
			} else if (pixelsB < 0) {
				pixelsB = 0;
			}
			// �����µ�RGB����������
			newPixels[i] = Color.argb(pixelsA, pixelsR, pixelsG, pixelsB);

		}
		// ����������������ͼƬ
		newbitmap.setPixels(newPixels, 0, width, 0, 0, width, height);

		long end = System.currentTimeMillis();
		Log.d("may", "used time=" + (end - start));
		return newbitmap;
	}

}
