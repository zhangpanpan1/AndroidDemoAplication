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
	public static String[] mListStr = { "1 ����", "2 ����", "3 ������", "4 �ữ����", "5 ������Ե", "6 ��Ч��", "7 ����ģ��", "8 LomoFilter","9 ��Ӱ��Ч", "10 ��ɫЧ��-��ɫ", "11 ��ɫЧ��-��ɫ","12 ��ɫЧ��-��ɫ", "13 ��ɫЧ��-��&��","14 ��ɫЧ��-��&��","�û�����"};

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