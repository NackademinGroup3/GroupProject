package test;

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

	public static void main(String[] args) {

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

}
