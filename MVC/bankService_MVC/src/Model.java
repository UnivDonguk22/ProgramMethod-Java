
public class Model {

	public int calculatorMoney(float [] calculatorInputData) {
		
		double investmentInputPersent = calculatorInputData[2] * 0.01;
		
		double calculatorMoney = calculatorInputData[0] * Math.pow(1 + investmentInputPersent , calculatorInputData[1]);
    	int calculatorMoneyInt = (int)calculatorMoney;
    	
    	return calculatorMoneyInt;
	}
	
}
