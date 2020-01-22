/**
 * Design an immutable class for representing two-dimensional sparse matrices.
 * Note that for space efficiency you should be storing only non zero elements
 * of a matrix.
 * 
 * @author Priyansh
 *
 */
public class SparseMatrix {
	private final int rows, cols;
	private final int[] elements;
	private final int[] rowPosition;
	private final int[] colPosition;

	/**
	 * Constructor that takes raw matrix as parameter
	 * @param matrix
	 * @throws Exception if matrix is null or if any dimension is zero
	 */
	public SparseMatrix(int[][] matrix) throws Exception {
		if (matrix == null) {
			throw new Exception("No matrix found");
		}
		if (matrix.length == 0 || matrix[0].length == 0) {
			throw new Exception("Empty matrix");
		}
		int count = 0;
		rows = matrix.length;
		cols = matrix[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] != 0) {
					count++;
				}
			}
		}

		elements = new int[count];
		rowPosition = new int[count];
		colPosition = new int[count];

		for (int i = 0, index = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] != 0) {
					elements[index] = matrix[i][j];
					rowPosition[index] = i;
					colPosition[index] = j;
					index++;
				}
			}
		}
	}

	/**
	 * This function computes and returns transpose of the matrix
	 * @return transpose of the matrix
	 * @throws Exception
	 * @see #SparseMatrix(int[][])
	 */
	public SparseMatrix transpose() throws Exception {
		int[][] matrix = new int[this.cols][this.rows];
		for (int i = 0; i < elements.length; i++) {
			int row = rowPosition[i];
			int col = colPosition[i];
			matrix[col][row] = elements[i];
		}
		return new SparseMatrix(matrix);
	}

	/**
	 * Checks if the matrix is equal to matrix s
	 * @param s another SparseMatrix
	 * @return true if they are equal or false otherwise
	 */
	public Boolean equals(SparseMatrix s) {
		if (s == null) {
			return false;
		}
		if (this.rows != s.rows || this.cols != s.cols) {
			return false;
		}
		if (this.elements.length != s.elements.length) {
			return false;
		}
		for (int i = 0; i < this.elements.length; i++) {
			if (this.elements[i] != s.elements[i]
					|| this.rowPosition[i] != s.rowPosition[i]
					|| this.colPosition[i] != s.colPosition[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if the matrix is Symmetric
	 * @return true is matrix is symmetric or false otherwise
	 * @throws Exception
	 * @see #transpose
	 */
	public Boolean isSymmetric() throws Exception {
		if (rows != cols) {
			return false;
		}
		return this.equals(this.transpose());
	}

	/**
	 * Prints the matrix as a raw matrix
	 */
	public void print() {
		System.out.println();
		for (int i = 0, index = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == rowPosition[index] && j == colPosition[index]) {
					System.out.print(elements[index++]);
				} else {
					System.out.print("0");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	/**
	 * Adds the matrix to matrix s
	 * @param s another SparseMatrix
	 * @return the matrix after Addition
	 * @throws Exception
	 * @see #SparseMatrix
	 */
	public SparseMatrix addMatrix(SparseMatrix s) throws Exception {
		if (s == null) {
			throw new Exception("Null Sparse Matrix passed");
		}
		if (this.rows != s.rows || this.cols != s.cols) {
			throw new Exception("Unmatched dimensions Exception");
		}
		int[][] matrix = new int[this.rows][this.cols];

		for (int i = 0; i < this.elements.length; i++) {
			int row = this.rowPosition[i], col = this.colPosition[i];
			matrix[row][col] += this.elements[i];
		}
		for (int i = 0; i < s.elements.length; i++) {
			int row = s.rowPosition[i], col = s.colPosition[i];
			matrix[row][col] += s.elements[i];
		}
		return new SparseMatrix(matrix);
	}

	/**
	 * Multiply the matrix to matrix s
	 * @param s another SparseMatrix
	 * @return the matrix after Multiplication
	 * @throws Exception
	 * @see #SparseMatrix
	 */
	public SparseMatrix multiplyMatrix(SparseMatrix s) throws Exception {
		if (s == null) {
			throw new Exception("Null Sparse Matrix passed");
		}
		if (this.cols != s.rows) {
			throw new Exception("Multiplication cannot be performed");
		}
		int[][] matrix = new int[this.rows][s.cols];

		for (int i = 0; i < this.elements.length; i++) {
			for (int j = 0; j < s.elements.length; j++) {
				if (this.colPosition[i] == s.rowPosition[j]) {
					int row = this.rowPosition[i];
					int col = s.colPosition[j];
					matrix[row][col] += this.elements[i] * s.elements[j];
				}
			}
		}
		return new SparseMatrix(matrix);
	}
}
