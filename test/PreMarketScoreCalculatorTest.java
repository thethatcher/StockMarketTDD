import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PreMarketScoreCalculatorTest {
	PreMarketScoreCalculator sc;
	Pot pot;
	
	@BeforeEach
	void setUp() {
		sc = new PreMarketScoreCalculator();
		pot = new Pot();
		pot.setCurrentPotValue(50);
	}

	@Test
	void calculateScore_OneTwo_is3() {
		int points = sc.calculateScore(1,2, pot);
		assertEquals(points, 3);
	}

	@Test
	void calculateScore_FourSix_is10() {
		int points = sc.calculateScore(4,6, pot);
		assertEquals(points, 10);
	}
	
	@Test
	void calculateScore_seven_is70() {
		int points = sc.calculateScore(1,6, pot);
		assertEquals(points, 70);
	}
}