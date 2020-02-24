package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.models.Point;

/**
 * The EnergyStation is a child of a fixedGameObject
 * @author kevinestrada
 *
 */
public class EnergyStation extends FixedGameObject{
	private int capacity;
	Random r = new Random();
	/**
	 * This is the constructor for EnergyStation 
	 * @param size is random each time an object is created 
	 * @param location is also passed in to set the location
	 * @param color the color can be changed unlike the Base object
	 */
	public EnergyStation(int size, Point location, int color) {
		super(size, location, color);
		this.capacity = getSize();
	}
	
	/**
	 * It sets the capacity of the energy station if it has to be changed
	 * @param loweredCap the value becomes the capacity of the EnergyStation
	 */
	public void setCapcity(int loweredCap) {
		this.capacity = loweredCap;
	}
	/**
	 * Returns the capacity 
	 * @return capacity
	 */
	public int getCapcity() {
		return this.capacity;
	}
	
	/**
	 * It takes away the ability of changing the size of the object
	 */
	@Override
	public void setSize(int size) {}
	
	/**
	 * displays the EnergyStation object
	 */
	@Override 
	public String toString() {
		String parentObjStr = super.toString();
		String objStr = parentObjStr + " Energy Station: Capacity " + this.capacity;
		return objStr;
	}
	
	
	
}
