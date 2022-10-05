
public class DiceGameDiceModel {
	
    private int face1;
    private int face2;
    private int sum;
    private int difference;
    private boolean twin;
    
    public int face1()
    { 
    	return face1;
    }
    
    public int face2() 
    { 
    	return face2; 
    }	
    
    public int sum() 
    { 
    	return sum; 
    }
    
    public int difference() 
    { 
    	return difference; 
    }
    
    public boolean twin() 
    {
    	return twin;
    }
	
    
    public void rollDice() {
        face1 = (int)(Math.random() * 6) + 1;
        face2 = (int)(Math.random() * 6) + 1;
        sum = face1 + face2;
        difference = Math.abs(face1 - face2);
        if (face1 == face2) 
            twin = true;
    }
}