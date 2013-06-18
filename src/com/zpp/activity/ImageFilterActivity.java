package com.zpp.activity;

 
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

import com.imageFilters.ColorToneFilter;
import com.imageFilters.ComicFilter;
import com.imageFilters.FeatherFilter;
import com.imageFilters.FilmFilter;
import com.imageFilters.GlowingEdgeFilter;
import com.imageFilters.IceFilter;
import com.imageFilters.LomoFilter;
import com.imageFilters.MoltenFilter;
import com.imageFilters.SoftGlowFilter;
import com.imageFilters.ZoomBlurFilter;
import com.zpp.util.ImageCache;
import com.zpp.util.ImageUtil;

public class ImageFilterActivity extends Activity {

	private final int PROGRESS_WAIT_VISIBLE = 1;
	private final int PROGRESS_WAIT_GONE = 2;
	
	ImageView imageView1, imageView2;
	Drawable mDrawable;
	Bitmap mBitmap;

	Context mContext;
	
	int colortone;
	
	private String[] key = {"IceFilter","MoltenFilter", "ComicFilter", "SoftGlowFilter", "GlowingEdgeFilter"
			,"FeatherFilter", "ZoomBlurFilter", "LomoFilter", "FilmFilter", "ColorToneFilter"};

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.image);
		mContext = this;
		findView();

		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		int pos = bundle.getInt("position", 0);
		Bitmap tmpBitmap;
		switch (pos) {
		case 0:
			 
			
			if (ImageCache.get(key[0]) != null) {
				tmpBitmap = ImageCache.get(key[0]);
				imageView2.setImageBitmap(tmpBitmap);
				break;
			}
			new Thread(){
				public void run() {
					mHandler.sendEmptyMessage(PROGRESS_WAIT_VISIBLE);
					Bitmap tmpBitmap = new IceFilter(mBitmap).imageProcess().getDstBitmap();
					Message msg = new Message();
					msg.obj = tmpBitmap;
					msg.arg1 = 0;
					msg.what = PROGRESS_WAIT_GONE;
					mHandler.sendMessage(msg);
				}
			}.start();
			break;
			
		case 1:
			
			if (ImageCache.get(key[1]) != null) {
				tmpBitmap = ImageCache.get(key[1]);
				imageView2.setImageBitmap(tmpBitmap);
				break;
			}
			new Thread(){
				public void run() {
					mHandler.sendEmptyMessage(PROGRESS_WAIT_VISIBLE);
					Bitmap tmpBitmap = new MoltenFilter(mBitmap).imageProcess().getDstBitmap();
					Message msg = new Message();
					msg.obj = tmpBitmap;
					msg.arg1 = 1;
					msg.what = PROGRESS_WAIT_GONE;
					mHandler.sendMessage(msg);
				}
			}.start();
			break;
			
		case 2:
			if (ImageCache.get(key[2]) != null) {
				tmpBitmap = ImageCache.get(key[2]);
				imageView2.setImageBitmap(tmpBitmap);
				break;
			}
			new Thread(){
				public void run() {
					mHandler.sendEmptyMessage(PROGRESS_WAIT_VISIBLE);
					Bitmap tmpBitmap = new ComicFilter(mBitmap).imageProcess().getDstBitmap();
					Message msg = new Message();
					msg.obj = tmpBitmap;
					msg.arg1 = 2;
					msg.what = PROGRESS_WAIT_GONE;
					mHandler.sendMessage(msg);
				}
			}.start();
			break;
			
		case 3:
			if (ImageCache.get(key[3]) != null) {
				tmpBitmap = ImageCache.get(key[3]);
				imageView2.setImageBitmap(tmpBitmap);
				break;
			}
			new Thread(){
				public void run() {
					mHandler.sendEmptyMessage(PROGRESS_WAIT_VISIBLE);
					Bitmap tmpBitmap = new SoftGlowFilter(mBitmap,10, 0.1f, 0.1f).imageProcess().getDstBitmap();
					Message msg = new Message();
					msg.obj = tmpBitmap;
					msg.arg1 = 3;
					msg.what = PROGRESS_WAIT_GONE;
					mHandler.sendMessage(msg);
				}
			}.start();
			break;
		case 4:
			
			if (ImageCache.get(key[4]) != null) {
				tmpBitmap = ImageCache.get(key[4]);
				imageView2.setImageBitmap(tmpBitmap);
				break;
			}
			new Thread(){
				public void run() {
					mHandler.sendEmptyMessage(PROGRESS_WAIT_VISIBLE);
					Bitmap tmpBitmap = new GlowingEdgeFilter(mBitmap).imageProcess().getDstBitmap();
					Message msg = new Message();
					msg.obj = tmpBitmap;
					msg.arg1 = 4;
					msg.what = PROGRESS_WAIT_GONE;
					mHandler.sendMessage(msg);
				}
			}.start();
			break;
		case 5:		
			
			if (ImageCache.get(key[5]) != null) {
				tmpBitmap = ImageCache.get(key[5]);
				imageView2.setImageBitmap(tmpBitmap);
				break;
			}
			new Thread(){
				public void run() {
					mHandler.sendEmptyMessage(PROGRESS_WAIT_VISIBLE);
					Bitmap tmpBitmap = new FeatherFilter(mBitmap).imageProcess().getDstBitmap();
					Message msg = new Message();
					msg.obj = tmpBitmap;
					msg.arg1 = 5;
					msg.what = PROGRESS_WAIT_GONE;
					mHandler.sendMessage(msg);
				}
			}.start();
			break;
			
		case 6:
			
			if (ImageCache.get(key[6]) != null) {
				tmpBitmap = ImageCache.get(key[6]);
				imageView2.setImageBitmap(tmpBitmap);
				break;
			}
			new Thread(){
				public void run() {
					mHandler.sendEmptyMessage(PROGRESS_WAIT_VISIBLE);
					Bitmap tmpBitmap = new ZoomBlurFilter(mBitmap, 30).imageProcess().getDstBitmap();
					Message msg = new Message();
					msg.obj = tmpBitmap;
					msg.arg1 = 6;
					msg.what = PROGRESS_WAIT_GONE;
					mHandler.sendMessage(msg);
				}
			}.start();
			break;
		case 7:
			
			if (ImageCache.get(key[7]) != null) {
				tmpBitmap = ImageCache.get(key[7]);
				imageView2.setImageBitmap(tmpBitmap);
				break;
			}
			new Thread(){
				public void run() {
					mHandler.sendEmptyMessage(PROGRESS_WAIT_VISIBLE);
					Bitmap tmpBitmap = new LomoFilter(mBitmap).imageProcess().getDstBitmap();
					Message msg = new Message();
					msg.obj = tmpBitmap;
					msg.arg1 = 7;
					msg.what = PROGRESS_WAIT_GONE;
					mHandler.sendMessage(msg);
				}
			}.start();
			break;
		case 8:
			
			if (ImageCache.get(key[8]) != null) {
				tmpBitmap = ImageCache.get(key[8]);
				imageView2.setImageBitmap(tmpBitmap);
				break;
			}
			new Thread(){
				public void run() {
					mHandler.sendEmptyMessage(PROGRESS_WAIT_VISIBLE);
					Bitmap tmpBitmap = new FilmFilter(mBitmap, 80f).imageProcess().getDstBitmap();
					Message msg = new Message();
					msg.obj = tmpBitmap;
					msg.arg1 = 8;
					msg.what = PROGRESS_WAIT_GONE;
					mHandler.sendMessage(msg);
				}
			}.start();
			break;
		case 9:
			colortone =0x00FF00; // green
			ColorTone(colortone);
			break;
		case 10:
			colortone =0xFF0000; // red
			ColorTone(colortone);
			break;
		case 11:
			colortone =0x0000FF; // blue
			ColorTone(colortone);
			break;
		case 12:
			colortone =0x00FFFF; // green&blue
			ColorTone(colortone);
			break;
		case 13:
			colortone =0xFFFF00; // red&green
			ColorTone(colortone);
			break;
		default:
			
			imageView2.setImageBitmap(mBitmap);
			//UMFeedbackService.setGoBackButtonVisible();
		//	UMFeedbackService.openUmengFeedbackSDK(mContext);
			break;
		}
	}

	private void findView() {
		// TODO Auto-generated method stub
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		imageView2 = (ImageView) findViewById(R.id.imageView2);
		mDrawable = imageView1.getDrawable();
		mBitmap = ImageUtil.readBitMap(mContext, R.drawable.image);
		imageView2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				imageView1.setVisibility(View.GONE);
			}
		});
	}
	
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
				case PROGRESS_WAIT_VISIBLE:
					setProgressBarIndeterminateVisibility(true);
					break;
				case PROGRESS_WAIT_GONE:
					setProgressBarIndeterminateVisibility(false);
					Bitmap tmpBitmap =(Bitmap) msg.obj;
					imageView2.setImageBitmap(tmpBitmap);
					ImageCache.put(key[msg.arg1], tmpBitmap);
					break;
				default:
					break;
			}
		}
	};
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	private void ColorTone(final int color) {
		new Thread(){
			public void run() {
				mHandler.sendEmptyMessage(PROGRESS_WAIT_VISIBLE);
				// green
				Bitmap tmpBitmap = new ColorToneFilter(mBitmap, color, 192).imageProcess().getDstBitmap();
				Message msg = new Message();
				msg.obj = tmpBitmap;
				msg.arg1 = 9;
				msg.what = PROGRESS_WAIT_GONE;
				mHandler.sendMessage(msg);
			}
		}.start();
	}
}
