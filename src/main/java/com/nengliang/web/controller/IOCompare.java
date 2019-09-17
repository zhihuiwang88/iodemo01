package com.nengliang.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class IOCompare {

	/**
	 * 文件的复制,进行对比 FileInputStream 和 FileOutputStream DataInputStream 和
	 * DataOutputStream BufferedInputStream 和 BufferedOutputStream 总结：
	 * 采纳FileInputStream批量文件复制 和 BufferedInputStream缓冲流的文件复制
	 */

	// RandomAccessFile 读写操作
	public static void ranfile(File file, File copyFile) throws IOException {
		RandomAccessFile r = new RandomAccessFile(file, "r");
		RandomAccessFile rw = new RandomAccessFile(copyFile, "rw");
		Long start = System.nanoTime();

		String str = null;
		while((str = r.readLine()) != null) {
			rw.writeBytes(str);
		}
		
		Long end = System.nanoTime();
		// 562885
		System.out.println("ranfile复制文件耗时：" + (end - start));
		r.close();
		rw.close();
	}

	// RandomAccessFile 读写操作
	public static void ranfileOne(File file, File copyFile) throws IOException {
		RandomAccessFile r = new RandomAccessFile(file, "r");
		RandomAccessFile rw = new RandomAccessFile(copyFile, "rw");
		Long start = System.nanoTime();
        // 文件复制没有完成
		int b = r.read();
		rw.write(b);

		Long end = System.nanoTime();
		// 408812
		System.out.println("ranfileOne复制文件耗时：" + (end - start));
		r.close();
		rw.close();
	}

	// RandomAccessFile 读写操作
	public static void ranfiletwo(File file, File copyFile) throws IOException {
		RandomAccessFile r = new RandomAccessFile(file, "r");
		RandomAccessFile rw = new RandomAccessFile(copyFile, "rw");
		Long start = System.nanoTime();

		int t = -1;
		while ((t = r.read()) != -1) {
			rw.write(t);
		}

		Long end = System.nanoTime();
		// 594078
		System.out.println("ranfiletwo复制文件耗时：" + (end - start));
		r.close();
		rw.close();
	}

	// RandomAccessFile 读写操作 批量
		public static void ranfileBatchThree(File file, File copyFile) throws IOException {
			RandomAccessFile r = new RandomAccessFile(file, "r");
			RandomAccessFile rw = new RandomAccessFile(copyFile, "rw");
			Long start = System.nanoTime();
			byte[] bs = new byte[(int) r.length()];
			int t = -1;
			while ((t = r.read(bs)) != -1) {
				rw.write(bs);
			}
			Long end = System.nanoTime();
			// 427245
			System.out.println("ranfileBatchThree复制文件耗时：" + (end - start));
			r.close();
			rw.close();
		}
	
	// RandomAccessFile 读写操作 批量
	public static void ranfileBatch(File file, File copyFile) throws IOException {
		RandomAccessFile r = new RandomAccessFile(file, "r");
		RandomAccessFile rw = new RandomAccessFile(copyFile, "rw");
		Long start = System.nanoTime();
		byte[] bs = new byte[(int) r.length()];
		int t = -1;
		while ((t = r.read(bs, 0, bs.length)) != -1) {
			rw.write(bs, 0, bs.length);
		}
		Long end = System.nanoTime();
		// 427245
		System.out.println("ranfileBatch复制文件耗时：" + (end - start));
		r.close();
		rw.close();
	}

	public static void fileStream(File file, File copyFile) throws IOException {
		// 使用FileInputStream 和 FileOutputStream 一个字节一个字节读写操作
		FileInputStream in = new FileInputStream(file);
		FileOutputStream out = new FileOutputStream(copyFile);
		Long start = System.nanoTime();
		int t = -1;
		while ((t = in.read()) != -1) {
			out.write(t);
		}
		Long end = System.nanoTime();
		// 871503
		System.out.println("fileStream复制文件耗时：" + (end - start));
		in.close();
		out.close();
	}

	// 使用FileInputStream 和 FileOutputStream 批量操作
		public static void fileStreamBatchOne(File file, File copyFile) throws IOException {
			FileInputStream in = new FileInputStream(file);
			FileOutputStream out = new FileOutputStream(copyFile);
			Long start = System.nanoTime();
			int t = -1;
			byte[] bs = new byte[(int) file.length()];
			while ((t = in.read(bs)) != -1) {
				out.write(bs);
			}
			Long end = System.nanoTime();
			// 609675
			System.out.println("fileStreamBatchOne复制文件耗时：" + (end - start));
			in.close();
			out.close();
		}
	
	// 使用FileInputStream 和 FileOutputStream 批量操作
	public static void fileStreamBatch(File file, File copyFile) throws IOException {
		FileInputStream in = new FileInputStream(file);
		FileOutputStream out = new FileOutputStream(copyFile);
		Long start = System.nanoTime();
		int t = -1;
		byte[] bs = new byte[(int) file.length()];
		while ((t = in.read(bs,0,bs.length)) != -1) {
			out.write(bs,0,bs.length);
		}
		Long end = System.nanoTime();
		// 609675
		System.out.println("fileStreamBatch复制文件耗时：" + (end - start));
		in.close();
		out.close();
	}

	// DataInputStream 和 DataOutputStream 进行读写操作
	public static void dataFile(File file, File copyFile) throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream(file));
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(copyFile));
		Long start = System.nanoTime();
		int t = -1;
		while ((t = dis.read()) != -1) {
			dos.write(t);
		}
		Long end = System.nanoTime();
		// 691910
		System.out.println("dataFile复制文件耗时：" + (end - start));
		dis.close();
		dos.close();
	}

	// DataInputStream 和 DataOutputStream 进行批量读写操作
		public static void dataFileBatchOne(File file, File copyFile) throws IOException {
			DataInputStream dis = new DataInputStream(new FileInputStream(file));
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(copyFile));
			Long start = System.nanoTime();
			int t = -1;
			byte[] bs = new byte[(int) file.length()];
			while ((t = dis.read(bs)) != -1) {
				dos.write(bs);
			}
			Long end = System.nanoTime();
			// 692854
			System.out.println("dataFileBatchOne复制文件耗时：" + (end - start));
			dis.close();
			dos.close();
		}
	
	// DataInputStream 和 DataOutputStream 进行批量读写操作
	public static void dataFileBatch(File file, File copyFile) throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream(file));
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(copyFile));
		Long start = System.nanoTime();
		int t = -1;
		byte[] bs = new byte[(int) file.length()];
		while ((t = dis.read(bs,0,bs.length)) != -1) {
			dos.write(bs,0,bs.length);
		}
		Long end = System.nanoTime();
		// 692854
		System.out.println("dataFileBatch复制文件耗时：" + (end - start));
		dis.close();
		dos.close();
	}

	// BufferedInputStream 和 BufferedOutputStream 进行复制文件操作
	public static void bufferedFile(File file, File copyFile) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(copyFile));
		Long start = System.nanoTime();
		int t = -1;
		while ((t = bis.read()) != -1) {
			bos.write(t);
			bos.flush();
		}

		Long end = System.nanoTime();
		// 1443369
		System.out.println("bufferedFile复制文件耗时：" + (end - start));
		bis.close();
		bos.close();
	}

	// BufferedInputStream 和 BufferedOutputStream 进行批量复制文件操作
		public static void bufferedFileBatchOne(File file, File copyFile) throws IOException {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(copyFile));
			Long start = System.nanoTime();
			int t = -1;
			byte[] bs = new byte[(int) file.length()];
			while ((t = bis.read(bs)) != -1) {
				bos.write(bs);
				bos.flush();
			}
			Long end = System.nanoTime();
			// 589352
			System.out.println("bufferedFileBatch复制文件耗时：" + (end - start));
			bis.close();
			bos.close();
		}
	
	// BufferedInputStream 和 BufferedOutputStream 进行批量复制文件操作
	public static void bufferedFileBatch(File file, File copyFile) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(copyFile));
		Long start = System.nanoTime();
		int t = -1;
		byte[] bs = new byte[(int) file.length()];
		while ((t = bis.read(bs,0,bs.length)) != -1) {
			bos.write(bs,0,bs.length);
			bos.flush();
		}
		Long end = System.nanoTime();
		// 589352
		System.out.println("bufferedFileBatch复制文件耗时：" + (end - start));
		bis.close();
		bos.close();
	}

	public static void main(String[] args) throws IOException {
		String oldPath = "E:\\cc.pptx";
		String newPath = "E:\\cc1.pptx";
		File oldFile = new File(oldPath);
		File copyFile = new File(newPath);

		
		// 视频不可以复制
		// IOCompare.ranfile(oldFile,copyFile);
		// 视频不可以复制
		// IOCompare.ranfileOne(oldFile, copyFile);
		// IOCompare.ranfiletwo(oldFile, copyFile);
		// IOCompare.ranfileBatchThree(oldFile, copyFile);
		// -mp4,3-02216572
		// IOCompare.ranfileBatch(oldFile, copyFile);
		
		// IOCompare.fileStream(oldFile, copyFile);
		// IOCompare.fileStreamBatchOne(oldFile, copyFile);
		// 1-82808099
		 IOCompare.fileStreamBatch(oldFile, copyFile);
		
		// IOCompare.dataFile(oldFile, copyFile);
		// IOCompare.dataFileBatchOne(oldFile, copyFile);
		// 3 -07278769
		// IOCompare.dataFileBatch(oldFile, copyFile);
		
		// IOCompare.bufferedFile(oldFile, copyFile);
		// IOCompare.bufferedFileBatchOne(oldFile, copyFile);
		// 1 -65189424
		// IOCompare.bufferedFileBatch(oldFile, copyFile);
	}

}
