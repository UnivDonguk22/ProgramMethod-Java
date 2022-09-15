public class HelloWorld {

	public static void main(String[] args) {
		Model model = new Model();
		View view = new View();
		new Controller().control(model, view);
	}

}