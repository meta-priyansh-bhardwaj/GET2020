package graph;

/**
 * Class to represent a Edge having origin, weight and end
 *
 */
public class Edge implements Comparable<Edge> {
	private int from;
	private int to;
	private int weight;

	/**
	 * Constructor to initialize from, to and weight
	 * @param from should be non-negative
	 * @param to should be non-negative
	 * @param weight should be positive
	 * @throws Exception on invalid parameters
	 */
	public Edge(int from, int to, int weight) throws Exception {
		if(from < 0 || to < 0 || weight <= 0) {
			throw new Exception("Invalid values found!");
		}
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	/**
	 * Function to get origin vertex
	 * @return from
	 */
	public int getFrom() {
		return this.from;
	}
	
	/**
	 * Function to get end vertex
	 * @return to
	 */
	public int getTo() {
		return this.to;
	}
	
	/**
	 * Function to get weight
	 * @return weight
	 */
	public int getWeight() {
		return this.weight;
	}

	/**
	 * Function to compare edges based on weights
	 */
	@Override
	public int compareTo(Edge edge) {
		return this.weight - edge.weight;
	}
}
