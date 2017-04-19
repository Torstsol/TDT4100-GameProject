package states;

import java.awt.Color;
//import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JTextField;

import game.Game;
import gfx.Assets;


public class FinishState extends State {
	
	List<String> highscore;
	int position;
	String dinHighscore;
	int scoreX = 50;
	int scoreY = 150;
	int distance = 55; 
	boolean exit = false;
	
	int score;
	String song;
	
	public FinishState(Game game){
		super(game);
		
		score = ((GameState) game.gameState).getScore();
		song = ((GameState) game.gameState).getSong();
		highscore = ((GameState) game.gameState).getHighscore();
		position = ((GameState) game.gameState).getPosition();
		if(position != -1){
			highscore.set(position, highscore.get(position) + " <- This round");
		}
	}
	public void tick() {
		//System.out.println(game.getMouseManager().getMouseX() + " " + game.getMouseManager().getMouseY());
		if(game.getMouseManager().isLeftPressed() && exit){
			State.setState(game.menuState);
			game.menuState.playSong();
			if(game.gameState.getResetGame()){
				game.gameState = new GameState(game);
			}
		}
	}

	
	public void render(Graphics g) {
		
		//bakgrunn
		g.drawImage(Assets.finishBg2, 0, 0, 831, 720, null);
		g.drawImage(Assets.finishBg, 831, 0 , 449, 720, null);
		g.setColor(Color.black);
		g.fillRect(831, 0, 4, 720);
		
		g.setColor(Color.white);
		g.setFont(new Font("Segoe UI Light", Font.BOLD, 30));
		
		//render score
		g.setFont(new Font("Segoe UI Light", Font.BOLD, 100));
		
		if(score < 10){
			g.drawString("000" + score, 940, 180);
		}
		else if(score < 100){
			g.drawString("00" + score, 940, 180);
		}
		else if(score < 1000){
			g.drawString("0" + score, 940, 180);
		}
		else{
			g.drawString("" + score, 940, 180);
		}
		
		//render song
		g.setFont(new Font("Segoe UI Light", Font.BOLD, 30));
		g.drawString(song.substring(2), 910, 650);
		
		
		//render streak
		g.setFont(new Font("Segoe UI Light", Font.BOLD, 50));
		if(position < 10){
			if(position == -1){
				g.drawString("NaN", 1130, 405);
			}
			else{
				g.drawString("0" + position, 1145, 405);	
			}
		}
		else{
			g.drawString("" + position, 1145, 405);
		}
		
		//render highscore
		g.setFont(new Font("Segoe UI Light", Font.BOLD, 50));
		g.drawString("Highscore: " + song.substring(2), scoreX, scoreY - distance);
		g.drawLine(scoreX-10, scoreY-50, 800, scoreY-50);
		g.setFont(new Font("Courier", Font.BOLD, 30));
		g.drawString("1. " + highscore.get(0), scoreX, scoreY);
		g.drawString("2. " + highscore.get(1), scoreX, scoreY + distance);
		g.drawString("3. " + highscore.get(2), scoreX, scoreY + distance*2);
		g.drawString("4. " + highscore.get(3), scoreX, scoreY + distance*3);
		g.drawString("5. " + highscore.get(4), scoreX, scoreY + distance*4);
		g.drawString("6. " + highscore.get(5), scoreX, scoreY + distance*5);
		g.drawString("7. " + highscore.get(6), scoreX, scoreY + distance*6);
		g.drawString("8. " + highscore.get(7), scoreX, scoreY + distance*7);
		g.drawString("9. " + highscore.get(8), scoreX, scoreY + distance*8);
		g.drawString("10." + highscore.get(9), scoreX, scoreY + distance*9);
		
		//render knapp
		if (game.getMouseManager().getMouseX() > 430 && game.getMouseManager().getMouseX() < 430 + 365 && game.getMouseManager().getMouseY() < 555 + 110  && game.getMouseManager().getMouseY() > 555 ){
			g.drawRect(430, 555, 365, 110);
			exit = true;
		}
		else{
			exit = false;
		}
		
	}

	
	public void playSong() {
		
	}

}
