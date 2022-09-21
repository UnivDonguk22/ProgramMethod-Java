import java.time.*;


public class Controller {

	/*
	public void control(Model m, ViewOut o) {
		Period checkXmas = m.countdownXmas();
		o.showCountdownXmas(checkXmas);
	}
	*/
	
	// 실습 - 현재날짜와 오늘 날짜와의 차이구하기
	public void controlGetDate(Model m, ViewOut o, ViewIn i) {
		String message = "현재날짜와의 차이를 비교할 날짜를 입력하세요";
		LocalDate getDate = i.getDate(message);
		Period checkDate = m.countdown(getDate);
		o.showCountdownXmas(getDate,checkDate);
	}
	
	// 과제 #1 - 오늘 날짜로부터 100일 뒤의 날짜구하기
	public void controlGetPlusHundredDate(Model m, ViewOut o) {
		String message = "오늘부터 100일 뒤는 며칠?\n";
		
		// 100일 뒤의 날짜
		LocalDate d = m.hundredDaysFromToday();
		
		// 100일 뒤의 날짜 출력
		o.showDate(d, message);
	}
	
	// 과제 #2 - 입력받은 날짜로부터 100일 뒤의 날짜구하기
	public void controlGetInputPlusHundredDate(Model m, ViewIn i, ViewOut o) {
		String message = "부터 100일 뒤는 며칠?\n";
		
		LocalDate inputDate = i.getInputDate();
		LocalDate inputDatePlusHundredDate = m.hundredDaysFromInputDay(inputDate);
		
		o.showInputDate(inputDate, inputDatePlusHundredDate, message);
	}
	
	
}
