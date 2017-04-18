package entities.props;

import java.awt.Graphics;
import gfx.Assets;

public class UpArrow extends Arrow {

	public UpArrow(int speed) {
		super(Arrow.DEFAULT_PROP_WIDTH, Arrow.DEFAULT_PROP_HEIGHT, speed);
	}

	public void render(Graphics g) {
		if (y < 720){
			g.drawImage(Assets.upArrow, 265, y, width, height, null);
		}
	}

}
