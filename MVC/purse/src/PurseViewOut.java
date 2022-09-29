import javax.swing.*;
import java.awt.*;

public class PurseViewOut extends JPanel {
	private PurseModel purse;
	String last_transaction;

	/*
	 * 지갑 애플리케이션 UI 출력
	 */
	public PurseViewOut(String title, int x, int y, PurseModel p) {

		purse = p;
		JFrame f = new JFrame();

		f.getContentPane().add(this);
		f.setTitle(title);
		f.setLocation(x, y);
		f.setSize(300, 200);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}
	
	/*
	 * 지갑 그리기 - JPanel
	 */
	protected void paintComponent(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 300, 222);
		g.setColor(Color.BLACK);
		g.drawString(last_transaction, 50, 50);
		g.drawString("잔액 = " + purse.getBalance(), 50, 70);

	}

	
	/*
	 * ??
	 */
	public void showTransaction(int amount, String message) {

		last_transaction = amount + " " + message;
		this.repaint();

	}

	/*
	 * ??
	 */
	public void showTransaction(String message) {

		last_transaction = message;
		this.repaint();

	}
}