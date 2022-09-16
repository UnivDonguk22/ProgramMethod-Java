
public class Controller {

	// Model, View 클래스를 선언했기에 객체로써 활용
	public void control(Model m, View v) {
		String message = m.createMessage();
		v.show(message);
		v.showWindow(message);
	}

}