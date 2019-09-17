package com.nengliang.web.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.junit.Test;

public class PrinterWriter {

	/**
	 * PriterWriter,缓冲字符输出流
	 * 
	 */

	// @Test
	public void fileOut() throws IOException {

		FileOutputStream fos = new FileOutputStream("E:\\wen.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		PrintWriter pw = new PrintWriter(osw);
		// wen.txt已经写入了信息
		// 12个字节
		// pw.print("恒邦好的");

		// 8个字节= 2个汉字 + 2个空格
		pw.println("不错");
		pw.flush();
		pw.close();
	}

	// @Test
	public void fie() throws IOException {
		// BufferedReader 读操作

		File file = new File("E:\\wen.txt");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		// 只读一行
		int t = -1;
		String str = null;
		/*
		 * if((str = br.readLine()) != null) { System.out.println(str); }
		 */
		int len = (int) file.length();
		char[] cbuf = new char[len];
		// 读出所有数据
		if ((t = br.read(cbuf, 0, len)) != -1) {
			System.out.println(t);
		}

		br.close();
	}

	// 文件的复制,mp4,word,ppt,excel这四个不可以复制
	// @Test
	public void readWrite() throws IOException {
		// 读操作
		File file = new File("E:\\wen.txt");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		// 写操作
		FileOutputStream fos = new FileOutputStream("E:\\wen1.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		PrintWriter pw = new PrintWriter(osw);

		// 文件复制操作
		int t = -1;
		int len = (int) file.length();
		char[] cbuf = new char[len];
		while ((t = br.read(cbuf, 0, len)) != -1) {
			pw.write(cbuf, 0, len);
			pw.flush();
		}
		br.close();
		pw.close();
	}

}
