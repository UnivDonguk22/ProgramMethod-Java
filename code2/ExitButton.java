import java.awt.event.*;
import javax.swing.*;

public class ExitButton extends JButton implements ActionListener {

    public ExitButton() {
        super("Exit");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
        
    }

}