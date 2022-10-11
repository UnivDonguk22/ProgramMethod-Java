import java.awt.Color;
import java.awt.Graphics;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.time.format.DateTimeFormatter;


// JPanel 클래스 상속받아서 사용
public class ClockAnalogViewOut extends JPanel{
	
	private final int SIZE;
	private int diameter;
	
	
	// 생성 메소드
	public ClockAnalogViewOut(int n) {
		
		SIZE = n;
		// this.MARGIN = SIZE / rate;
		JFrame frame = new JFrame();
		frame.getContentPane().add(this);
        frame.setTitle("Clock");
        frame.setSize(SIZE + 50, SIZE + 100);
        frame.setVisible(true);
        
        
        // Java Application exit Option
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	// 시계판, 시침, 분침, 동심원 그리기
	public void paintComponent(Graphics g) {
		// 현재 시간
		LocalTime time = LocalTime.now();
		
   	 	//출력 형식을 정한다.
    	DateTimeFormatter ClockTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
    	String ClockTime = time.format(ClockTimeFormat);
    	


		g.setColor(Color.BLUE);
		g.drawString(ClockTime, 105, 50);
		
		// 시계판 그리기
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(25, 100, SIZE, SIZE);
		

		
		
		int radius = SIZE / 2;
		int x1 = 25 + radius;
		int y1 = 100 + radius;
		int diff = radius / 5;
		
		
		// 동심원
		// 시간에 따른 동심원 반지름 구함.
		this.diameter = (this.diameter >= SIZE) ? 0 : ((SIZE * time.getSecond())/60);
		int base = (SIZE - this.diameter) / 2;
		g.setColor(Color.PINK);
		g.fillOval(25 + base, 100 + base, this.diameter, this.diameter);
		// Java의 연산결과는 데이터타입이 큰 거대로 맞춰지기에, 아래는 정수로써 0으로 나누어 떨어진다. (정수 / 정수)
		// System.out.println(time.getSecond()/60);
		
		
		/*
		 *  분침 그리기
		 */
		// 분침 - 1파이에 30분이 속해있음.
		radius -= 30;
		// draw 메소드는 정수형만 허용한다
		double minute_angle =  (time.getMinute() - 15) * Math.PI / 30;
		int x2_minute = (int)(x1 + radius * Math.cos(minute_angle));
		int y2_minute = (int)(y1 + radius * Math.sin(minute_angle));
		
		// 구한 분침좌표를 애플리케이션에 그리기~
		g.setColor(Color.RED);
		g.drawLine(x1, y1, x2_minute, y2_minute);
		
		
		/*
		 * 시침 그리기
		 */
		// 시침 - 1파이에 6시간이 속해있음.
		radius -= 30;
		// draw 메소드는 정수형만 허용한다
		double hour_angle =  (time.getHour() - 3) * Math.PI / 6;
		int x2_hour = (int)(x1 + radius * Math.cos(hour_angle));
		int y2_hour = (int)(y1 + radius * Math.sin(hour_angle));
		
		// 구한 시침좌표를 애플리케이션에 그리기~
		g.setColor(Color.yellow);
		g.drawLine(x1, y1, x2_hour, y2_hour);
		
		
		
		/*
		 * 시계 눈금 그리기
		 * 		시간 눈금 그리기
		 * 		분 눈금 그리기
		 */
		
		// 시간 눈금 그리기
		radius += 40;
		int h;
		for (h = 24 ; h > 0 ; h-- ) {
		double hour_angle_draw = (h - 3) * Math.PI /6;
		int x1_drawHour = (int)(x1 + radius * Math.cos(hour_angle_draw));
		int y1_drawHour = (int)(y1 + radius * Math.sin(hour_angle_draw));
		
		int x2_drawHour = (int)(x1 + (SIZE / 2) * Math.cos(hour_angle_draw));
		int y2_drawHour = (int)(y1 + (SIZE / 2) * Math.sin(hour_angle_draw));
		
		g.setColor(Color.black);
		g.drawLine(x1_drawHour, y1_drawHour, x2_drawHour, y2_drawHour);
		}
		
		// 분 눈금 그리기
		radius += 10;
		int m;
		for (m = 60 ; m > 0 ; m--) {
			double minute_angle_draw =  (m - 15) * Math.PI / 30;
			int x1_drawMinute = (int)(x1 + radius * Math.cos(minute_angle_draw));
			int y1_drawMinute = (int)(y1 + radius * Math.sin(minute_angle_draw));
			
			int x2_drawMinute = (int)(x1 + (SIZE / 2) * Math.cos(minute_angle_draw));
			int y2_drawMinute = (int)(y1 + (SIZE / 2) * Math.sin(minute_angle_draw));
			
			if (m%5 != 0) {
			g.setColor(Color.blue);
			g.drawLine(x1_drawMinute, y1_drawMinute, x2_drawMinute, y2_drawMinute);
			}
		}
		
		
		
	}
	
	
	
	
	

}
