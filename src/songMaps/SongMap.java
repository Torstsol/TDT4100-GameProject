package songMaps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SongMap {
	
	private int[][] matrise;
	private String title;
	private int largestInt;
	
	public SongMap(String title){
		this.title ="res/songs/" + title + ".txt";
		makeMap();
		largestInt = 0;
	}
	
	public void makeMap(){
		
		matrise = new int[16][5000];
		int index = 0;
		File file = new File(title);
		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scan.hasNextLine()){
			String str = scan.nextLine();
			String[] tall = str.split(" ");
			for (int i = 0; i<tall.length; i++){
				matrise[index][i]= Integer.parseInt(tall[i]);
				if(largestInt < matrise[index][i]){
					largestInt = matrise[index][i];
				}
			}
			index++;
		}
		//finne ut hvilket tikk sangen skal ende på
		matrise[15][500] = largestInt;
		
	}
	
	public int[][] getSongMap(){
		return matrise;
	}

}
