package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferStrategy;

import celestial_body.CelestialBody;
import celestial_body.Star;

public class PlayGround {
	
	private Display display;
	private String title;
	private int width, height;
	private boolean running;
	private BufferStrategy bs;
	private Graphics g;
	
	private CelestialBody brick;
	Point centerOfSystem;
	
	public PlayGround(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		
		centerOfSystem = new Point();
		centerOfSystem.setLocation(400, 350);
		brick =  new Star(40, 0.001, centerOfSystem, 0.001);
		
	}
	
	private void tick() {
		
		
		
		brick.update(centerOfSystem);
		
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, width, height);
		//DRAW
		
		brick.render(g);
		
		//DRAW
		
		
		bs.show();
		g.dispose();
	}
	
	private void mainLoop() {
		int fps = 60;
		double timePerTick = 1_000_000_000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running) {
			now = System.nanoTime();
			delta += (now-lastTime)/timePerTick;
			lastTime = now;
			
			if(delta>=1) {
				tick();
				render();
				delta--;
			}
		}
	}
	
	public void start() {
		display = new Display(title, width, height);
		running = true;
		mainLoop();
	}
	
}
