import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PotTest {
	Pot pot;
	
	@BeforeEach
	public void setup() {
		pot = new Pot();
	}
	
	@Test
	void rollDiceOnce_OneTwo_potValueIs3() {
		//setup
		DiceRoller dr = new DiceRoller(1,2);
		//execute
		pot.rollDice(dr);
		//assert
		assertEquals(pot.getCurrentPotValue(),3);
	}
	
	@Test
	void rollDiceOnce_FourSix_potValueIs10() {
		//setup
		DiceRoller dr = new DiceRoller(4,6);
		//execute
		pot.rollDice(dr);
		//assert
		assertEquals(pot.getCurrentPotValue(),10);
	}
	
	@Test
	void rollDiceOnce_FourThree_potValueIs70() {
		DiceRoller dr = new DiceRoller(3,4);
		pot.rollDice(dr);
		assertEquals(pot.getCurrentPotValue(),70);
	}
	
	@Test
	void fourthDiceRoll_OneTwo_is18() {
		DiceRoller dr = new DiceRoller(2,3);
		pot.rollDice(dr);
		pot.rollDice(dr);
		pot.rollDice(dr);
		dr = new DiceRoller(1,2);
		pot.rollDice(dr);
		assertEquals(pot.getCurrentPotValue(),18);
	}
	
	@Test
	void fourthDiceRoll_ThreeFour_is0() {
		DiceRoller dr = new DiceRoller(2,3);
		pot.rollDice(dr);
		pot.rollDice(dr);
		pot.rollDice(dr);
		dr = new DiceRoller(3,4);
		pot.rollDice(dr);
		assertEquals(pot.getCurrentPotValue(),0);
	}
	
	@Test
	void fourthDiceRoll_doubles_is30() {
		DiceRoller dr = new DiceRoller(2,3);
		pot.rollDice(dr);
		pot.rollDice(dr);
		pot.rollDice(dr);
		dr = new DiceRoller(3,3);
		pot.rollDice(dr);
		assertEquals(pot.getCurrentPotValue(),30);
	}
}
