package com.zpp.componentactivity;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.zpp.activity.R;
import com.zpp.impl.CastingView;
import com.zpp.impl.FrozenView;
import com.zpp.impl.NegativeView;
import com.zpp.impl.TurnBitmapView;
import com.zpp.impl.ZoomBitmapView;

public class ControlBitMapActivity extends Activity {

	private ImageView iv;
	private static int SELECT_PICTURE;// ���ر�־λ filed
	private File tempFile = new File("/sdcard/qq.jpg");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		int position = intent.getIntExtra("position", 0);
		System.out.println("position=" + position);
		if (position == 4) {

			setContentView(new NegativeView(this));

		} else if (position == 12) {
			setContentView(new TurnBitmapView(this));

		} else if (position == 10) {
			setContentView(new CastingView(this, null));

		} else if (position == 11) {
			setContentView(new FrozenView(this, null));

		} else if (position == 13) {
			setContentView(new ZoomBitmapView(this));
		} else if (position == 14) {
			setContentView(R.layout.blurimage);
			iv = (ImageView) findViewById(R.id.blur);
			Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
					R.drawable.qq);
			iv.setImageBitmap(bitmap);

			iv.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
					intent.setType("image/*");
					intent.putExtra("crop", "true");// crop=true �������ܳ������Ĳü�ҳ��.

					intent.putExtra("aspectX", 1);// ������Ϊ�ü���ı���.
					intent.putExtra("aspectY", 2);// x:y=1:2

					intent.putExtra("output", Uri.fromFile(tempFile));
					intent.putExtra("outputFormat", "JPEG");// ���ظ�ʽ

					startActivityForResult(
							Intent.createChooser(intent, "ѡ��ͼƬ"),
							SELECT_PICTURE);
				}
			});
		}
	}

	/**
	 * �ü���ͼƬ��ϵͳ���õķ���:onActivityResult
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK)
			if (requestCode == SELECT_PICTURE)
				iv.setImageDrawable(Drawable.createFromPath(tempFile
						.getAbsolutePath()));
	}
}
