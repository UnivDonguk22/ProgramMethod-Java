public class ClockAnalog {
    
    public static void main(String[] args) {
    	
        // Controller에 필요한 객체에 대해 값을 "통제"함.
    	ClockAnalogViewOut clock = new ClockAnalogViewOut(240);
        
    	
        new ClockAnalogController().switchOn(clock);
    }

}