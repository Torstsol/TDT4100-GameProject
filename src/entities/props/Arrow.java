package entities.props;

import entities.Entity;

public abstract class Arrow extends Entity {
	
	protected int y = -height;
	
	
	public static final int DEFAULT_PROP_WIDTH = 100;
	public static final int DEFAULT_PROP_HEIGHT = 100;
	public static int speed;
	
	public Arrow(int width, int height, int speed){
		super(width, height);
		Arrow.speed = speed;
	}
	
	public void tick() {
		y += speed;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int n){
		y = n;
	}
}
