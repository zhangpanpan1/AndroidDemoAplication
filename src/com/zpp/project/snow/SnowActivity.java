package com.zpp.project.snow;

import com.zpp.activity.R;

import android.app.Activity;
import android.app.Service;
import android.content.ContentProvider;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;

public class SnowActivity extends Activity {
	
	SnowView snow = null;
 
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.snowmain);

		// ���ѩ����ͼ,������ѩ��ͼƬ���ڴ�
		snow = (SnowView) findViewById(R.id.snow);
		snow.LoadSnowImage();

		// ��ȡ��ǰ��Ļ�ĸߺͿ�
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		snow.SetView(dm.heightPixels, dm.widthPixels);
		// ���µ�ǰѩ��
		update();
		
	}
	
	/*
	 * ������������¹��� ��ʵ����ѩ
	 */
	private RefreshHandler mRedrawHandler = new RefreshHandler();

	class RefreshHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {
			//snow.addRandomSnow();
			snow.invalidate();
			sleep(110);
		}
		
		public void sleep(long delayMillis) {
			this.removeMessages(0);
			sendMessageDelayed(obtainMessage(0), delayMillis);
			//postAtTime(delayMillis);
		}
	};

	/**
	 * Handles the basic update loop, checking to see if we are in the running
	 * state, determining if a move should be made, updating the snake's
	 * location.
	 */
	public void update() {
		snow.addRandomSnow();
		mRedrawHandler.sleep(200);
	}
}
