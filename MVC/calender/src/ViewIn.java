import javax.swing.JOptionPane;
import java.time.*;

public class ViewIn {

	// 실습 - 입력받은 날짜와 오늘 날짜의 차이구하기
	public LocalDate getDate(String message) {
		String getYear = JOptionPane.showInputDialog(message);
		String getMonth = JOptionPane.showInputDialog(message);
		String getDay = JOptionPane.showInputDialog(message);
		LocalDate getDate = LocalDate.of(Integer.parseInt(getYear),Integer.parseInt(getMonth),Integer.parseInt(getDay));
		
		return getDate;
	}
	
	// 과제 - 입력받은 날짜로부터 100뒤의 날짜구하기
	public LocalDate getInputDate() {
		String getYear = JOptionPane.showInputDialog("년도를 입력하세요");
		String getMonth = JOptionPane.showInputDialog("월을 입력하세요");
		String getDay = JOptionPane.showInputDialog("일을 입력하세요");
		LocalDate getInputDate = LocalDate.of(Integer.parseInt(getYear),Integer.parseInt(getMonth),Integer.parseInt(getDay));
		
		return getInputDate;
	}

}
