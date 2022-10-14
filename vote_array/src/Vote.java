import javax.swing.*;

/** VoteCount 투표 애플리케이션 */
public class Vote {

    public static void main(String[] args) {
        int num_candidates = 4;
        int[] votes = new int[num_candidates]; // 0으로 자동 초기화

        boolean processing = true;
    while (processing) {
        /* loop invariant: 기표수는 해당 배열에 후보자별로 누적되었음 */
        String input = JOptionPane.showInputDialog("원하는 후보에 투표하세요: 0, 1, 2, 3");
        if (input == null)
            processing = false;
        else {
            char vote = input.charAt(0);
            if ('0' <= vote && vote <= '3') {
                int voted = vote - '0';
                votes[voted] += 1;
            }
            else
                System.out.println(input + "은 후보자가 아닙니다.");
        }
    }
    for (int i = 0; i != votes.length; i = i + 1)
        System.out.println("후보 " + i + "번이 " + votes[i] + "표를 득표하였습니다.");
    }

}