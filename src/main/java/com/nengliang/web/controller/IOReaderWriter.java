package com.nengliang.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOReaderWriter {

	/**
	 * 使用字符流按照指定编码格式进行读写操作 InputStreamReader , OutputStreamWriter
	 */

	// InputStreamReader ，一个一个字节的文件复制
	public static void readFile(File file, File copyFile) throws IOException {

		FileInputStream in = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(in, "gbk");
		FileOutputStream out = new FileOutputStream(copyFile);
		OutputStreamWriter osw = new OutputStreamWriter(out, "gbk");
		Long start = System.nanoTime();

		int i = -1;
		while ((i = isr.read()) != -1) {
			osw.write(i);
		}

		Long end = System.nanoTime();
		// 342174
		System.out.println("readFile复制文件耗时：" + (end - start));
		isr.close();
		osw.close();
	}

	// InputStreamReader ，批量文件复制
	public static void readFileBatch(File file, File copyFile) throws IOException {

		FileInputStream in = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(in, "gbk");
		FileOutputStream out = new FileOutputStream(copyFile);
		OutputStreamWriter osw = new OutputStreamWriter(out, "gbk");
		Long start = System.nanoTime();

		int length = (int) file.length();
		char[] cbuf = new char[length];
		int t = -1;
		while ((t = isr.read(cbuf, 0, length)) != -1) {
			osw.write(cbuf, 0, length);
		}

		Long end = System.nanoTime();
		// 819988
		System.out.println("readFileBatch复制文件耗时：" + (end - start));
		isr.close();
		osw.close();
	}

	// InputStreamReader ，批量文件复制
	public static void readFileBatchOne(File file, File copyFile) throws IOException {

		FileInputStream in = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(in, "gbk");
		FileOutputStream out = new FileOutputStream(copyFile);
		OutputStreamWriter osw = new OutputStreamWriter(out, "gbk");
		Long start = System.nanoTime();

		int length = (int) file.length();
		char[] cbuf = new char[length];
		int t = -1;
		while ((t = isr.read(cbuf)) != -1) {
			osw.write(cbuf);
		}

		Long end = System.nanoTime();
		// 477342
		System.out.println("readFileBatchOne复制文件耗时：" + (end - start));
		isr.close();
		osw.close();
	}

	// OutputStreamWriter ，写操作
	public static void fileOne(File file) throws IOException {

		FileOutputStream out = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(out, "gbk");
		Long start = System.nanoTime();

		osw.write("国家好");

		Long end = System.nanoTime();
		// 477342
		System.out.println("readFileBatchOne复制文件耗时：" + (end - start));
		osw.close();
	}

	public static void main(String[] args) throws IOException {
		// word,ppt,excel,mp4这四个不可以复制
		String oldPath = "E:\\aa.txt";
		String newPath = "E:\\aa1.txt";
		File oldFile = new File(oldPath);
		File copyFile = new File(newPath);

		// 进行读写操作
		// IOReaderWriter.readFile(oldFile, copyFile);
		IOReaderWriter.readFileBatch(oldFile, copyFile);
		// IOReaderWriter.readFileBatchOne(oldFile, copyFile);
		// IOReaderWriter.fileOne(oldFile);

	}

}
