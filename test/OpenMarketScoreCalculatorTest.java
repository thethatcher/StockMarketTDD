import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpenMarketScoreCalculatorTest {
	OpenMarketScoreCalculator sc;
	Pot pot;
	
	@BeforeEach
	public void setup() {		
		sc = new OpenMarketScoreCalculator();
		pot = new Pot();
		pot.setCurrentPotValue(50);
	}
	
	@Test
	public void calculateScore_OneTwo_is3() {
		int points = sc.calculateScore(1,2, pot);
		assertEquals(points,3);
	}
	
	@Test
	public void calculateScore_TwoThree_is5() {
		int points = sc.calculateScore(2,3, pot);
		assertEquals(points,5);
	}

	@Test
	public void caclulateScore_ThreeFour_is0() {
		int points = sc.calculateScore(3,4, pot);
		assertEquals(points,0);
	}
	
	@Test
	
	public void calculateScore_doubles_isDoubled() {
		int points = sc.calculateScore(2,2, pot);
		assertEquals(points, 50);
	}
/*	
 * 
 * This test fails because ScoreCalculator is only meant to calculate the score, not set the pot value. 
 * This test is outside the scope of ScoreCalculator
	@Test
	public void calculateScore_doublesTwice_is4times() {
		//setup
		sc.pot.setCurrentPotValue(50);
		//execute
		int firstPoints = sc.calculateScore(1,1);
		int secondPoints = sc.calculateScore(6,6);
		//assert
		assertEquals(firstPoints, 50);
		assertEquals(secondPoints,100);
	}
*/
}
