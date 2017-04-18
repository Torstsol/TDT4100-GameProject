package display;

import java.awt.Canvas; //Drawing graphics to the canvas
import java.awt.Dimension;
import javax.swing.JFrame; //Taking data from the canvas, and displays it

public class Display {
 //staged
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	private void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); //Locked window-size to the width and height
		frame.setLocationRelativeTo(null); //Window appear in the center of the screen
		frame.setVisible(true); //JFrame by default is not visible
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack(); //Makes sure the whole canvas is displayed
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
}
