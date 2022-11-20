package slidePuzzle_GUI;

import java.awt.event.*;
import javax.swing.*;

public class StartButton extends JButton implements ActionListener {
    
    private SlidePuzzleBoard board;
    private PuzzleFrame frame;
    
    public StartButton(SlidePuzzleBoard b, PuzzleFrame f) {
        super("Start");
        board = b;
        frame = f;
        addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
    	
    	// Frame에서 받은 SlidePuzzleBoard 객체 동일하게 넘겨줌. - 객체 생성 후 그대로 넘겨줌. (메모리 주소 동일)
        board.createPuzzleBoard();
        frame.update();
    }
}
