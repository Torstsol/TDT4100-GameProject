package states;

import java.awt.Color;
//import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JTextField;

import game.Game;


public class FinishState extends State {
	
	List<String> highscore;
	int position;
	public FinishState(Game game){
		super(game);
		highscore = ((GameState) game.gameState).getHighscore();
		position = ((GameState) game.gameState).getPosition();

		
	}
	public void tick() {
		//System.out.println(game.getMouseManager().getMouseX() + " " + game.getMouseManager().getMouseY());
		if(game.getMouseManager().isLeftPressed()){
			State.setState(game.menuState);
			game.menuState.playSong();
			if(game.gameState.getResetGame()){
				game.gameState = new GameState(game);
			}
		}
	}

	
	public void render(Graphics g) {
		g.setFont(new Font("Verdana", Font.ITALIC, 30));
		g.drawString("Score: " + ((GameState) game.gameState).getScore(), 0, 150);
		g.drawString("song: " + ((GameState) game.gameState).getSong(), 0, 200);
//		g.setColor(Color.RED);
//		g.fillRect(game.getMouseManager().getMouseX(), game.getMouseManager().getMouseY(), 10, 10);
		
	}

	
	public void playSong() {
		
	}

}
