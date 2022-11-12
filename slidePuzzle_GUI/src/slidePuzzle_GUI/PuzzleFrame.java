package slidePuzzle_GUI;

import java.awt.*;
import javax.swing.*;

// JFrame 상속받아서 사용
/*
 * XML와 같은 역할로
 * 퍼즐보드의 Layout을 생성하고, 이에 대한 요소를 넣어준다. 
 */
public class PuzzleFrame extends JFrame {

    private SlidePuzzleBoard board;
    private PuzzleButton[][] button_board;

    public PuzzleFrame(SlidePuzzleBoard b) {
        board = b;
        button_board = new PuzzleButton[4][4];
        
        // 요소들이 넣어지는 Layout 영역을 Container라고 지칭함.
        /*
         * 		안드로이드에서 Fragment의 Layout 영역을 Container라고 함. 
         */
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        // Start Button 배치 | FlowLayout 배치사용
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(new StartButton(board, this));
        
        
        // 슬라이드 퍼즐 보드판 배치 | GridLayout 배치사용
        JPanel p2 = new JPanel(new GridLayout(4,4));
        for(int row = 0; row < 4; row ++)
        	for (int col = 0; col < 4; col ++) {
        		button_board[row][col] = new PuzzleButton(board, this);
        		p2.add(button_board[row][col]);
        	}
        
        cp.add(p1,BorderLayout.NORTH);
        cp.add(p2,BorderLayout.CENTER);
        update();
        
       
        
        // Layout을 GridLayout으로 셋팅
//        cp.setLayout(new GridLayout(4,4));
//        for (int row = 0; row < 4; row++)
//            for (int col = 0; col < 4; col++) {
//                button_board[row][col] = new PuzzleButton(board, this);
//                
//                /*
//                 *  GridLayout 특성상 요소를 추가하면
//                 *  요소들을 옆으로 재배정해줌.
//                 */
//                cp.add(button_board[row][col]);
//            }
        
        // 초기 퍼즐보드판 생성 시 퍼즐보드판 업데이트
   
        /*
         * 아래의 메소드들은 JFrame의 메소드
         * JFrame의 메소드가 해당 클래스에 내장되어 있음 (JFrame 클래스를 상속받았기 때문이다.)
         */
        setTitle("Slide Puzzle");
        setSize(250,250);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void update() {
    	for (int row = 0; row < 4; row ++) {
    		for (int col = 0; col < 4; col ++) {
    			
    			// 슬라이드 퍼즐 보드판 Model에서 만들어진 Data를 이용해
    			// GUI로 표시 - 퍼즐 조각 하나씩 가져옴.
    			PuzzlePiece pp = board.getPuzzlePiece(row, col);
    			if(pp != null) {
        			String n = Integer.toString(pp.face());
        			button_board[row][col].setText(n);
    			}
    			else {
    				// 퍼즐 조각의 값이 null일 때
    				button_board[row][col].setText("");
    			}

    		}
    	}
    }
    
    public void finish() {
    	button_board[3][3].setText("Done");
    }

}