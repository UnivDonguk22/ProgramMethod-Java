import javax.swing.JOptionPane;

public class ViewOut {

	public void showCalculator (float [] calculatorInputData, int calculatorMoney) {
		
		int inputDate = (int) calculatorInputData[1];
		
    	String message = inputDate + "개월 후 받으실 금액은 " + calculatorMoney + "원 입니다.";
    	JOptionPane.showMessageDialog(null, message);
	}

}
