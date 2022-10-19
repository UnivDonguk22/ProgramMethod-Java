import javax.swing.*;

public class HospitalController {
    
    private HospitalMainModel hospital; // 병원 객체
    private HospitalViewOut displayer; // 출력 객체
    private HospitalViewIn reader; // 입력 객체
    private int new_id = 1001; // 신규 환자 등록번호, 1001 = 첫 환자의 등록번호 (고유 등록 번호임 ^.^)
    
    public HospitalController(HospitalMainModel h, HospitalViewOut d, HospitalViewIn r) {
        hospital = h;
        displayer = d;
        reader = r;
    }
    
    // 입원실 관리 서비스 (무한 루프)
    // [5번 - 배점 10점]
    public void manageRooms() {
        while (true) {
            double temperature;
            int bp_high, bp_low, id;
            HospitalPatientModel p;
            
           String UserSelectService = reader.readMenu("+: 입실, -: 퇴실");
           
           System.out.println(UserSelectService);
           
           // 입실 서비스
           if (UserSelectService.equals("+")) {
        	   if(hospital.roomAvailable()) {
        		   
        		  // 환자 상세 정보 기입
        		  temperature = reader.readDouble("체온?");
        		  bp_high = reader.readInteger("혈압(상)");
        		  bp_low = reader.readInteger("혈압(하)");
        		  
        		  // 첫 환자일 때의 입원 서비스
        		  if(new_id == 1001) {
        			  
        			  // 객체를 선언 후 활용한다.
        			  p = new HospitalPatientModel(new_id, temperature, bp_high, bp_low);
        			  hospital.admit(p);
        			  displayer.display();
        			  new_id = new_id + 1;
        		  }
        		  
        		  else {
        			  p = new HospitalPatientModel(new_id, temperature, bp_high, bp_low);
        			  hospital.admit(p);
        			  displayer.display();
        			  new_id = new_id + 1;
        		  }
        		  
        		  
        	   }
        	   else {
        		   displayer.showMessage("병실이 없습니다.");
        	   }
           }
           
           // 퇴실 서비스
           else {
        	   id = reader.readInteger("환자 번호?");
        	   
        	   
        	   // 환자 퇴실 시키기
        	   if(hospital.findPatient(id) != null) {
        		  
        		  p = hospital.findPatient(id);
        		  hospital.discharge(p);
        		  displayer.display();
        	   }
        	   else {
        		   displayer.showMessage(id + " 환자를 찾을 수 없습니다.");
        	   }
           }
           
           
        }
    }
    
}