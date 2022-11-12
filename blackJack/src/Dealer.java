public class Dealer {

    CardDeck deck;

    
    // 생성 메소드
    public Dealer() {
        deck = new CardDeck();
    }

    // 카드를 다루는 메소드
    public void dealTo(CardPlayerBehavior p) {
        while (p.wantsACard()) {
            Card c = deck.newCard();
            p.receiveCard(c);
        }

    }
    
    // abstract 메소드 - 카드를 더 받고 싶은 지 의사를 물음.
    public boolean wantsACard() {
    	if() {
    		return true
    	}
    	else {
    		return false
    	}
    }
    

    
    // dealOneTo 메소드
    public void dealOneTo(CardPlayerBehavior p) {
    	
    }
    
    public static void main(String[] args) {
        Dealer d = new Dealer();
        HumanPlayer p = new HumanPlayer(3);
        d.dealTo(p);
        Card[] hand = p.showCards();
        for (int i = 0; i < hand.length; i++) {
            System.out.println(hand[i].getSuit() + " " + hand[i].getRank());
        }
    }
}