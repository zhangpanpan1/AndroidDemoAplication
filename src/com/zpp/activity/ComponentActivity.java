package com.zpp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.peter.viewpage.MainActivity;
import com.zpp.componentactivity.ParcelMain;
import com.zpp.componentactivity.ReqActivity;
import com.zpp.componentactivity.SubThreadActivity;
import com.zpp.componentactivity.ViewPageMainActivity;

public class ComponentActivity extends Activity {
	private ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	 	setContentView(R.layout.activity_main);
	    lv=(ListView)findViewById(R.id.lv);
	    String component[]=getResources().getStringArray(R.array.component_item);
	   
	    ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,component);
	    
		
	    lv.setAdapter(adapter);
	    
	    
	    
	    lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
			//	System.out.println(position);
				Intent intent=new Intent();
				 if (position == 0) {
					intent.setClass(ComponentActivity.this, ParcelMain.class);
					
				}else if(position==1){
					intent.setClass(ComponentActivity.this, HandlerActivity.class);
				}else if(position==2){
					intent.setClass(ComponentActivity.this, ReqActivity.class);
				}else if(position==3){
					intent.setClass(ComponentActivity.this, SubThreadActivity.class);
					
				}else if(position==4){
					intent.setClass(ComponentActivity.this, MainActivity.class);
				}else if(position==5){
					intent.setClass(ComponentActivity.this, ViewPageMainActivity.class);
				}
				 startActivity(intent);
			}
		});
	     
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		
	}
}
