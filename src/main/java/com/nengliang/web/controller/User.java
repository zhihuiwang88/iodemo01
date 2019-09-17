package com.nengliang.web.controller;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 用户基本信息
	 * 
	 * 
	 */

	private String name;
	private Integer age;
	private transient String city;
	// 被transient关键字修饰的属性，序列化时被忽略
	// private transient String city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", city=" + city + "]";
	}

}
