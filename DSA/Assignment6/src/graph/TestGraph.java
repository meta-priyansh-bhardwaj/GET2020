package graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * Class to test Graph class and its member functions 
 *
 */
public class TestGraph {

	@Test
	public void testGraph1() {
		try {
			List<Edge> edges = new ArrayList<Edge>();
			edges.add(new Edge(0,1,1));
			edges.add(new Edge(0,2,4));
			edges.add(new Edge(1,3,1));
			edges.add(new Edge(1,4,5));
			edges.add(new Edge(2,4,2));
			
			Graph graph = new UndirectedGraph(5, edges);
			assertTrue(graph.isConnected());
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	public void testGraph2() {
		try {
			List<Edge> edges = new ArrayList<Edge>();
			edges.add(new Edge(0,1,1));
			edges.add(new Edge(1,3,1));
			edges.add(new Edge(1,4,5));
			
			Graph graph = new UndirectedGraph(5, edges);
			assertFalse(graph.isConnected());
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
	
	@Test
	public void testGraph3() {
		try {
			List<Edge> edges = new ArrayList<Edge>();
			edges.add(new Edge(0,1,1));
			edges.add(new Edge(0,2,4));
			edges.add(new Edge(1,3,1));
			edges.add(new Edge(1,4,5));
			edges.add(new Edge(2,4,2));
			
			Graph graph = new UndirectedGraph(5, edges);
			Set<Integer> reachable = graph.getReachableVertices(0);
			Set<Integer> expectedResult = new HashSet<Integer>();
			expectedResult.add(0);
			expectedResult.add(1);
			expectedResult.add(2);
			expectedResult.add(3);
			expectedResult.add(4);
			
			assertTrue(expectedResult.equals(reachable));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
	
	@Test
	public void testGraph4() {
		try {
			List<Edge> edges = new ArrayList<Edge>();
			edges.add(new Edge(0,1,1));
			edges.add(new Edge(1,3,1));
			edges.add(new Edge(1,4,5));
			
			Graph graph = new UndirectedGraph(5, edges);
			Set<Integer> reachable = graph.getReachableVertices(0);
			Set<Integer> expectedResult = new HashSet<Integer>();
			expectedResult.add(0);
			expectedResult.add(1);
			expectedResult.add(3);
			expectedResult.add(4);
			
			assertTrue(expectedResult.equals(reachable));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
	
	@Test
	public void testGraph5() {
		try {
			List<Edge> edges = new ArrayList<Edge>();
			edges.add(new Edge(0,1,1));
			edges.add(new Edge(0,2,4));
			edges.add(new Edge(1,3,1));
			edges.add(new Edge(1,4,5));
			edges.add(new Edge(2,4,2));
			
			Graph graph = new UndirectedGraph(5, edges);
			
			List<Edge> expectedEdges = new ArrayList<Edge>();
			expectedEdges.add(new Edge(0,1,1));
			expectedEdges.add(new Edge(0,2,4));
			expectedEdges.add(new Edge(1,3,1));
			expectedEdges.add(new Edge(2,4,2));
			
			assertTrue(new UndirectedGraph(5, expectedEdges).equals(graph.getMinimumSpanningTree()));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testGraph6() {
		try {
			List<Edge> edges = new ArrayList<Edge>();
			edges.add(new Edge(0,1,1));
			edges.add(new Edge(0,2,4));
			edges.add(new Edge(1,3,1));
			edges.add(new Edge(1,4,5));
			edges.add(new Edge(2,4,2));
			
			Graph graph = new UndirectedGraph(5, edges);
			List<Integer> shortestPath = graph.getShortestPath(0, 3);
			List<Integer> expectedResult = new ArrayList<Integer>();
			expectedResult.add(0);
			expectedResult.add(1);
			expectedResult.add(3);
			
			assertTrue(expectedResult.equals(shortestPath));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
}
