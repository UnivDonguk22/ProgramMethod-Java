
public class Controller {
	
	public void controlCalculatorProgram (Model m, ViewIn i, ViewOut o) {
		
		// Get calculatorInputData
		float [] calculatorInputData = i.inputCalculatorData();
		
		// Calculator Money with calculatorInputData
		int calculatorMoney = m.calculatorMoney(calculatorInputData);
		
		// Show Result by compound Interest Program
		o.showCalculator(calculatorInputData, calculatorMoney);
	}

}
