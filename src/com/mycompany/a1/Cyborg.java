package com.mycompany.a1;

import com.codename1.charts.models.Point;

/**
 * 
 * @author Kevin Estrada
 *The class Cyborg is a a child of MoveableObject and GameObject, it also the ISteerable interface
 *It has the 
 */
public class Cyborg extends MoveableGameObject implements ISteerable {

	private int maximumSpeed;
	private int steeringDirection;
	private int energyLevel;
	private int damageLevel;
	private int lastBaseReached;
	private int energyConsumptionLevel;
	
	/**
	 * This is the constructor which takes size, location, and color for the parent class
	 * then it initializes its own attributes. 
	 * @param size is the objects size
	 * @param location it gives the object its location
	 * @param color gives the object is color
	 */
	public Cyborg(int size, Point location, int color) {
		super(size, location, color);
		this.size = size;
		this.steeringDirection = 0;
		this.maximumSpeed = 0;
		this.energyLevel = 60;
		this.damageLevel = 0;
		this.energyConsumptionLevel = 5;
		this.lastBaseReached = 0;
	}
	/**
	 * The setSize class gets overriden since the size should be set when the object is created
	 */
	@Override
	public void setSize(int size) {}
	/**
	 * This returns the maximumSpeed of the cyborg 
	 * @return maximumSpeed
	 */
	public int getMaximumSpeed() {
		return maximumSpeed;
	}

	/**
	 * It takes in a param maximumSpeed and sets that as the speed for the cyborg
	 * @param maximumSpeed
	 */
	public void setMaximumSpeed(int maximumSpeed) {
		this.maximumSpeed = maximumSpeed;
	}

	/**
	 * This method returns the steering direction of the cyborg
	 * @return steeringDirection
	 */
	public int getSteeringDirection() {
		return steeringDirection;
	}
	
	/**
	 * The method takes in a parameter direction which then sets the direction
	 * @param direction
	 */
	public void setSteeringDirection(int direction) {
		this.steeringDirection = direction;
	}

	/**
	 * It returns the energy level of the cyborg
	 * @return enrgyLevel 
	 */
	public int getEnergyLevel() {
		return energyLevel;
	}

	/**
	 * sets the energy level of the cyborg
	 * @param energyLevel
	 */
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	/**
	 * 
	 * @return
	 */
	public int getDamageLevel() {
		return damageLevel;
	}


	public void setDamageLevel(int damageLevel) {
		this.damageLevel = damageLevel;
	}


	public int getLastBaseReached() {
		return lastBaseReached;
	}


	public void setLastBaseReached(int lastBaseReached) {
		this.lastBaseReached = lastBaseReached;
	}


	public int getEnergyConsumptionLevel() {
		return energyConsumptionLevel;
	}


	public void setEnergyConsumptionLevel(int energyConsumptionLevel) {
		this.energyConsumptionLevel = energyConsumptionLevel;
	}
	
	@Override
	public String toString() {
		String parentObjStr = super.toString();
		String childObjStr =", \nEnergy: Level " + this.energyLevel
				+ ", Damage Level: " + this.damageLevel + ", Last Base Reached: " 
				+ this.lastBaseReached + ", Energy Consumption Level: " + this.energyConsumptionLevel
				+ ", Steering Direction: " + this.steeringDirection
				+ ", Maximum Level: " + this.maximumSpeed;
		return parentObjStr + childObjStr;
	}
	
	@Override
	public void turnLeft() {
		if(this.getSteeringDirection() == 0) {
			setSteeringDirection(this.getSteeringDirection());
			setHeading(5);
		}
		if(this.getSteeringDirection() <= 40) {
			this.setSteeringDirection(this.getSteeringDirection() - 5);
			this.setHeading(this.getSteeringDirection() - 5);
		}
	}
	@Override
	public void turnRight(){
		if(this.getSteeringDirection() == 0) {
			setSteeringDirection(this.getSteeringDirection());
			setHeading(5);
		}
		if(this.getSteeringDirection() <= 40) {
			this.setSteeringDirection(this.getSteeringDirection()+5);
			this.setHeading(this.getSteeringDirection()+5);
		}
	}
	
}
