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
	 * 保存内容到sd卡中（以私有文件形式保存）
	 * 
	 * @param filename
	 *            文件名称
	 * @param content
	 *            文件内容
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
	 * 保存内容（以私有文件形式保存）
	 * 
	 * @param filename
	 *            文件名称
	 * @param content
	 *            文件内容
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
	 * 保存内容（以私有文件形式保存+追加）
	 * 
	 * @param filename
	 *            文件名称
	 * @param content
	 *            文件内容
	 * @throws Exception
	 */
	public void saveAppend(String fileName, String content) throws Exception { // ctrl+shift+y
																				// 变小写
																				// ctrl+shift+x
																				// 变大写
	//	FileOutputStream outputStream = context.openFileOutput(fileName,
		//		Context.MODE_WORLD_READABLE);

		File file = new File(fileName);
		FileOutputStream outputStream = new FileOutputStream(file,true);
		
		
		outputStream.write(content.getBytes());
		outputStream.close();
	}

	/**
	 * 保存内容（允许其他应用读取）
	 * 
	 * @param filename
	 *            文件名称
	 * @param content
	 *            文件内容
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
	 * 文件读取
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
		while ((len = inputStream.read(buffer)) != -1) {// 读取文件到缓冲区
			byteArrayOutputStream.write(buffer, 0, len);// 写入到内存
		}
		byte[] data = byteArrayOutputStream.toByteArray();// 将内存中的二进制数据转为数组
		byteArrayOutputStream.close();
		inputStream.close();
		
		return new String(data);
		
	}
}
