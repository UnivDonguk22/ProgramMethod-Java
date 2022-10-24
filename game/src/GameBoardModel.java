import java.awt.Color;
import java.util.Random;

public class GameBoardModel {
    
	// 게임 보드판 4X4 & 색깔이 드러나있는 칸의 갯수
    private GameCellModel[][] square;
    private int point;
    
    
    // 게임 보드판 리
    public GameCellModel[][] square() { 
        return square; 
    }
    
    // 색깔 드러나있는 칸의 갯수 리턴
    public int point() { 
        return point; 
    }
    
    
    public void upgrade() { 
        point += 2; 
    }
    
    
    
    
    // 생성 메소드
    public GameBoardModel() {
        square = new GameCellModel[4][4];
        Color[] colors = {Color.BLUE, Color.CYAN, Color.PINK, Color.RED, 
                          Color.GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE};
        GameCellModel[] twins = createTwinCells(colors);
        makeSquare(shuffle(twins));
    }
    
    
    // 보드 배열을 생성함 TO DO 3
    private void makeSquare(GameCellModel[] cells) {
    	int up = 0;
        for (int i = 0; i < 4; i ++) {
        	for(int j = 0; j < 4; j ++) {
        		square[i][j] = cells[up];
        		up = up + 1;
        	}
        }
    }
    
    
    
    
    // 같은 색깔 쌍의 1차원 배열로 모아서 리턴 TO DO 1
    private GameCellModel[] createTwinCells(Color[] cs) {
        // to be filled...
    	GameCellModel[] color_setMain = new GameCellModel[16];
    	for(int i = 0; i < 16; i ++) {
    		
    		if (i < 8) {
    			GameCellModel color_set = new GameCellModel(cs[i]);
    	
    			// 16개 해당하는 색깔 배열 들어감
    			color_setMain[i] = color_set;
    		}
    		
    		else {
        		GameCellModel color_set = new GameCellModel(cs[i - 8]);
        		// 16개 해당하는 색깔 배열 들어감
        		color_setMain[i] = color_set;
    		}

    	}
    	return color_setMain;
    	
    }
    
    
    // 구현완료
    private GameCellModel[] shuffle(GameCellModel[] twins) {
        int index;
        GameCellModel temp;
        Random random = new Random();
        for (int i = twins.length - 1; i > 0; i--) {
            index = random.nextInt(i+1);
            temp = twins[index];
            twins[index] = twins[i];
            twins[i] = temp;
        }
        return twins;
    }

}