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
	String dinHighscore;
	int scoreX = 50;
	int scoreY = 150;
	int distance = 55; 
	public FinishState(Game game){
		super(game);
		highscore = ((GameState) game.gameState).getHighscore();
		position = ((GameState) game.gameState).getPosition();
		if(position != -1){
			highscore.set(position, highscore.get(position) + " <- This round");
		}
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
		g.setFont(new Font("Segoe UI Light", Font.BOLD, 30));
		g.drawString("Your score: " + ((GameState) game.gameState).getScore(), scoreX + 500, scoreY+100);
		g.drawString("song: " + ((GameState) game.gameState).getSong(), scoreX + 500, scoreY+150);
		
		g.drawLine(1280/2, 0, 1280/2, 720);

		
		//render highscore
		g.drawString("Highscore: ", scoreX, scoreY - distance);
		g.drawString("#1 " + highscore.get(0), scoreX, scoreY);
		g.drawString("#2 " + highscore.get(1), scoreX, scoreY + distance);
		g.drawString("#3 " + highscore.get(2), scoreX, scoreY + distance*2);
		g.drawString("#4 " + highscore.get(3), scoreX, scoreY + distance*3);
		g.drawString("#5 " + highscore.get(4), scoreX, scoreY + distance*4);
		g.drawString("#6 " + highscore.get(5), scoreX, scoreY + distance*5);
		g.drawString("#7 " + highscore.get(6), scoreX, scoreY + distance*6);
		g.drawString("#8 " + highscore.get(7), scoreX, scoreY + distance*7);
		g.drawString("#9 " + highscore.get(8), scoreX, scoreY + distance*8);
		g.drawString("#10 " + highscore.get(9), scoreX, scoreY + distance*9);
		
	}

	
	public void playSong() {
		
	}

}
