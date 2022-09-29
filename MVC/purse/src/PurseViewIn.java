
import javax.swing.*;
public class PurseViewIn {
	
	
	/*
	 * Input "+" or "-"
	 */
	public char readRequest(String message) {
		String input = JOptionPane.showInputDialog(message);
		return input.charAt(0);
	}
	
	/*
	 * Input Amount
	 */
	public int readAmount(String message) {
		String input = JOptionPane.showInputDialog(message);
		input = input.trim();
	
		if (input.length() > 0)
			return Integer.parseInt(input);
		else {
			JOptionPane.showMessageDialog(null, "금액 입력 오류");
			return 0;
	
		}
	
	}
	
}

