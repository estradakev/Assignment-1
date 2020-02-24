package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.models.Point;

public abstract class GameObject{
	protected int size;
	protected Point location;
	protected int color;
	Random r = new Random();
	
	public GameObject(int size, Point location, int color) {
		this.size = 10+r.nextInt(50);
		this.location = location;
		this.color = color;
		
	}
	

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location){
		this.location = location;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	
	public String toString() {
		String objString = "Size: " + this.size + ", " + "Location: " +
				"("+this.location.getX() + "), (" + this.location.getY() + ")," + " Color: " + this.color + ",";
		
		return objString;
	}
	
}
