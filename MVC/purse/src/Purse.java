public class Purse {
	

	public static void main(String[] args) {
		
		PurseViewIn r = new PurseViewIn();
		PurseModel p = new PurseModel();
		PurseViewOut w = new PurseViewOut("에리카", 300, 0, p);
		new PurseController(r, w, p).processTransactions();

	}
}