import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;


// View Class
/*
 *  JPanel 클래스 부모클래스로 상속받
 */
public class Clock_AnalogWriter extends JPanel {

	
	
	// JFrame 
	public Clock_AnalogWriter(){
		JFrame frame = new JFrame();
		frame.getContentPane().add(this);
        frame.setTitle("Clock");
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawString("TIME IS GOOD", 105, 50);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(25, 100, 250, 250);
		
		g.setColor(Color.red);
		g.drawLine(150, 225, 150, 100);
		
		int x1 = 150;
		int y1 = 225;
		int x2 = x1 + (int)(125 * Math.cos(Math.PI / 6));
		int y2 = y1 + (int)(125 * Math.sin(Math.PI / 6));
		g.drawLine(x1, y1, x2, y2);
	}
	
	//for test
	public static void main(String[] args) {
		new Clock_AnalogWriter();
	}
	
	
	
	
}
