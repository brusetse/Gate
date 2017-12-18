package com.bruse.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

	public static void test01(){
		String input = "214421sdgasad";
		Pattern pattern = Pattern.compile("\\d+[a-z]{2}",Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
//		整个字符串都要符合表达式
		boolean b = matcher.matches();
		System.out.println(b);
	}
	//封装方法
	public static boolean test02(String input,String regex){
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
	//查找与该模式匹配的输入序列的下一个子序列
	public static boolean findChild(String input,String regex){
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		return matcher.find();
	}
	
	public static String findFirstChild(String input,String regex){
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		if(matcher.find()){
			return matcher.group();
		}else{
			return null;
		}
	}
	
	public static List<String> findAllChild(String input,String regex){
		List<String> list = new ArrayList<String>(); 
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		while(matcher.find()){
			list.add(matcher.group());
		}
		return list;
	}
	
	public static void main(String[] args) {
//		test01();
//		String input = "214421sdgasad";
//		String regex = "\\d+[a-z]{2}";
//		System.out.println(test02(input, regex));
//		System.out.println(findChild(input, regex));
//		System.out.println(findFirstChild(input, regex));
//		System.out.println(findAllChild(input, regex));
		
		//split(String regex) 
        //根据给定正则表达式的匹配拆分此字符串。
		String str = "kjshfksdgsdgkslkfsjgfoqgvlkddodolshgaksjfak";
		String[] split = str.split("([a-zA-Z]{2,5})\\1");
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
		}
		//replaceAll(String regex, String replacement)
		//使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串
		String replaceAll = str.replaceAll("([a-zA-Z]{2,5})\\1", "--");
		System.out.println(replaceAll);
	}
}
