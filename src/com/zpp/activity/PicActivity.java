package com.zpp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PicActivity extends Activity {
	ListView mListView;
	public static String[] mListStr = { "1 冰冻", "2 熔铸", "3 连环画", "4 柔化美白", "5 照亮边缘", "6 羽化效果", "7 缩放模糊", "8 LomoFilter","9 电影特效", "10 反色效果-绿色", "11 反色效果-红色","12 反色效果-蓝色", "13 反色效果-绿&蓝","14 反色效果-红&绿","用户反馈"};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		findView();
	}

	private void findView() {
		mListView = (ListView) findViewById(R.id.listview);
		// SimpleAdapter = new SimpleAdapter(context, data, resource, from, to)
		mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mListStr));
		mListView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
				Intent intent = new Intent(PicActivity.this, ImageFilterActivity.class);
				intent.putExtra("position", position);
				startActivity(intent);
			}
		});
	}
}