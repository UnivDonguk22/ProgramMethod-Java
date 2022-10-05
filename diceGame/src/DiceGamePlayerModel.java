
public class DiceGamePlayerModel {
	
	/*
	 *	Pre - set field variable
	 */
	private String name;
	private int points; // points == 0
	private DiceGameDiceModel rolledDiceResult; // rolledDiceResult의 자동으로 초기화된 객체
	private boolean wins; // wins == 0 | false
	
	public String name() 
	{ 
		return name; 
	}
	
	public int points() 
	{ 
		return points;
	}
	
	/*
	 * 		Player 1 or Player 2 's rolledDiceResult
	 */
	public DiceGameDiceModel rolled()
	{ 
		return rolledDiceResult;
	}
	
	public boolean wins()
	{ 
		return wins;
	}
	
	
	
	
	
	/*
	 * 	Product Method
	 */
	public DiceGamePlayerModel (String n) {
		name = n;
	}
	
	
	
	public void play(DiceGameDiceModel d) {
		d.rollDice();
		rolledDiceResult = d;
	}
	
	
	
	public void receivePoint() {
		points += 1;
		wins = true;
	}
	
	
	
	
	public void reset() {
		wins = false;
	}

}