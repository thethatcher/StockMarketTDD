import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiceRollerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void diceRoller_roll10000_within1And6() {
		boolean[] numbers = new boolean[6];
		for(int i = 0; i < 10000; i++) {
			DiceRoller dr = new DiceRoller(6);
			switch (dr.rolls[0]) {
			case 1 :
				numbers[0] = true;
				break;
			case 2 :
				numbers[1] = true;
				break;
			case 3 :
				numbers[2] = true;
				break;
			case 4 :
				numbers[3] = true;
				break;
			case 5 :
				numbers[4] = true;
				break;
			case 6 :
				numbers[5] = true;
			}
			
			assertTrue(dr.rolls[0] >= 1 && dr.rolls[0] <= 6);
			assertTrue(dr.rolls[1] >= 1 && dr.rolls[1] <= 6);			
		}
		
		for(int i = 0; i < 6; i++) {
			assertTrue(numbers[i]);
		}
	}
	
	@Test
	void diceRoller_mockRoller12_is12() {
		DiceRoller dr = new DiceRoller(1,2);
		assertEquals(dr.rolls[0], 1);
		assertEquals(dr.rolls[1], 2);
	}

	@Test
	void diceRoller_mockRoller42_is42() {
		DiceRoller dr = new DiceRoller(4,2);
		assertEquals(dr.rolls[0], 4);
		assertEquals(dr.rolls[1], 2);
	}

}
