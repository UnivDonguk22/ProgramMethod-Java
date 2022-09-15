
import java.time.LocalTime;

public class Controller {

	public void control(Model m, View v) {
		LocalTime t = m.whatTimeIsIt();
		v.show(t);
		v.showSwing(t);
	}

}