
public class OpenMarketScoreCalculator implements ScoreCalculator{

	@Override
	public RollResult calculateScore(int die1, int die2) {
		RollResult rollResult = new RollResult();
		int sum = die1 + die2;
		
		if(sum == 7 ) {
			rollResult.potOperation = RollResult.Operation.BUST;
		} else if( die1 == die2) {
			rollResult.potOperation = RollResult.Operation.DOUBLE;
		} else {
			rollResult.points = sum;
			rollResult.potOperation = RollResult.Operation.ADD;
		}
		
		return rollResult;
	}
}
