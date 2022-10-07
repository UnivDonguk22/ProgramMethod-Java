import java.awt.*;

/** BounceBall - 애니메이션 객체를 생성하고 공 운동 시작 */
public class BounceBall {
	
	// 상자 속 공굴리기 애니메이션의 main 클래스
    public static void main(String[] args) {
        // 모델 객체 생성
        int box_size = 200;
        int balls_radius = 6;
        BounceBallBoxModel box = new BounceBallBoxModel(box_size);
        
        // 공을 상자의 적절한 위치에 둠 - 공의 초기위치 설정
        BounceBallMoveBallModel ball = new BounceBallMoveBallModel((int)(box_size / 3.0),
                                         (int)(box_size / 5.0),
                                         balls_radius, box);
        BounceBallMoveBallModel blueBall = new BounceBallMoveBallModel(80,
                							150,
                							balls_radius, box);
        
        
        BounceBallBallViewOut ball_writer = new BounceBallBallViewOut(ball, Color.red);
        BounceBallBallViewOut blueBall_writer = new BounceBallBallViewOut(blueBall, Color.blue);
        
        
        BounceBallBoxViewOut box_writer  = new BounceBallBoxViewOut(box);
        BounceBallControllerViewOut writer = new BounceBallControllerViewOut(box_writer, ball_writer, blueBall_writer, box_size);
        
        // 컨트롤러 객체를 생성하고 애니메이션 시작
        new BounceBallController(ball,blueBall, writer).runAnimation();
    }
}