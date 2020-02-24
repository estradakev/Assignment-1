package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

/**
 * The Drone is a child of a MoveableGameObject
 * @author kevinestrada
 *
 */
public class Drone extends MoveableGameObject{

	
	Random r = new Random();
			
	/**
	 * The constructor of the Drone object, the color is red by default, the size is anywhere from 10-50 and the location is set random automatically as well
	 * @param size is for the parent constructor
	 * @param location is for the parent constructor
	 * @param color is for the parent constructor
	 */
	public Drone(int size, Point location, int color) {
		super(size, location, ColorUtil.rgb(255, 0, 0));
		this.size = 10 + r.nextInt(50);
		this.heading = 0 + r.nextInt(359);
		this.location.setX(r.nextInt(1001)); 
		this.location.setY(r.nextInt(1001)); 
		setSpeed(0 + r.nextInt(50));
	}
	
}
