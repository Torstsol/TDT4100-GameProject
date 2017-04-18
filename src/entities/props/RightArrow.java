package entities.props;

import java.awt.Graphics;
import gfx.Assets;

public class RightArrow extends Arrow {
	
	public RightArrow(int speed) {
		super(Arrow.DEFAULT_PROP_WIDTH, Arrow.DEFAULT_PROP_HEIGHT, speed);
	}

	public void render(Graphics g) {
		if (y < 720){
			g.drawImage(Assets.rightArrow, 665, y, width, height, null);
		}
		
	}
}
