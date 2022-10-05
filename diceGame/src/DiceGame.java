
public class DiceGame {

    public static void main(String[] args) {
        DiceGameViewIn input = new DiceGameViewIn();
        DiceGamePlayerModel p1 = new DiceGamePlayerModel(input.invitePlayer());
        DiceGamePlayerModel p2 = new DiceGamePlayerModel(input.invitePlayer());
        
        // TO DO
        DiceGameViewOut output = new DiceGameViewOut(p1, p2);
        new DiceGameController().controllDiceGame(p1,p2,output,input);
    }
}