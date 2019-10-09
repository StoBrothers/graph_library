package com.sto.graph;

import java.util.List;

public interface Graph <T> {
	
	/** Adds vertex to the graph.
	 * 
	 * @param vertex vertex for add to the graph
	 */
	void addVertex(Vertex<T> vertex);

	/**
	 * Adds edge to the graph.
	 * 
	 * @param edge edge for add to the graph.
	 */
	void addEdge(Edge<T> edge);

	/**
	 * Get list of edges between 2 vertices (startVertex and endVertex).
	 *  
	 * @param startVertex start.
	 * @param endVertex end. 
	 * @return List of Edges between 2 vertices.
	 */
	List<Edge<T>> getPath(Vertex<T> startVertex, Vertex<T> endVertex);
	

}
