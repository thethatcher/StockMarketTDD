
public class OpenMarketScoreCalculator implements ScoreCalculator{
	Pot pot;
	
	OpenMarketScoreCalculator(Pot pot){
		this.pot = pot;
	}
	
	public int calculateScore(int die1, int die2) {
		int sum = die1 + die2;
		
		if(sum == 7) {
			return 0;
		}
		
		if(die1 == die2) {
			return pot.getCurrentPotValue();
		}
		
		return sum;
	}
}
