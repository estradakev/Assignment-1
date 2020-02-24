package com.mycompany.a1;

import com.codename1.charts.models.Point;

/**
 * It is a child of the GameObject class
 * @author kevinestrada
 *
 */
public class MoveableGameObject extends GameObject{
	
	private int speed;
	protected int heading;

	/**
	 * takes in three parameters for the constructor and it also sets the speed and heading
	 * @param size
	 * @param location
	 * @param color
	 */
	public MoveableGameObject(int size, Point location, int color) {
		super(size, location, color);
		this.speed = 0;
		this.heading = 0;
	}
	/**
	 * returns the speed of the object
	 * @return speed
	 */
	public int getSpeed() {
		return speed;
	}
	/**
	 * Updates the speed attribute of the object
	 * @param speed the new value that will update the speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	/**
	 * returns the heading of the object
	 * @return heading
	 */
	public int getHeading() {
		return heading;
	}
	
	/**
	 * displays the MoveableGameObject in text
	 */
	@Override
	public String toString() {
		String objStr = super.toString() + " Speed: " + this.speed + ", heading " + this.heading;
		return objStr;
	}
	/**
	 * this method calculates the new location after it gets the heading and speed, moving the MoveGameObject
	 */
	public void move() {
		float deltaX, deltaY, x, y;
		
		deltaX = (float) Math.cos(90 - getHeading()) * getSpeed();
		deltaY = (float) Math.sin(90 - getHeading()) * getSpeed();
		
		x = getLocation().getX() + deltaX;
		y = getLocation().getY() + deltaY;
		
		x = Math.round(x * 10)/10;
		y = Math.round(y * 10)/10;
		this.setLocation(new Point(x , y));
		
	}
	
	
}
