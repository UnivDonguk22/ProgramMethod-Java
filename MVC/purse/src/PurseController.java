public class PurseController {
	
	// Create Field Variable 
	private PurseViewIn input;
	private PurseViewOut outputKorea;
	private PurseViewOut outputJapan;
	private PurseModel purseKorea;
	private PurseModel purseJapan;


	
	/*
	 * Product Method
	 */
	public PurseController(PurseViewIn r, PurseViewOut ok, PurseViewOut oj, PurseModel pk, PurseModel pj) {

		input = r;
		outputKorea = ok;
		outputJapan = oj;
		purseKorea = pk;
		purseJapan = pj;

	}

	
	/*
	 * process Checking and process Start
	 */
	public void processTransactions() {

		String message = "K,J,Q 키 중 하나를 누르고 OK 단추를 누르세요.\n";
		message += "수입 +, 지출 -, 한화 K, 일화 J, 종료 Q";
		
		char request = input.readRequest(message);
		message = "+,- 키 중 하나를 누르고 OK 단추를 누르세요.";

		int amount;
		
		if (request == 'Q' || request == 'q' ) {
			outputKorea.showTransaction("서비스를 마칩니다.");
			return;
		}
		
		
		/*
		 * 		Select Country
		 */
		
		// If input 'K || k'
		else if (request == 'K' || request == 'k') {
			outputKorea.showTransaction("활성");
			outputJapan.showTransaction("비활성");
			
			
			// new input with '+' or '-'
			request = input.readRequest(message);
			
			if (request == '+') {
				message = "금액을 입력하고 OK 단추를 누르세요.";
				amount = input.readAmount(message);
				if (purseKorea.earn(amount))
					outputKorea.showTransaction(amount, "수입");
				else
					outputKorea.showTransaction("수입 실패");
			}
			else if (request == '-') {
				message = "금액을 입력하고 OK 단추를 누르세요.";
				amount = input.readAmount(message);
				if (purseKorea.spend(amount))
					outputKorea.showTransaction(amount, "지출");
				else
					outputKorea.showTransaction("지출 실패");
			}
			else
				outputKorea.showTransaction("요청 오류");
		
			// 프로그램을 지속실행하기
			this.processTransactions();
		}
		
		
		// If input 'J || j'
		else if (request == 'J' || request == 'j') {
			outputKorea.showTransaction("비활성");
			outputJapan.showTransaction("활성");
			
			// new input with '+' or '-'
			request = input.readRequest(message);
			
			
			if (request == '+') {
				message = "금액을 입력하고 OK 단추를 누르세요.";
				amount = input.readAmount(message);
				if (purseJapan.earn(amount))
					outputJapan.showTransaction(amount, "수입");
				else
					outputJapan.showTransaction("수입 실패");
			}
			else if (request == '-') {
				message = "금액을 입력하고 OK 단추를 누르세요.";
				amount = input.readAmount(message);
				if (purseJapan.spend(amount))
					outputJapan.showTransaction(amount, "지출");
				else
					outputJapan.showTransaction("지출 실패");
			}
			else
				outputJapan.showTransaction("요청 오류");
		
			// 프로그램을 지속실행하기
			this.processTransactions();
			
		}
		
		
		// All Invalid input Data
		else {
			outputKorea.showTransaction("입력 데이터를 지정된 타입에 맞게 입력해주세요.");
			this.processTransactions();
		}
	}
}
	
	