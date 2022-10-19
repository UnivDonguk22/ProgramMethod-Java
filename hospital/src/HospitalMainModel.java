// 다하고 Main Model 2차원 배열로 풀어보기 ㅎㅎ
public class HospitalMainModel {
    
    private HospitalPatientModel[] rooms; // 입원실 배열 
    private int occupied; // 환자가 입실중인 입원실의 개수 
    
    // 생성 메서드
    public HospitalMainModel(int n) { // 병원 객체 생성 초기화 메소드, n = 병원이 보유한 입원실의 개수
        rooms = new HospitalPatientModel[n]; 
        occupied = 0;
        
        // 디버깅 코드
        // PatientModel 타입의 배열 객체 rooms는 null 값을 갖는다. 
        System.out.println(rooms[0] == null);
        System.out.println(rooms.length);
        /*
         *	2차원 배열이 아닌, 타입이 객체인 배열 객체이다.
         *	그래서, 배열 원소 하나가 선언한 타입 객체 형태로 저장된다.
         * [ {HostpitalPatient}, {HospitalPatientModel}, {HospitalPatientModel}, {HospitalPatientModel}]     
         *  위와 같은 형태로 rooms 배열 객체가 선언되어 있다.
         *  (결국, 객체 타입으로 )
         */
        
    }
    
    
    
    /**
     * 입원실 배열을 리턴한다.
     * @return
     */
    // Patient Model 타입의 배열 객체를 생성한다.
    public HospitalPatientModel[] getRoomsInfo() {
        return rooms;
    }
    
    
    
    /** [1번 - 배점 2점]
     * 비어있는 입원실이 있는지 여부를 리턴한다.
     * @return
     */
    public boolean roomAvailable() {
    	for (int i = 0; i < rooms.length; i ++) {
    		if(rooms[i] == null) {
    			return true;
    		}
    	}
        return false;
    }
    
    
    
    
    
    
    /** [2번 - 배점 5점]
     * 환자 등록번호 id로 입원 중인 환자를 찾는다. 
     * @param id
     * @return 환자 
     */
    // return 타입은 HospitalPatientModel 로 생성메서드에서 할당해준 타입들이다 ㅎㅎ (rooms 배열을 return)
    public HospitalPatientModel findPatient(int id) {
    	
    	
        
    	// 환자 id와 일치한 환자가 입원실에 존재하는지 찾기 - (객체 배열 활용 ㅎㅎ)
    	// 비교 연산 시 어떤 순간에 null 값이 온다면, Null 에러가 발생 - 단축계산 원리로 에러를 해결함!
    	for(int i = 0; i < rooms.length; i ++) {
    		if(rooms[i] != null && rooms[i].getID() == id) {
    			return rooms[i];
    		}
    	}
    	
    	// null 객체는 초기화하기 전의 값이므로, 받아지는 듯
    	return null;

    }
    
    
    
    
    
    /** [3번 - 배점 5점]
     * 환자 p를 입실시킨다.
     * @param p 
     * @return 빈 입원실이 있어서 입실 성공하면 true, 없어서 실패하면 false
     */
    public boolean admit(HospitalPatientModel p) {
    	
    	if(roomAvailable()) {
    		for(int i = 0; i < rooms.length; i ++) {
    			if(rooms[i] == null) {
    				rooms[i] = p;
    				return true;
    			}
    		}
    	}
        return false;
    }
    
    
    
    
    
    
    /** [4번 - 배점 5점]
     * 환자 p를 퇴실시킨다.
     * @param p
     * @return 환자를 찾아서 퇴실 성공하면 true, 실패하면 false
     */
    public boolean discharge(HospitalPatientModel p) {
    	
    	if(findPatient(p.getID()) == null) {
    		return false;
    	}
    	else {
    		// 환자 p를 퇴실시키기
    		for(int i = 0; i < rooms.length; i ++) {
    			if(rooms[i] != null && rooms[i].getID() == p.getID()) {
    				rooms[i] = null;
    				return true;
    			}

    		}
    	}
    	
    	
    	// 해당 boolean은 값을 가지지 않음 - 형식상 데이터
    	return true;
    	
    }
    
}