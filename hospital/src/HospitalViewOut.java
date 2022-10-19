import java.awt.*;
import javax.swing.*;

public class HospitalViewOut extends JPanel {
    
    private HospitalMainModel hospital;
    
    // 생성 메서드
    public HospitalViewOut(HospitalMainModel h) {
        hospital = h;
        JFrame f = new JFrame();
        f.getContentPane().add(this);
        f.setLocation(200,200);
        f.setTitle("ERICA 병원");
        f.setSize(400, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    
    
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 400, 400);
        g.setColor(Color.black);
        int y = 100;
        paintHeader(g, 100, y);
        HospitalPatientModel[] rooms = hospital.getRoomsInfo();
        for (int i = 0; i < rooms.length; i++) {
        	HospitalPatientModel p = rooms[i];
            if (p != null) {
                y += 30;
                paintRow(g, p, i, 100, y);
            }
        }
    }
    
    private void paintHeader(Graphics g, int x, int y) {
        g.drawString("병실", x, y);
        x += 50;
        g.drawString("환자", x, y);
        x += 50;
        g.drawString("체온", x, y);
        x += 50;
        g.drawString("혈압", x, y);
    }
    
    private void paintRow(Graphics g, HospitalPatientModel p, int r, int x, int y) {
        g.drawString(Integer.toString(r), x, y);
        x += 50;
        g.drawString(Integer.toString(p.getID()), x, y);
        x += 50;
        g.drawString(Double.toString(p.getTemp()), x, y);
        x += 50;
        String high = Integer.toString(p.getBPHigh());
        String low = Integer.toString(p.getBPLow());
        g.drawString(high+"/"+low, x, y);
    }
    
    /**
     * 병원 입원실의 입실 상황을 보여준다.
     */
    public void display() {
        this.repaint();
    }
    
    /**
     * 메시지 대화창에 전달할 메시지를 띄운다.
     * @param message - 전달할 메시지 
     */
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}