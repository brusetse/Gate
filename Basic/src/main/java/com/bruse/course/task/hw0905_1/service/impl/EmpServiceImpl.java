package com.bruse.course.task.hw0905_1.service.impl;

import com.bruse.course.task.hw0905_1.dao.EmpDao;
import com.bruse.course.task.hw0905_1.dao.impl.EmpDaoImpl;
import com.bruse.course.task.hw0905_1.service.EmpService;

import java.util.List;


public class EmpServiceImpl implements EmpService {

	private EmpDao e = new EmpDaoImpl();
	
	public List findEmp(){
		if(e.findEmp()!=null){
			return e.findEmp();
		}else{
			return null;
		}
		
	}
}
