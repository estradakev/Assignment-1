package com.mycompany.a1;
import java.util.ArrayList;
import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

/**
 * This class handles the movements and actions that happen within the world. It also displays the world and the status of the player
 * @author kevinestrada
 *
 */
public class GameWorld {
	private final int BASE_SIZE = 10;
	private int lives;
	private int clock;
	private ArrayList<GameObject> gameObjects;
	private Cyborg cyborg;
	
	Random r = new Random();
	// sets up how many base objects and energy stations there will be
	int baseObjects = 4 + r.nextInt(5);
	int energyBaseObjects = 2 + r.nextInt(5);
	
	
	public GameWorld() {}
	
	/**
	 * This method creates the objects and sets the max speed for the cyborg as well as setting the clock and the amount of lives 
	 */
	public void init() {
		gameObjects  = new ArrayList<>();
		this.lives = 3;
		this.clock = 0;
		
		Point cyborgLocation = new Point(r.nextInt(1000),r.nextInt(1000));
		cyborg = new Cyborg(40, cyborgLocation, ColorUtil.BLUE);
		gameObjects.add(new Base(BASE_SIZE, cyborgLocation,1));
		
		for (int i = 2 ; i <= baseObjects; i++) {
			gameObjects.add(new Base(BASE_SIZE, new Point(Math.round(r.nextFloat()*10000)/10, Math.round(r.nextFloat()*10000)/10), i));
		}
		
		for (int i = 1; i <= energyBaseObjects; i++) {
			gameObjects.add(new EnergyStation(0, new Point(Math.round(r.nextFloat()*10000)/10, Math.round(r.nextFloat()*10000)/10), ColorUtil.GREEN));
		}
		
		for (int i = 1; i<= 2; i++) {
			gameObjects.add(new Drone(0, new Point(0, 0), ColorUtil.rgb(255, 0, 0)));
		}
		this.cyborg.setMaximumSpeed(50);
		
	}
	
	/**
	 * returns the lives of the player
	 * @return lives
	 */
	private int getLives() {
		return this.lives;
	}
	/**
	 * returns the clock of the world
	 * @return clock
	 */
	private int getClock() {
		return this.clock;
	}
	
	/**
	 * This method increases the damage level on the cyborg once it crashes with a cyborg
	 */
	public void cyborgCollision() {
		int nuColor = ColorUtil.rgb(102,102,255);
		
		this.cyborg.setDamageLevel(this.cyborg.getDamageLevel() + 20);
		System.out.print("The cyborg collided with another cyborg, the damage is now " + cyborg.getDamageLevel() +"\n\n");
		cyborg.setColor(nuColor);
	}
	
	//This method increases the damage level on the cyborg once it crashes with a drone it also brightens the color of the drone
	public void droneCollision() {
		int nuColor = ColorUtil.rgb( 102, 255, 255);
		
		for(GameObject drone : gameObjects) {
			if(drone instanceof Drone) {
				cyborg.setDamageLevel(cyborg.getDamageLevel() + ((Drone)drone).getSize());
				if(cyborg.getDamageLevel() >= 100) {
					cyborg.setSpeed(cyborg.getSpeed()/2);
				}
			}
		}
		cyborg.setColor(nuColor);
		System.out.println("The cyborg collided with a drone, the damage is now " + cyborg.getDamageLevel() + "\n");
	}
	
