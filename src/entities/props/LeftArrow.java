package entities.props;

import java.awt.Graphics;
import gfx.Assets;

public class LeftArrow extends Arrow {
	
	public LeftArrow(int speed) {
		super(Arrow.DEFAULT_PROP_WIDTH, Arrow.DEFAULT_PROP_HEIGHT, speed);
	}

	public void render(Graphics g) {
		if (y < 720){
			g.drawImage(Assets.leftArrow, 65, y, width, height, null);
		}
	}

}
