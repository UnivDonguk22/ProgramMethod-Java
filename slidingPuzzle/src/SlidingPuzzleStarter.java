
public class SlidingPuzzleStarter {
	
	public static void main(String[] args) {
		SlidingPuzzleBoardModel b = new SlidingPuzzleBoardModel();
		SlidingPuzzleViewOut v = new SlidingPuzzleViewOut(b);
		new SlidingPuzzleController(b,v).play();
		
	}
}
