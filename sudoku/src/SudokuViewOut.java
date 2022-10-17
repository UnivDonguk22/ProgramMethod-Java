import java.awt.*;
import javax.swing.*;


// JPanel 클래스 상속받음.
public class SudokuViewOut extends JPanel {

    private SudokuModel sudoku;
    private final int SIZE = 40;
    private final int PANEL_SIZE = SIZE * 11;

    /** JPanel 객체 초기화 메소드
     *    
     * @param s - 윈도우에 그릴 Sudoku 객체
     */
    // 생성 메소드
    public SudokuViewOut(SudokuModel s) {
        sudoku = s;
        JFrame f = new JFrame();
        f.getContentPane().add(this);
        f.setLocation(160, 200);
        f.setTitle("Sudoku");
        f.setSize(PANEL_SIZE, PANEL_SIZE+28);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, PANEL_SIZE, PANEL_SIZE);
        int digit;
        
        // 스도쿠 판 좌표
        int x = SIZE;
        int y = SIZE;
        
        /*
         * 스도쿠 판 (한칸 씩) 그리기
         */
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) { 				
                g.setColor(Color.gray);
                g.drawRect(x, y, SIZE, SIZE);
                g.setColor(Color.black);
                digit = sudoku.getPuzzleBoard()[i][j];
                if (digit != 0)
                    g.drawString(digit + "", x+15, y+25);
                x += SIZE;
            }
            x = SIZE;
            y += SIZE;
        }
        
        /*
         * 스도쿠 판 3 X 3 판으로 9등분하기
         */
        x = SIZE;
        y = SIZE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                g.setColor(Color.black);
                g.drawRect(x, y, SIZE*3, SIZE*3);
                x += SIZE * 3;
            }
            x = SIZE;
            y += SIZE * 3;
        }
        
        /*
         * 가로줄 번호
         */
        x = SIZE - 25;
        y = SIZE;
        for (int i = 1; i <= 9; i++) {
            g.setColor(Color.blue);
            g.drawString(i + "", x, y+25);
            y += SIZE;
        }
        
        /*
         * 세로줄 번호
         */
        x = SIZE;
        y = SIZE - 10;
        for (int i = 1; i <= 9; i++) {
            g.setColor(Color.blue);
            g.drawString(i + "", x+15, y);
            x += SIZE;
        }
    }
}