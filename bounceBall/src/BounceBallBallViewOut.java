
import java.awt.*;

/** BounceBallBallViewOut - 움직이는 공을 그림 */
public class BounceBallBallViewOut {

    private BounceBallMoveBallModel ball;   // 공 객체
    private Color balls_color; // 공의 색깔

    /** Constructor BallWriter
     * @param x - 공 객체
     * @param c - 공의 색깔 */
    public BounceBallBallViewOut(BounceBallMoveBallModel x, Color c) {
        ball = x;
        balls_color = c;

    }

    /** paint - 공 그리기
     * @param g - 그래픽스 펜  */
    public void paintComponent(Graphics g) {
        g.setColor(balls_color);
        int radius = ball.radiusOf();
        g.fillOval(ball.xPosition() - radius, ball.yPosition() - radius,
                   radius * 2, radius * 2);
    }
    
}