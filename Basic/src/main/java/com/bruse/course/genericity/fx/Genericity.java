package com.bruse.course.genericity.fx;

public class Genericity <T>{
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public static void main(String[] args) {
		Genericity<String> fx1 = new Genericity<String>();
		fx1.setT("java");
		System.out.println(fx1.getT());
		Genericity<Integer> fx2 = new Genericity<Integer>();
		fx2.setT(213);
		System.out.println(fx2.getT());
		Genericity<Person> fx3 = new Genericity<Person>();
		fx3.setT(new Person("张三"));
		System.out.println(fx3.getT());
		System.out.println(new Person("张三"));
	}
}
