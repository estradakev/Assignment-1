package com.mycompany.a1;

import com.codename1.charts.models.Point;

public class FixedGameObject extends GameObject{
	
	public FixedGameObject(int size, Point location, int color) {
		super(size, location, color);
	}
	
	@Override
	public void setLocation(Point location) {}
	
	
}
