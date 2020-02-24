package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class Drone extends MoveableGameObject{

	
	Random r = new Random();
			
	//the color is red
	public Drone(int size, Point location, int color) {
		super(size, location, ColorUtil.rgb(255, 0, 0));
		this.size = 10 + r.nextInt(50);
		this.heading = 0 + r.nextInt(359);
		this.location.setX(r.nextInt(1001)); 
		this.location.setY(r.nextInt(1001)); 
		setSpeed(0 + r.nextInt(50));
	}
	
}
