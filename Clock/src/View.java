
import java.time.*;
import javax.swing.*;

public class View {

	public void show(LocalTime t) {
		System.out.println(t);
	}

	public void showSwing(LocalTime t) {
		JOptionPane.showMessageDialog(null, t);
	}

}