package entities.props;

import java.awt.Color;
import java.awt.Graphics;

public class RightHit extends Hit{
	
	public void render(Graphics g) {
		if (y < y_render){
			g.setColor(Color.MAGENTA);
			g.fillOval(665, 575 + 15, 100, 100);
		}
	}

}