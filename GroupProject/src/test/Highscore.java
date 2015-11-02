package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


//http://stackoverflow.com/questions/33190156/sort-a-linkedlist-of-objects-by-objects-variable

public class Highscore {

	private String name;
	private int score;

	Highscore(String name, int score) {
		this.name = name;
		this.score = score;
	}
	

	@Override
	public String toString() {
		return "Highscore [name=" + name + ", score=" + score + "]";
	}

		
	private void sortList(){ 
		// SceneMeny sceneMeny = new SceneMeny();

		List<Highscore> highScoreList = new LinkedList<>(Arrays.asList(new Highscore("Robin", 3), new Highscore("Elliot", 9), new Highscore("Patrik", 20)));

		System.out.println("före sortering: " + highScoreList);

		
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
		
		
	private void readFile(){
		// Läsa in testfil med highscores, test
		
		String pathName = "/Users/patrikhornqvist/Documents/Text/highscore";
		String oneRowOfText = "";
		String textFromFile = "";

		try (BufferedReader instream = new BufferedReader(new FileReader(pathName + ".txt"))) { 
			
			while ((oneRowOfText = instream.readLine()) != null) {
				textFromFile += "\n" + oneRowOfText;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fil hittades inte");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Fel med I/O");
			e.printStackTrace();
		}
		System.out.println(textFromFile);

}

		public static void main(String[] args) {
			
			Highscore highscore = new Highscore("test", 3);
			highscore.sortList();
			
		}

}
