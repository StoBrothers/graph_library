package com.sto.graph;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestUtil {

	/**
	 * Create vertexes list in range 1-15.
	 * 
	 * @return vertexes list.
	 */
	public static List<Vertex<String>> createVertexes() {
		return IntStream.range(0, 15).mapToObj(t -> new Vertex<String>(String.valueOf(t))).collect(Collectors.toList());
	}	
	
	public static Graph<String> createDirectedGraph(List<Vertex<String>> vertexes) {

		GraphsFactory<String> fabric = new GraphsFactory<>();
		Graph<String> graph = fabric.createDirectedGraph();

		vertexes.stream().forEach(t -> graph.addVertex(t));// adds vertexes into the graph

		graph.addEdge(new Edge<>(vertexes.get(0), vertexes.get(1)));
		graph.addEdge(new Edge<>(vertexes.get(1), vertexes.get(2)));
		graph.addEdge(new Edge<>(vertexes.get(2), vertexes.get(3)));
		graph.addEdge(new Edge<>(vertexes.get(2), vertexes.get(14)));
		graph.addEdge(new Edge<>(vertexes.get(3), vertexes.get(4)));
		graph.addEdge(new Edge<>(vertexes.get(3), vertexes.get(14)));
		graph.addEdge(new Edge<>(vertexes.get(3), vertexes.get(6)));
		graph.addEdge(new Edge<>(vertexes.get(5), vertexes.get(4)));
		graph.addEdge(new Edge<>(vertexes.get(4), vertexes.get(6)));

		graph.addEdge(new Edge<>(vertexes.get(6), vertexes.get(9)));
		graph.addEdge(new Edge<>(vertexes.get(6), vertexes.get(7)));
		graph.addEdge(new Edge<>(vertexes.get(7), vertexes.get(9)));
		graph.addEdge(new Edge<>(vertexes.get(7), vertexes.get(8)));

		graph.addEdge(new Edge<>(vertexes.get(12), vertexes.get(9)));
		graph.addEdge(new Edge<>(vertexes.get(9), vertexes.get(10)));

		graph.addEdge(new Edge<>(vertexes.get(10), vertexes.get(11)));
		graph.addEdge(new Edge<>(vertexes.get(12), vertexes.get(10)));

		graph.addEdge(new Edge<>(vertexes.get(14), vertexes.get(12)));
		graph.addEdge(new Edge<>(vertexes.get(13), vertexes.get(12)));
		graph.addEdge(new Edge<>(vertexes.get(14), vertexes.get(13)));

		return graph;
	}
	

	public static Graph<String> createUndirectedGraph(List<Vertex<String>> vertexes) {

		GraphsFactory<String> fabric = new GraphsFactory<>();
		Graph<String> graph = fabric.createUndirectedGraph();

		vertexes.stream().forEach(t -> graph.addVertex(t));// adds vertexes into the graph

		graph.addEdge(new Edge<>(vertexes.get(0), vertexes.get(1)));
		graph.addEdge(new Edge<>(vertexes.get(1), vertexes.get(2)));
		graph.addEdge(new Edge<>(vertexes.get(2), vertexes.get(3)));
		graph.addEdge(new Edge<>(vertexes.get(2), vertexes.get(14)));
		graph.addEdge(new Edge<>(vertexes.get(3), vertexes.get(4)));
		graph.addEdge(new Edge<>(vertexes.get(3), vertexes.get(14)));
		graph.addEdge(new Edge<>(vertexes.get(3), vertexes.get(6)));
		graph.addEdge(new Edge<>(vertexes.get(4), vertexes.get(5)));
		graph.addEdge(new Edge<>(vertexes.get(4), vertexes.get(6)));

		graph.addEdge(new Edge<>(vertexes.get(6), vertexes.get(9)));
		graph.addEdge(new Edge<>(vertexes.get(6), vertexes.get(7)));
		graph.addEdge(new Edge<>(vertexes.get(7), vertexes.get(9)));
		graph.addEdge(new Edge<>(vertexes.get(7), vertexes.get(8)));

		graph.addEdge(new Edge<>(vertexes.get(9), vertexes.get(12)));
		graph.addEdge(new Edge<>(vertexes.get(9), vertexes.get(10)));

		graph.addEdge(new Edge<>(vertexes.get(10), vertexes.get(11)));
		graph.addEdge(new Edge<>(vertexes.get(10), vertexes.get(12)));

		graph.addEdge(new Edge<>(vertexes.get(12), vertexes.get(14)));
		graph.addEdge(new Edge<>(vertexes.get(13), vertexes.get(14)));
		graph.addEdge(new Edge<>(vertexes.get(13), vertexes.get(12)));

		return graph;
	}
	
}
