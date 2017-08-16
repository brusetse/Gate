package com.bruse.course.collection.col2;

import java.util.*;

public class Demo2 {
	public static void main(String[] args) {
		List<String> lt1 = new ArrayList<String>();
		lt1.add("java");
		lt1.add("php");
		lt1.add("python");
		List<String> lt2 = new ArrayList<String>();
		lt2.add("c语言");
		lt2.add("c++");
		lt2.add("oc");

		lt1.addAll(lt2);
//		lt1.addAll(1, lt2);
		sop(lt1);
		sop(lt1.containsAll(lt2));
//		lt1.removeAll(lt2);
		lt1.retainAll(lt2);
		sop(lt1);
		sop(lt1.equals(lt2));
		sop(lt1.indexOf("c语言"));
		sop(lt1.subList(1, 2));
	}

	public static void sop(Object obj){
		System.out.println(obj);
	}
}