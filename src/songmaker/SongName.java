package songmaker;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SongName {
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int[][] matrise = new int[16][500];
		int start;
		int interval;
		//int songEnd;
		int linjeRow = -1;
		boolean run = true;
		String Filnavn;
		List<Integer> venstre = new ArrayList<Integer>();
		List<Integer> opp = new ArrayList<Integer>();
		List<Integer> ned = new ArrayList<Integer>();
		List<Integer> høyre = new ArrayList<Integer>();
		ArrayList<ArrayList<String>> visningsMatrix = new ArrayList<ArrayList<String>>();
		
		//counters
		int leftRad = 0;
		int leftCol = 0;
		int upRad = 4;
		int upCol = 0;
		int downRad = 8;
		int downCol = 0;
		int rightRad = 12;
		int rightCol = 0;
		
		System.out.println("Hva er filnavnet til den nye sangen?");
		Filnavn = scan.nextLine();
		System.out.println("Når starter sangen?");
		start = scan.nextInt();
		System.out.println("Hva er intervallet pr. linje?");
		interval = scan.nextInt();
		System.out.println("hvilke tic skal sangen ende på?");
		//songEnd = scan.nextInt();
		scan.nextLine();
		System.out.println("Skriv 69 hvis du vil avslutte");
		
		
		while(run){
			System.out.println("Skriv 1 for pil, 0 for ikke pil (left, up, down, right)");
			String linje = scan.nextLine();
			String[] input = linje.split(" ");
			int left = Integer.parseInt(""+input[0]);
			if (left == 69){
				break;
			}
			ArrayList<String> tempList = new ArrayList<String>(Arrays.asList(input[0], input[1], input[2], input[3]));
			visningsMatrix.add(tempList);
			
			linjeRow++;
			int up = Integer.parseInt(input[1]);
			int down = Integer.parseInt(input[2]);
			int right = Integer.parseInt(input[3]);
			
			if( left == 1){
				venstre.add(start + interval*linjeRow);
//				matrise[leftRad][leftCol] = 1;
				leftRad++;
				if(leftRad > 3){
					leftRad = 0;
					leftCol++;
				}
			}
			if( up== 1){
				opp.add(start + interval*linjeRow);
//				matrise[upRad][upCol] = 1;
				upRad++;
				if(leftRad > 7){
					leftRad = 4;
					leftCol++;
				}
			}
			if( down == 1){
				ned.add(start + interval*linjeRow);
//				matrise[downRad][downCol] = 1;
				downRad++;
				if(downRad > 11){
					downRad = 8;
					downCol++;
				}
			}
			if( right == 1){
				høyre.add(start + interval*linjeRow);
//				matrise[rightRad][rightCol] = 1;
				rightRad++;
				if(rightRad > 15){
					rightRad = 12;
					rightCol++;
				}
			}
			for(int i = visningsMatrix.size(); i > 0; i--){
				System.out.print(visningsMatrix.get(i-1).get(0)+" ");
				System.out.print(visningsMatrix.get(i-1).get(1)+" ");
				System.out.print(visningsMatrix.get(i-1).get(2)+" ");
				System.out.print(visningsMatrix.get(i-1).get(3));
				System.out.println();
				
			}
		}
		//skrive filen for real
		int row = 0;
		int col = 0;
		for (int i = 0; i < venstre.size(); i++){
			matrise[row][col] = venstre.get(i);
			row++;
			if(row > 3){
				row = 0;
				col++;
			}
		}
		row = 4;
		col = 0;
		for (int i = 0; i < opp.size(); i++){
			matrise[row][col] = opp.get(i);
			row++;
			if(row > 7){
				row = 4;
				col++;
			}
		}
		row = 8;
		col = 0;
		for (int i = 0; i < ned.size(); i++){
			matrise[row][col] = ned.get(i);
			row++;
			if(row > 11){
				row = 8;
				col++;
			}
		}
		row = 12;
		col = 0;
		for (int i = 0; i < høyre.size(); i++){
			matrise[row][col] = høyre.get(i);
			row++;
			if(row > 15){
				row = 12;
				col++;
			}
		}
		//skrive til fil 
		PrintWriter file = new PrintWriter(Filnavn + ".txt");
		for(int i = 0; i < 16; i++){
			for(int j = 0; j < 500; j++){
				file.print(matrise[i][j] + " ");
			}
			file.println();
		}
		file.close();
		scan.close();
		
		
		
	}
}
