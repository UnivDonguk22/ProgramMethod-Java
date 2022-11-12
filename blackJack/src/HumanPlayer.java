import javax.swing.*;

public class HumanPlayer extends CardPlayer {

	// 생성 메소드
    public HumanPlayer(int max_cards) {
        super(max_cards);
    }
    
    // TO DO : wantsACard(), youWin(), youWinBlackjack(), youLose(), youDraw(), chips()
    
    
    // CardPlayer 클래스에서 상속받아 사용하는 abstract 메소드
    public boolean wantsACard() {
        String response = JOptionPane.showInputDialog("한장 더 드릴까요? (Y/N)");
        return response.equals("Y");
    }
}
