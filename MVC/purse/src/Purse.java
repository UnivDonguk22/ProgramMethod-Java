public class Purse {
	

	public static void main(String[] args) {
		
		PurseViewIn r = new PurseViewIn();
		PurseModel pk = new PurseModel();
		PurseModel pj = new PurseModel();
		PurseViewOut wk = new PurseViewOut("에리카(원화)", 300, 0, pk);
		PurseViewOut wj = new PurseViewOut("에리카(일화)", 300, 0, pj);
		new PurseController(r, wk, wj, pk, pj).processTransactions();

	}
}