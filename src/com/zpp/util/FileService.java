package com.zpp.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import android.content.Context;
import android.os.Environment;

public class FileService {
	private Context context;

	public FileService(Context context) {
		this.context = context;
	}

	/**
	 * �������ݵ�sd���У���˽���ļ���ʽ���棩
	 * 
	 * @param filename
	 *            �ļ�����
	 * @param content
	 *            �ļ�����
	 * @throws Exception
	 */
	
	public void save2sdCard(String fileName, String content) throws Exception {
		File file = new File(Environment.getExternalStorageDirectory(),fileName);
		file.createNewFile();
		System.out.println(Environment.getExternalStorageDirectory());
		FileOutputStream outputStream = new FileOutputStream(file);
		outputStream.write(content.getBytes());
		outputStream.close();
	}
	
	/**
	 * �������ݣ���˽���ļ���ʽ���棩
	 * 
	 * @param filename
	 *            �ļ�����
	 * @param content
	 *            �ļ�����
	 * @throws Exception
	 */
	public void save(String fileName, String content) throws Exception {
		//FileOutputStream outputStream = context.openFileOutput(fileName,
		//		Context.MODE_WORLD_READABLE);

		File file = new File(fileName);
		FileOutputStream outputStream = new FileOutputStream(file);
		outputStream.write(content.getBytes());
		outputStream.close();
	}

	/**
	 * �������ݣ���˽���ļ���ʽ����+׷�ӣ�
	 * 
	 * @param filename
	 *            �ļ�����
	 * @param content
	 *            �ļ�����
	 * @throws Exception
	 */
	public void saveAppend(String fileName, String content) throws Exception { // ctrl+shift+y
																				// ��Сд
																				// ctrl+shift+x
																				// ���д
	//	FileOutputStream outputStream = context.openFileOutput(fileName,
		//		Context.MODE_WORLD_READABLE);

		File file = new File(fileName);
		FileOutputStream outputStream = new FileOutputStream(file,true);
		
		
		outputStream.write(content.getBytes());
		outputStream.close();
	}

	/**
	 * �������ݣ���������Ӧ�ö�ȡ��
	 * 
	 * @param filename
	 *            �ļ�����
	 * @param content
	 *            �ļ�����
	 * @throws Exception
	 */
	public void saveReadAble(String fileName, String content) throws Exception {
		//FileOutputStream outputStream = context.openFileOutput(fileName,
				//Context.MODE_WORLD_READABLE);
		
		
		File file = new File(fileName);
		FileOutputStream outputStream = new FileOutputStream(file);
		
		outputStream.write(content.getBytes());
		outputStream.close();
	}

	/**
	 * �ļ���ȡ
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	
	public String read(String fileName) throws Exception {
		//FileInputStream inputStream = context.openFileInput(fileName);
		
		File file = new File(fileName);
		FileInputStream inputStream = new FileInputStream(file);
		
		
		byte[] buffer = new byte[1024];
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		int len = -1;
		while ((len = inputStream.read(buffer)) != -1) {// ��ȡ�ļ���������
			byteArrayOutputStream.write(buffer, 0, len);// д�뵽�ڴ�
		}
		byte[] data = byteArrayOutputStream.toByteArray();// ���ڴ��еĶ���������תΪ����
		byteArrayOutputStream.close();
		inputStream.close();
		
		return new String(data);
		
	}
}
