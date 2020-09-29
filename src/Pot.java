
public class Pot {
	
	int rollCounter = 0;
	int currentScore = 0;
	
	public int getCurrentScore() {
		return currentScore;
	}
	
	public int rollDice(int num1, int num2) {
		int rollResult =  makeRollResult(num1, num2);
		if(rollResult == 0) {
			currentScore = 0;
		} else {			
			currentScore += rollResult;
		}
		return rollResult;
	}

	private int makeRollResult(int num1, int num2) {
		rollCounter++;
		int sum = num1 + num2;
		if(rollCounter <= 3) {
			return (sum*10);
		} else {
			return handleOpenMarket(num1, num2);
		}
	}
	
	private int handleOpenMarket(int num1, int num2) {
		int sum = num1 + num2;
		
		if(sum == 7) {
			return 0;
		} 
		
		if( num1 == num2) {
			return currentScore;
		} else {
			return (sum*10);
		}
	}
}