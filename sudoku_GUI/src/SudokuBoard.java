import java.util.Random;

// 스도쿠 보드판 생성 & 관리
public class SudokuBoard {
	
	private int [][] sudokuBoard_solution;
	private int [][] sudokuBoard_gameBoard;
	private int hole_count;
	
	private boolean on;
	
	// 생성 메소드
	public SudokuBoard(int count) {
		sudokuBoard_solution = new int [9][9];
		sudokuBoard_gameBoard = new int [9][9];
		
		// 스도쿠 보드 생성 [정답 보드 & 스도쿠 게임 보드]
		createSolutionBoard();
		createPuzzleBoard(count);
		// 난이도에 따른 스도쿠 빈칸 갯수
		hole_count = count;
		
		// 게임 처음시작
		on = true;
		
	}
	
    /*
     * Return 메서드
     */
    /** 퍼즐 보드 배열을 리턴 한다. (겜 근황 출력)
     *
     * @return 퍼즐 보드 배열
     */
	
	/*
	 * 	스도쿠 게임 보드판 한조각씩 가져오는 메소드
	 */
    public int getPuzzleBoard(int row, int col) {
        return sudokuBoard_gameBoard[row][col];
    }

    /** 빈칸의 개수를 리턴 한다. (겜 종료)
     *
     * @return 빈칸의 개수
     */
    public int countHoles() {
        return hole_count;
    }
    
    private void createSolutionBoard() {
        // 1~9 범위의 무작위 시퀀스 {n1,n2,n3,n4,n5,n6,n7,n8,n9}를 만들고,
        // 이를 문서에 첨부한 그림 1과 같이 solution 배열에 배치 한다.
    	
    	
    	// 일반 스도쿠 퍼즐보드 판 생성 - 스도쿠 형성 구조를 구글링 ㅎ 해서 반복구간 알아냄 ㅎㅎ
    	int [] arr_num = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    	// 1행 시작
    	for(int i = 0; i <= 2; i++) {
    		for(int j = 0; j <=8 ; j++) {
    			
    			// 1
    			if (i == 1 && j < 6) {
    				sudokuBoard_solution[i][j] = sudokuBoard_solution[0][j+3];
    			}
    			else if (i == 1 && j >= 6) {
    				sudokuBoard_solution[i][j] = sudokuBoard_solution[0][j-6];
    			}
    			
    			// 2
    			else if (i == 2 && j < 3) {
    				sudokuBoard_solution[i][j] = sudokuBoard_solution[0][j+6];
    			}
    			else if (i == 2 && j >= 3) {
    				sudokuBoard_solution[i][j] = sudokuBoard_solution[0][j-3];
    			}
    			
    			else {
    				sudokuBoard_solution[i][j] = arr_num[j];
    			}
    		}
    	}
    	
    	
    	int [] arr_num_2 = {2, 3, 1, 5, 6, 4, 8, 9, 7};
    	// 3행 시작
    	for(int i = 3; i <= 5; i++) {
    		for(int j = 0; j <=8 ; j++) {
    			
    			// 1
    			if (i == 4 && j < 6) {
    				sudokuBoard_solution[i][j] = sudokuBoard_solution[3][j+3];
    			}
    			else if (i == 4 && j >= 6) {
    				sudokuBoard_solution[i][j] = sudokuBoard_solution[3][j-6];
    			}
    			
    			// 2
    			else if (i == 5 && j < 3) {
    				sudokuBoard_solution[i][j] = sudokuBoard_solution[3][j+6];
    			}
    			else if (i == 5 && j >= 3) {
    				sudokuBoard_solution[i][j] = sudokuBoard_solution[3][j-3];
    			}
    			
    			else {
    				sudokuBoard_solution[i][j] = arr_num_2[j];
    			}
    		}
    	}
    	
    	
    	int [] arr_num_3 = {3, 1, 2, 6, 4, 5, 9, 7, 8};
    	// 4행 시
    	for(int i = 6; i <= 8; i++) {
    		for(int j = 0; j <=8 ; j++) {
    			
    			// 1
    			if (i == 7 && j < 6) {
    				sudokuBoard_solution[i][j] = sudokuBoard_solution[6][j+3];
    			}
    			else if (i == 7 && j >= 6) {
    				sudokuBoard_solution[i][j] = sudokuBoard_solution[6][j-6];
    			}
    			
    			// 2
    			else if (i == 8 && j < 3) {
    				sudokuBoard_solution[i][j] = sudokuBoard_solution[6][j+6];
    			}
    			else if (i == 8 && j >= 3) {
    				sudokuBoard_solution[i][j] = sudokuBoard_solution[6][j-3];
    			}
    			
    			else {
    				sudokuBoard_solution[i][j] = arr_num_3[j];
    			}
    		}
    	}

        // 문서에 첨부한 그림 2와 같이 가로줄 바꾸기와 세로줄 바꾸기를 무작위로 한다.
        // 무작위로 줄 바꾸기를 한다는 말은 바꿀지 말지를 무작위로 결정한다는 의미이다.
        // 가로줄 바꾸기
        shuffleRibbons();
        
        // 세로줄 바꾸기
        transpose();
        shuffleRibbons();
        transpose();
        // 테스트용 메소드
//        showBoard(solution);

        // 스도쿠 게임판 테스트용 메소드
//        showBoard(puzzle_board);
    }
    
    
    
