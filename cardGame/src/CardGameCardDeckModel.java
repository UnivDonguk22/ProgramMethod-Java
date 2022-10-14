public class CardGameCardDeckModel {

    private CardGameCardModel[] deck = new CardGameCardModel[4 * CardGameCardModel.SIZE_OF_ONE_SUIT]; // 카드 덱
    private int card_count; // 덱에 현재 남아있는 카드의 장수
    // Invariant: deck[0], .., decl[card_count-1] 에 카드가 있다.

    
    // 생성 메소드
    /** CardDeck 카드 한 벌 생성  */
    public CardGameCardDeckModel() {
        createDeck();
    }
    
    
    // 카드덱 생성하는 Controller 메소드 
    private void createDeck() {
        createSuit(CardGameCardModel.SPADES);
        createSuit(CardGameCardModel.HEARTS);
        createSuit(CardGameCardModel.CLUBS);
        createSuit(CardGameCardModel.DIAMONDS);
    }
    
    
    // 카드덱 생성하는 Model 메소드
    private void createSuit(String which_suit) {
        for(int i = 1; i <= CardGameCardModel.SIZE_OF_ONE_SUIT; i++) {
            deck[card_count] = new CardGameCardModel(which_suit, i);
            card_count = card_count + 1;
        }
    }
    
    

    /** 카드 덱에서 무작위로 카드를 한 장 선택하여 내줌
     * @return 카드 덱에서 무작위로 한 장 뽑아줌
     *         없으면 카드 1벌을 새로 만들고 무작위로 한 장 뽑아줌   */
    public CardGameCardModel drawCard() {
        if (card_count == 0) // will never be negative!
            createDeck();
        int the_picked = (int)(Math.random() * card_count);
        CardGameCardModel the_card_drawn = deck[the_picked];
        
        
        // 뽑은 카드를 카드덱에서 제거하기 위함.
        for (int i = the_picked+1; i < card_count; i++)
        {
        	deck[i-1] = deck[i];
        }
        
        card_count -= card_count;
        return the_card_drawn;
    }

}