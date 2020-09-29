import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoundTest {
	Round round;
	@BeforeEach
	public void setup() {
		round = new Round();
	}
	
	@Test
	void roll2D6_noInput_returnsArrayWith2D6Values() {
		//setup
		int[] rollResult = new int[2];
		//execute
		rollResult = round.roll2D6();
		//assert
		assertTrue(rollResult[0] >= 1 && rollResult[0] <= 6);
		assertTrue(rollResult[1] >= 1 && rollResult[1] <= 6);
	}
	
	@Test
	void roll_noInput_rollExists() {
		round.roll(); //this test is pointless
	}
	
	@Test
	void getFirstRound_noInput_is1() {
		//setup
		//execute
		int roundNumber = round.getRound();
		//assert
		assertEquals(roundNumber, 1);
	}
	
	@Test
	void getSecondRound_noInput_is2() {
		//setup
		round.nextRound();
		//execute
		int roundNumber = round.getRound();
		//assert
		assertEquals(roundNumber, 2);
	}
	
	@Test
	void getNthround_noInput_isN() {
		int roundNumber = round.getRound();
		for(int i = 1; i < 21; i++) {
			roundNumber = round.getRound();
			assertEquals(roundNumber,i);
			round.nextRound();
		}
	}
	
	

}
