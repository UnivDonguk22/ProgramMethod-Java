package slidePuzzle_GUI;

// Action에 따른 event 처리하는 모듈 모아둠.
import java.awt.event.*;

import javax.swing.JButton;

/*
 * 안드로이드의 Button Activity 클래스와 같음.
 * XML과 Activity를 하나의 클래스에서 처리
 */
// PuzzleButton 클래스는 Puzzle의 클릭 이벤트를 통제하는 클래스로, 해당 프로젝트에선 Controller를 담당한다.
public class PuzzleButton extends JButton implements ActionListener{
	
	
	private SlidePuzzleBoard board;
	private PuzzleFrame frame;
	
	// 생성 메소드
	public PuzzleButton(SlidePuzzleBoard b, PuzzleFrame f) {
		board = b;
		frame = f;
		
		
		// 버튼이 눌렸을 때 해당 메소드 재실행 - GUI 초기화
		/*
		 * this는 해당 클래스를 의미한다.
		 */
		addActionListener(this);
	}
	
	// ActionListener 를 처리하기 위한 메소드
	public void actionPerformed(ActionEvent e) {
		
		// 게임이 진행 중일 때만, GUI 버튼 구동
		if(board.on()) {
			

		
			// 버튼이 눌려진 퍼즐 조각의 번호를 가져옴.
			String click_ButtonPiece = getText();
		
		
			/*
			 * Button 클릭 이벤트 예외처리
			 * 1. 클릭한 Button이 빈칸이 아니다.
			 * 2. 클릭한 Button이 움직일 수 있다.
			 */
			if(click_ButtonPiece != "" && board.move(Integer.parseInt(click_ButtonPiece))) {
				frame.update();
				if(board.gameOver()) {
					frame.finish();
				}
			}
		}
		
	}
	
	

}
