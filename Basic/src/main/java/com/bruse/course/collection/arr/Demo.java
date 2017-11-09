package com.bruse.course.collection.arr;

public class Demo {


	public static void main(String[] args) {
/*		int a[] = new int[2];
		boolean b[] = new boolean[2];
		String c[] = new String[2];
		for(int i=0;i<2;i++){
			System.out.println(a[i]);
			System.out.println(b[i]);
			System.out.println(c[i]);
		}*/

		/*int numArray[] = {1,2,3,4,5,6};
		for(int i:numArray){
			System.out.print(i+" ");
		}*/

//		Integer i = new Integer(100);
//		System.out.println(i);
//		System.out.println(Integer.toHexString(i));

/*		Integer i = 100;
		System.out.println(i);
		int a = new Integer(100);
		System.out.println(a);*/

		//String s1 = "helloworld";
		//String s2 = "whycompareme";
		//int a = s1.length();
		//boolean a = s1.equals(s2);
		//boolean a = s1.startsWith("hel");
		//boolean a = s1.endsWith("me");
//		String s1 = "abc";
//		String s2 = "aba";
//		int a = s1.compareTo(s2);
//		String s1 = "i love you";
//		String s2 = "i hate you";
//		System.out.println(s1.concat(s2));

		StringBuffer s1 = new StringBuffer("i want you");
		StringBuffer s2 = new StringBuffer(" but i don't like you");
		s1.append(s2);
		s1.insert(6, s2);
		s1.delete(1, 2);
		s1.replace(2, 6, s2.toString());
		System.out.println(s1);

//		System.out.println(Float.MIN_VALUE);

//		Float f1 = new Float(3.1415926);
//		Float f2 = new Float(3.1415926);
//		System.out.println(f1.compareTo(f2));

//		String s1 = "1234";
//		String s2 = "567";
//		int a1 = Integer.parseInt(s1);
//		int a2 = Integer.parseInt(s2);
//		System.out.println(a1+a2);

//		int a1 = 1234;
//		int a2 = 567;
//		System.out.println(Integer.toBinaryString(a1));
//		System.out.println(Integer.toOctalString(a1));
//		System.out.println(Integer.toHexString(a1));
//		String s = Integer.toString(a1, 8);//最多36进制
//		Integer i = Integer.valueOf(s,8);
//		System.out.println(i.intValue());

//		long sum = 0;
//		long a = System.currentTimeMillis();
//		for(int i=0;i<1000000000;i++)
//			sum = sum+i;
//		System.out.println(sum);
//		long b = System.currentTimeMillis();
//		System.out.println(b-a);

//		byte s1[] = {65,66,67,68};
//		byte s2[] = {88,88,88,88,88,88};
//		System.out.println(new String(s1));
//		System.out.println(new String(s2));
//		System.arraycopy(s1, 0, s2, 0, s1.length);
//		System.out.println(new String(s2));

//		double d = 1.577827839;
//		System.out.println(Math.random());

//		Random r = new Random();
//		System.out.println(r.nextGaussian());

//		Date d1 = new Date();
//		Date d2 = new Date(18742030304L);
//		System.out.println(d1);
//		System.out.println(d2);
//		System.out.println(d1.after(d2));

//		Calendar c = Calendar.getInstance();
//		c.set(2016, 7, 20);
//		c.set(c.HOUR, 9);
//		c.set(c.MINUTE, 30);
//		c.set(c.SECOND, 20);
	}
}
















