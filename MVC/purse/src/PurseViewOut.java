import javax.swing.*;
import java.awt.*;

/*
 *  해당 클래스는 클래스를 JPanel을 상속받았다.
 *  extends 명령으로 부모 클래스를 상속받음.
 */
public class PurseViewOut extends JPanel {
	
	private PurseModel purse;
	String last_transaction;

	/*
	 * 지갑 애플리케이션 UI 출력
	 */
	public PurseViewOut(String title, int x, int y, PurseModel p) {

		purse = p;
		JFrame f = new JFrame();
		
		/*
		 * 	프로그램 첫 실행을 위해 last_transcation 필드변수 초기화 ㅎ
		 */
		last_transaction = "비활성";

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
	 * 지갑 기능 정상 작동 시 출력
	 */
	public void showTransaction(int amount, String message) {

		last_transaction = amount + " " + message;
		this.repaint();

	}

	/*
	 * 지갑 기능 예외 작동 시 출력
	 */
	public void showTransaction(String message) {

		last_transaction = message;
		this.repaint();

	}
}