	/**
	 * This method increases the damage level on the cyborg once it crashes with a base
	 */
	public void baseCollision() {
		
		for(GameObject base : gameObjects) {
			int lastReached = this.cyborg.getLastBaseReached();
			if(base instanceof Base && ((Base) base).getSequenceNumber() - lastReached == 1) {
				this.cyborg.setLastBaseReached(lastReached + 1);
				break;
			}
		}
	}
	/**
	 * This method increases the damage level on the cyborg once it crashes with a energy base and lightens the color of the base
	 */
	public void energyBaseCollision() {
		int nuColor = ColorUtil.rgb(102, 255, 102);
		
		for(GameObject enBase : gameObjects) {
			if(enBase instanceof EnergyStation && ((EnergyStation)enBase).getCapcity() != 0) {
				cyborg.setEnergyLevel(cyborg.getEnergyLevel() + ((EnergyStation) enBase).getCapcity());
				((EnergyStation)enBase).setCapcity(0);
				((EnergyStation)enBase).setColor(nuColor);
				gameObjects.add(new EnergyStation(0, new Point(Math.round(r.nextFloat()*10000)/10, Math.round(r.nextFloat()*10000)/10), ColorUtil.GREEN));
				break;
			}
		}
		
	}
	/**
	 * This method increases the cyborg speed accordingly to the damage and energy level
	 */
	public void cyborgAccelerate() {
		int speed = this.cyborg.getSpeed();
		int maxSpeed = this.cyborg.getMaximumSpeed();
		
		
		if (speed != maxSpeed && maxSpeed != 0) {
			
			if(this.cyborg.getDamageLevel() <= 50 ) {
				 speed += 5;
				 this.cyborg.setSpeed(speed);
			}
			else if(this.cyborg.getDamageLevel() <= 100 ) {
				speed += 3;
				this.cyborg.setSpeed(speed);
			}
			else if(this.cyborg.getDamageLevel() <= 150) {
				speed += 1;
				this.cyborg.setSpeed(speed);
			}
			else if(this.cyborg.getDamageLevel() <= 199 && this.cyborg.getEnergyLevel() >= 1) {
				System.out.println("The speed can't be updated due to the energy level and damagelevel\n");
			}
		}
		if(speed == maxSpeed) {
			System.out.println("The cyborg speed is " + speed +" it is at max speed\n");
		} else
		System.out.print("Speed is " + speed + "\n\n");
		
	}
	
	/**
	 * This method tells the cyborg to break and decreases speed by 5
	 */
	public void cyborgBreaking() {
		int speed = this.cyborg.getSpeed();
		
		if (speed >= 0 && (speed > 0)) {
			this.cyborg.setSpeed(speed - 5);
			speed -= 5;
			System.out.println("The cyborg speed is " + speed + "\n\n");
		}
		else {
			System.out.println("The speed can not be lowered it is already at " + speed + "\n\n");
		}
		 
			
	}
	/**
	 *  This tells the cyborg to update the steering and the heading to the left
	 */
	public void goLeft() {
		int steeringDir = cyborg.getSteeringDirection();
		
		if(steeringDir == 0) {
			cyborg.setSteeringDirection(steeringDir);
			cyborg.setHeading(5);
		}
		if(steeringDir < 40) {
			steeringDir -= 5;
			cyborg.setSteeringDirection(steeringDir);
			cyborg.setHeading(steeringDir);
		}
		else if(cyborg.getHeading() <= 90 && cyborg.getHeading() > 0) {
			cyborg.setHeading(cyborg.getHeading() - 5);
				
		}
		System.out.println("The cyborg has turned left by 5 degrees " + this.cyborg.getHeading() + "\n");
	}
	
	/**
	 *  This tells the cyborg to update the steering and the heading to the right
	 */
	public void goRight() {
		int steeringDir = cyborg.getSteeringDirection();
		
		if(steeringDir == 0) {
			cyborg.setSteeringDirection(steeringDir);
			cyborg.setHeading(5);
		}
		if(steeringDir < 40) {
			steeringDir += 5;
			cyborg.setSteeringDirection(steeringDir);
			cyborg.setHeading(steeringDir);
		}
		else if(cyborg.getHeading() < 90 && cyborg.getHeading() > -1) {
			cyborg.setHeading(cyborg.getHeading() + 5);
				
		}
		System.out.println("The cyborg has turned left by 5 degrees " + this.cyborg.getHeading() + "\n");
	}
	
