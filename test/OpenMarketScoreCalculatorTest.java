import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpenMarketScoreCalculatorTest {
	OpenMarketScoreCalculator sc;
	
	@BeforeEach
	public void setup() {		
		sc = new OpenMarketScoreCalculator();
	}
	
	@Test
	public void calculateScore_OneTwo_is3() {
		RollResult rollResult = sc.calculateScore(1,2);
		assertEquals(rollResult.points,3);
		assertEquals(rollResult.potOperation, RollResult.Operation.ADD);
	}
	
	@Test
	public void calculateScore_TwoThree_is5() {
		RollResult rollResult = sc.calculateScore(2,3);
		assertEquals(rollResult.points,5);
		assertEquals(rollResult.potOperation, RollResult.Operation.ADD);
	}

	@Test
	public void caclulateScore_ThreeFour_isBust() {
		RollResult rollResult = sc.calculateScore(3,4);
		assertEquals(rollResult.potOperation,RollResult.Operation.BUST);
	}
	
	@Test
	
	public void calculateScore_doubles_isDouble() {
		RollResult rollResult = sc.calculateScore(2,2);
		assertEquals(rollResult.potOperation, RollResult.Operation.DOUBLE);
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
