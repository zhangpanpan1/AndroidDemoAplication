package com.zpp.activity;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
 
import com.zpp.componentactivity.ControlBitMapActivity;
import com.zpp.componentactivity.ImageToneActivity;
import com.zpp.projectactivity.BlurImageActivity;
import com.zpp.projectactivity.HandWritingActivity;
import com.zpp.projectactivity.OldImageActivity;
import com.zpp.projectactivity.ReliefActivity;
import com.zpp.projectactivity.ThumbnailActivity;

public class PictureActivity extends ListActivity {
	ArrayList<Class<?>> c=new ArrayList<Class<?>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        c.add(0,BlurImageActivity.class);
        c.add(1,OldImageActivity.class);
        c.add(2,BlurImageActivity.class);
        c.add(3,ReliefActivity.class);
        c.add(4,ControlBitMapActivity.class);
        c.add(5,BlurImageActivity.class);
        c.add(6,BlurImageActivity.class);
        c.add(7,BlurImageActivity.class);
        c.add(8,HandWritingActivity.class);
        c.add(9,ImageToneActivity.class);
        c.add(10,ControlBitMapActivity.class);
        c.add(11,ControlBitMapActivity.class);
        c.add(12,ControlBitMapActivity.class);
        c.add(13,ControlBitMapActivity.class);
        c.add(14,ControlBitMapActivity.class);
        c.add(15,ThumbnailActivity.class);
        
		String effect[] = getResources().getStringArray(R.array.photo_item);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, effect);
		this.setListAdapter(adapter);

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent();
		intent.putExtra("position", position);
		intent.setClass(PictureActivity.this, c.get(position));
		startActivity(intent);
	}
	 
}
