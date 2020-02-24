package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.models.Point;

/**
 * It is a class that represents an object in the game
 * @author kevinestrada
 *
 */
public abstract class GameObject{
	protected int size;
	protected Point location;
	protected int color;
	Random r = new Random();
	/**
	 * it has a constructor that takes in int size, Point location, and int color
	 * @param size
	 * @param location
	 * @param color
	 */
	public GameObject(int size, Point location, int color) {
		this.size = 10+r.nextInt(50);
		this.location = location;
		this.color = color;
		
	}
	
	/**
	 * returns the size of the GameObject
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * updates the size of the object
	 * @param size the new size value
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * returns the location of the GameObject
	 * @return location 
	 */
	public Point getLocation() {
		return location;
	}
	/**
	 * updates the location of the GameObject
	 * @param location the new updates location
	 */
	public void setLocation(Point location){
		this.location = location;
	}
	/**
	 * returns the color of the GameObject
	 * @return color
	 */
	public int getColor() {
		return color;
	}
	/**
	 * updates the color of the object
	 * @param color the new color
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * Displays the GameObject in a text representation
	 */
	public String toString() {
		String objString = "Size: " + this.size + ", " + "Location: " +
				"("+this.location.getX() + "), (" + this.location.getY() + ")," + " Color: " + this.color + ",";
		
		return objString;
	}
	
}
