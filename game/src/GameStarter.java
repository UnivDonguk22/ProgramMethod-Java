public class GameStarter {

    public static void main(String[] args) {
        GameBoardModel board = new GameBoardModel();
        GameViewOut writer = new GameViewOut(board);
        GameViewIn reader = new GameViewIn();
        new GameController(board,writer,reader).play();
    }

}