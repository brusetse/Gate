package com.bruse.course.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
	//类信息
	public static void testClass() throws Exception{
		//获取小人 clazz 第一种方式
//		Class clazz = Class.forName("cn.gzsxt.reflectTest.Person");
		//第二种
//		Class clazz = new Person().getClass();
		//第三种
		Class clazz  =Person.class;
		//返回类名称
		System.out.println(clazz.getName());
		//返回底层类简称
		System.out.println(clazz.getSimpleName());
		//返回包名
		System.out.println(clazz.getPackage().getName());
		//返回类修饰符对应编码
		System.out.println(clazz.getModifiers());
	}
	//属性信息
	public static void testField() throws Exception{
		Class clazz = Person.class;
		//返回对象字段数组
//		Field f[] = clazz.getDeclaredFields();
//		//打印字段名称和类型
//		for (int i = 0; i < f.length; i++) {
//			System.out.println(f[i].getName());
//			System.out.println(f[i].getType());
//		}
		//根据指定字段名返回对象
		Field f = clazz.getDeclaredField("name");
		System.out.println(f.getName());
		System.out.println(f.getType());
		//调用无参构造方法 new Person()
		Object obj = clazz.newInstance();
		System.out.println(obj instanceof Person);
		//破坏封装性！
		f.setAccessible(true);
		//将指定对象变量上此 Field 对象表示的字段设置为指定的新值。
		f.set(obj, "zhangsan");
		//父类中没有该方法 必须向下转型
		System.out.println(((Person)obj).getName());
		Field fage = clazz.getDeclaredField("age");
		//静态成员可以传null
		fage.set(null, 19);
		System.out.println(((Person)obj).getAge());
	}
	//方法信息
	public static void testMethod() throws Exception{
		Class clazz = new Person().getClass();
		//返回实例对象
		Object obj = clazz.newInstance();
		//生成方法字段数组
//		Method[] m = clazz.getDeclaredMethods();
//		for (int i = 0; i < m.length; i++) {
//			System.out.println(m[i].getName());
//			System.out.println(m[i].getReturnType());
//		}
		//返回一个 Method 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明方法
		Method m = clazz.getDeclaredMethod("add", new Class[]{int.class,int.class});
		System.out.println(m.getName());
		System.out.println(m.getReturnType());
		//破坏方法封装性
		m.setAccessible(true);
		//对带有指定参数的指定对象调用由此 Method 对象表示的底层方法
		m.invoke(obj, new Object[]{123,123});
	}
	//构造方法信息
	public static void testCon() throws Exception{
		Class clazz = new Person().getClass();
		//生成构造方法字段数组
//		Constructor[] con = clazz.getConstructors();
//		for (int i = 0; i < con.length; i++) {
//			System.out.println(con[i].getName());
		//按照声明顺序返回一组 Type 对象，这些对象表示此 Constructor 对象所表示的方法的形参类型
//			Class[] types = con[i].getParameterTypes();
//			for (int j = 0; j < types.length; j++) {
//				System.out.println(types[j].getName());
//			}
//		}
		//返回一个 Constructor 对象，它反映此 Class 对象所表示的类的指定公共构造方法
		Constructor con = clazz.getConstructor(new Class[]{String.class});
		System.out.println(con.getName());
		//建立构造方法实例
		Person instance = (Person) con.newInstance("zhangsan");
		System.out.println(instance.getName());
	}

	public static void main(String[] args) throws Exception {
//		testClass();
//		testField();
//		testMethod();
		testCon();
	}
}