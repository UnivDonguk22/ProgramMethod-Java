import java.text.*;
import javax.swing.*;

public class ViewOut {

	public void show(int radius, double area) {
		DecimalFormat formatter = new DecimalFormat("0.00");
		System.out.print("반지름이 " + radius + "인 원의 면적은 ");
		System.out.println(formatter.format(area) + " 입니다.");
	}

}