import java.awt.Color;
import java.awt.Graphics;
import java.time.LocalTime;

import javax.swing.*;


// View Class
/*
 *  JPanel 클래스 부모클래스로 상속받
 */
public class Clock_AnalogWriter extends JPanel {
	
	private final int SIZE;
	private final int MARGIN;
	private int diameter;
	
	
	
	// JFrame 
	public Clock_AnalogWriter(int n, int rate){
		SIZE = n;
		this.MARGIN = SIZE / rate;
		JFrame frame = new JFrame();
		frame.getContentPane().add(this);
        frame.setTitle("Clock");
        frame.setSize(SIZE + 50, SIZE + 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	
	
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawString("TIME IS GOOD", 105, 50);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(25, 100, SIZE, SIZE);
		
		// 현재 시간
		LocalTime time = LocalTime.now();
		int radius = SIZE / 2;
		int x1 = 25 + radius;
		int y1 = 100 + radius;
		int diff = radius / 5;
		
		// 동심원
		int base = (SIZE - this.diameter) / 2;
		g.setColor(Color.PINK);
		g.fillOval(25 + base, 100 + base, this.diameter, this.diameter);
		this.diameter = (this.diameter >= SIZE) ? 0 : this.diameter + this.MARGIN;
		
		// 분침 - 1파이에 30분이 속해있음.
		radius -= 30;
		// draw 메소드는 정수형만 허용한다
		double minute_angle =  (time.getMinute() - 15) * Math.PI / 30;
		int x2_minute = (int)(x1 + radius * Math.cos(minute_angle));
		int y2_minute = (int)(y1 + radius * Math.sin(minute_angle));
		System.out.println("Hello World !");
		// 구한 분침좌표를 애플리케이션에 그리기~
		g.setColor(Color.RED);
		g.drawLine(x1, y1, x2_minute, y2_minute);
		
		
		// 시침 - 1파이에 6시간이 속해있음.
		radius -= 30;
		// draw 메소드는 정수형만 허용한다
		double hour_angle =  (time.getHour() - 3) * Math.PI / 6;
		int x2_hour = (int)(x1 + radius * Math.cos(hour_angle));
		int y2_hour = (int)(y1 + radius * Math.sin(hour_angle));
		// 구한 시침좌표를 애플리케이션에 그리기~
		g.setColor(Color.yellow);
		g.drawLine(x1, y1, x2_hour, y2_hour);
		
	}
	
	//for test
	public static void main(String[] args) {
		new Clock_AnalogWriter(300,5);
	}
	
	
	
	
}
