package com.nengliang.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class IOSerializableObject {

	/**
	 * java的序列化和反序列化
	 * 
	 * @throws IOException
	 *             ObjectOutputStream ， 对象序列化输出流 ObjectInputStream , 对象序列化输入流
	 * 
	 *             java.io.NotSerializableException 这个错误原因是 User 没有 implements
	 *             Serializable
	 * 
	 */

	// @Test
	public void objectStream() throws Exception {
		// 对象的序列化: 对象 转 字节序列
		File file = new File("E:\\wen.txt");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		User user = new User();
		user.setName("张三");
		user.setAge(68);
		user.setCity("北京");
		// 将指定的对象转换为字节序列
		oos.writeObject(user);
		oos.flush();
		oos.close();
	}

	// @Test
	public void objectInput() throws Exception {
		// 对象的反序列化: 字节序列 转 对象
		File file = new File("E:\\wen.txt");
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		// 从流中读取字节并转换为对应的对象
		Object object = ois.readObject();

		// city被关键字transient修饰了，控制台打印结果为 null
		System.out.println(object);

		ois.close();
	}

}
