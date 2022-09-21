import javax.swing.JOptionPane;

public class ViewIn {
	
	public float [] inputCalculatorData() {
		// input calculatorData with String
    	String inputMoney = JOptionPane.showInputDialog("투자 원금을 원 단위로 입력해주세요.");
    	String inputDate = JOptionPane.showInputDialog("투자 기간을 월 단위로 입력해주세요.");
    	String inputPersent = JOptionPane.showInputDialog("월 수익률을 % 단위로 입력해주세요.");
		
    	// String to float type - exchange type
    	/*
    	  	Java에서 연산 시 타입이 다르면,  type mismatch 에러가 발생한다.
    	  	그렇기에, 타입을 float로 맞춰주고 연산을 하여
    	  	출력을 위한 int로 타입을 바꿔주었다.
    	*/
    	float inputMoneyFloat = Float.parseFloat(inputMoney);
    	float inputDateFloat = Float.parseFloat(inputDate);
    	float inputPersentFloat = Float.parseFloat(inputPersent);
    	
    	// 배열 선언
    	float calculatorInputData[] = new float[3];
    	
    	calculatorInputData[0] = inputMoneyFloat;
    	calculatorInputData[1] = inputDateFloat;
    	calculatorInputData[2] = inputPersentFloat;
    	
    	return calculatorInputData;
	}
	
}
