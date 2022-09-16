import java.time.*;

public class Controller {

	/*
	public void control(Model m, ViewOut o) {
		Period checkXmas = m.countdownXmas();
		o.showCountdownXmas(checkXmas);
	}
	*/
	
	public void controlGetDate(Model m, ViewOut o, ViewIn i) {
		String message = "현재날짜와의 차이를 비교할 날짜를 입력하세요";
		LocalDate getDate = i.getDate(message);
		Period checkDate = m.countdown(getDate);
		o.showCountdownXmas(getDate,checkDate);
	}
}
