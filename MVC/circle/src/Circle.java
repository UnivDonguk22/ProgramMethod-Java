public class Circle{

	public static void main(String[] args) {
		Model model = new Model();
		ViewIn input = new ViewIn();
		ViewOut output = new ViewOut();
		// 클래스를 객체로 만들어 메모리에 할당함.
		new Controller().control(model, input, output);
	}

}