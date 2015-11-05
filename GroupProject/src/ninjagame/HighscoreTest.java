package ninjagame;

import static org.junit.Assert.*;

import org.junit.Test;

public class HighscoreTest {
	

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

	@Test(timeout=10) // Annotation som visar att det är ett JUnit test.	
	public void readFileShouldBeFast(){
		
		Highscore.readFile();
	}
}
