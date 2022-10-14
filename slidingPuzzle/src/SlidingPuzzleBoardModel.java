
public class SlidingPuzzleBoardModel {
	
	// 2차원 배열객체 생성
	public SlidingPuzzlePieceModel[][] board;
	
	// 보드판에서 빈공간 생성
	private int empty_row;
	private int empty_col;
	
	// 생성 메소드
	public SlidingPuzzleBoardModel() {
		board = new SlidingPuzzlePieceModel[4][4];
		int number = 15;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				board[i][j] = new SlidingPuzzlePieceModel(number);
				number -= 1;
			}
		}
		board[3][3] = null;
		empty_row = 3;
		empty_col = 3;
	}
	
	public boolean move(int n) {
		
		// 이동할 칸에 대한 위치 기억변수
		int row, col;
		
		if(found(n, empty_row - 1, empty_col)) {
			row = empty_row-1;
			col = empty_col;
		}
		
		else if(found(n, empty_row + 1, empty_col)) {
			row = empty_row+1;
			col = empty_col;
		}
		
		else if(found(n, empty_row, empty_col - 1)) {
			row = empty_row;
			col = empty_col-1;
		}
		
		else if(found(n, empty_row, empty_col + 1)) {
			row = empty_row;
			col = empty_col+1;
		}
		
		// 사용자가 입력한 보드의 좌표가 움직이지 못할 때의 예외
		else {
			return false;
		}
		
		board[empty_row][empty_col] = board[row][col];
		board[row][col] = null;
		empty_row = row;
		empty_col = col;
		return true;		
		
	}
	
	private boolean found(int n, int r, int c) {
		if (r >= 0 && r <= 3 && c >= 0 && c <= 3) {
			
			// 사용자가 null에 해당하는 보드판의 값을 요구할 때의 예외처리 
			if (board[r][c] != null) {
			return board[r][c].puzzleFace() == n;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
	}
	
	
	
	
	
	
}
