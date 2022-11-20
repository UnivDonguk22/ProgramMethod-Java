import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SelectHardButton extends JButton implements ActionListener {
	
	
	// 난이도 선택 GUI
	private SelectFrame frame;
	
	// 생성 메소드
	public SelectHardButton(SelectFrame f) {
		super("Hard");
		frame = f;
		
		
		// 버튼이 눌렸을 때 해당 메소드 재실행 - GUI 초기화
		/*
		 * this는 해당 클래스를 의미한다.
		 */
		addActionListener(this);
	}
	
	// ActionListener 를 처리하기 위한 메소드
	public void actionPerformed(ActionEvent e) {
		
		
		int hole_count = 54;
		String level = "Hard Mode";
		
		// 스도쿠 보드게 쉬움으로 GUI 동작
		new SudokuBoardFrame(new SudokuBoard(hole_count), level);

		
	}
	
	
	

}