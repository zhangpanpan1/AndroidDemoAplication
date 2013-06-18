package com.zpp.componentactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.zpp.activity.R;

public class SubThreadActivity extends Activity {

	TextView mTextView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainlist);
		mTextView = (TextView) findViewById(R.id.item);
		mTextView.setText("我在主线程中运行了！");
		new Thread() {
			public void run() {
				mTextView.setText("我在子线程中运行了！");
			};
		}.start();

	}
	
}