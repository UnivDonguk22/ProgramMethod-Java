import java.awt.event.*;
import javax.swing.*;

public class NewButton extends JButton implements ActionListener {

    private ScoreBoard score_board;

    public NewButton(ScoreBoard b) {
        super("New");
        score_board = b;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        score_board.begin();
        
        score_board.guest_name = JOptionPane.showInputDialog("Enter your name.");
        score_board.home_name = JOptionPane.showInputDialog("Enter your name.");
        
        score_board.update_playerName();
        
    }

}