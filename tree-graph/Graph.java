//****************************************************************************************
// Author: Tianlong Song
// Name: Graph.java
// Description: Graph represented by adjacency list
// Date created: 02/10/2015
//****************************************************************************************
import java.io.*;
import java.util.*;

class Graph {

	private final int V;
	private Map<Integer,List<Integer>> adj;	

	Graph(int V) {
		this.V = V;
		adj = new HashMap<Integer,List<Integer>>();
		for(int i=0;i<V;i++)
			adj.put(i,new ArrayList<Integer>());	
	}

	// Add a directed edge from s to t
	public void addEdge(int s,int t) {
		if(s>=V||t>=V) {
			System.out.println("Illegal vertex number!");	
		}
		adj.get(s).add(t);
	}

	// DFS traversal
	public void DFS(int start) { // Specify the starting vertex
		// Initilize the status of each vertex to be unvisited (0)
		int [] status = new int[V];
		
		// Start from vertex 0
		DFS_Visit(start,status);	
	}

	public void DFS_Visit(int vertex, int [] status) {
		status[vertex] = 1; // Label the vertex to be discovered
		System.out.println(vertex);
		for(int neighbor: adj.get(vertex)) {
			if(status[neighbor]==0) // Unvisited yet
				DFS_Visit(neighbor,status);
		}	
		status[vertex] = 2; // Label the vertex to be explored	
	}

	// BFS traversal
	public void BFS(int start) { // Specify the starting vertex
		// Initilize the status of each vertex to be unvisited (0)
		int [] status = new int[V];

		Queue<Integer> queue = new LinkedList<Integer>();
		status[start] = 1; // Label the vertex to be discovered
		queue.add(start);
		System.out.println(start);

		while(queue.peek()!=null) {
			int curr = queue.poll();	
			for(int neighbor: adj.get(curr)) {
				if(status[neighbor]==0) { // Unvisited yet
					status[neighbor] = 1;
					queue.add(neighbor);
					System.out.println(neighbor);
				}
			}		
			status[curr] = 2; // Label the vertex to be explored	
		}
	}

	// Reverse the graph with all directed edges reversed
	public Graph reverse() {
		Graph graph = new Graph(V);
		Iterator<Map.Entry<Integer,List<Integer>>> it = adj.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Integer,List<Integer>> pair = it.next();
			for(int neighbor: pair.getValue())
				graph.addEdge(neighbor,pair.getKey());
		}
		return graph;	
	}
}
