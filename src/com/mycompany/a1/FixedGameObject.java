package com.mycompany.a1;

import com.codename1.charts.models.Point;

/**
 * This class is a child of the GameObject class, it does not allow for their position to be changed once they are created
 * @author kevinestrada
 *
 */
public class FixedGameObject extends GameObject{
	
	public FixedGameObject(int size, Point location, int color) {
		super(size, location, color);
	}
	/**
	 * The setLocation is overridden so the location can not be changed 
	 */
	@Override
	public void setLocation(Point location) {}
	
	
}
