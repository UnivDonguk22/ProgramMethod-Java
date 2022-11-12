public interface CardPlayerBehavior {

    /** wantsACard - 카드 한 장을 받겠는지 답한다.
     * @return 카드를 받고 싶으면 true, 아니면 false */
    public boolean wantsACard();

    /** receiveCard - 카드를 한장 받는다. 한도(배열 hand의 크기)를 초과하면 받을 수 없다.
     * @param c - 카드
     * @return 성공적으로 받았으면 true, 그렇지 않으면 false */
    public boolean receiveCard(Card c);

}