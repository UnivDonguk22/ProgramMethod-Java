import javax.swing.JOptionPane;

public class ComputerPlayer extends CardPlayer {

	int maxCards;
	
	
	// 생성 메소드
    public ComputerPlayer(int max_cards) {
    	// CardPlayer 클래스 상속받음.
    	/*
    	 *  컴퓨터 카드 덱 생성
    	 */
        super(max_cards);
    }
    
    // abstract 메소드인 wantsACard() 구현
    public boolean wantsACard() {
    	
    	// 컴퓨터의 카드 덱 받기 & 안받기 의사결정
        boolean decision;
        Card[] cards = showCards();
        
        // 게임에 따라 다른 전략을 세움
        if(totalScore() <= 16) {
        	decision = true;
        }
        else {
        	decision = false;
        }
        
        return decision;
    }
    

}