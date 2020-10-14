
public class DiceRoller {
	int[] rolls = new int[2];
	
	DiceRoller(int sides) {		
		for(int i = 0; i < rolls.length; i++) {
			int temp = (int)Math.ceil(Math.random() * sides);
			rolls[i] = temp;
		}
	}
	
	DiceRoller(int mock1, int mock2){
		rolls[1] = mock2;
		rolls[0] = mock1;
	}

}
