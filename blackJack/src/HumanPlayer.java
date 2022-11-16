import javax.swing.*;

public class HumanPlayer extends CardPlayer {
	
	// 유저 정보
	public String name;
	private int chips;
	
	
	// 생성 메소드
    public HumanPlayer(int max_cards, String n) {
    	// CardPlayer 클래스 상속받음.
    	/*
    	 * 유저의 카드 덱 생성
    	 */
        super(max_cards);
        name = n;
    }
    

    
    // CardPlayer 클래스에서 상속받아 사용하는 abstract 메소드
    public boolean wantsACard() {
        String response = JOptionPane.showInputDialog("한장 더 드릴까요? (Y/N)");
        return response.equals("Y");
    }
    
    
    // TO DO youWin(), youWinBlackjack(), youLose(), youDraw(), chips()
    
    public void youWin() {
    	chips = chips + 1;
    	System.out.println("You Win!");
    }
    
    public void youWinBlackjack() {
    	chips = chips + 2;
    	System.out.println("You Win! Blackjack ~ !");
    }
    
    public void youLose() {
    	chips = chips - 1;
    	System.out.println("You Lose..");
    }
    
    public void youDraw() {
    	chips = chips;
    	System.out.println("Draw!!!");
    }
    
    // 유저 칩 갯수 리턴
    public int chips() {
    	return chips;
    }
    
}
