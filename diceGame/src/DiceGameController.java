
// TO DO

public class DiceGameController {
	
	public void controllDiceGame(DiceGamePlayerModel p1, DiceGamePlayerModel p2, DiceGameViewOut output, DiceGameViewIn input) {
		/*
		 *	Start Game - first Dice roll is player1 -> player2
		 *	If winner is player1 -> next game first Dice roll Player2
		 *	If player2 's point is big at player1 's point
		 *	then, change the Dice roll
		 */
		
		/*
		 * 주사위 굴림 - p1부터 시작
		 * 
		 * 주사위 게임 규칙에 따른 게임설정 ㅎㅎ
		 */
		
		/*
		 * I have Question : p1.play(p1.rolled()) is why Null Error?
		 */
		if (p1.points() == 0) {
			p1.play(new DiceGameDiceModel());
			p2.play(new DiceGameDiceModel());
		}
		else if (p1.points() >= p2.points()) {
			p2.play(new DiceGameDiceModel());
			p1.play(new DiceGameDiceModel());
		}
		else {
			p1.play(new DiceGameDiceModel());
			p2.play(new DiceGameDiceModel());
		}
		
		
		// p1과 p2의 주사위 결과가 쌍둥이
		if (p1.rolled().twin() && p2.rolled().twin()) {
			if (p1.rolled().sum() > p2.rolled().sum()) {
				p1.receivePoint();
				output.showWinP1Result(75,"이겼다!");
				p1.reset();
				
			}
			else if (p1.rolled().sum() < p2.rolled().sum()) {
				p2.receivePoint();
				output.showWinP2Result(75,"이겼다!");
				p2.reset();
			}
			else {
				output.showDrawResult("비겼다!");
			}
			
		}
		
		// p1의 주사위 결과가 쌍둥이
		else if (p1.rolled().twin()) {
			p1.receivePoint();
			output.showWinP1Result(75,"이겼다!");
			p1.reset();
		}
		
		// p2의 주사위 결과가 쌍둥이
		else if (p2.rolled().twin()) {
			p2.receivePoint();
			output.showWinP2Result(75,"이겼다!");
			p2.reset();
		}
		
		// p1, p2가 쌍둥이가 아닐 때이다.
		else {
			
			// p1 쌍의 합과 p2쌍의 합이 같다.
			if (p1.rolled().sum() == p2.rolled().sum()) {
				if (p1.rolled().difference() > p2.rolled().difference()) {
					p2.receivePoint();
					output.showWinP2Result(75,"이겼다!");
					p2.reset();
				}
				else if (p1.rolled().difference() < p2.rolled().difference()) {
					p1.receivePoint();
					output.showWinP1Result(75,"이겼다!");
					p1.reset();
				}
				else {
					output.showDrawResult("비겼다!");
				}
			
			// p1 쌍의 합과 p2쌍의 합이 다르다.
			}
			else {
				if (p1.rolled().sum() > p2.rolled().sum()) {
					p1.receivePoint();
					output.showWinP1Result(75,"이겼다!");
					p1.reset();
				}
				else {
					p2.receivePoint();
					output.showWinP2Result(75,"이겼다!");
					p2.reset();
				}
			}
		}
		
		
		
		if(input.wantToContnue() == 0) {
			this.controllDiceGame(p1, p2, output, input);
		}
		else {
			System.exit(0);
		}
		
		
		
		
		
		
		
	}

}
