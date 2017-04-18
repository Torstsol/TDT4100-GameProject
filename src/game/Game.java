package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import display.Display;
import gfx.Assets;
import input.KeyManager;
import input.MouseManager;
import states.FinishState;
import states.GameState;
import states.MenuState;
import states.SettingState;
import states.State;

public class Game implements Runnable {
	
	private Display display;	
	public int width, height;
	private Thread thread;
	private boolean running;
	public String title;
	private BufferStrategy bs;
	private Graphics g;
	
	//states du er teit
	public State gameState;
    public State menuState;
	public State settingState;
	public State finishState;
	
	//input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	public Game(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		running = false;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		
		
		
	}
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		gameState = new GameState(this);
		menuState = new MenuState(this);
		settingState = new SettingState(this);
		finishState = new FinishState(this);
		State.setState(menuState);
	    State.getState().playSong();
	}
	
	private void tick(){
		keyManager.tick();
		
		if(State.getState() != null){
			State.getState().tick();
		}
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		
		if(State.getState() != null){
			State.getState().render(g);
			
		}
		
		bs.show();
		g.dispose();
	}

	public void run() {
		
		init();
		
		int fps = 144;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				delta--;
			}
		}
		
		stop();
	}
	
	public KeyManager getkeyManager(){
		return keyManager;
	}
	
	public MouseManager getMouseManager(){
		return mouseManager;
	}
	
	public synchronized void start(){
		if(running) return; //safety
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running) return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
