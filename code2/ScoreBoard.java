import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ScoreBoard extends JFrame {

    private JLabel set_score_guest;
    private JLabel set_score_home;
    private PointButton point_guest;
    private PointButton point_home;
    
    public String guest_name;
    public String home_name;
    
    private	JLabel set_guestName;
    private JLabel set_homeName;
    
    private WriterFile reader;
    
    
//    private int total_score_guest = 0;
//    private int total_score_home = 0;

    public ScoreBoard() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(4,1));
        
        // 게스트 : 홈 타이틀 헤더 텍스트
        JPanel p1 = new JPanel(new FlowLayout());
        
        
        guest_name = JOptionPane.showInputDialog("Enter your name.");
        home_name = JOptionPane.showInputDialog("Enter your name.");
        
        
        
        
        set_guestName  = new JLabel(guest_name);
        p1.add(set_guestName);
        
        p1.add(new JLabel(":"));
        
        set_homeName  = new JLabel(home_name);
        p1.add(set_homeName);
        
        cp.add(p1);
        
        // 게스트 & 홈 라운드 승리 스코어
        JPanel p2 = new JPanel(new FlowLayout());
        set_score_guest = new JLabel("0");
        p2.add(set_score_guest);
        p2.add(new JLabel(":"));
        set_score_home = new JLabel("0");
        p2.add(set_score_home);
        cp.add(p2);
        
        // 게스트 & 홈 게임 진행 스코어 버튼
        JPanel p3 = new JPanel(new FlowLayout());
        point_guest = new PointButton(this);
        p3.add(point_guest);
        point_home = new PointButton(this);
        p3.add(point_home);
        cp.add(p3);
        
        // New & Exit 버튼
        JPanel p4 = new JPanel(new FlowLayout());
        p4.add(new NewButton(this));
        // 해당 사항은 내 컴퓨터에서만 에러가 발생.
        p4.add(new ExitButton());
        
        reader = new WriterFile("result.csv");
        cp.add(p4);
        begin();
        setTitle("Badminton");
        setSize(200,160);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    
    /* begin - 새 경기를 기록할 수 있도록 점수 버튼을 모두 0으로 세팅하고,  
     *         세트 스코어도 0 : 0 으로 세팅한다.
     */
    
    // New 버튼 클릭 이벤트 시 호출 메소드
    public void begin() {
        if (matchOver()) {
            set_score_guest.setText("0");
            set_score_home.setText("0");
            point_guest.setText("0");
            point_home.setText("0");
        }
    }

    /* matchOver - 경기가 끝났는지 판정해준다. 둘 중 하나가 2세트를 먼저 따면 승패가 결정되어 경기가 끝난다.
     * @returns true - 경기가 끝났음, false - 경기가 끝나지 않았음
     */
    
    // 토탈 경기가 끝났는지 알려주는 메소드
    public boolean matchOver() {
        int guest = Integer.parseInt(set_score_guest.getText());
        int home = Integer.parseInt(set_score_home.getText());
        return guest == 2 || home == 2;
    }
    
    /* update - 스코어보드를 갱신한다.
     */
    
    // 동작에따라 frame 판을 업데이트 해주는 메소드
    public void update() {
        int guest = Integer.parseInt(point_guest.getText());
        int home = Integer.parseInt(point_home.getText());
        

        
        // 둘 다 10이 되는 상황 - 듀스로 라운드 판별
        if(guest >= 10 && home >= 10) {
        	if(guest - home == 2) {
            	int point = Integer.parseInt((set_score_guest.getText()));
            	set_score_guest.setText(Integer.toString(point+1));
            	point_guest.setText("0");
            	point_home.setText("0");
        	}
        	else if (home - guest == 2) {
            	int point = Integer.parseInt((set_score_guest.getText()));
            	set_score_guest.setText(Integer.toString(point+1));
            	point_guest.setText("0");
            	point_home.setText("0");
        	}
        }
        
        // 듀스가 아닌 채 라운드 판별
        else if (guest == 11) {
        	int point = Integer.parseInt((set_score_guest.getText()));
        	set_score_guest.setText(Integer.toString(point+1));
        	point_guest.setText("0");
        	point_home.setText("0");
        }
        else if (home == 11) {
        	int point = Integer.parseInt((set_score_guest.getText()));
        	set_score_guest.setText(Integer.toString(point+1));
        	point_guest.setText("0");
        	point_home.setText("0");
        }
        
        
        // 2점을 먼저 내고, 버튼클릭값 처리하지 않기
        if(matchOver()) {
        	point_guest.setText("");
        	point_home.setText("");
        	
 
        	reader.printCheck(guest_name, home_name, set_score_guest.getText(), set_score_home.getText());
//        	reader.close();
        	// TO DO
        	/*
        	 * 	버튼 클릭 이벤트 처리 제거 구현
        	 */
        }
        








        
        
    }
    
    /* updateSetScore - 승리한 선수의 세트 스코어를 1 증가시킨다.
     * @param winner - 승리한 선수의 JLabel 객체 
     */
    
    // 승리한 선수의 세트 스코어 증가시키는 메소드
    private void updateSetScore(JLabel winner) {
        int new_set_score = Integer.parseInt(winner.getText()) + 1;
        winner.setText(Integer.toString(new_set_score));
    }
    
    
    public void update_playerName() {
    	set_guestName.setText(guest_name);
    	set_homeName.setText(home_name);
    }

}


