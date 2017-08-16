package com.bruse.course.collection.set.dogDemo;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		ArrayList<Dog> list = new ArrayList<Dog>();
		//将多个Dog的信息添加到集合中
		Dog d1 = new Dog("小白",100);
		Dog d2 = new Dog("旺财",50);
		list.add(d1);
		list.add(d2);
		//查看Dog的数量及所有Dog的信息
		System.out.println("狗的数量为："+list.size());
		for (Iterator<Dog> iterator = list.iterator(); iterator.hasNext();) {
			Dog dog = (Dog) iterator.next();
			System.out.println(dog);
		}
		//删除指定的狗
		System.out.print("请输入要删除的狗：");
		Scanner s = new Scanner(System.in);
		String str = s.next();
		for (Iterator<Dog> iterator = list.iterator(); iterator.hasNext();) {
			if(iterator.next().getName().equals(str)){
				iterator.remove();
				System.out.println("删除成功！");
			}
		}
		//判断集合中是否有指定的狗
		System.out.print("请输入指定的狗：");
		String str2 = s.next();
		int flag = 0;
		for (Iterator<Dog> iterator = list.iterator(); iterator.hasNext();) {
			if(iterator.next().getName().equals(str2)){
				System.out.println(str2+"存在！");
				flag = 1;
			}
		}
		if(flag == 0)
			System.out.println(str2+"不存在！");
		s.close();
	}
}
