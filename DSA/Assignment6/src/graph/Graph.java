package graph;

import java.util.List;
import java.util.Set;

/**
 * Interface to represent a Graph
 *
 */
public interface Graph {

	/**
	 * Function to check if graph is connected
	 * @return true if connected or false otherwise
	 */
	public boolean isConnected();
	
	/**
	 * Function to return set of all vertices reachable from vertex a
	 * @param a
	 * @return Set of all reachable vertices
	 * @throws Exception if vertex a is invalid
	 */
	public Set<Integer> getReachableVertices(int a) throws Exception;
	
	/**
	 * Function to return Minimum Spanning Tree
	 * @return Graph of minimum spanning tree
	 * @throws Exception
	 */
	public Graph getMinimumSpanningTree() throws Exception;
	
	/**
	 * Function to get shortest path from vertex a to b
	 * @param a
	 * @param b
	 * @return List of vertices in order of path
	 * @throws Exception if any of vertices is invalid
	 */
	public List<Integer> getShortestPath(int a, int b) throws Exception;
}
