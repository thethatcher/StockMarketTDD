
public class PreMarketScoreCalculator implements ScoreCalculator{

	@Override
	public RollResult calculateScore(int die1, int die2) {
		int sum = die1 + die2;
		RollResult rollResult = new RollResult();
		if(sum == 7) {
			rollResult.points = 70;
		} else {			
			rollResult.points = sum;
		}
		rollResult.potOperation = RollResult.Operation.ADD;
		return rollResult;
	}
}