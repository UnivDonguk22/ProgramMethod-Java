
public class Calender {
	public static void main(String[] args) {
		Model m = new Model();
		ViewOut o  = new ViewOut();
		ViewIn i = new ViewIn();
		new Controller().controlGetDate(m,o,i);
	}
}
