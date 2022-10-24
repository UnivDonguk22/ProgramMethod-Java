import java.awt.Color;

public class GameCellModel {
    
	//Color 클래스 인가봄
    private Color color;
    // 초기화 false로 됨
    private boolean revealed;
    
    
    // 생성 메소드
    public GameCellModel(Color c) {
        color = c;
    }
    
    
    
    public Color color() { 
        return color; 
    }

    
    
    public boolean revealed() { 
        return revealed; 
    }
    
    
    // 색깔 보드판에 드러
    public void reveal() {
        revealed = true;
    }
    
    
    // 색깔 보드판에 숨기기
    public void hide() {
        revealed = false;
    }
    
    
    
    public boolean isATwinWith(GameCellModel c) {
    	
    	if(color == c.color()) {
    		return true;
    	}
    	else {
    		return false;
    	}
        
    }

}