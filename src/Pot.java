
public class Pot {
	int currentPotValue;
	int rollCounter;
	ScoreCalculator scoreCalculator;
	
	
	Pot(){
		super();
		currentPotValue = 0;
		scoreCalculator = new PreMarketScoreCalculator();
		rollCounter = 0;
	}
	
	void rollDice(DiceRoller roller) {
		if(rollCounter >= 3 && !(scoreCalculator  instanceof OpenMarketScoreCalculator)) {
			setScoreCalculator(new OpenMarketScoreCalculator());
		}
		
		RollResult rollResult = scoreCalculator.calculateScore(roller.rolls[0], roller.rolls[1]);
		
		if(rollResult.potOperation == RollResult.Operation.ADD) {			
			currentPotValue += rollResult.points;
		} else if(rollResult.potOperation == RollResult.Operation.BUST){
			currentPotValue = 0;
		} else if(rollResult.potOperation == RollResult.Operation.DOUBLE) {
			currentPotValue *= 2;
		}
		rollCounter++;
	}
	
	public int getCurrentPotValue() {
		return currentPotValue;
	}
	
	
	public void setScoreCalculator(ScoreCalculator sc) {
		scoreCalculator = sc;
	}
	
	
}
