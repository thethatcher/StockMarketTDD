
public class Round {
	
	private int roundCounter = 1;
	
	public int roll() {
		
		return 0;
	}
	
	int[] roll2D6() {
		int [] results = new int[2];
		results[0] = (int) Math.ceil(Math.random()*6);
		results[1] = (int) Math.ceil(Math.random()*6);
		return results;
	}

	public int getRound() {
		return roundCounter;
	}

	public void nextRound() {
		roundCounter++;
	}
}
