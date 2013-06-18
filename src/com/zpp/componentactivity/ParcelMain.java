package com.zpp.componentactivity;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.zpp.activity.R;
import com.zpp.impl.Person;

public class ParcelMain extends Activity {
	
	private Button btn;
	    @Override  
	    public void onCreate(Bundle savedInstanceState) {   
	        super.onCreate(savedInstanceState);   
	         setContentView(R.layout.parcelmain);
	         btn=(Button)findViewById(R.id.btn);
	         btn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();   
					Person p = new Person(); 
					
					p.map = new HashMap<String,String>();   
					p.map.put("age", "25");   
					p.name="zhangpan";   
					intent.putExtra("person", p);  
					
					intent.setClass(ParcelMain.this, ParcelTestActivity.class);   
					startActivity(intent);   
				}
			});
	        
	    }   

}
