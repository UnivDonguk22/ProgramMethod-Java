
import javax.swing.*;

public class ViewIn {

	public int getNumber(String message) {
		String input = JOptionPane.showInputDialog(message);
		return Integer.parseInt(input);
	}

}