package com.mycompany.a1;

import com.codename1.charts.models.Point;

public class MoveableGameObject extends GameObject{
	
	private int speed;
	protected int heading;

	
	public MoveableGameObject(int size, Point location, int color) {
		super(size, location, color);
		this.speed = 0;
		this.heading = 0;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getHeading() {
		return heading;
	}
	
	@Override
	public String toString() {
		String objStr = super.toString() + " Speed: " + this.speed + ", heading " + this.heading;
		return objStr;
	}

	public void move() {
		float deltaX, deltaY, x, y;
		
		deltaX = (float) Math.cos(90 - getHeading()) * getSpeed();
		deltaY = (float) Math.sin(90 - getHeading()) * getSpeed();
		
		x = getLocation().getX() + deltaX;
		y = getLocation().getY() + deltaY;
		
		x = Math.round(x * 10)/10;
		y = Math.round(y * 10)/10;
		setLocation(new Point(x , y));
		
	}
	
	
}
