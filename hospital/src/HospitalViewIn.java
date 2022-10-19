import javax.swing.JOptionPane;

public class HospitalViewIn {
    
    /**
     * 입력 대화창을 띄워 +와 - 둘 중 하나만 받아 리턴한다. 
     * @param message 인풋 대화창에 보여줄 메시지 
     * @return "+" 또는 "-"
     */
    public String readMenu(String message) {
        String input = JOptionPane.showInputDialog(message);
        while (! (input.equals("+") || input.equals("-")))
            input = JOptionPane.showInputDialog(message);
        return input;
    }
    
    /**
     * 입력 대화창을 띄워 받은 입력을 정수로 변환하여 리턴한다. 
     * @param message 인풋 대화창에 보여줄 메시지
     * @return 정수
     */
    public int readInteger(String message) { // 입력 오류 처리 생략  
        String input = JOptionPane.showInputDialog(message);
        int n = Integer.parseInt(input);
        return n;
    }
    
    /**
     * 입력 대화창을 띄워 받은 입력을 실수로 변환하여 리턴한다. 
     * @param message 인풋 대화창에 보여줄 메시지
     * @return 실수 
     */
    public double readDouble(String message) { // 입력 오류 처리 생략  
        String input = JOptionPane.showInputDialog(message);
        double r = Double.parseDouble(input);
        return r;
    }

}