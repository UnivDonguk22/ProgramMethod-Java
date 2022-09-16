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

	public Period countdown(LocalDate d) {
        LocalDate today = LocalDate.now();
        Period p = Period.between(today,d);
        return p;
	}

}
