import javax.swing.JOptionPane;
import java.time.*;

public class ViewIn {

	public LocalDate getDate(String message) {
		String getYear = JOptionPane.showInputDialog(message);
		String getMonth = JOptionPane.showInputDialog(message);
		String getDay = JOptionPane.showInputDialog(message);
		LocalDate getDate = LocalDate.of(Integer.parseInt(getYear),Integer.parseInt(getMonth),Integer.parseInt(getDay));
		return getDate;
	}

}
