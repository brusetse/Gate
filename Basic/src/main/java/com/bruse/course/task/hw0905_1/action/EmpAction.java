package com.bruse.course.task.hw0905_1.action;

import com.bruse.course.task.hw0905_1.service.EmpService;
import com.bruse.course.task.hw0905_1.service.impl.EmpServiceImpl;
import com.bruse.course.task.hw0905_1.vo.EmpVo;

import java.util.Iterator;
import java.util.List;


public class EmpAction {

	private static EmpService es = new EmpServiceImpl();
	
	public static void getEmp(){
		List list = es.findEmp();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			EmpVo emp = (EmpVo) iterator.next();
			System.out.print(emp.getEname()+"    ");
			System.out.print(emp.getSal()+"    ");
			System.out.println(emp.getDname()+"    ");
		}

	}
	
	public static void main(String[] args) {
		getEmp();
	}
}
