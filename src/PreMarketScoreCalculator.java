
public class PreMarketScoreCalculator implements ScoreCalculator{

	@Override
	public int calculateScore(int die1, int die2, Pot pot) {
		int sum = die1 + die2;
		return (sum == 7) ? 70 : sum;
	}
	
	
}
