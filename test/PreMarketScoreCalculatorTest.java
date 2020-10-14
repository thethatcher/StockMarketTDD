import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PreMarketScoreCalculatorTest {
	PreMarketScoreCalculator sc;
	Pot pot;
	
	@BeforeEach
	void setUp() {
		sc = new PreMarketScoreCalculator();
	}

	@Test
	void calculateScore_OneTwo_is3() {
		RollResult rollResult = sc.calculateScore(1,2);
		assertEquals(rollResult.points, 3);
		assertEquals(rollResult.potOperation, RollResult.Operation.ADD);
	}

	@Test
	void calculateScore_FourSix_is10() {
		RollResult rollResult = sc.calculateScore(4,6);
		assertEquals(rollResult.points, 10);
		assertEquals(rollResult.potOperation, RollResult.Operation.ADD);
	}
	
	@Test
	void calculateScore_seven_is70() {
		RollResult rollResult = sc.calculateScore(1,6);
		assertEquals(rollResult.points, 70);
		assertEquals(rollResult.potOperation, RollResult.Operation.ADD);
	}
}