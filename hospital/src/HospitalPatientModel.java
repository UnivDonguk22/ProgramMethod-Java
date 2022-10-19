public class HospitalPatientModel {
    
    private int patient_id; // 환자 등록번호 
    private double temperature; // 환자 체온 
    private int blood_pressure_high; // 환자 혈압 (위)
    private int blood_pressure_low; // 환자 혈압 (아래) 
    
    // 환자 객체 생성 초기화 메소드
    public HospitalPatientModel(int id, double t, int high, int low) {
        patient_id = id;
        temperature = t;
        blood_pressure_high = high;
        blood_pressure_low = low;
    }
    
    public int getID() {
        return patient_id;
    }
    
    public double getTemp() {
        return temperature;
    }
    
    public int getBPHigh() {
        return blood_pressure_high;
    }

    public int getBPLow() {
        return blood_pressure_low;
    }
}