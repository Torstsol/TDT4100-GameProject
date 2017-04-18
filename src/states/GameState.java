package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import entities.props.DownArrow;
import entities.props.DownHit;
import entities.props.LeftArrow;
import entities.props.LeftHit;
import entities.props.RightArrow;
import entities.props.RightHit;
import entities.props.UpArrow;
import entities.props.UpHit;
import game.Game;
import songMaps.SongMap;
import sounds.Effects;
import entities.props.RightArrow;
import entities.props.RightHit;
import entities.props.UpArrow;
import entities.props.UpHit;
import game.Game;
import gfx.Assets;
import songMaps.SongMap;
import sounds.Effects;


public class GameState extends State{
	
	
	
	
	private LeftArrow leftArrow1, leftArrow2, leftArrow3, leftArrow4;
	private UpArrow upArrow1, upArrow2, upArrow3, upArrow4;
	private DownArrow downArrow1, downArrow2, downArrow3, downArrow4;
	private RightArrow rightArrow1, rightArrow2, rightArrow3, rightArrow4;
	
	private LeftHit leftHit;
	private UpHit upHit;
	private DownHit downHit;
	private RightHit rightHit;
	
	private int[][] matrise;
	private SongMap songMap;
	private String songName;
	
	private int leftCounter1 = 0;
	private int leftCounter2 = 0;
	private int leftCounter3 = 0;
	private int leftCounter4 = 0;
	
	private int upCounter1 = 0;
	private int upCounter2 = 0;
	private int upCounter3 = 0;
	private int upCounter4 = 0;
	
	private int downCounter1 = 0;
	private int downCounter2 = 0;
	private int downCounter3 = 0;
	private int downCounter4 = 0;
	
	private int rightCounter1 = 0;
	private int rightCounter2 = 0;
	private int rightCounter3 = 0;
	private int rightCounter4 = 0;
	
	private int counter = 0;
	private int score = 0;
	private int missRow = 0;
	private int hitRow = 0;
	private int topCombo = 20;
	private int midCombo = 15;
	private int lowCombo = 10;
	
	private int keyLockLeft = 0;
	private int keyLockUp = 0;
	private int keyLockDown = 0;
	private int keyLockRight = 0;
	private int tickLock = 45;
	
	private int outY = 728;
	private boolean resetGame;
	
	private Effects ef = new Effects();
	private Effects song = new Effects();
	
	public GameState(Game game){
		super(game);
		resetGame = false;
		
		leftArrow1 = new LeftArrow(3);
		leftArrow2 = new LeftArrow(3);
		leftArrow3 = new LeftArrow(3);
		leftArrow4 = new LeftArrow(3);
		
		upArrow1 = new UpArrow(3);
		upArrow2 = new UpArrow(3);
		upArrow3 = new UpArrow(3);
		upArrow4 = new UpArrow(3);
		
		downArrow1 = new DownArrow(3);
		downArrow2 = new DownArrow(3);
		downArrow3 = new DownArrow(3);
		downArrow4 = new DownArrow(3);
		
		rightArrow1 = new RightArrow(3);
		rightArrow2 = new RightArrow(3);
		rightArrow3 = new RightArrow(3);
		rightArrow4 = new RightArrow(3);
		
		leftHit = new LeftHit();
		upHit = new UpHit();
		downHit = new DownHit();
		rightHit = new RightHit();
		
		//songMap = new SongMap("tull");
		
	}
	public void setSongMap(String songString){
		this.songMap = new SongMap(songString);
		matrise = songMap.getSongMap();
	}
	
	public void setSongAudio(String songName){
		this.songName = songName;
	}

