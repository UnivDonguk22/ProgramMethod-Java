import java.awt.event.*;
import javax.swing.*;

public class PointButton extends JButton implements ActionListener {

    private ScoreBoard score_board;

    public PointButton(ScoreBoard b) {
        super("0");
        score_board = b;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (! score_board.matchOver()) {
            int point = Integer.parseInt(getText());
            setText(Integer.toString(point+1));
            score_board.update();
        }
        
        
    }

}