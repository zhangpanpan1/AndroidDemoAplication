package com.zpp.activity;
 

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity{
	
	private static String project="PROJECT";
	private static String component="COMPONENT";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  String[] item = getResources().getStringArray(R.array.item);
		  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		  android.R.layout.simple_list_item_1, item);
		  setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent intent=new Intent();
		if(position==0){
		   intent.setClass(MainActivity.this,ProjectActivity.class);
 		   intent.setAction(project);
 		    
			
		}else if(position==1){
			intent.setClass(MainActivity.this,ComponentActivity.class);
			intent.setAction(component);
			
		}else if(position==2){
			intent.setClass(MainActivity.this,PicActivity.class);
		}
		  
		startActivity(intent);
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
