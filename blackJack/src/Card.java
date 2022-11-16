// Card 정보 Data 생성 

public class Card {

    public static final String SPADES = "spades";
    public static final String HEARTS = "hearts";
    public static final String DIAMONDS = "diamonds";
    public static final String CLUBS = "clubs";

    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;

    public static final int SIZE_OF_ONE_SUIT = 13;

    private String suit;
    private int rank;

    // Card 생성 메소드
    /*
     * 	카드의 무늬 & 숫자를 지정
     */
    public Card(String s, int r) {
        suit = s;
        rank = r;
    }

    
    // 카드의 무늬
    public String suit() {
        return suit;
    }
    
    
    // 카드의 숫자
    public int rank() {
        return rank;
    }
    
    
    // 카드가 동일한 카드인지 비교
    public boolean equals(Card c) {
        return suit.equals(c.suit()) && rank == c.rank();
    }

}