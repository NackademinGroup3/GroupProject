package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class Highscore {

	private int score;
	private String name;
	List<Highscore> highScoreList = new LinkedList<>(Arrays.asList()); // Läs på mer om Arrays.asList
	String pathName = "highscore/highscore.txt";

	Highscore(String name, int score) {
		this.score = score;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[score = " + score + " name = " + name + "]";
	}

	// Sortera lista med highscore objekt
	private void sortList(){ 

		System.out.println("före sortering: " + highScoreList);

		// Alternativ Java 8 kod med lambda:
		//Collections.sort(highScoreList, Comparator.comparingInt(obj ->
		//obj.score).reversed());
		
		Collections.sort(highScoreList, new Comparator<Highscore>() {
		@Override
		public int compare(Highscore o1, Highscore o2) {
				return o2.score - o1.score;
			}
		});

		System.out.println("efter sortering: " + highScoreList);
		
		}
		
	// Läsa in testfil med highscores och lägg in som element i listan
	private void readFile(){
		
		
		String oneRowOfText = "";

		try (BufferedReader instream = new BufferedReader(new FileReader(pathName))) { 
			
			int counter = 1;
			
			while ((oneRowOfText = instream.readLine()) != null && counter <=10) {
				String[] rowArray = oneRowOfText.split(" ");
				int rowScore = Integer.parseInt(rowArray[0]);
				String rowName = rowArray[1];
				highScoreList.add(new Highscore(rowName, rowScore));
				counter ++;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Fil hittades inte");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Fel med I/O");
			e.printStackTrace();
		}

}
	

	private void writeFile(List<Highscore> highScoreList) {
		try (BufferedWriter outstream = new BufferedWriter(new FileWriter(pathName))){
		//	outstream.write();
		//	loopa igenom 10 listan och skriv ut score + name på en ny rad för varje objekt.	
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

		public static void main(String[] args) {
			
			// Skapa ett testobjekt bara för att komma åt att testmetoderna
			Highscore highscore = new Highscore("test", 3);
			
			
			highscore.readFile();
			highscore.sortList();
			
		}

}
