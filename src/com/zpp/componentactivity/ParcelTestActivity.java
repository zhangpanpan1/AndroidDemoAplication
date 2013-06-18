package com.zpp.componentactivity;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.zpp.activity.R;
import com.zpp.impl.Person;

public class ParcelTestActivity extends Activity {
	    private TextView tv;
	    @Override  
	    public void onCreate(Bundle savedInstanceState) {   
	        super.onCreate(savedInstanceState);   
	        setContentView(R.layout.parcelmaintest);   
	        tv=(TextView)findViewById(R.id.tv);
	        
	        Intent i = getIntent();   
	        Person p = i.getParcelableExtra("person");   
	        String name=p.name;
	        HashMap<String, String> map=p.map;
	        tv.setText("name:"+name+"\n"+"age:"+map.get("age"));
	        
	    }   
}
