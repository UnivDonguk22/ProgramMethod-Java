import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BoardAnswerButton extends JButton implements ActionListener {
	
	private SudokuBoard board;
	private SudokuBoardFrame frame;
	
	private int piece_answers;
	
	
	// 생성 메소드
	public BoardAnswerButton(SudokuBoard b, SudokuBoardFrame f, int answers) {
		super(Integer.toString(answers));
		board = b;
		frame = f;
		piece_answers = answers;
		
		addActionListener(this);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		// 스도쿠 보드판 조각 클릭 이벤트 시 동작
		if(board.on()) {
			if(frame.first == 1) {
				System.out.println("정답 버튼인, 여길 거쳐가니??");
				if(board.check(piece_answers, frame.board_row, frame.board_col)) {
					frame.update();
					frame.answer_update();
					frame.first = 0;
				}
			}
		}
		
		

	}

	
}