    /** 0~n-1 범위의 정수 수열을 무작위로 섞은 배열을 리턴 한다.
    *
    * @param n - 수열의 길이
    * @return 0~n-1 범위의 정수를 무작위로 섞어 만든 배열
    */
   private int[] generateRandomPermutation(int n) {
       Random random = new Random();
       int[] permutation = new int[n];
       for (int i = 0; i < n; i++) {
           int d = random.nextInt(i+1);
           permutation[i] = permutation[d];
           permutation[d] = i;
       }
       return permutation;
   }

   
   
   
   /** 문서에 첨부한 그림 2와 같은 전략으로 solution 배열의 가로줄을 무작위로 섞는다. */
   private void shuffleRibbons() {
       int[][] shuffled = new int[9][9];
       int[] random_index;
       for (int i = 0; i < 3; i++) {
           random_index = generateRandomPermutation(3);
           for (int j = 0; j < 3; j++)
               shuffled[i*3+random_index[j]] = sudokuBoard_solution[i*3+j];
       }
       sudokuBoard_solution = shuffled;
   }

   
   
   /** solution 배열의 행과 열을 바꾼다. */
   private void transpose() {
       int[][] transposed = new int[9][9];
       for (int i = 0; i < 9; i++)
           for (int j = 0; j < 9; j++)
               transposed[i][j] = sudokuBoard_solution[j][i];
       sudokuBoard_solution = transposed;
   }

   
   
   /** 2차원 배열 b를 콘솔 윈도우에 보여준다. (테스트용 메소드)
    *
    * @param b - 2차원 배열
    */
   public void showBoard(int[][] b) {
       System.out.println("스도쿠 보드");
       for (int i = 0; i < 9; i++) {
           for (int j = 0; j < 9; j++)
               System.out.print(b[i][j] + " ");
           System.out.println();
       }
   }
   
   
   /*
    * TO DO 2.
    */
   // [배점 = 0.5/2.0]
   /** solution 배열에서 count 만큼 무작위로 빈칸을 채워 puzzle_board 배열을 만들어 리턴한다.
    *  
    * @param count - 빈칸의 개수
    */
   private void createPuzzleBoard(int count) {
   
   	// 답지 복제
   	// 2차원 배열 복제 - 2차원은 다르게 복제해야댐 ㅎㅎ
       for(int i=0; i<sudokuBoard_gameBoard.length; i++){
           System.arraycopy(sudokuBoard_solution[i], 0, sudokuBoard_gameBoard[i], 0, sudokuBoard_solution[0].length);
       }
   	
       // solution 보드를 그대로 puzzle_board에 복제한다.

   	
       // 무작위로 빈칸을 선정한다. 빈칸은 구별을 위해서 0으로 채운다.
       // new Random().nextInt(n) 메소드를 호출하면
       // 0~n-1 범위의 정수 중에서 무작위로 하나를 고를 수 있다.
   	for (int i = 1; i <= count; i ++) {
   		
   		// nextInt의 범위는 0 ~ 입력값 - 1이다.
   		int hole_low = new Random().nextInt(9);
   		int hole_col = new Random().nextInt(9);
   		System.out.println(hole_low);
   		
   		if(sudokuBoard_gameBoard[hole_low][hole_col] != 0) {
   			sudokuBoard_gameBoard[hole_low][hole_col] = 0;   
   		}
   		else {
   			i = i - 1;
   		}
   	}

   }
   
   
   

   // 게임 진행 시 스도 보드 업데이트 & 게임 종료 Check
   /*
    * TO DO 3.
    */
   // [배점 0.5/2.0]
   /** row번 가로줄, col번 세로줄에 digit을 채울 수 있는지 검사하여,
    *  가능하면 채우고 true를 리턴하고, 불가능하면 false를 리턴 한다.
    *
    * @param digit - 빈칸에 채울 수 (1~9 중 하나)
    * @param row - 가로줄 번호
    * @param col - 세로줄 번호
    * @return 퍼즐 보드 조건에 만족하여 빈칸을 채웠으면 true, 만족하지 않으면 false
    */
   public boolean check(int digit, int row, int col) {
   	
//   	showBoard(sudokuBoard_gameBoard);
//   	showBoard(sudokuBoard_solution);
   	if(sudokuBoard_gameBoard[row][col] == 0 && sudokuBoard_solution[row][col] == digit) {
   		sudokuBoard_gameBoard[row][col] = digit;
   			hole_count = hole_count - 1;
   			return true;
   	}
   	else {
   		return false;
   	}

   }
   
   public boolean on() {
	   return on;
   }
   
   public void gameOver() {
	   on = false;
   }
   
   /*
    * 	To DO: 스도쿠 정답판의 숫자에 대해서 유효한 지 Check 메소드
    */
   public boolean answer_check(int answer) {
	  for(int row = 0; row < 9; row ++) {
		  for (int col = 0; col < 9; col ++) {
			  if(sudokuBoard_gameBoard[row][col] == 0 && sudokuBoard_solution[row][col] == answer) {
				  return true;
			  }
		  }
	  }
	  return false;
   }
   
}

    
    
	

