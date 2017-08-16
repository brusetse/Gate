package com.bruse.course.object;

public class Car {
	String carName;
	int number;
	int speed;

	Car(String a,int b,int c){
		carName = a;
		number = b;
		speed = c;
	}

	public void showMessage(){
		System.out.println("型号为"+carName+" 车牌号为"+number+" 最快时速为"+speed);
	}
}
