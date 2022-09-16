
public class Clock {

	public static void main(String[] args) {
		Model model = new Model();
		View view = new View();
		new Controller().control(model, view);

	}

}