package com.zpp.projectactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.zpp.activity.R;
import com.zpp.impl.HandWriteView;

public class HandWritingActivity extends Activity  
{  
    /** Called when the activity is first created. */  
    private HandWriteView handWrite;  
    private Button clear;  
    @Override  
    public void onCreate(Bundle savedInstanceState)  
    {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.handwrite);  
        
        handWrite = (HandWriteView)findViewById(R.id.handwriteview);  
        clear = (Button)findViewById(R.id.clear);
        
        clear.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 handWrite.clear();  
			}
		});  
    } 
}  