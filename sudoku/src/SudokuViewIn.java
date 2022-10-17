import javax.swing.*;

public class SudokuViewIn {

    /** 플레이어에게 난이도를 선택하게 하여 난이도에 따라 빈칸의 개수를 정하여 리턴한다.
     *
     * @return 빈칸의 개수
     */
    public int selectLevel() {
        String message = "난이도 숫자 입력  = 초급 1, 중급 2, 고급 3";
        String input = JOptionPane.showInputDialog(message);
        
        // 사용자 난이도 입력 예외처리
        while (! (input.equals("1") || input.equals("2") || input.equals("3")))
            input = JOptionPane.showInputDialog(message);
        int level = Integer.parseInt(input);
        if (level == 1)
            return 27;
        else if (level == 2)
            return 36;
        else // level must be 3
            return 45;
    }

    
    // 사용자 스도쿠 게임의 입력 예외처리
    // (여기선, 가로줄 & 세로줄 & 넣을 데이터 모두 예외처리함)
    /** 1~9 범위의 수를 플레이어에게서 입력받아서 정수로 리턴한다.
     *
     * @param message - 인풋 메시지 윈도우에 보여줄 메시지 문자열   
     * @return 인풋 받은 1~9 범위의 정수
     */
    public int selectNumber(String message) {
        String input = JOptionPane.showInputDialog(message);
        while (! (input.equals("1") || input.equals("2") || input.equals("3") ||
                  input.equals("4") || input.equals("5") || input.equals("6") ||
                  input.equals("7") || input.equals("8") || input.equals("9")))
            input = JOptionPane.showInputDialog(message);
        return Integer.parseInt(input);
    }
}
