public class HospitalStarter {

    public static void main(String[] args) {
        HospitalMainModel h = new HospitalMainModel(4);
        new HospitalController(h, new HospitalViewOut(h), new HospitalViewIn()).manageRooms();
    
    }

}