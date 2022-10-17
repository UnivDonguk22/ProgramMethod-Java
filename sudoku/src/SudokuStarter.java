public class SudokuStarter {

    public static void main(String[] args) {
    	new SudokuModel(3);
        new SudokuController().playSudokuPuzzle();
    }
}