
public class PurseModel {
	private int balance;
	
	/*
	 * 지갑에 금액을 추가 - 수입
	 */
	public boolean earn(int amount) {
		if (amount < 0) {
			return false;
		}
		else {
			balance += amount;
			return true;
		}
		
	}
	
	
	/*
	 * 지갑에 금액을 뺴기 - 지출
	 */
	public boolean spend(int amount) {
		if (amount < 0 || amount > balance) {
			return false;
		}
		else {
			balance -= amount;
			return true;
		}
		
	}
	
	
	/*
	 * 지갑의 금액을 가져옴.
	 */
	public int getBalance() {
		return balance;
	}
	
	
	
	// test
	/*
	public static void main(String[] args) {
		PurseModel p = new PurseModel();
		System.out.println(p.earn(5000));
		System.out.println(p.getBalance());
	}
	*/

	
}
