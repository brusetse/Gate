package com.bruse.course.collection.set.employeeDemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		HashSet<Employee> set = new HashSet<Employee>();
		//添加员工
		Employee e1 = new Employee(7632,"张三",23);
		Employee e2 = new Employee(8756,"李四",24);
		Employee e3 = new Employee(9384,"王五",25);
		set.add(e1);
		set.add(e2);
		set.add(e3);
		//输出员工的信息
		for (Iterator<Employee> iterator = set.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		//删除离职的员工
		System.out.print("请输入离职的员工：");
		Scanner s = new Scanner(System.in);
		String str = s.next();
		for (Iterator<Employee> iterator = set.iterator(); iterator.hasNext();) {
			if(iterator.next().getName().equals(str)){
				iterator.remove();
				System.out.println("删除成功！");
			}
		}
		//判断指定员工是否存在
		System.out.print("请输入指定的员工：");
		String str2 = s.next();
		int flag = 0;
		for (Iterator<Employee> iterator = set.iterator(); iterator.hasNext();) {
			if(iterator.next().getName().equals(str2)){
				System.out.println(str2+"存在！");
				flag = 1;
			}
		}
		if(flag == 0)
			System.out.println(str2+"不存在！");
	}
}
