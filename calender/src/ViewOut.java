import java.time.*;

public class ViewOut {

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

}
