package com.bruse.course.collection.set.workerDemo2;

public class Worker implements Comparable<Worker>{

	private String name;
	private int age;
	private int salary;

	public Worker() {
		super();
	}

	public Worker(String name, int age, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", age=" + age + ", salary=" + salary
				+ "]";
	}

	public void work(){
		System.out.println(name+" work");
	}

	//外部比较器，重写compareTo方法
	public int compareTo(Worker o) {
		//先比较年龄
		if(this.age - o.age > 0)
			return 1;
		else if(this.age - o.age < 0)
			return -1;
			//再比较收入
		else if(this.salary - o.salary > 0)
			return 1;
		else if(this.salary - o.salary < 0)
			return -1;
		//最后比较姓名
		return this.name.compareTo(o.name);
	}
}