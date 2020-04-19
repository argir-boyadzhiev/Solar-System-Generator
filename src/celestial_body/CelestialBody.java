package celestial_body;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class CelestialBody {
	protected double size;
	private double speed;
	private double distance;
	protected Point currentLocation;
	private double phase;
	protected Color color;
	
	private ArrayList<CelestialBody> childCelestialBodies; 
	
	public CelestialBody(double size, double distance, Point orbitCenter, double outerGravity) {
		childCelestialBodies = new ArrayList<CelestialBody>();
		this.size = size;
		this.distance = distance;
		speed = (size / distance) * 0.001 * outerGravity;
		
		if(Math.random() > 0.5) speed *= -1;
		
		phase = Math.random() * Math.PI * 2;
		currentLocation = new Point();
		updateLocation(orbitCenter);
		color = new Color(50, 50, 50);
	}
	
	public void update(Point orbitCenter) {
		updatePhase();
		updateLocation(orbitCenter);
		updateChildBodies();
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval((int)Math.round(currentLocation.x - size/2), (int)Math.round(currentLocation.y - size/2), (int)Math.round(size), (int)Math.round(size));
		renderChildBodies(g);
	}
	
	private void updateLocation(Point orbitCenter) {
		double x = distance * Math.cos(phase) + orbitCenter.x;
		double y = distance * Math.sin(phase) + orbitCenter.y;
		currentLocation.setLocation(x, y);
	}
	private void updatePhase() {
		phase += speed;
		if(phase > Math.PI*2) {
			phase -= Math.PI*2;
		}else if(phase < 0) {
			phase += Math.PI*2;
		}
	}
	
	////////CHILD
	//might be deleted!
	public void addChild(CelestialBody newChild) {
		childCelestialBodies.add(newChild);
	}
	
	private void updateChildBodies() {
		for(int i = 0; i < childCelestialBodies.size(); i++) {
			childCelestialBodies.get(i).update(currentLocation);
		}
	}
	
	private void renderChildBodies(Graphics g) {
		for(int i = 0; i < childCelestialBodies.size(); i++) {
			childCelestialBodies.get(i).render(g);
		}
	}
}
