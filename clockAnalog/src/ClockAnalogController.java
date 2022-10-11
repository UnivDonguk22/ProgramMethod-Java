

public class ClockAnalogController {
    
    /** delay - how_long millisecond 동안 실행 정지  */
    private void delay(int how_long) { 
        try { Thread.sleep(how_long); }
        catch (InterruptedException e) { }
    }
    
    public void switchOn(ClockAnalogViewOut clock) {
        while (true) { 
        	// delay를 20프레임을 준다.
        	// 1초에 20장번의 그림을 그린다.
            delay(20);
            clock.repaint();
        }
    }

}