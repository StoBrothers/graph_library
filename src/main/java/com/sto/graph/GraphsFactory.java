package com.sto.graph;

public class GraphsFactory<T> {

	public Graph<T> createUndirectedGraph() {
		return new GraphImpl<T>(GraphType.UNDIRECTED); 
	};
	
	public Graph<T> createDirectedGraph() {
		return new GraphImpl<T>(GraphType.DIRECTED);
	};

}
