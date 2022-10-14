public class CardGameHandModel {
    // 카드 놀이 하는 참여자의 손에 들고 있는 카드의 모델

    private CardGameCardModel[] hand;
    private int number_of_cards;

    /** CardGameHand 생성 메소드
     * @param max - 들고 있을 수 있는 카드의 최대 장수 */
    public CardGameHandModel(int max) {
        hand = new CardGameCardModel[max];
    }
    
    

    /** 카드를 한장 받는다. 한도를 초과하면 받을 수 없다.
     * @param c - 카드
     * @return 성공적으로 받았으면 true, 그렇지 않으면 false
     */
    public boolean receiveCard(CardGameCardModel c) {
        if (number_of_cards < hand.length) {
            hand[number_of_cards] = c;
            number_of_cards += 1;
            return true;
        }
        else
            return false;
    }
    
    

    /** 지정한 카드를 낸다. 없으면 낼 수 없다.
     * @param c - 카드
     * @return 카드가 있으면 손에서 제거하고 true를 리턴, 없으면 false를 리턴
     */
    public boolean playCard(CardGameCardModel c) {
        boolean found = false;
        int index = 0;
        while (!found && index < number_of_cards) {
            if (hand[index].equals(c))
                found = true;
            else
                index += 1;
        }
        if (found) {
            for (int i = index+1; i < number_of_cards; i++)
                hand[i-1] = hand[i];
            number_of_cards -= 1;
            hand[number_of_cards] = null;
            return true;
        }
        else
            return false;
    }
    
    

    /** 들고 있는 카드를 모두 실행창에 보여 준다.
     *  카드가 없으면 없음을 알려 준다. */
    public void showHand() {
        if (number_of_cards == 0)
            System.out.println("카드가 없습니다.");
        else {
        	CardGameCardModel card;
            System.out.println(number_of_cards + "장 있습니다.");
            for (int i = 0; i < number_of_cards; i++) {
                card = hand[i];
                System.out.println("#" + (i + 1) + " " + card.suit() + " " + card.rank());
            }
        }
    }

}