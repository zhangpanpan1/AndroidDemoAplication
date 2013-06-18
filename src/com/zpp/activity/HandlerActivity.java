package com.zpp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HandlerActivity extends Activity {
	private TextView tv;
	int i;
	private Button handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.handler);
		tv = (TextView) findViewById(R.id.handler);
		handler=(Button)findViewById(R.id.handler_btn);
	
		handler.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MyHandler.post(r);
			}
		});
		
		
		

	}
	
	
	

	Runnable r = new Runnable() {

		@Override
		public void run() { // TODO Auto-generated method stub

			for (int j = 0; j < 10000; j++) {
				i = i + j;
				
			}
		 
				Message msg = MyHandler.obtainMessage();  
			    msg.obj = i;
			    msg.what = 1;
			    MyHandler.sendMessage(msg);
		 
			
			
		}
	};
	
	private Handler MyHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.what == 1) {

				tv.setText(((Integer) msg.obj).toString());
				MyHandler.removeCallbacks(r);
				//MyHandler.post(r);
			}

		}
	};

}
