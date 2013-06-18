package com.zpp.componentactivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.zpp.activity.R;

public class ReqActivity extends Activity {

	private Button btn01;
	private TextView tv01;
	public static final int REQUSET = 1;
	 static final int PICK_CONTACT_REQUEST = 1;
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		/*super.onActivityResult(requestCode, resultCode, data);
		// requestCode标示请求的标示 resultCode表示有数据
		if (requestCode == ReqActivity.REQUSET && resultCode == RESULT_OK) {
			String str = "账号"
					+ data.getStringExtra(RequestInfoActivity.KEY_USER_ID) + "\n"
					+ "密码"
					+ data.getStringExtra(RequestInfoActivity.KEY_USER_PASSWORD);
			tv01.setText(str);
		}
		Toast.makeText(
				this,
				"requestCode=" + requestCode + ":" + "resultCode=" + resultCode,
				Toast.LENGTH_LONG).show();*/
		
		
		 if (requestCode == PICK_CONTACT_REQUEST) {
		        // Make sure the request was successful
		        if (resultCode == RESULT_OK) {
		        	// 接收数据然后多数据进行处理
		            // Get the URI that points to the selected contact
		            Uri contactUri = data.getData();
		            // We only need the NUMBER column, because there will be only one row in the result
		            String[] projection = {Phone.NUMBER};
		            // Perform the query on the contact to get the NUMBER column
		            // We don't need a selection or sort order (there's only one result for the given URI)
		            // CAUTION: The query() method should be called from a separate thread to avoid blocking
		            // your app's UI thread. (For simplicity of the sample, this code doesn't do that.)
		            // Consider using CursorLoader to perform the query.
		            Cursor cursor = getContentResolver() .query(contactUri, projection, null, null, null);
		            cursor.moveToFirst();
		            // Retrieve the phone number from the NUMBER column
		            int column = cursor.getColumnIndex(Phone.NUMBER);
		            
		            String number = cursor.getString(column);
		            System.out.println(number);
		            
		            // Do something with the phone number...
		        }
		    }
		
		
		
		
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.req);
		btn01 = (Button) findViewById(R.id.btn01);
		tv01 = (TextView) findViewById(R.id.tv01);
		btn01.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			/*	Intent intent = new Intent(ReqActivity.this,
						RequestInfoActivity.class);
				// 发送意图标示为REQUSET=1
				startActivityForResult(intent, REQ SET);*/
				
				// 跳转到联系人 选择一个电话号码后返回
				Uri u=Uri.parse("content://contacts");
				Intent pickContactIntent =new Intent(Intent.ACTION_PICK, u);
				pickContactIntent.setType(Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
				startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
			}
		});

	}
}