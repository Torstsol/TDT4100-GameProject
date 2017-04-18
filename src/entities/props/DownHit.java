package entities.props;

import java.awt.Color;
import java.awt.Graphics;

public class DownHit extends Hit{
	
	public void render(Graphics g) {
		if (y < y_render){
			g.setColor(Color.blue);
			g.fillOval(465, 575 + 15, 100, 100);
		}
	}
}