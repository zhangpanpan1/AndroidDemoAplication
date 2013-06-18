package com.zpp.project.snow;

import java.util.Random;

public class Snow {
	Coordinate coordinate;
	int speed;
	
	public Snow(int x, int y, int speed){
		coordinate = new Coordinate(x, y);
		System.out.println("Speed:"+speed);
		this.speed = speed;
		if(this.speed <= 0) {
			this.speed =2;
		}
	}
	
}
