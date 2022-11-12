package slidePuzzle_GUI;

import java.util.*;

public class SlidePuzzleBoard {

    private PuzzlePiece[][] board;
    // 빈칸의 좌표
    private int empty_row;
    private int empty_col;
    // representation invariant: board[empty_row][empty_col] == null

    // 게임의 실행을 알려주는 실행 필드변수 | on
    private boolean on = false;

    
    // SlidePuzzleBoard 생성 메소드
    public SlidePuzzleBoard() {
    	// 4 x 4 보드 만들기
        board = new PuzzlePiece[4][4];
        // 퍼즐 조각 1~15를 보드에 순서대로 끼우기
        int number = 1;
        for (int row = 0; row < 4; row++)
            for (int col = 0; col < 4; col++) {
                if (col != 3 || row != 3) {
                    board[row][col] = new PuzzlePiece(number);
                    number += 1;
                } else {
                    board[3][3] = null;
                    empty_row = 3;
                    empty_col = 3;
                }
            }
    }

    /** getPuzzlePiece - 퍼즐 조각을 리턴
     * @param row - 가로줄 인덱스
     * @param col - 세로줄 인덱스
     * @return 퍼즐 조각  */
    public PuzzlePiece getPuzzlePiece(int row, int col) {
        return board[row][col];
    }

    /** on - 게임이 진행중인지 점검하는 함수
     * @return 게임이 진행중이면 true, 아니면 false  */
    public boolean on() {
        return on;
    }

    /** 이동이 가능하면, 퍼즐 조각을 빈칸으로 이동
     * @param w - 이동하기 원하는 퍼즐 조각
     * @return 이동 성공하면 true를 리턴하고, 이동이 불가능하면 false를 리턴 */
    public boolean move(int w) {
        int row, col; // w의 위치
        // 빈칸에 주변에서 w의 위치를 찾음
        if (found(w, empty_row - 1, empty_col)) {
            row = empty_row - 1;
            col = empty_col;
        }
        else if (found(w, empty_row + 1, empty_col)) {
            row = empty_row + 1;
            col = empty_col;
        }
        else if (found(w, empty_row, empty_col - 1)) {
            row = empty_row;
            col = empty_col - 1;
        }
        else if (found(w, empty_row, empty_col + 1)) {
            row = empty_row;
            col = empty_col + 1;
        }
        else
            return false;
        // w를 빈칸에 복사
        board[empty_row][empty_col] = board[row][col];
        // 빈칸 위치를 새로 설정하고, w를 제거
        empty_row = row;
        empty_col = col;
        board[empty_row][empty_col] = null;
        return true;
    }

    /** found - board[row][col]에 퍼즐 조각 v가 있는지 확인  
     * @param v - 확인할 수
     * @param row - 보드의 가로줄 인덱스
     * @param col - 보드의 세로줄 인덱스
     * @return 있으면 true, 없으면 false */
    private boolean found(int v, int row, int col) {
        if (row >= 0 && row <= 3 && col >= 0 && col <= 3)
            return board[row][col].face() == v;
        else
            return false;
    }

    /** createPuzzleBoard - 퍼즐 게임 초기 보드 생성 */
    public void createPuzzleBoard() {
    	
    	// 0 ~ 14까지의 수를 랜덤으로 배치
        int[] numbers = generateRandomPermutation(15);
        int i = 0;
        for (int row = 0; row < 4; row++)
            for (int col = 0; col < 4; col++) {
            	if(row != 3 || col != 3) {
                	board[row][col] = new PuzzlePiece(numbers[i] + 1);
                	i += 1;
            	}
            	else {
            		board[row][col] = null;
            		empty_row = 3;
            		empty_col = 3;
            	}

            }
        
        // 슬라이드 보드판이 생성되면서, 게임 상태를 실행 중으로 할당
        on = true;
    }
    


    /** generateRandomPermutation - 0~n-1 범위의 정수 수열을 무작위로 섞은 배열을 리턴 한다.
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

    
    /** gameOver - 퍼즐 게임이 끝났는지를 확인  
     * @return 목표를 달성했으면 true, 아직 더 진행해야 하면 false
     */
    public boolean gameOver() {
    	if (empty_row != 3 || empty_col != 3) {
    		return false;
    	}
    	else {
    		int number = 1;
            for (int row = 0; row < 4; row++) {
            	for (int col = 0; col < 4; col++) {
            		// 마지막 영역 4행 4열에 이르면, 게임종료 | for문으로 규칙을 배정해둠.
            		if (row != 3 || col != 3) {
                		if(board[row][col].face() != number) {
                			return false;
                		}
                		else {
                			number += 1;
                		}
            		}
            	}
            	
            }
            on = false;
            return true;
            
	}


    }
}