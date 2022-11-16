import javax.swing.JOptionPane;

public class BlackJackController {
	
	private Dealer dealer;
	private HumanPlayer hand_player;
	private ComputerPlayer hand_dealer;
	
	
	// Controller의 생성 메소드
	public BlackJackController(Dealer d) {
		dealer = d;
	}
	

	// Controller의 메소드
	public void manageBlackjack() {
		
		boolean game_status = true;
		
		// 유저 - 컴퓨터의 카드 덱 저장 - 출력
		Card[] card_player;
		Card[] card_dealer;
		String name = JOptionPane.showInputDialog("플레이어의 이름을 입력하세요");
		
		System.out.println("플레이어 이름: "+ name);
		
		
		// 플레이어 객체 생성
		hand_player = new HumanPlayer(53, name);
		
		// 컴퓨터 플레이어 객체 생성
		hand_dealer = new ComputerPlayer(53);
		System.out.println("Your Chips: "+ hand_player.chips() + "\n");
		
		while(game_status) {
			
			System.out.println("+----------+----------------+-------------+\n\n");
			
			
			
			// 게임 처음,
			/*
			 * 카드를 두장씩 유저, 컴퓨터에게 뿌림.
			 */
			
			dealer.dealOneTo(hand_player);
			dealer.dealOneTo(hand_dealer);
			
			dealer.dealOneTo(hand_player);
			dealer.dealOneTo(hand_dealer);
			
			// 카드 2장 나눠주고, 유저 - 컴퓨터 카드덱 출력
			card_player = hand_player.showCards();
			card_dealer = hand_dealer.showCards();
			
			System.out.println("Player Card");
			for(int i = 0; i < card_player.length; i++) {
				System.out.print(card_player[i].suit());
				
				if(card_player[i].rank() == 1){
					System.out.println(" ACE");
				}
				else if(card_player[i].rank() == 11) {
					System.out.println(" JACK");
				}
				else if(card_player[i].rank() == 12) {
					System.out.println(" QUEEN");
				}
				else if(card_player[i].rank() == 13) {
					System.out.println(" KING");
				}
				else {
					System.out.println(" "+card_player[i].rank());
				}
			}
			System.out.println(hand_player.totalScore()+ "\n");
			
			System.out.println("Dealer Card");
			for(int i = 1; i < card_dealer.length; i++) {
				System.out.print(card_dealer[i].suit());
				
				if(card_dealer[i].rank() == 1){
					System.out.println(" ACE");
				}
				else if(card_dealer[i].rank() == 11) {
					System.out.println(" JACK");
				}
				else if(card_dealer[i].rank() == 12) {
					System.out.println(" QUEEN");
				}
				else if(card_dealer[i].rank() == 13) {
					System.out.println(" KING");
				}
				else {
					System.out.println(" "+card_dealer[i].rank());
				}
			}
//			System.out.println(hand_dealer.totalScore()+ "\n");
			System.out.println("\n");
			
			// 게임 진행
			if(hand_player.totalScore() == 21) {
				hand_player.youWinBlackjack();
			}
			else {
				while(hand_player.totalScore() < 21 && hand_player.wantsACard()) {
					dealer.dealOneTo(hand_player);
					
					// 플레이어 카드 덱 출력
					card_player = hand_player.showCards();
					System.out.println("Player Card");
					for(int i = 0; i < card_player.length; i++) {
						System.out.print(card_player[i].suit());
						
						if(card_player[i].rank() == 1){
							System.out.println(" ACE");
						}
						else if(card_player[i].rank() == 11) {
							System.out.println(" JACK");
						}
						else if(card_player[i].rank() == 12) {
							System.out.println(" QUEEN");
						}
						else if(card_player[i].rank() == 13) {
							System.out.println(" KING");
						}
						else {
							System.out.println(" "+card_player[i].rank());
						}
					}
					System.out.println(hand_player.totalScore()+ "\n");
				}
				
				if(hand_player.totalScore() > 21) {
					hand_player.youLose();
				}
				else if(hand_player.totalScore() == 21) {
					hand_player.youWinBlackjack();
				}
				
				// 유저 턴 종료 - 21이하인 채로 종료
				else {
					while(hand_dealer.wantsACard() && hand_dealer.totalScore() < 21) {
						dealer.dealOneTo(hand_dealer);
						
						// 컴퓨터 카드 덱 출력
						card_dealer = hand_dealer.showCards();
						System.out.println("Dealer Card");
						for(int i = 1; i < card_dealer.length; i++) {
							System.out.print(card_dealer[i].suit());
							
							if(card_dealer[i].rank() == 1){
								System.out.println(" ACE");
							}
							else if(card_dealer[i].rank() == 11) {
								System.out.println(" JACK");
							}
							else if(card_dealer[i].rank() == 12) {
								System.out.println(" QUEEN");
							}
							else if(card_dealer[i].rank() == 13) {
								System.out.println(" KING");
							}
							else {
								System.out.println(" "+card_dealer[i].rank());
							}
						}
//						System.out.println(hand_dealer.totalScore()+ "\n");
						System.out.println("\n");
					}
					
					
					if (hand_dealer.totalScore() > 21) {
						hand_player.youWin();
					}
					else if(hand_dealer.totalScore() == hand_player.totalScore()) {
						hand_player.youDraw();
					}
					else if(hand_dealer.totalScore() < hand_player.totalScore()) {
						hand_player.youWin();
					}
					
					// 컴퓨터가 블랙잭 or 컴퓨터의 카드 덱 total이 더 클 때
					else {
						hand_player.youLose();
					}
					
				}
			}
				
				
				// 한 턴 게임종료
				
				/*
				 * 매 판마다 게임 종료 시
				 *  유저 - 컴퓨터 카드 덱 초기화 - 다음 게임을 진행
				 */
				hand_player.resetHand();
				hand_dealer.resetHand();
				
				System.out.println("Your chips: " + hand_player.chips() + "\n");
				System.out.println("+----------+----------------+-------------+\n\n\n\n\n");
				
				String continue_game = JOptionPane.showInputDialog("\n\n게임을 더 하시겠습니까?");
				
				if(!continue_game.equals("y")) {
					game_status = false;
				}
			
		}
		
		System.out.println("Bye!!!!!");
		
	}
	
	

}
