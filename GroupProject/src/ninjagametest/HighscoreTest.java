package ninjagametest;

import static org.junit.Assert.*;

import org.junit.Test;

import ninjagame.Highscore;

public class HighscoreTest {
	
	Highscore highscore = new Highscore();

	/*
	@Test // Annotation som visar att detta är ett JUnit test.
	public void testSortList() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteFile() {
		fail("Not yet implemented");
	}
	*/

	@Test(timeout=100) // Annotation som visar att det är ett JUnit test.	
	public void readFileShouldBeFast(){
		
		//Highscore highscore = new Highscore();
		highscore.readFile();
	}
}
