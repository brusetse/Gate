package com.bruse.course.collection.col;

import java.util.*;

public class Demo{
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("mysql");
		list.add("html");
		sop(list);
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			sop(object);
		}
		for (Object object : list) {
			sop(object);
		}
		ffx("维护");
		FanXing<String> fanxing = new FanXing<String>();
		fanxing.setT("维护");
		sop(fanxing.getT());

	}

	public static void sop(Object obj){
		System.out.println(obj);
	}

	public static <Q> void ffx(Q q){
		sop(q);
	}
}