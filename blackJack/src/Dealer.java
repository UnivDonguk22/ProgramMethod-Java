// 블랙잭 게임의 카드 덱을 관리하는 Model 클래스
// 컴퓨터 - 유저한테 카드 뿌려줌.

public class Dealer {

    CardDeck deck;

    
    // 생성 메소드
    public Dealer() {
        deck = new CardDeck();
    }

    // 카드를 원할 때까지 주는 메소드
    /*
     * 카드 2장을 모두 나눠준 뒤의 실행될 카드 뿌리기 메소드
     */
    public void dealTo(CardPlayerBehavior p) {
        while (p.wantsACard()) {
           p.receiveCard(deck.newCard());
        }
    }
   
    // 카드를 한번만 주는 메소드
    /*
     * 처음 카드 2장을 나눠줄 때 사용할 카드 뿌리기 메소드
     */
    public void dealOneTo(CardPlayerBehavior p) {
       p.receiveCard(deck.newCard());
    }
   

}