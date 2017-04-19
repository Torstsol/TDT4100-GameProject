package states;

//import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import game.Game;
import sounds.Effects;

public class MenuState extends State {
	
	Effects song;
	String[] songArray;
	
	private int songX = 50;
	private int songY = 150;
	private int distance = 55;
	private int songBoxLength = 370;
	public String songString = "none";
	

	public MenuState(Game game){
		super(game);
		song = new Effects();
//		this.songArray= getSongs();
	}
	public void tick() {
		//System.out.println(game.getMouseManager().getMouseX() + " " + game.getMouseManager().getMouseY());
		if(game.getMouseManager().isLeftPressed()){
			if(!songString.equals("none")){
				try {
					song.stopSound();
				} catch (IOException e) {
					e.printStackTrace();
				}
				State.setState(game.gameState);
				game.gameState.playSong();
				((GameState) game.gameState).setSongMap(songString);
			}
		}

		if(game.getMouseManager().isRightPressed()){
			System.exit(0);
		}

	}

	
	public void render(Graphics g) {
		g.setFont(new Font("Verdana", Font.ITALIC, 30));
		g.drawString("HovedMeny:", 1280/2 - 100, 50);

		//liste med sanger
		g.drawString("Velg sang: ", songX, songY - distance);
		g.drawString("Gikk i bakken", songX, songY);
		g.drawString("Mom is home", songX, songY + distance);
		g.drawString("Trap-Paris", songX, songY + distance*2);
		g.drawString("Friday-Fahrenheit", songX, songY + distance*3);
		g.drawString("Pon Pon Pon", songX, songY + distance*4);
		g.drawString("All I Ever Wanted", songX, songY + distance*5);
		g.drawString("Hybrida i aare", songX, songY + distance*6);
		g.drawString("Ravers in the UK", songX, songY + distance*7);
		g.drawString("Release", songX, songY + distance*8);
		g.drawString("Bocha Bass Kolbaser", songX, songY + distance*9);
		
		//sang 1
		if(game.getMouseManager().getMouseX() > songX - 10 && game.getMouseManager().getMouseX() < songX + songBoxLength && game.getMouseManager().getMouseY() < songY + 5 && game.getMouseManager().getMouseY() > songY - 30 ){
			g.drawRect(songX - 10, songY-30, songBoxLength, 35);
			songString = "E-Gikk i bakken";
			setSong("E-GikkIBakken");
			((GameState) game.gameState).setArrowSpeed(3);
		}
		//sang 2
		else if(game.getMouseManager().getMouseX() > songX - 10 && game.getMouseManager().getMouseX() < songX + songBoxLength && game.getMouseManager().getMouseY() < songY + distance + 5 && game.getMouseManager().getMouseY() > songY + distance - 30 ){
			g.drawRect(songX - 10, songY + distance -30, songBoxLength, 35);
			songString = "E-Mom is home";
			setSong("E-MomIsHome");
			((GameState) game.gameState).setArrowSpeed(3);
		}
		//sang 3
		else if(game.getMouseManager().getMouseX() > songX - 10 && game.getMouseManager().getMouseX() < songX + songBoxLength && game.getMouseManager().getMouseY() < songY + distance*2 + 5 && game.getMouseManager().getMouseY() > songY + distance*2 - 30 ){
			g.drawRect(songX - 10, songY + distance*2 -30, songBoxLength, 35);
			songString = "E-Trap paris";
			setSong("E-TrapParis");
			((GameState) game.gameState).setArrowSpeed(3);
		}
		//sang 4
		else if(game.getMouseManager().getMouseX() > songX - 10 && game.getMouseManager().getMouseX() < songX + songBoxLength && game.getMouseManager().getMouseY() < songY + distance*3 + 5 && game.getMouseManager().getMouseY() > songY + distance*3 - 30 ){
			g.drawRect(songX - 10, songY + distance*3 -30, songBoxLength, 35);
			songString = "H-Friday Fahrenheit";
			setSong("H-FridayFahrenheit");
			((GameState) game.gameState).setArrowSpeed(6);
		
		}
		//sang 5
		else if(game.getMouseManager().getMouseX() > songX - 10 && game.getMouseManager().getMouseX() < songX + songBoxLength && game.getMouseManager().getMouseY() < songY + distance*4 + 5 && game.getMouseManager().getMouseY() > songY + distance*4 - 30 ){
			g.drawRect(songX - 10, songY + distance*4 -30, songBoxLength, 35);
			songString = "H-Pon Pon Pon";
			setSong("H-PonPonPon");
			((GameState) game.gameState).setArrowSpeed(9);
		}
		//sang 6
		else if(game.getMouseManager().getMouseX() > songX - 10 && game.getMouseManager().getMouseX() < songX + songBoxLength && game.getMouseManager().getMouseY() < songY + distance*5 + 5 && game.getMouseManager().getMouseY() > songY + distance*5 - 30 ){
			g.drawRect(songX - 10, songY + distance*5 -30, songBoxLength, 35);
			songString = "M-All I ever wanted";
			setSong("M-AllIEverWanted");
			((GameState) game.gameState).setArrowSpeed(6);
		}
		//sang 7
		else if(game.getMouseManager().getMouseX() > songX - 10 && game.getMouseManager().getMouseX() < songX + songBoxLength && game.getMouseManager().getMouseY() < songY + distance*6 + 5 && game.getMouseManager().getMouseY() > songY + distance*6 - 30 ){
			g.drawRect(songX - 10, songY + distance*6 -30, songBoxLength, 35);
			songString = "M-Hybrida";
			setSong("M-Hybrida");
			((GameState) game.gameState).setArrowSpeed(6);
		}
		//sang 8
		else if(game.getMouseManager().getMouseX() > songX - 10 && game.getMouseManager().getMouseX() < songX + songBoxLength && game.getMouseManager().getMouseY() < songY + distance*7 + 5 && game.getMouseManager().getMouseY() > songY + distance*7 - 30 ){
			g.drawRect(songX - 10, songY + distance*7 -30, songBoxLength, 35);
			songString = "M-Ravers in the UK";
			setSong("M-RaversInTheUK");
			((GameState) game.gameState).setArrowSpeed(6);
		}
		//sang 9
		else if(game.getMouseManager().getMouseX() > songX - 10 && game.getMouseManager().getMouseX() < songX + songBoxLength && game.getMouseManager().getMouseY() < songY + distance*8 + 5 && game.getMouseManager().getMouseY() > songY + distance*8 - 30 ){
			g.drawRect(songX - 10, songY + distance*8 -30, songBoxLength, 35);
			songString = "M-Release";
			setSong("M-Release");
			((GameState) game.gameState).setArrowSpeed(6);
		}
		//sang 10
		else if(game.getMouseManager().getMouseX() > songX - 10 && game.getMouseManager().getMouseX() < songX + songBoxLength && game.getMouseManager().getMouseY() < songY + distance*9 + 5 && game.getMouseManager().getMouseY() > songY + distance*9 - 30 ){
			g.drawRect(songX - 10, songY + distance*9 -30, songBoxLength, 35);
			songString = "S-Bocha Bass Kolbaser";
			setSong("S-BochkaBassKolbaser");
			((GameState) game.gameState).setArrowSpeed(9);
		}
		else{
			songString = "none";
		}



	}

	
	public void playSong() {
		song.playSound("Elevator-music");
	}
	
//	public String[] getSongs(){
//		File file = new File("res/songs");
//		String path = file.getAbsolutePath();
//		File folder = new File(path);
//		File[] listOfFiles = folder.listFiles();
//		String[] strListOfFiles = new String[listOfFiles.length];
//		String songString = null;
//
//		    for (int i = 0; i < listOfFiles.length; i++) {
//		      if (listOfFiles[i].isFile()) {
//		        strListOfFiles[i] = listOfFiles[i].getName().replaceAll(".txt", "");
//		        songString = songString + listOfFiles[i].getName().replaceAll(".txt", "") + "\n";
//		      }
//		    }
//		return strListOfFiles;
//	}
	
	private void setSong(String songName){
		((GameState) game.gameState).setSongAudio(songName);
	}
	

}
