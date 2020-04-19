package celestial_body;

import java.awt.Color;
import java.awt.Point;

public class Planet extends CelestialBody{
	
	public Planet(double size, double distance, Point orbitCenter, double outerGravity) {
		super(size, distance, orbitCenter, outerGravity);
		createMoons();
		int transPart = newColor();
		color = new Color(transPart + 50, transPart/2 + 100, 255 - transPart);
	}
	
	private int newColor() {
		double col = Math.random() * 200;
		return (int)Math.round(col);
	}
	
	private void createMoons() {
		
		int numberOfMoons = (int)Math.round(Math.random() * 2);
		double addedDistance = size;
		for(int i = 0; i < numberOfMoons; i++) {
			
			double newSize = (Math.random() * 0.3 * size) + size * 0.1;
			addedDistance += newSize / 2;
			double newDistance = addedDistance;
			addedDistance += newSize / 2;
			
			addChild(new Moon(newSize, newDistance, currentLocation, size));
			
		}
	}
}
