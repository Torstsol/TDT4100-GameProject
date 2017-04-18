package entities.props;

public class Hit {
	
	protected int y_render = 50;
	protected int y = y_render + 1;
	
	public void tick() {
		y += 1;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int n){
		y = n;
	}

}
