public class SudokuController {

    private SudokuModel sudoku;
    private SudokuViewIn reader;
    private SudokuViewOut writer;

    /** Sudoku, PlayerInput, SudokuWriter 객체를 생성하여 필드 변수에 지정한다. */
    // 생성 메서드
    public SudokuController() {
        reader = new SudokuViewIn();
        int hole_count = reader.selectLevel();
        
        /*
         * 객체를 활용하는 좋은 사례 중 하나임 ㅎㅎ
         */
        // Model 객체를 선언해
        // ViewOut 클래스로 Model 객체 보내줌.
        sudoku = new SudokuModel(hole_count);
        writer = new SudokuViewOut(sudoku);
    }

    
    /*
     * TO DO 4.
     */
    // [배점 0.5/2.0]
    /** 스도쿠 퍼즐 게임을 진행한다. */
    public void playSudokuPuzzle() {
    	
    	while(true) {
        	if(sudoku.countHoles() != 0) {
        		
        		// 스도쿠 보드판 다시 그리기
        		writer.repaint();
        		
        		// 사용자 스도쿠 게임 데이터 입력
        		int userInputRow = reader.selectNumber("가로줄 번호를 입력하세요.");
        		int userInputCol = reader.selectNumber("세로줄 번호를 입력하세요.");
        		int userInputDigit = reader.selectNumber("숫자를 입력하세요.");
        		
        		// 사용자가 입력한 데이터 스도쿠에 대입 - 불가 시 false, 가능 시 true
        		if(sudoku.check(userInputDigit, userInputRow, userInputCol)) {
        			// 한번 선언된 객체는 프로그램이 실행 종료할 때까지 유효하다.
        			// 객체가 업데이트 되면, 반영된다.
        			/*
        			 * 자바 객체 새로운 앎. - 블로그 포스 (자바 과제를 하며,, 객체를 깨닫다)
        			 */
        			
        			// 아래 코드를 사용하면, ViewOut 페이지가 여러 개 출력된다. (블로그 작성 참고)
//        			writer = new SudokuViewOut(sudoku);
//        			sudoku.showBoard(sudoku.getPuzzleBoard());
        		}
        		
        	}
        	else {
        		break;
        	}
        	
    	}







    }
}