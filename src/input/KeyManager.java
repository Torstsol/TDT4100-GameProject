package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	public boolean up, down, left, right;
	private int binds;
	
	public KeyManager(int binds){
		this.binds = binds;
		keys = new boolean[256];
	}
	
	public void tick(){
		
		if(binds == 0){
			left = keys[KeyEvent.VK_LEFT];
			up = keys[KeyEvent.VK_UP];
			down = keys[KeyEvent.VK_DOWN];
			right = keys[KeyEvent.VK_RIGHT];
		}
		else{
			left = keys[KeyEvent.VK_Q];
			up = keys[KeyEvent.VK_W];
			down = keys[KeyEvent.VK_E];
			right = keys[KeyEvent.VK_R];
		}
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	
	public void keyTyped(KeyEvent e) {
		keys[e.getKeyChar()] = true;
	}

}
