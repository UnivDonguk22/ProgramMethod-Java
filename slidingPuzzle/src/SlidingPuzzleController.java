import javax.swing.JOptionPane;

public class SlidingPuzzleController {

	private SlidingPuzzleBoardModel board;
	private SlidingPuzzleViewOut viewOut;
	
	// 생성 메소드
	public SlidingPuzzleController(SlidingPuzzleBoardModel b, SlidingPuzzleViewOut v) {
		board = b;
		viewOut = v;
	}
	
	public void play() {
		while(true) {
			viewOut.displayPuzzleBoard();
			String input = JOptionPane.showInputDialog("주세요");
			int n = Integer.parseInt(input);
			
			// 사용자가 입력한 보드의 좌표에 대한 예외처리
			if (! board.move(n)) {
				viewOut.showNoMove("안돼");
			}
			
		}
		
	}
}
