import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class SelectFrame extends JFrame {
	
	
	
	// SelectFrame 생성 메소드
	public SelectFrame() {
		
		// SelectFrame의 Container 지정 | 최상단 Layout 지정
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		
		
		JPanel p1 = new JPanel(new FlowLayout());
		p1.add(new SelectEasyButton(this));
		p1.add(new SelectMidiumButton(this));
		p1.add(new SelectHardButton(this));
		
		// 자식 Layout 추가
		cp.add(p1);
		
		
        setTitle("Slide Puzzle");
        setSize(250,80);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
	}
	
	// SelectFrame 제거 메소드
	public void deleteFrame() {
		setVisible(false);
	}
	
	
}