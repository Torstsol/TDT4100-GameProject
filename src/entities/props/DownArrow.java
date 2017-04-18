package entities.props;

import java.awt.Graphics;
import gfx.Assets;

public class DownArrow extends Arrow {
	
	public DownArrow(int speed) {
		super(Arrow.DEFAULT_PROP_WIDTH, Arrow.DEFAULT_PROP_HEIGHT, speed);
	}

	public void render(Graphics g) {
		if (y < 720){
			g.drawImage(Assets.downArrow, 462, y, width, height, null);
		}
	}

}
