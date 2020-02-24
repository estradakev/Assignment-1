package com.mycompany.a1;

//import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

/**
 * This class is a base of a FixedGameObject it contains a sequence number as a waypoint
 * @author kevinestrada
 *
 */
public class Base extends FixedGameObject{
	
	
	private int sequenceNumber;
	
	/**
	 * Constructor for base 
	 * @param size it sets the size of the base
	 * @param location the location is given and cannot be changed
	 * @param sequenceNum this gives the waypoint number of the base
	 */
	
	public Base(int size, Point location, int sequenceNum) {
		super(size, location, ColorUtil.YELLOW);
		this.size = size;

		this.sequenceNumber = sequenceNum;
		
		
	}	
	/**
	 * It displays the Base object
	 */
	@Override 
	public String toString() {
		String parent = super.toString();
		String childObjStr = " Sequence Number: " + this.getSequenceNumber();
		return parent + childObjStr;
	}
	/**
	 * It does not allow the size to change
	 */
	@Override
	public void setSize(int size) {}
	/**
	 * It does not allow the color to change
	 */
	@Override
	public void setColor(int color) {}
	
	/**
	 * gets the sequence number of the base
	 * @return the sequence number of the object
	 */
	public int getSequenceNumber() {
		return this.sequenceNumber;
	}

	
	
}

