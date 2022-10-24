public class GameController {
    
    private GameBoardModel board;
    private GameViewOut writer;
    private GameViewIn reader;
    
    public GameController(GameBoardModel b, GameViewOut w, GameViewIn r) {
        board = b;
        writer = w;
        reader = r;
    }
    
    public void play() {
    	// 게임보드판 색깔 판 있는 상태
        GameCellModel[][] square = board.square();
        
        while(true) {
        	writer.repaint();
        	
        	if(board.point() < 16) {
        		writer.repaint();
        		int num;
        		int row;
        		int col;
        		num = reader.readInput();
        		
        		
        		if(num%4 == 0) {
        			row = (num/4) -1 ;
        			col = 3;
        			square[row][col].reveal();
        		}
        		else {
        			row =(num/4);
        			col = (num%4) -1;
        			square[row][col].reveal();
        		}
        		
        		writer.repaint();
        		
        		int num2;
        		int row2;
        		int col2;
        		num2 = reader.readInput();
        		
        		
        		while(num == num2) {
        			num2 = reader.readInput();
        		}
        		
        		
        		// Cell 2번째
        		if(num2%4 == 0) {
        			row2 =(num2/4) -1;
        			col2 = 3;
        			square[row2][col2].reveal();
        		}
        		else {
        			row2 = (num2/4);
        			col2 =(num2%4) -1;
        			square[row2][col2].reveal();
        		}
        		
        		
        		// 입력받아진 두 색깔들을 보여줌 (색깔 일치하지 않아도 ㅎㅎ)
        		writer.repaint();
        		// delay(2000) = 2초
        		delay(2000);
        		
        		
        		if(square[row][col].color() == square[row2][col2].color()) {
        			board.upgrade();
        		}
        		else {
        			square[row][col].hide();
        			square[row2][col2].hide();
        		}
        		
        		
        		
        		
        			
        	}
        	else {
        		break;
        	}
        	
        }
        
    }
    
    /** delay - how_long millisecond 동안 실행 정지  */
    private void delay(int how_long) { 
        try { Thread.sleep(how_long); }
        catch (InterruptedException e) { }
    }

}