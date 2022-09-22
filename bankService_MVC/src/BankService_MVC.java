
public class BankService_MVC {
	public static void main(String[] args) {
		Model m = new Model();
		ViewOut o  = new ViewOut();
		ViewIn i = new ViewIn();
		new Controller().controlCalculatorProgram(m,i,o);
	} 
}