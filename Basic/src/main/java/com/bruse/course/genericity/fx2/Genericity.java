package com.bruse.course.genericity.fx2;

public class Genericity <T>{
	public static <Q> void show1(Q q){
		System.out.println(q);
	}
	public void show2(T t){
		System.out.println(t);
	}
	public <Q> void show3(Q q){
		System.out.println(q);
	}
	public <A> void show4(@SuppressWarnings("unchecked") A...a){
		for (A a2 : a) {
			System.out.println(a2);
		}
	}

	public static void main(String[] args) {
		show1("维护");
		Genericity<String> g = new Genericity<String>();
		g.show2("去除了警告");
		g.show3("这个也可以 ");
		g.show4("java","mysql","html");
	}
}
