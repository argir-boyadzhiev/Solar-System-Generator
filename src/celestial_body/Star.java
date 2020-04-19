package celestial_body;

import java.awt.Color;
import java.awt.Point;

public class Star extends CelestialBody{

	public Star(double size, double distance, Point orbitCenter, double outerGravity) {
		super(size, distance, orbitCenter, outerGravity);
		createPlanets();
		
		int transPart = newColor();
		color = new Color(transPart + 50, transPart/2 + 50, 255 - transPart);
	}
	
	private int newColor() {
		double col = Math.random() * 200;
		return (int)Math.round(col);
	}
	
	private void createPlanets() {
		
		int numberOfPlanets = (int)Math.round(Math.random()*4 + 1);
		double addedDistance = size*2;
		for(int i = 0; i < numberOfPlanets; i++) {
			
			double newSize = (Math.random() * 0.5 * size) + size * 0.2;
			addedDistance += newSize / 2;
			double newDistance = addedDistance;
			addedDistance += newSize * 4;
			
			addChild(new Planet(newSize, newDistance, currentLocation, size));
			
		}
	}
	
}
