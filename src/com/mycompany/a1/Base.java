package com.mycompany.a1;

//import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;


public class Base extends FixedGameObject{
	
	
	private int sequenceNumber;
//	Random r = new Random();
	
	//Constructor for base and sets the color to green
	public Base(int size, Point location, int sequenceNum) {
		super(size, location, ColorUtil.YELLOW);
		this.size = size;

		this.sequenceNumber = sequenceNum;
		
		
	}	
//	public Base(int size, float x, float y, int sequenceNum) {
//		super(size, location, ColorUtil.rgb(0,255,0));
////		this.size = 0 + r.nextInt(10);
//		this.setLoc;
//		this.sequenceNumber = sequenceNum;
//	}
	
	@Override 
	public String toString() {
		String parent = super.toString();
		String childObjStr = " Sequence Number: " + this.getSequenceNumber();
		return parent + childObjStr;
	}
	@Override
	public void setSize(int size) {}
	
	@Override
	public void setColor(int color) {}
	
	public int getSequenceNumber() {
		return this.sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {}
	
	
}

