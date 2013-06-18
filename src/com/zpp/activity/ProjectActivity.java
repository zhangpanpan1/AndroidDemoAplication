package com.zpp.activity;

import com.zpp.project.snow.SnowActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ProjectActivity extends Activity {
	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.lv);
		String project[] = getResources().getStringArray(R.array.project_item);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, project);

		lv.setAdapter(adapter);
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				if(position==0){
					intent.setClass(ProjectActivity.this, SnowActivity.class);
					startActivity(intent);
				}else if(position==3){
					intent.setClass(ProjectActivity.this, PictureActivity.class);
					startActivity(intent);
				}
				
			}
		});

	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

	}

}
