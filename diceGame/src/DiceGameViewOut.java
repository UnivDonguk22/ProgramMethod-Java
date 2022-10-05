import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class DiceGameViewOut extends JPanel {
	
	int size;
	private DiceGamePlayerModel player1;
	private DiceGamePlayerModel player2;
	String printResult;
	
	/*
	 * ViewOut - Product Method
	 */
	public DiceGameViewOut(DiceGamePlayerModel p1,DiceGamePlayerModel p2) {
		
		JFrame f = new JFrame();
		size = 150;
		player1 = p1;
		player2 = p2;
		printResult = " ";
		
		f.getContentPane().add(this);
		f.setTitle("주사위 게임");
		f.setLocation(300, 0);
		f.setSize(300, 300);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	/*
	 *	보드판 그리기 - JPanel
	 */
	
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 300, 222);
		
		// Draw the Players name
		g.setColor(Color.BLACK);
		g.drawString(player1.name(), 75, 75);
		g.drawString(player2.name(), 225, 75);
		
		// Draw the Players DiceGame Score
		g.drawString(Integer.toString(player1.points()), 75, 100);
		g.drawString(Integer.toString(player2.points()), 225, 100);
		
		//비겼다, 이겼다 표시
		g.drawString(printResult, size, 150);
		
		//Play별 주사위 던진 결과 출력
		g.drawString(Integer.toString(player1.rolled().face1()), 75, 170);
		g.drawString(Integer.toString(player1.rolled().face2()), 85, 170);
		
		g.drawString(Integer.toString(player2.rolled().face1()), 225, 170);
		g.drawString(Integer.toString(player2.rolled().face2()), 235, 170);
		
	}
	

	
	public void showWinP1Result(int s, String r) {
		size = 150 - s;
		printResult = r;
		this.repaint();
	}
	
	public void showWinP2Result(int s, String r) {
		size = 150 + s;
		printResult = r;
		this.repaint();
	}
	
	public void showDrawResult(String drawString) {
		printResult = drawString;
		size = 150;
		this.repaint();
	}
	
	
	

}
