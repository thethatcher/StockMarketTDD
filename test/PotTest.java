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
	
	@Test 
	void tenthRoll_manyRolls_is1234(){
		DiceRoller dr = new DiceRoller(2,3);
		pot.rollDice(dr); //5
		assertEquals(pot.getCurrentPotValue(),5);
		dr = new DiceRoller(3,4); //75
		pot.rollDice(dr);
		assertEquals(pot.getCurrentPotValue(),75);
		dr = new DiceRoller(6,5); //86
		pot.rollDice(dr);
		assertEquals(pot.getCurrentPotValue(),86);
		//Open Market
		dr = new DiceRoller(1,3); //90
		pot.rollDice(dr);
		assertEquals(pot.getCurrentPotValue(),90);
		dr = new DiceRoller(5,5); //180
		pot.rollDice(dr);
		assertEquals(pot.getCurrentPotValue(),180);
		dr = new DiceRoller(1,5); //186
		pot.rollDice(dr);
		assertEquals(pot.getCurrentPotValue(),186);
		dr = new DiceRoller(1,1); //372
		pot.rollDice(dr);
		assertEquals(pot.getCurrentPotValue(),372);
		dr = new DiceRoller(6,6); //744
		pot.rollDice(dr);
		assertEquals(pot.getCurrentPotValue(),744);
		dr = new DiceRoller(3,2); //749
		pot.rollDice(dr);
		assertEquals(pot.getCurrentPotValue(),749);
		dr = new DiceRoller(6,1); // 0
		pot.rollDice(dr);
		assertEquals(pot.getCurrentPotValue(),0);
	}
}
