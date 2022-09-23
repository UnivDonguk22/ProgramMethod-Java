

/*
public class Geometry {
    public static void main(String[] args) {
        int radius;
        int area;
        radius = 7;
        area = (int)(Math.PI * Math.pow(radius,2));
        System.out.println(area);
    }
}
*/



import java.text.*;
import javax.swing.*;

public class Geometry {
    public static void main(String[] args) {
        String message = "반지름을 주시면 원의 면적을 계산해드립니다.";
        String input = JOptionPane.showInputDialog(message);
        int radius = Integer.parseInt(input);
        double area = Math.PI * Math.pow(radius,2);
        DecimalFormat f = new DecimalFormat("0.00");
        System.out.print("반지름이 " + radius + "인 원의 면적은 ");
        System.out.println(f.format(area) + " 입니다.");
    }
}