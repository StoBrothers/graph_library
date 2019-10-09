package com.sto.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;

/**
 * Directed and undirected graph implementation.
 * 
 * @author Sergey Stotskiy
 */
final class GraphImpl<T> implements Graph<T> {

	private static Logger logger = LoggerFactory.getLogger(GraphImpl.class);

	@Getter
	private GraphType graphType = GraphType.UNDIRECTED;

	/**
	 * Graph
	 */
	private Map<Vertex<T>, List<Edge<T>>> vertexes = new HashMap<>();

	/**
	 * Constructor.
	 * 
	 * @param graphType - type of Graph.
	 */
	public GraphImpl(final GraphType graphType) {
		this.graphType = graphType;
	}

	@Override
	public void addVertex(final Vertex<T> vertex) {
		this.vertexes.putIfAbsent(vertex, new ArrayList<>());
	}

	@Override
	public void addEdge(final Edge<T> edge) {
		switch (this.graphType) {
		case DIRECTED:
			addDirectedGraphEdge(edge);
			break;
		case UNDIRECTED:
			addUndirectedGraphEdge(edge);
			break;
		}

	}

	/**
	 * Add Edge to directed graph with duplicate check.
	 * 
	 * @param edge
	 */
	private void addDirectedGraphEdge(final Edge<T> edge) {
		List<Edge<T>> edges = this.vertexes.get(edge.getStartVertex());
		if (!edges.contains(edge)) {
			edges.add(edge);
		}
	}

	/**
	 * Add Edge to undirected graph with duplicate check.
	 * 
	 * @param edge
	 */
	private void addUndirectedGraphEdge(final Edge<T> edge) {
		addDirectedGraphEdge(edge);
		List<Edge<T>> edges = this.vertexes.get(edge.getEndVertex());
		if (!edges.contains(edge)) {
			edges.add(new Edge<>(edge.getEndVertex(), edge.getStartVertex()));
		}
	}

	@Override
	public List<Edge<T>> getPath(final Vertex<T> startVertex, final Vertex<T> endVertex) {
		return dfs(startVertex, endVertex);
	}

	private List<Edge<T>> dfs(final Vertex<T> startVertex, final Vertex<T> endVertex) {
		Set<Vertex<T>> visited = new HashSet<>();
		List<Edge<T>> path = new ArrayList<>();
		dfsRecursive(path, startVertex, endVertex, visited);
		Collections.reverse(path);
		return path;
	}

	private boolean dfsRecursive(final List<Edge<T>> path, final Vertex<T> startVertex, final Vertex<T> endVertex,
			final Set<Vertex<T>> visited) {
		visited.add(startVertex);

		logger.debug("Visit:" + startVertex.toString());

		List<Edge<T>> edges = vertexes.get(startVertex);
		for (Edge<T> current : edges) {
			if (!visited.contains(current.getEndVertex())) {

				if (current.getEndVertex().equals(endVertex)) {
					path.add(current);
					return true;
				}

				if (dfsRecursive(path, current.getEndVertex(), endVertex, visited)) {
					path.add(current);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @deprecated
	 * 
	 * @param startEdge
	 * @param function
	 */
	public void traverseFunction(Edge<T> startEdge, Function<Edge<T>, Boolean> function) {
		function.apply(startEdge);
	}

}
