/** BounceBallController - 상자 안에서 움직이는 공 제어 */
public class BounceBallController {
    private BounceBallMoveBallModel ball;  // 공 객체 (Model)
    private BounceBallControllerViewOut writer; // 애니메이션 객체 (Output-View)
    private BounceBallMoveBallModel blueBall;

    /** Constructor BounceController 컨트롤러 초기화
     * @param b - 공 객체 (Model)
     * @param w - 애니메이션 객체 (Output-View)  */
    public BounceBallController(BounceBallMoveBallModel b, BounceBallMoveBallModel bb, BounceBallControllerViewOut w) {
        ball = b;
        blueBall = bb;
        writer = w;
    }

    
    
    
    /** runAnimation - 내부 시계를 활용하여 애니메이션 구동 */
    public void runAnimation() {
        int time_unit = 1;    // 애니메이션 스텝의 시간 단위
        int painting_delay = 20;  // 다시 그리기 사이의 지연 시간 간격
        while (true) {
            delay(painting_delay);
            
            // 공 객체 업데이트
            ball.move(time_unit);
            blueBall.move(time_unit);
            
            System.out.println(ball.xPosition() + ", " + ball.yPosition());
            writer.repaint();
        }
    }

    
    /** delay - how_long millisecond 동안 실행 정지  */
    private void delay(int how_long) {
        try { Thread.sleep(how_long); }
        catch (InterruptedException e) { }
    }
}