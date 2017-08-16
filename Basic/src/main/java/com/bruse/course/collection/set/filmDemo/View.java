package com.bruse.course.collection.set.filmDemo;

import java.util.*;

public class View {

	ArrayList<Film> list = new ArrayList<Film>();

	public void initial(){
		Film f1 = new Film("栀子花开", "何炅", "李易峰 张慧雯", 107);
		Film f2 = new Film("道士下山", "陈凯歌", "王宝强 郭富城", 120);
		Film f3 = new Film("大圣归来", "田晓鹏", "田晓鹏 爱德华兹", 110);
		list.add(f1);
		list.add(f2);
		list.add(f3);
	}

	public void startmenu(){
		System.out.println("欢 迎 光 临 C G V 国际影城");
		System.out.println("-------------------------------------");
		System.out.println("1. 新 增 电 影");
		System.out.println("2. 查 看 电 影");
		System.out.println("3. 删 除 电 影");
		System.out.println("4. 退         出 ");
		System.out.println("--------------------------------------");
		System.out.print("请选择：");
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		switch(a){
			case 1:add();
				break;
			case 2:search();
				break;
			case 3:delete();
				break;
			case 4:System.out.println("已退出");
				break;
			default:System.out.println("您的输入有误，请重新输入！");
				startmenu();
		}
	}

	public void add(){
		Scanner s = new Scanner(System.in);
		Film newfilm = new Film();
		System.out.println("---> 添加电影信息\n");
		System.out.print("请输入电影名称：");
		newfilm.setName(s.next());
		System.out.print("请输入电影导演：");
		newfilm.setDirector(s.next());
		System.out.print("请输入电影主演：");
		newfilm.setActor(s.next());
		System.out.print("请输入电影时长：");
		newfilm.setTime(s.nextInt());
		list.add(newfilm);
		System.out.println("添加 "+newfilm.getName()+" 成功！");
		System.out.println("**************************");
		returnmenu();
	}

	public void search(){
		int i = 1;
		System.out.println("---> 查看影视快讯\n");
		System.out.println("\t名称\t\t导演\t\t主演\t\t\t时长");
		for (Iterator<Film> iterator = list.iterator(); iterator.hasNext();i++) {
			Film film = (Film) iterator.next();
			System.out.print(i+"\t");
			System.out.println(film);
		}
		System.out.println("**************************");
		returnmenu();
	}

	public void delete(){
		Scanner s = new Scanner(System.in);
		System.out.println("---> 删除电影信息\n");
		System.out.print("请输入您要删除的电影：");
		String str = s.next();
		int i = 0,flag = 0;
		for (Iterator<Film> iterator = list.iterator(); iterator.hasNext();i++) {
			if(iterator.next().getName().equals(str)){
				iterator.remove();
				System.out.println("删除 "+str+" 成功！");
				flag = 1;
			}
		}
//		for(;i<list.size();i++){
//			if(list.get(i).getName().equals(str)){
//				list.remove(i);
//				System.out.println("删除 "+str+" 成功！");
//				flag = 1;
//			}
//		}
		if(flag == 0)
			System.out.println("该电影不存在!");
		System.out.println("**************************");
		returnmenu();
	}

	public void returnmenu(){
		System.out.print("\n请按0返回：");
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		if(a==0)
			startmenu();
		else
			System.out.println("输入有误！");
	}
}
