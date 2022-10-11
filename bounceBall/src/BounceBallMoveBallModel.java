/** MovingBall - 2차원 상자에서 움직이는 공 */
public class BounceBallMoveBallModel {
    private int x_pos; // 공의 중심 x 좌표
    private int y_pos; // 공의 중심 y 좌표
    private int radius; // 공의 반지름

    private int x_velocity = +5; // 속도 x축
    private int y_velocity = +2; // 속도 y축

    private BounceBallBoxModel container;

    /** Contructor Method - 공 만들기
     * @param x_initial - 공의 중심 x 좌표
     * @param y_initial - 공의 중심 y 좌표
     * @param r - 공의 반지름
     * @param box - 공이 살고 있는 상자 */
    public BounceBallMoveBallModel(int x_initial, int y_initial, int r, BounceBallBoxModel box) {
        x_pos = x_initial;
        x_pos = y_initial;
        radius = r;
        container = box;
    }

    
    /** xPosition - 공의 x축 위치 리턴 */
    public int xPosition() {
        return x_pos;
    }

    /** yPosition - 공의 y축 위치 리턴 */
    public int yPosition() {
        return y_pos;
    }

    /** radiusOf - 공의 반지름 리턴 */
    public int radiusOf() {
        return radius;
    }

    /** move - time_unit 만큼 공을 이동, 벽에 부딪치면 방향을 바꿈
     * @param time_units - 프레임 사이의 시간 */
    public void move(int time_units) {
        x_pos = x_pos + x_velocity * time_units;
        if (container.inHorizontalContact(x_pos))
            x_velocity = - x_velocity;
        y_pos = y_pos + y_velocity * time_units;
        if (container.inVerticalContact(y_pos))
            y_velocity = - y_velocity;
    }
}