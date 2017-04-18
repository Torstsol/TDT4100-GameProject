package entities.props;

import java.awt.Color;
import java.awt.Graphics;

public class UpHit extends Hit{

	public void render(Graphics g) {
		if (y < y_render){
			g.setColor(Color.green);
			g.fillOval(265, 575 + 15, 100, 100);
		}
	}

}