package celestial_body;

import java.awt.Color;
import java.awt.Point;

public class Moon extends CelestialBody{

	public Moon(double size, double distance, Point orbitCenter, double outerGravity) {
		super(size, distance, orbitCenter, outerGravity);
		
		int transPart = newColor();
		color = new Color(transPart + 150, transPart + 150, transPart + 150);
	}
	
	private int newColor() {
		double col = Math.random() * 100;
		return (int)Math.round(col);
	}

}
