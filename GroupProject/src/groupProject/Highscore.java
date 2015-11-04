package groupProject;

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
	
	String pathName = "src/highscore/highscore.txt";

	Highscore(){
	}
	
	Highscore(String name, int score) {
		this.score = score;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name + " - " + score;
	}

	List<Highscore> sortList(List<Highscore> hsl){ 

		// Alternativ Java 8 kod med lambda:
		//Collections.sort(highScoreList, Comparator.comparingInt(obj ->
		//obj.score).reversed());
		
		Collections.sort(hsl, new Comparator<Highscore>() {
		@Override
		public int compare(Highscore o1, Highscore o2) {
				return o2.score - o1.score;
			}
		});

		return hsl;
		}
		
	List<Highscore> readFile(){
		
		List<Highscore> highScoreList = new LinkedList<>(Arrays.asList()); // Läs på mer om Arrays.asList
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
		return highScoreList;

}
	
	void writeFile(List<Highscore> highScoreList) {
		try (BufferedWriter outstream = new BufferedWriter(new FileWriter(pathName))){
			String writeToFile = "";
			for(int i = 0; i <=9; i++){
				writeToFile += highScoreList.get(i).score + " " + highScoreList.get(i).name + "\n";
			}
			outstream.write(writeToFile);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}
