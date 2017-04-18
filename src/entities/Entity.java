package entities;

import java.awt.Graphics;

public abstract class Entity {
	
	protected float x, y;
	protected int width, height;
	
	public Entity(int width, int height){
		
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
