package entities.props;

import java.awt.Color;
import java.awt.Graphics;

public class LeftHit extends Hit{

	public void render(Graphics g) {
		if (y < y_render){ //Skal bare vises i 50 ticks
			g.setColor(Color.red);
			g.fillOval(65, 575 + 15, 100, 100);
		}
	}
}