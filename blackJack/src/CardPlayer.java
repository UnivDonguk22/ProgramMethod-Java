// 블랙잭 (유저 - 컴퓨터)의 카드 덱 클래스 (생성, 관리)

// 해당 클래스는 매 판마다 초기화를 진행해주는 가?
// 컴퓨터, 유저 모델 클래스를 초기화해주는 건가? 아니면, 부모 클래스인 CardPlayer 클래스만 초기화해주는 건가?


public abstract class CardPlayer implements CardPlayerBehavior {

    private Card[] hand; // 갖고 있는 카드
    private int card_count; // 갖고 있는 카드의 장 수
    
    // 유저 - 컴퓨터의 카드 덱을 초기화해주기위해 hand가 가지는 수 저장.
    private int maxCards;
    
    // 생성 메소드
    /** Constructor CardPlayer - max_cards 카드를 수용가능한 Card 배열 객체를 만들어 CardPlayer 생성
     * @param max_cards - 들고 있을 수 있는 카드의 최대 장수 */
    public CardPlayer(int max_cards) {
    	
    	// Card 타입으로 배열객체 생성 - 생성 인자 할당 x -> 초기화 안됨.
    	maxCards = max_cards;
        hand = new Card[max_cards];
        card_count = 0;
    }
    
    // abstract 메소드
    /** wantsACard - 카드 한 장을 받겠는지 답한다.
     * @return 카드를 받고 싶으면 true, 아니면 false */
    public abstract boolean wantsACard();

    // (유저 - 컴퓨터)의 카드 덱에 카드 한장을 추가하는 메소드
    /** receiveCard - 카드를 한장 받는다. 한도(배열 hand의 크기)를 초과하면 받을 수 없다.
     * @param c - 카드
     * @return 성공적으로 받았으면 true, 그렇지 않으면 false */
    public boolean receiveCard(Card c) {
        if (card_count < hand.length) {
            hand[card_count] = c;
            card_count += 1;
            return true;
        }
        else
            return false;
    }

    
    // (유저 - 컴퓨터)의 카드 덱을 보여주는 메소드 
    /** showCards - 들고 있는 카드를 내준다.
     * @return 들고 있는 카드 전체  */
    public Card[] showCards() {
        Card[] card = new Card[card_count];
        for (int i = 0; i < card_count; i++)
            card[i] = hand[i];
        return card;
    }
    
    
    // 블랙잭 게임진행 점수 생성 메소드
    public int totalScore() {
    	
    	int total_score = 0;
    	
    	for(int i = 0; i < card_count; i++ ) {
    		int rank = hand[i].rank();
    		
    		// ACE 무늬카드가 나왔을 때 예외처리  { 유리한 방향으로 카드 선택 }
    		if(rank == 1) {
    			if(total_score + 11 > 21 ) {
    				total_score = total_score + 1;
    			}
    			else {
    				total_score = total_score + 11;
    			}
    			
    		// J,Q,K 무늬카드가 나왔을 때 예외처리 	
    		}
    		else if(rank == 11 || rank == 12 || rank == 13) {
    			total_score = total_score + 10;
    		}
    		else {
    			total_score = total_score + rank;
    		}
    		
    	}
    	return total_score;
    }
    
    // 매 판이 종료되고 이어서 게임을 진행할 때, 유저 - 컴퓨터 카드 덱 초기화
    public void resetHand() {
    	hand = new Card[maxCards];
    	card_count = 0;
    }

}