	public void tick() {
		leftArrow1.tick();
		leftArrow2.tick();
		leftArrow3.tick();
		leftArrow4.tick();
		
		upArrow1.tick();
		upArrow2.tick();
		upArrow3.tick();
		upArrow4.tick();
		
		downArrow1.tick();
		downArrow2.tick();
		downArrow3.tick();
		downArrow4.tick();
		
		rightArrow1.tick();
		rightArrow2.tick();
		rightArrow3.tick();
		rightArrow4.tick();
		
		leftHit.tick();
		upHit.tick();
		downHit.tick();
		rightHit.tick();
		
		isHit();
		isOut();
		
		counter++;
		
		if(score < 0){
			score = 0;
		}
		
		//Dette er venstre-pil logikk
		
		if(counter == matrise[0][leftCounter1]){
			leftArrow1 = new LeftArrow(speed);
			leftCounter1++;
		}
		if(counter == matrise[1][leftCounter2]){
			leftArrow2 = new LeftArrow(speed);
			leftCounter2++;
		}
		if(counter == matrise[2][leftCounter3]){
			leftArrow3 = new LeftArrow(speed);
			leftCounter1++;
		}
		if(counter == matrise[3][leftCounter4]){
			leftArrow4 = new LeftArrow(speed);
			leftCounter4++;
		}
		
		//Dette er opp-pil logikk
		
		if(counter == matrise[4][upCounter1]){
			upArrow1 = new UpArrow(speed);
			upCounter1++;
		}
		if(counter == matrise[5][upCounter2]){
			upArrow2 = new UpArrow(speed);
			upCounter2++;
		}
		if(counter == matrise[6][upCounter3]){
			upArrow3 = new UpArrow(speed);
			upCounter3++;
		}
		if(counter == matrise[7][upCounter4]){
			upArrow4 = new UpArrow(speed);
			upCounter4++;
		}
		
		//Dette er ned-pil logikk
		
		if(counter == matrise[8][downCounter1]){
			downArrow1 = new DownArrow(speed);
			downCounter1++;
		}
		if(counter == matrise[9][downCounter2]){
			downArrow2 = new DownArrow(speed);
			downCounter2++;
		}
		if(counter == matrise[10][downCounter3]){
			downArrow3 = new DownArrow(speed);
			downCounter3++;
		}
		if(counter == matrise[11][downCounter4]){
			downArrow4 = new DownArrow(speed);
			downCounter4++;
		}
		
		//Dette er høyre-pil logikk
		
		if(counter == matrise[12][rightCounter1]){
			rightArrow1 = new RightArrow(speed);
			rightCounter1++;
		}
		if(counter == matrise[13][rightCounter2]){
			rightArrow2 = new RightArrow(speed);
			rightCounter2++;
		}
		if(counter == matrise[14][rightCounter3]){
			rightArrow3 = new RightArrow(speed);
			rightCounter3++;
		}
		if(counter == matrise[15][rightCounter4]){
			rightArrow4 = new RightArrow(speed);
			rightCounter4++;
		}
		
		
		//Switch states
		if(counter == matrise[15][500] + 500 || missRow >= 5){
//		if(counter == matrise[15][500] + 500){
			this.highscore = highscore(score);
			writeFile(songName);
			game.finishState = new FinishState(game);
			State.setState(game.finishState);
			resetGame = true;
			try {
				song.stopSound();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public boolean getResetGame(){
		return resetGame;
	}
	
	private int speed;
	
	public void setArrowSpeed(int speed){
		this.speed = speed;
	}

	public void render(Graphics g) {
	
		//BG
		
//		g.setColor(Color.green);
//		g.fillRect(0, 0, 215, 1280);
//		g.setColor(Color.yellow);
//		g.fillRect(220, 0, 215, 1280);
//		g.setColor(Color.blue);
//		g.fillRect(440, 0, 215, 1280);
//		g.setColor(Color.cyan);
//		g.fillRect(660, 0, 215, 1280);
		
//		g.setColor(Color.blue);
//		g.fillRect(0, 0, 831, 720);
		
		g.drawImage(Assets.bg, 0, 0, 831, 720, null);
		g.drawImage(Assets.bg1, 831, 0 , 449, 720, null);
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval(50, 575, 130, 130);
		g.fillOval(250, 575, 130, 130);
		g.fillOval(450, 575, 130, 130);
		g.fillOval(650, 575, 130, 130);
		
		g.setColor(Color.WHITE);
		g.fillOval(65, 575 + 15, 100, 100);
		g.fillOval(265, 575 + 15, 100, 100);
		g.fillOval(465, 575 + 15, 100, 100);
		g.fillOval(665, 575 + 15, 100, 100);
		
		//Treff-analyse
		
		leftHit.render(g);
		upHit.render(g);
		downHit.render(g);
		rightHit.render(g);
		
		//Svarte streker
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 550, 831, 5);
		g.fillRect(213, 0, 4, 720);
		g.fillRect(413, 0, 4, 720);
		g.fillRect(613, 0, 4, 720);
		g.fillRect(831, 0, 4, 720);
		
		//Text
		
		g.setColor(Color.white);
		
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
		
		g.setFont(new Font("Segoe UI Light", Font.BOLD, 100));
		g.drawString("" + getMultiplier(), 1150, 630);
		
		g.setFont(new Font("Segoe UI Light", Font.BOLD, 50));
		if(hitRow < 10){
			g.drawString("00" + hitRow, 1135, 405);
			
		}
		else if(hitRow < 100){
			g.drawString("0" + hitRow, 1135, 405);
		}
		else{
			g.drawString("" + hitRow, 1135, 405);
		}
	
		
		//Arrows 272 tick = en runde
		
		if(counter > 272){
			
			leftArrow1.render(g);
			leftArrow2.render(g);
			leftArrow3.render(g);
			leftArrow4.render(g);
			
			upArrow1.render(g);
			upArrow2.render(g);
			upArrow3.render(g);
			upArrow4.render(g);
			
			downArrow1.render(g);
			downArrow2.render(g);
			downArrow3.render(g);
			downArrow4.render(g);
			
			rightArrow1.render(g);
			rightArrow2.render(g);
			rightArrow3.render(g);
			rightArrow4.render(g);
			
		}
		
	}
	
	public int getMultiplier(){
		if (hitRow >= topCombo){
			return 8;
		}
		else if (hitRow >= midCombo){
			return 4;
		}
		else if (hitRow >= lowCombo){
			return 2;
		}
		else{
			return 1;
		}
	}
	
	public void playSong(){
		
		song.playSound(songName);
	}
	
	public void isOut(){
		
		if(counter > 280){
			if((leftArrow1.getY() == outY || leftArrow2.getY() == outY || leftArrow3.getY() == outY || leftArrow4.getY() == outY)){	
				score--;
				hitRow = 0;
				missRow++;
				ef.playSound("button-18");
			}
			if((upArrow1.getY() == outY || upArrow2.getY() == outY || upArrow3.getY() == outY || upArrow4.getY() == outY)){	
				score--;
				hitRow = 0;
				missRow++;
				ef.playSound("button-18");
			}
			if((downArrow1.getY() == outY || downArrow2.getY() == outY || downArrow3.getY() == outY || downArrow4.getY() == outY)){	
				score--;
				hitRow = 0;
				missRow++;
				ef.playSound("button-18");
			}
			if((rightArrow1.getY() == outY || rightArrow2.getY() == outY || rightArrow3.getY() == outY || rightArrow4.getY() == outY)){	
				score--;
				hitRow = 0;
				missRow++;
				ef.playSound("button-18");
			}
		}
	}
	
	public void isHit(){
		
		if(game.getkeyManager().left && counter >= keyLockLeft){
			
			keyLockLeft = counter + tickLock;
			
			if(isIn(leftArrow1.getY())){
				hitRow++;
				if (hitRow >= topCombo){
					score += 8;
				}
				else if (hitRow >= midCombo){
					score += 4;
				}
				else if (hitRow >= lowCombo){
					score += 2;
				}
				else{
					score += 1;
				}
				missRow = 0;
				leftArrow1.setY(723);
				ef.playSound("button-14");
				leftHit.setY(0);
				return;
			}
			if(isIn(leftArrow2.getY())){
				hitRow++;
				if (hitRow >= topCombo){
					score += 8;
				}
				else if (hitRow >= midCombo){
					score += 4;
				}
				else if (hitRow >= lowCombo){
					score += 2;
				}
				else{
					score += 1;
				}
				missRow = 0;
				leftArrow2.setY(723);
				ef.playSound("button-14");
				leftHit.setY(0);
				return;
			}
			if(isIn(leftArrow3.getY())){
				hitRow++;
				if (hitRow >= topCombo){
					score += 8;
				}
				else if (hitRow >= midCombo){
					score += 4;
				}
				else if (hitRow >= lowCombo){
					score += 2;
				}
				else{
					score += 1;
				}
				missRow = 0;
				leftArrow3.setY(723);
				ef.playSound("button-14");
				leftHit.setY(0);
				return;
			}
			if(isIn(leftArrow4.getY())){
				hitRow++;
				if (hitRow >= topCombo){
					score += 8;
				}
				else if (hitRow >= midCombo){
					score += 4;
				}
				else if (hitRow >= lowCombo){
					score += 2;
				}
				else{
					score += 1;
				}
				missRow = 0;
				leftArrow4.setY(723);
				ef.playSound("button-14");
				leftHit.setY(0);
				return;
			}
			
			ef.playSound("button-29");
			hitRow = 0;
			missRow++;
			score--;
		}
		
		if(game.getkeyManager().up && counter >= keyLockUp){
			
			keyLockUp = counter + tickLock;
			
			if(isIn(upArrow1.getY())){
				if (hitRow >= topCombo){
					score += 8;
				}
				else if (hitRow >= midCombo){
					score += 4;
				}
				else if (hitRow >= lowCombo){
					score += 2;
				}
				else{
					score += 1;
				}
				hitRow++;
				missRow = 0;
				upArrow1.setY(723);
				ef.playSound("button-14");
				upHit.setY(0);
				return;
			}
			if(isIn(upArrow2.getY())){
				if (hitRow >= topCombo){
					score += 8;
				}
				else if (hitRow >= midCombo){
					score += 4;
				}
				else if (hitRow >= lowCombo){
					score += 2;
				}
				else{
					score += 1;
				}
				hitRow++;
				missRow = 0;
				upArrow2.setY(723);
				ef.playSound("button-14");
				upHit.setY(0);
				return;
			}
			if(isIn(upArrow3.getY())){
				if (hitRow >= topCombo){
					score += 8;
				}
				else if (hitRow >= midCombo){
					score += 4;
				}
				else if (hitRow >= lowCombo){
					score += 2;
				}
				else{
					score += 1;
				}
				hitRow++;
				missRow = 0;
				upArrow3.setY(723);
				ef.playSound("button-14");
				upHit.setY(0);
				return;
			}
			if(isIn(upArrow4.getY())){
				if (hitRow >= topCombo){
					score += 8;
				}
				else if (hitRow >= midCombo){
					score += 4;
				}
				else if (hitRow >= lowCombo){
					score += 2;
				}
				else{
					score += 1;
				}
				hitRow++;
				missRow = 0;
				upArrow4.setY(723);
				ef.playSound("button-14");
				upHit.setY(0);
				return;
			}
			ef.playSound("button-29");
			hitRow = 0;
			score--;
			missRow++;
		}
		
		if(game.getkeyManager().down && counter >= keyLockDown){
			
			keyLockDown = counter + tickLock;
			
			if(isIn(downArrow1.getY())){
				if (hitRow >= topCombo){
					score += 8;
				}
				else if (hitRow >= midCombo){
					score += 4;
				}
				else if (hitRow >= lowCombo){
					score += 2;
				}
				else{
					score += 1;
				}
				hitRow++;
				missRow = 0;
				downArrow1.setY(723);
				ef.playSound("button-14");
				downHit.setY(0);
				return;
			}
			if(isIn(downArrow2.getY())){
				if (hitRow >= topCombo){
					score += 8;
				}
				else if (hitRow >= midCombo){
					score += 4;
				}
				else if (hitRow >= lowCombo){
					score += 2;
				}
				else{
					score += 1;
				}
				hitRow++;
				missRow = 0;
				downArrow2.setY(723);
				ef.playSound("button-14");
				downHit.setY(0);
				return;
			}
			if(isIn(downArrow3.getY())){
				if (hitRow >= topCombo){
					score += 8;
				}
				else if (hitRow >= midCombo){
					score += 4;
				}
				else if (hitRow >= lowCombo){
					score += 2;
				}
				else{
					score += 1;
				}
				hitRow++;
				missRow = 0;
				downArrow3.setY(723);
				ef.playSound("button-14");
				downHit.setY(0);
				return;
			}
			if(isIn(downArrow4.getY())){
				if (hitRow >= topCombo){
					score += 8;
				}
				else if (hitRow >= midCombo){
					score += 4;
				}
				else if (hitRow >= lowCombo){
					score += 2;
				}
				else{
					score += 1;
				}
				hitRow++;
				missRow = 0;
				downArrow4.setY(723);
				ef.playSound("button-14");
				downHit.setY(0);
				return;
			}
			ef.playSound("button-29");
			hitRow = 0;
			score--;
			missRow++;
		}
		
		if(game.getkeyManager().right && counter >= keyLockRight){
			
			keyLockRight = counter + tickLock;
			
			if(isIn(rightArrow1.getY())){
				if (hitRow >= topCombo){
					score += 8;
				}
				else if (hitRow >= midCombo){
					score += 4;
				}
				else if (hitRow >= lowCombo){
					score += 2;
				}
				else{
					score += 1;
				}
				hitRow++;
				missRow = 0;
				rightArrow1.setY(723);
				ef.playSound("button-14");
				rightHit.setY(0);
				return;
			}
			if(isIn(rightArrow2.getY())){
				if (hitRow >= topCombo){
					score += 8;
				}
				else if (hitRow >= midCombo){
					score += 4;
				}
				else if (hitRow >= lowCombo){
					score += 2;
				}
				else{
					score += 1;
				}
				hitRow++;
				missRow = 0;
				rightArrow2.setY(723);
				ef.playSound("button-14");
				rightHit.setY(0);
				return;
			}
			if(isIn(rightArrow3.getY())){
				if (hitRow >= topCombo){
					score += 8;
				}
				else if (hitRow >= midCombo){
					score += 4;
				}
				else if (hitRow >= lowCombo){
					score += 2;
				}
				else{
					score += 1;
				}
				hitRow++;
				missRow = 0;
				rightArrow3.setY(723);
				ef.playSound("button-14");
				rightHit.setY(0);
				return;
			}
			if(isIn(rightArrow4.getY())){
				if (hitRow >= topCombo){
					score += 8;
				}
				else if (hitRow >= midCombo){
					score += 4;
				}
				else if (hitRow >= lowCombo){
					score += 2;
				}
				else{
					score += 1;
				}
				hitRow++;
				missRow = 0;
				rightArrow4.setY(723);
				ef.playSound("button-14");
				rightHit.setY(0);
				return;
			}
			ef.playSound("button-29");
			hitRow = 0;
			score--;
			missRow++;
		}
		
	}
	
	private boolean isIn(int y){
		if(y >= 510 && y <= 640){
			return true;
		}
		return false;
	}
	
	int position = -1;
	List<String> highscore;
	
	public int getPosition(){
		return position;
	}
	
	public String getSong() {
		return songName;
	}
	public int getScore() {
		return score;
	}
	public List<String> getHighscore(){
		return highscore;
	}
	
	private List<String> highscore(int score){
		List<String> highscore = null;
		Path path = FileSystems.getDefault().getPath("res", "highscores", songName + ".txt");
		try {
			highscore = Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < highscore.size(); i++){
            if(score > Integer.parseInt(highscore.get(i))){
                highscore.add(i, score+ "");
                position = i;
                highscore.remove(10);
                break;
            }
        }
//		System.out.println(highscore.toString());
	return highscore;
		
	}
	
	private void writeFile(String songName){
		PrintWriter write = null;
		try {
			write = new PrintWriter("res/highscores" + "/" + songName + ".txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(highscore.get(0));
		for(int i = 0; i < 10; i++){
			write.println(highscore.get(i));
		}
		write.close();
	}
}
