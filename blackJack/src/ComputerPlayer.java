import javax.swing.JOptionPane;

public class ComputerPlayer extends CardPlayer {

	
	// 생성 메소드
    public ComputerPlayer(int max_cards) {
        super(max_cards);
    }
    
    // abstract 메소드인 wantsACard() 구현
    public boolean wantsACard() {
        boolean decision;
        Card[] cards = showCards();
        // 게임에 따라 다른 전략을 세움
        return true;
    }

}