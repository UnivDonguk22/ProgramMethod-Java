 import java.time.*;
import javax.swing.JOptionPane;


public class ViewOut {
	
	// 실습 - 오늘부터 지정한 날짜까지 남은 날짜 출력
	public void showCountdownXmas(LocalDate getDate, Period p) {
		int year = p.getYears();
        int months = p.getMonths();
        int days = p.getDays();
        
        int getYear = getDate.getYear();
        int getMonths = getDate.getMonthValue();
        int getDays = getDate.getDayOfMonth();
        
        String message = getYear + "년 " + getMonths + "월 " + getDays + "일까지 "
        + year + "년 " + months + "달 " + days + "일 남았다.";
        
        System.out.println(message);

	}
	
	// 과제 #1 - 오늘 날짜로부터 100일뒤의 날짜 출력
	public void showDate(LocalDate d, String message) {
		
		int getYear = d.getYear();
		int getMonth = d.getMonthValue();
		int getDay = d.getDayOfMonth();
		
		String showMessage = message + getYear + "년 " + getMonth + "월 " + getDay + "일입니다.";
		JOptionPane.showMessageDialog(null, showMessage);
	}
	
	// 과제 #2 - 입력받은 날짜로부터 100뒤의 날짜 출력
	public void showInputDate(LocalDate inputDate, LocalDate hundredPlusDate, String message) {
		int getYear = inputDate.getYear();
		int getMonth = inputDate.getMonthValue();
		int getDay = inputDate.getDayOfMonth();
		
		int getPlusYear = hundredPlusDate.getYear();
		int getPlusMonth = hundredPlusDate.getMonthValue();
		int getPlusDay = hundredPlusDate.getDayOfMonth();
		
		String showMessage = getYear + "년 " + getMonth + "월 " + getDay + "일" + message
				+ getPlusYear + "년 " + getPlusMonth + "월 " + getPlusDay + "일입니다.";
		JOptionPane.showMessageDialog(null, showMessage);
	}

}
