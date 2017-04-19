package states;

import java.awt.Color;
//import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import game.Game;
import gfx.Assets;
import sounds.Effects;

public class MenuState extends State {
	
	Effects song;
	List<String> mapArray, soundArray, displayArray;
	
	List<Integer> speedArray;
	
	private int songX = 460;
	private int songY = 370;
	private int distance = 55;
	
	private int songBoxLength = 95;
	private int songBoxHeight = 98;
	public String songString = "none";
	
	private int leftBox_x = 305;
	private int leftBox_y = 280;
	private int rightBox_x = 876;
	private int rightBox_y = 280;
	
	private int middleBox_x = leftBox_x + songBoxLength;
	private int middleBox_y = leftBox_y;
	private int middleBoxLength = rightBox_x - middleBox_x;
	
	private int compansator = 30;
	private int index = 5;
	
	private int toggle = -1;
	private int mouseLock = 25;
	private int counter = 0;
	private int keyLock = 0;

	public MenuState(Game game){
		super(game);
		song = new Effects();
		mapArray = new ArrayList<String>();
		mapArray.add("E-Gikk i bakken");
		mapArray.add("E-Mom is home");
		mapArray.add("E-Trap paris");
		mapArray.add("M-All I ever wanted");
		mapArray.add("M-Hybrida");
		mapArray.add("M-Ravers in the UK");
		mapArray.add("M-Release");
		mapArray.add("H-Friday Fahrenheit");
		mapArray.add("H-Pon Pon Pon");
		mapArray.add("S-Bocha Bass Kolbaser");
		
		soundArray = new ArrayList<String>();
		soundArray.add("E-GikkIBakken");
		soundArray.add("E-MomIsHome");
		soundArray.add("E-TrapParis");
		soundArray.add("M-AllIEverWanted");
		soundArray.add("M-Hybrida");
		soundArray.add("M-RaversInTheUK");
		soundArray.add("M-Release");
		soundArray.add("H-FridayFahrenheit");
		soundArray.add("H-PonPonPon");
		soundArray.add("S-BochkaBassKolbaser");
		
		displayArray = new ArrayList<String>();
		displayArray.add("Easy: Gikk I Bakken");
		displayArray.add("Easy: Mom Is Home");
		displayArray.add("Easy: Trap Paris");
		displayArray.add("Medium: All I Ever Wanted");
		displayArray.add("Medium: Hybrida");
		displayArray.add("Medium: Ravers In The UK");
		displayArray.add("Medium: Release");
		displayArray.add("Hard: Friday Fahrenheit");
		displayArray.add("Hard: Pon Pon Pon");
		displayArray.add("ACID: BochkaBassKolbaser");
		
		speedArray = new ArrayList<Integer>();
		speedArray.add(3);
		speedArray.add(3);
		speedArray.add(3);
		speedArray.add(6);
		speedArray.add(6);
		speedArray.add(6);
		speedArray.add(6);
		speedArray.add(6);
		speedArray.add(9);
		speedArray.add(9);

	}
	public void tick() {
		
		counter++;

		if(game.getMouseManager().isLeftPressed() && toggle == 0 && counter >= keyLock){
			keyLock = counter + mouseLock;
			if(index - 1 < 0){
				index = 9;
			}
			else{
				index--;
			}

		}
		if(game.getMouseManager().isLeftPressed() && toggle == 1 && counter >= keyLock){
			keyLock = counter + mouseLock;
			if(index + 1 > 9){
				index = 0;
			}
			else{
				index++;
			}
			
		}
		if(game.getMouseManager().isLeftPressed() && toggle == 2){
			try {
				song.stopSound();
			} catch (IOException e) {
				e.printStackTrace();
			}
			State.setState(game.gameState);
			setSong(soundArray.get(index));
			game.gameState.playSong();
			((GameState) game.gameState).setArrowSpeed(speedArray.get(index)); //setter speed
			((GameState) game.gameState).setSongMap(mapArray.get(index)); //setter map
			
		}

		if(game.getMouseManager().isRightPressed()){
			System.exit(0);
		}

	}
	
	public void render(Graphics g) {
		g.drawImage(Assets.menuBg, 0, 0, 1280, 720, null);
		g.setFont(new Font("Segoe UI Light", Font.BOLD, 30));
		g.setColor(Color.WHITE);
		g.drawString(displayArray.get(index), songX, songY);
	
		
		if(game.getMouseManager().getMouseX() > leftBox_x && game.getMouseManager().getMouseX() < leftBox_x + songBoxLength && game.getMouseManager().getMouseY() < leftBox_y + songBoxHeight + compansator  && game.getMouseManager().getMouseY() > leftBox_y ){
			g.drawRect(leftBox_x, leftBox_y + compansator, songBoxLength, songBoxHeight);
			toggle = 0;
		}
		
		else if(game.getMouseManager().getMouseX() > rightBox_x && game.getMouseManager().getMouseX() < rightBox_x + songBoxLength + 2 && game.getMouseManager().getMouseY() < rightBox_y + songBoxHeight + compansator  && game.getMouseManager().getMouseY() > rightBox_y ){
			g.drawRect(rightBox_x, rightBox_y + compansator, songBoxLength + 2, songBoxHeight);
			toggle = 1;
		}
		
		else if(game.getMouseManager().getMouseX() > middleBox_x && game.getMouseManager().getMouseX() < middleBox_x + middleBoxLength + 2 && game.getMouseManager().getMouseY() < middleBox_y + songBoxHeight + compansator  && game.getMouseManager().getMouseY() > middleBox_y ){
			g.drawRect(middleBox_x, middleBox_y + compansator, middleBoxLength, songBoxHeight);
			toggle = 2;
		}
		else{
			toggle = -1;
		}

	}

	public void playSong() {
		song.playSound("menuMusic");
	}
	
	private void setSong(String songName){
		((GameState) game.gameState).setSongAudio(songName);
	}
	

}
