package com.bruse.course.collection.coll;

import java.util.*;

public class Coll {
	public static void main(String[] args) {
		ArrayList a1 = new ArrayList();
		a1.add("java01");
		a1.add("java02");
		a1.add("java03");
		a1.add("java04");
		sop("原集合"+a1);
//		a1.remove("java03");
//		sop("现集合"+a1);
		Iterator it = a1.iterator();
		while(it.hasNext())
			sop(it.next());
	}




	public static void sop(Object obj){
		System.out.println(obj);
	}
}