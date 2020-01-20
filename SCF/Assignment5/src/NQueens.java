/*
 * Implement N Queens Problem using Recursion
 * The N Queen is the problem of placing N chess queens on an N×N chessboard so
 * that no two queens attack each other. (Thus, a solution requires that no
 * two queens share the same row, column, or diagonal)
 * 
 * @author Priyansh 
 */
public class NQueens {
	/*
	 * @param dimension is the no. of Queens to be placed on N*N matrix
	 * 
	 * @return returns True if solution exist else returns false
	 */
	public static Boolean solveNQueens(int dimension) throws Exception {
		if(dimension==0){
			throw new Exception("Zero no. of Queens");
		}
		int board[][] = new int[dimension][dimension];

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				board[i][j] = 0;
			}
		}

		if (!solveNQueensUtil(board, 0, dimension)) {
			System.out.println("Unable to solve");
			return false;
		}
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		return true;
	}

	/*
	 * @param board is a dimension*dimension matrix @param col is a column index taken to
	 * calculate safe position
	 * 
	 * @return returns True if queen position is correct for column col else
	 * returns false
	 */
	private static Boolean solveNQueensUtil(int[][] board, int row,
			int dimension) {
		if (row >= dimension) {
			return true;
		}
		for (int i = 0; i < dimension; i++) {
			if (isSafe(board, row, i, dimension)) {
				board[row][i] = 1;
				if (solveNQueensUtil(board, row + 1, dimension)) {
					return true;
				}
				board[row][i] = 0;
			}
		}
		return false;
	}

	/*
	 * @param board is a dimension*dimension matrix @param col and row are column and row index
	 * taken to check safe position
	 * 
	 * @return returns True if queen position safe for particular column and row
	 * else returns false
	 */
	private static Boolean isSafe(int[][] board, int row, int col, int dimension) {
		for (int i = row - 1; i >= 0; i--) {
			if (board[i][col] == 1) {
				return false;
			}
		}

		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		for (int i = row - 1, j = col + 1; i >= 0 && j < dimension; i--, j++) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}
};