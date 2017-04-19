package gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage leftArrow, rightArrow, upArrow, downArrow, bg, bg1, menuBg, hitter;
	
	private static final int width = 600, height = 600;
	
	public static void init(){

		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/newArrows.png"));
		
		leftArrow = sheet.crop(0, 0, height, width);
		upArrow = sheet.crop(600, 0, width, height);
		downArrow = sheet.crop(600*2, 0, width, height);
		rightArrow = sheet.crop(600*3, 0, height, width);
		
		SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/bg.jpg"));
		
		bg = sheet1.crop(0, 0, 831, 720);
		
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/bg2.png"));
		
		bg1 = sheet2.crop(0, 0, 449, 720);
		
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/menuBg3.png"));
		
		menuBg = sheet3.crop(0, 0, 1280, 720);
		
		SpriteSheet sheet4 = new SpriteSheet(ImageLoader.loadImage("/textures/hitter2.png"));
		
		hitter = sheet4.crop(0, 0, 140, 140); 
	}

}
