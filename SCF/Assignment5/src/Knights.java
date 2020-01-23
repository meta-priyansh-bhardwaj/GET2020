/**
 * A knight's tour is a sequence of moves of a
 * knight on a chessboard such that the knight visits every square only once. If
 * the knight ends on a square that is one knight's move from the beginning
 * square (so that it could tour the board again immediately, following the same
 * path), the tour is closed, otherwise it is open.
 * 
 * @author Priyansh
 *
 */
public class Knights {
	/**
	 * 
	 * @param N is the no. of Queens to be placed on N*N matrix
	 * @return True if solution exist else returns false
	 * @throws Exception if dimension is too short
	 */
	public static Boolean solveKnights(int N) throws Exception {
		if (N < 4) {
			throw new Exception("Too short dimension");
		}
		int[][] board = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = 0;
			}
		}

		int[] xMove = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] yMove = { -1, -2, -2, -1, 1, 2, 2, 1 };

		board[0][0] = 1;
		if (solveKnightsUtil(N, board, 0, 0, xMove, yMove)) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			return true;
		}
		System.out.println("No solution found");
		return false;
	}

	/**
	 * A recursive utility function to solve Knight Tour problem
	 * 
	 * @param N dimension is the no. of Queens to be placed on N*N matrix
	 * @param board board is a dimension*dimension matrix @param col is a column index taken to
	 * calculate safe position
	 * @param x current abscissa on the board
	 * @param y current ordinate on the board
	 * @param xMove the array of moves on x-coordinate
	 * @param yMove the array of moves on y-coordinate
	 * @return True if solution exist else returns false
	 */
	private static Boolean solveKnightsUtil(int N, int[][] board, int x, int y,
			int[] xMove, int[] yMove) {
		if (board[x][y] == N * N) {
			return true;
		}
		for (int i = 0; i < xMove.length; i++) {
			int nextX = x + xMove[i], nextY = y + yMove[i];
			if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N
					&& board[nextX][nextY] == 0) {
				board[nextX][nextY] = board[x][y] + 1;
				if (solveKnightsUtil(N, board, nextX, nextY, xMove, yMove)) {
					return true;
				}
				board[nextX][nextY] = 0;
			}
		}
		return false;
	}

	public static void main(String args[]) throws Exception {
		int dimension = 6;
		solveKnights(dimension);
	}
}