	/**
	 *  increases the time of the clock and updates the location of movable objects
	 */
	public void tick() {
		
		if((cyborg.getDamageLevel() != 200) || (cyborg.getEnergyLevel() != 0) || (cyborg.getSpeed() != 0)) {
			cyborg.move();
			cyborg.setSteeringDirection(0);
			cyborg.setEnergyLevel(cyborg.getEnergyConsumptionLevel());
			this.clock++;
			for(GameObject mvAble : gameObjects) {
				if(mvAble instanceof MoveableGameObject) {
					((MoveableGameObject) mvAble).move();
				}
				if(mvAble instanceof Drone) {
					((Drone)mvAble).move();
				}
			}
		} 
		System.out.println("The clock is at " + this.clock + "\n\n");
	}
	
	/**
	 *  displays the current state of the player (cyborg)
	 */
	public void display() {
		String lives = "Current lives: " + getLives() + ", \n";
		String clock = "Current clock: " + getClock() + ", \n";
		String baseNumber = "highest base reached: " + this.cyborg.getLastBaseReached() + ", \n";
		String enLevel = "energy level: " + this.cyborg.getEnergyLevel() + ", \n";
		String damLevel = "damage lebel: " + this.cyborg.getDamageLevel();
		
		System.out.println(lives + clock + baseNumber + enLevel + damLevel + "\n\n");
		
	}
	/**
	 * Displays the state of the world, locations of the objects and its attributes
	 */
	public void mapGame() {
		
		System.out.println("Cyborg: loc=(" + this.cyborg.getLocation().getX() + ", " + cyborg.getLocation().getY() + ")"
				+ ", heading = " + cyborg.getHeading() + ", speed = " + cyborg.getSpeed() + ", size = " + cyborg.getSize() + ", "
				+ "max speed = " + cyborg.getMaximumSpeed() + ", \n\tsteering direction = " + cyborg.getSteeringDirection()
				+ ", energy level = " + cyborg.getEnergyLevel() + ", damage level = " + cyborg.getDamageLevel() 
				+ ", color: [" + ColorUtil.red(cyborg.getColor()) + ", " + ColorUtil.green(cyborg.getColor()) + ", "+ ColorUtil.blue(cyborg.getColor())+ "]" );
		for(GameObject obj : gameObjects) {
			if(obj instanceof Base) {
				Base b = (Base) obj;
				System.out.println("Base: loc=(" + b.getLocation().getX()+", " + b.getLocation().getY()+")"
						+ ", size = " + b.getSize() + ", sequence number = " + b.getSequenceNumber()
						+ ", color: [" + ColorUtil.red(b.getColor()) + ", " + ColorUtil.green(b.getColor()) + ", "+ ColorUtil.blue(b.getColor())+ "]" );
			}
			else if(obj instanceof EnergyStation) {
				EnergyStation e = (EnergyStation) obj;
				System.out.println("Energy Station: loc=(" + e.getLocation().getX() + ", " + e.getLocation().getY() + ")"
						+ ", size = " + e.getSize() + ", capacity = " + e.getCapcity()
						+ ", color: [" + ColorUtil.red(e.getColor()) + ", " + ColorUtil.green(e.getColor()) + ", "+ ColorUtil.blue(e.getColor())+ "]" );
			}
			else if(obj instanceof Drone) {
				Drone d = (Drone) obj;
				System.out.println("Drone: loc=(" + d.getLocation().getX() +", " + d.getLocation().getY() + ")"
						+ ", heading = " + d.getHeading() + ", speed = " + d.getSpeed() + ", size = " + d.getSize()
						+ ", color: [" + ColorUtil.red(d.getColor()) + ", " + ColorUtil.green(d.getColor()) + ", "+ ColorUtil.blue(d.getColor())+ "]" );
			}
		}
		System.out.print("\n\n");
	}
	/**
	 * This method exits the game after it is called
	 */
	public void exit() {
		System.exit(0);
	}
	
}
