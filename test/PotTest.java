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
	void firstRoll_OneOne_is20() {
		assertEquals(pot.rollDice(1,1), 20);
	}
	
	@Test
	void firstRoll_TwoSix_is80() {
		assertEquals(pot.rollDice(2,6), 80);
	}
	
	@Test
	void secondRoll_TwoTwo_is40() {
		pot.rollDice(1,2);
		
		int rollScore = pot.rollDice(2,2);
		int currentPot = pot.getCurrentScore();
		
		assertEquals(rollScore, 40);
		assertEquals(currentPot,70);
	}
	
	@Test 
	void thirdRoll_OneSix_is70() {
		pot.rollDice(1,2);
		pot.rollDice(3,4);
		
		int rollScore = pot.rollDice(2,5);
		int currentPot = pot.getCurrentScore();
		
		assertEquals(rollScore,70);
		assertEquals(currentPot, 170);
	}

	@Test
	void fourthRoll_ThreeFour_is0() {
		//setup
		assertEquals(pot.rollDice(3,4),70);
		assertEquals(pot.rollDice(3,4),70);
		assertEquals(pot.rollDice(3,4),70);
		//execute
		int points = pot.rollDice(3,4);
		//assert
		assertEquals(points, 0);
	}
	
	@Test 
	void fourthRoll_notSeven_isNot0(){
		assertEquals(pot.rollDice(3,2),50);
		assertEquals(pot.rollDice(1,2),30);
		assertEquals(pot.rollDice(3,4),70);
		
		int points = pot.rollDice(2,3);
		
		assertEquals(points,50);
	}
	
	@Test
	void fourthRoll_getScore_CumulativeValue() {
		pot.rollDice(1,2);
		pot.rollDice(3,4);
		pot.rollDice(5,6);
		pot.rollDice(1,5);
		
		int currentPot = pot.getCurrentScore();
		
		assertEquals(currentPot,270);
	}
	
	@Test
	void fourthRoll_isSeven_BustsPot() {
		pot.rollDice(1,2);
		pot.rollDice(3,4);
		pot.rollDice(5,6);
		
		int rollScore = pot.rollDice(1,6);
		int currentPot = pot.getCurrentScore();
		
		assertEquals(rollScore,0);
		assertEquals(currentPot,0);
	}
	
	@Test 
	void fourthRoll_Doubles_DoublesPot(){
		pot.rollDice(1,2);
		pot.rollDice(3,4);
		pot.rollDice(5,6);
		
		int rollScore = pot.rollDice(1,1);
		int currentPot = pot.getCurrentScore();
		
		assertEquals(rollScore, 210);
		assertEquals(currentPot, 420);
	}
}
