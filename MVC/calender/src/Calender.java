
public class Calender {
	public static void main(String[] args) {
		
		// Static Method가 아니기에, 객체를 생성해줘야한다.
		Model m = new Model();
		ViewOut o  = new ViewOut();
		ViewIn i = new ViewIn();
		new Controller().controlGetInputPlusHundredDate(m,i,o);
	}
}