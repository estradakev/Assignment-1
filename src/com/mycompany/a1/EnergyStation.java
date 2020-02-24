package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.models.Point;


public class EnergyStation extends FixedGameObject{
	private int capacity;
	Random r = new Random();
	
	public EnergyStation(int size, Point location, int color) {
		super(size, location, color);
		this.capacity = getSize();
	}
	
	public void setCapcity(int loweredCap) {
		this.capacity = loweredCap;
	}
	
	public int getCapcity() {
		return this.capacity;
	}
	
	@Override
	public void setSize(int size) {}
	
	@Override 
	public String toString() {
		String parentObjStr = super.toString();
		String objStr = parentObjStr + " Energy Station: Capacity " + this.capacity;
		return objStr;
	}
	
	
	
}
