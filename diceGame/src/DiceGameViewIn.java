import javax.swing.*;

public class DiceGameViewIn {
	
    public String invitePlayer() {
        return JOptionPane.showInputDialog("이름을 등록해 주세요.");	
    }
	
    public int wantToContnue() {
        return JOptionPane.showConfirmDialog(null, "더 하시겠어요?");
    }

}
