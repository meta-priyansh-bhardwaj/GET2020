package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 * Class to represent Undirected Graph that implements Graph
 *
 */
public class UndirectedGraph implements Graph {
	private int noOfVertices;
	private List<Edge> edges;
	private List<List<Integer>> adjList;

	/**
	 * Constructor to initialize noOfVertices, edge list and adjacency list
	 * @param noOfVertices a positive integer
	 * @param edges List of Edge
	 * @throws Exception if noOfVertices or any of vertex is invalid
	 */
	public UndirectedGraph(int noOfVertices, List<Edge> edges) throws Exception {
		this.noOfVertices = noOfVertices;
		this.adjList = new ArrayList<List<Integer>>(this.noOfVertices);
		this.edges = new ArrayList<Edge>(2*edges.size());
		
		for(int i=0;i<this.noOfVertices;i++) {
			this.adjList.add(new ArrayList<Integer>());
		}
		
		for(Edge edge: edges) {
			if(edge.getFrom() >= this.noOfVertices || edge.getTo() >= this.noOfVertices) {
				throw new Exception("Invalid vertex found in edge list");
			}
			this.adjList.get(edge.getFrom()).add(this.edges.size());
			this.edges.add(edge);
			if(edge.getFrom() != edge.getTo()) {
				adjList.get(edge.getTo()).add(this.edges.size());
				this.edges.add(new Edge(edge.getTo(), edge.getFrom(), edge.getWeight()));
			}
		}
	}
	
	/**
	 * Function to check if graph is connected
	 * @return true if connected or false otherwise
	 */
	@Override
	public boolean isConnected() {
		Set<Integer> visited = new HashSet<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		visited.add(0);
		while(!stack.isEmpty()) {
			int vertex = stack.pop();
			for(int edgeIndex: adjList.get(vertex)) {
				int neighbour = edges.get(edgeIndex).getTo();
				if(!visited.contains(neighbour)) {
					stack.push(neighbour);
					visited.add(neighbour);
				}
			}
		}
		return visited.size() == this.noOfVertices;
	}

	/**
	 * Function to return set of all vertices reachable from vertex a
	 * @param a
	 * @return Set of all reachable vertices
	 * @throws Exception if vertex a is invalid
	 */
	@Override
	public Set<Integer> getReachableVertices(int a) throws Exception {
		if(a < 0 || a >= this.noOfVertices) {
			throw new Exception("Invalid vertex!");
		}
		Set<Integer> visited = new HashSet<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		visited.add(a);
		stack.add(a);
		while(!stack.isEmpty()) {
			int vertex = stack.pop();
			for(int edgeIndex: adjList.get(vertex)) {
				int neighbour = edges.get(edgeIndex).getTo();
				if(!visited.contains(neighbour)) {
					stack.push(neighbour);
					visited.add(neighbour);
				}
			}
		}
		return visited;
	}

	/**
	 * Function to return Minimum Spanning Tree
	 * @return Graph of minimum spanning tree
	 * @throws Exception
	 */
	@Override
	public Graph getMinimumSpanningTree() throws Exception {
		if(this.edges.size() == 0) {
			return null;
		}
		Set<Integer> visited = new HashSet<Integer>();
		List<Edge> edges = new ArrayList<Edge>();
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		int shortestEdge = 0;
		for(int i=0;i<this.edges.size();i++) {
			if(this.edges.get(i).getWeight() < this.edges.get(shortestEdge).getWeight()) {
				shortestEdge = i;
			}
		}
		edges.add(this.edges.get(shortestEdge));
		visited.add(this.edges.get(shortestEdge).getFrom());
		visited.add(this.edges.get(shortestEdge).getTo());
		
		for(int edgeIndex: this.adjList.get(this.edges.get(shortestEdge).getFrom())) {
			Edge edge = this.edges.get(edgeIndex);
			queue.add(edge);
		}
		for(int edgeIndex: this.adjList.get(this.edges.get(shortestEdge).getTo())) {
			Edge edge = this.edges.get(edgeIndex);
			queue.add(edge);
		}
		
		while(!queue.isEmpty() && edges.size() < this.noOfVertices-1) {
			Edge edge = queue.poll();
			if(visited.contains(edge.getTo())) {
				continue;
			}
			edges.add(edge);
			visited.add(edge.getTo());
			for(int edgeIndex: this.adjList.get(edge.getTo())) {
				queue.add(this.edges.get(edgeIndex));
			}
		}
		
		return new UndirectedGraph(this.noOfVertices, edges);
	}

	/**
	 * Function to get shortest path from vertex a to b
	 * @param a
	 * @param b
	 * @return List of vertices in order of path
	 * @throws Exception if any of vertices is invalid
	 */
	@Override
	public List<Integer> getShortestPath(int a, int b) throws Exception {
		if(a<0 || a>=this.noOfVertices || b<0 || b>=this.noOfVertices) {
			throw new Exception("Invalid vertex!");
		}
		Set<Integer> visited = new HashSet<Integer>();
		Integer[] distance = new Integer[this.noOfVertices];
		Integer[] previous = new Integer[this.noOfVertices];
		distance[a] = 0;
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		queue.add(new Vertex(a, distance[a]));
		
		while(!queue.isEmpty()) {
			int u = queue.poll().getIndex();
			visited.add(a);
			for(int edgeIndex: this.adjList.get(u)) {
				Edge edge = this.edges.get(edgeIndex);
				int v = edge.getTo();
				if(!visited.contains(v)) {
					if(distance[v]==null || distance[v] > distance[u]+edge.getWeight()) {
						distance[v] = distance[u]+edge.getWeight();
						previous[v] = u;
						queue.add(new Vertex(v, distance[v]));
					}
				}
			}
		}
		List<Integer> path = new ArrayList<Integer>();
		Integer currentVertex = b;
		while(currentVertex != null) {
			path.add(currentVertex);
			currentVertex = previous[currentVertex];
		}
		Collections.reverse(path);
		return path;
	}
	
	/**
	 * Checks equility of two graph checks if all edges present are same or not
	 */
	@Override
	public boolean equals(Object object) {
		if(object==null || this.getClass() != object.getClass()) {
			return false;
		}
		UndirectedGraph graph = (UndirectedGraph)object;
		if(this.noOfVertices != graph.noOfVertices) {
			return false;
		}
		for(int i=0;i<this.noOfVertices;i++) {
			if(this.adjList.get(i).size() != graph.adjList.get(i).size()) {
				return false;
			}
			for(int edgeIndex: this.adjList.get(i)) {
				boolean found = false;
				for(int searchEdge: graph.adjList.get(i)) {
					if(this.edges.get(edgeIndex).getTo() == graph.edges.get(searchEdge).getTo() && this.edges.get(edgeIndex).getWeight() == graph.edges.get(searchEdge).getWeight()) {
						found = true;
						break;
					}
				}
				if(!found) {
					return false;
				}
			}
		}
		return true;
	}
}
