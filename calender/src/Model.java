/*
 * 실습 1. 크리스마스까지 몇달 며 남았을까?
import java.time.*;

public class Model {

	public Period countdownXmas() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        LocalDate xmas = LocalDate.of(year,12,25);
        Period p = Period.between(today,xmas);
        return p;
	}

}
*/


// 실습 2. 몇월 며칠까지 몇달 며칠 남았는지 계산 기능 추
import java.time.*;

public class Model {
	
	// 실습 - 입력받은 날짜와 오늘 날짜의 차이구하기
	public Period countdown(LocalDate d) {
        LocalDate today = LocalDate.now();
        Period p = Period.between(today,d);
        return p;
	}
	
	// 과제 #1 - 오늘날짜로 부터 100뒤의 날짜구하기
	public LocalDate hundredDaysFromToday() {
		
		// Get now Date
		LocalDate today = LocalDate.now();
		LocalDate hundredDayPlusDay = today.plusDays(100);
		// Plus 100 Days with Now Date
		
		return hundredDayPlusDay;
	}
	
	// 과제 #2 - 입력받은 날짜로 부터 100뒤의 날짜 구하기
	public LocalDate hundredDaysFromInputDay(LocalDate d) {
		
		LocalDate hundredDayPlusInputDay = d.plusDays(100);
		
		return hundredDayPlusInputDay;
	}

}
