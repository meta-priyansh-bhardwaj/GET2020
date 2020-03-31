package graph;

/**
 * Class to represent a vertex so that it
 * 	can be compared based on a constraint(distance from source vertex)
 * Required for priority queue (used in Dijkstra algorithm)
 *
 */
public class Vertex implements Comparable<Vertex> {
	private int index;
	private int constraint;

	/**
	 * Constructor to initialize index and constraint
	 * @param index
	 * @param constraint
	 */
	public Vertex(int index, int constraint) {
		this.index = index;
		this.constraint = constraint;
	}

	/**
	 * Function to get index
	 * @return index
	 */
	public int getIndex() {
		return this.index;
	}

	/**
	 * Function to compare vertices based on contraint
	 */
	@Override
	public int compareTo(Vertex vertex) {
		return this.constraint - vertex.constraint;
	}
}
