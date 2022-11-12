import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


// JFrame 클래스를 상속받음.
public class CounterFrame extends JFrame implements ActionListener {
	
	// 필드변수 ConuterModel 객체 타입으로 선언
	private CounterModel counter;
	
	// Jlabel 타입으로 label 필드변수 생성
	// 이는, Java GUI의 label 텍스트 데이터
	private JLabel label = new JLabel("count = 0");
	
	
	// CountFrame 생성메소드
	public CounterFrame( CounterModel c ) {
		counter = c;
		
		// ActionListener 클래스 메소드
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		
		cp.add(label);
		JButton button = new JButton("OK");
		cp.add(button);
		
		button.addActionListener(this);
		
		setTitle("Counter");
		setSize(200,70);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		
	}
	
	public void actionPerforemd(ActionEvent e) {
		counter.increment();
		label.setText("count = " + counter.count());

	}

}



