package com.bruse.course.task.hw0821.homework4;

public class User {

	/**
	 * 创建User类，包含以下属性name:String,age:int,gender enum,重写toString方法显示对象的信息
	 */

	private String name;
	private int age;
	private gender sex;

	public User(String name, int age, gender sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public gender getSex() {
		return sex;
	}

	public void setSex(gender sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "[姓名：" + name + " 年龄：" + age + " 性别：" + sex + "]";
	}

	enum gender{
		男,女
	}
}