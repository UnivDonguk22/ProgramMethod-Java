import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;



public class SudokuBoardFrame extends JFrame {
	
	// 스도쿠 게임 보드판
	private SudokuBoard board;
	private BoardButton[][] gui_board_buttons;
	
	private BoardAnswerButton[] gui_boardPiece_buttons;
	
	
	// 버튼 클릭 이벤트 순서 관리
	public int first;
	
	public int board_row;
	public int board_col;
	
	// 생성 메소드
	public SudokuBoardFrame(SudokuBoard b, String level) {
		board = b;
		String Sudoku_level = level;
		
		// 스도쿠 게임판 9X9로 버튼으로 제작
		gui_board_buttons = new BoardButton[9][9];
		gui_boardPiece_buttons = new BoardAnswerButton[9];
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		/*
		 * To DO 1. 스도쿠 게임 난이도 텍스트 출력
		 */
        JPanel p1_title = new JPanel(new FlowLayout());
        p1_title.add(new JLabel(Sudoku_level));
        
        cp.add(p1_title, BorderLayout.NORTH);
        
        // 스도쿠 게임판 첫 스타트를 위해 GUI에 대해서 게임판 셋팅
        /*
         * To DO 2.  스도쿠 난이도에 따른 게임판 출력 (Button)
         */
        JPanel p2_sudokuButton = new JPanel(new GridLayout(9,9));
        for(int row = 0; row < 9; row ++)
        	for (int col = 0; col < 9; col ++) {
        		gui_board_buttons[row][col] = new BoardButton(board, this, row, col);
        		p2_sudokuButton.add(gui_board_buttons[row][col]);
        	}
       
        cp.add(p2_sudokuButton, BorderLayout.CENTER);
        
        

        
        /*
         * To DO 3. 스도쿠 답안판 출력 (Button)
         */
        JPanel p3_AnswerPiece = new JPanel(new GridLayout(1,9));
        for(int i = 0; i < 9; i ++) {
        	gui_boardPiece_buttons[i] = new BoardAnswerButton(board, this, i + 1);
        	p3_AnswerPiece.add(gui_boardPiece_buttons[i]);
        }
		
        cp.add(p3_AnswerPiece, BorderLayout.SOUTH);
        
        
        update();
        
        
        setTitle("Sudoku");
        setSize(250,250);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		// 스도쿠 게임보드판 Frame 제작
		/*
		 *  To do
		 *  스도쿠 난이도 텍스트 출력
		 *  스도쿠 난이도에 따른 게임판 출력 (Button)
		 *  스도쿠 답안판 출력 (Button)
		 */
		
	}
	
	
	/*
	 * To DO : 스도쿠 게임판 GUI 업데이트 메소드
	 */
	
	public void update() {
    	for (int row = 0; row < 9; row ++) {
    		for (int col = 0; col < 9; col ++) {
    			
    			// 스도쿠 게임판을 조각하나씩 가져옴
    			int board_piece = board.getPuzzleBoard(row, col);
    			if(board_piece != 0) {
    				String n = Integer.toString(board_piece);
    				gui_board_buttons[row][col].setText(n);
    			}
    			else {
    				gui_board_buttons[row][col].setText("");
    			}
    		}
    	}
	}
	
	
	/*
	 * 	To DO : 스도쿠 정답판 GUI 업데이트 메소드
	 */
	
	public void answer_update() {
		for(int i = 0; i < 9; i ++) {
			if(!board.answer_check(i+1)) {
				gui_boardPiece_buttons[i].setText("");
				gui_boardPiece_buttons[i].setVisible(false);
			}
		}
	}
	 
	
}
