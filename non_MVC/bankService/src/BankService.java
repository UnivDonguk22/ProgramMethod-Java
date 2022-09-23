import javax.swing.JOptionPane;

public class BankService {
    public static void main(String[] args) {
    	String originalMoney = JOptionPane.showInputDialog("투자 원금을 원 단위로 입력해주세요.");
    	String investmentPersent = JOptionPane.showInputDialog("월 수익률을 % 단위로 입력해주세요.");
    	String investmentTime = JOptionPane.showInputDialog("투자 기간을 월 단위로 입력해주세요.");
    	
    	// String to float type - exchange type
    	/*
    	  	Java에서 연산 시 타입이 다르면,  type mismatch 에러가 발생한다.
    	  	그렇기에, 타입을 float로 맞춰주고 연산을 하여
    	  	출력을 위한 int로 타입을 바꿔주었다.
    	*/
    	float originalMoneyFloat = Float.parseFloat(originalMoney);
    	float investmentTimeFloat = Float.parseFloat(investmentTime);
    	float investmentPersentFloat = Float.parseFloat(investmentPersent);
    	
    	double investmentPersentCalculationFloat = investmentPersentFloat * 0.01;
    	
    	// Calculation
    	double totalMoney = originalMoneyFloat * Math.pow(1 + investmentPersentCalculationFloat , investmentTimeFloat);
    	int totalMoneyInt = (int)totalMoney;
 
    	//ViewOut - Print with Dialog
    	int investmentTimeInt = Integer.parseInt(investmentTime);
    	
    	String message = investmentTimeInt + "개월 후 받으실 금액은 " + totalMoneyInt + "원 입니다.";
    	JOptionPane.showMessageDialog(null, message);
   }
}