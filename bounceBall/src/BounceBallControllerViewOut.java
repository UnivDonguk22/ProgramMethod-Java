import java.awt.*;
import javax.swing.*;

/** AnimationWriter - 상자와 공의 애니메이션 디스플레이 */
public class BounceBallControllerViewOut extends JPanel {
    private BounceBallBoxViewOut box_writer;    // 상자 그리는 객체
    private BounceBallBallViewOut ball_writer;  // 공 그리는 객체
    private BounceBallBallViewOut blueBall_writer; // 파란색 공 그리는 객체

    /** Constructor AnimationWriter - 상자와 공을 그리는 View 객체를 생성
     * @param b - 상자 그리는 객체
     * @param l - 공 그리는 객체
     * @param size - 프레임의 크기 */
    public BounceBallControllerViewOut(BounceBallBoxViewOut b, BounceBallBallViewOut l, BounceBallBallViewOut lb , int size) {
        box_writer = b;
        ball_writer = l;
        blueBall_writer = lb;
        JFrame f = new JFrame();
        f.getContentPane().add(this);
        f.setTitle("Bounce");
        f.setSize(size, size+22);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /** paintComponent - 공과 상자 그리기
     * @param g - 그래픽스 펜 */
    public void paintComponent(Graphics g) {
        box_writer.paintComponent(g);
        ball_writer.paintComponent(g);
        blueBall_writer.paintComponent(g);
    }
}