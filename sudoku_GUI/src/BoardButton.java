import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BoardButton extends JButton implements ActionListener{
	
	private SudokuBoard board;
	private SudokuBoardFrame frame;
	
	private int board_row;
	private int board_col;
	
	
	// 생성 메소드
	public BoardButton(SudokuBoard b, SudokuBoardFrame f, int row, int col) {
		board = b;
		frame = f;
		
		board_row = row;
		board_col = col;
		
		addActionListener(this);
	}
	
	
	// 스도쿠 버튼 클릭 시 ActionListener 처리
	public void actionPerformed(ActionEvent e) {
		
		// 스도쿠 보드판의 버튼이 클릭 됨
		if(board.on()) {
			frame.first = 1;
			frame.board_row = board_row;
			frame.board_col = board_col;
			
			System.out.println("여길 거쳐가니??");
		}
		else {
			System.out.println("겜 종료 수고하셨습니다 ㅎㅎㅎㅎㅎ!!!");
		}
		

		if(board.countHoles() == 0) {
			board.gameOver();
		}
		
		
		
		// BoardAnswerButton 이벤트 작용 후의 업데이트
//		if(board.on()) {
//			frame.update();
//		}
	
		
	}

}
