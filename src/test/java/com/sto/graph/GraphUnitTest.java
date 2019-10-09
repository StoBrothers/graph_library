package com.sto.graph;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GraphUnitTest {

	private static Logger logger = LoggerFactory.getLogger(GraphUnitTest.class);

	@Test
	public void testUndirectedGraph_when_expected_path_thenPrintPath_ver1() {

		logger.debug("Test undirected graph and checking expected result path version 1");

		List<Vertex<String>> vertexes = TestUtil.createVertexes();

		Graph<String> graph = TestUtil.createUndirectedGraph(vertexes);

		List<Edge<String>> resultList = graph.getPath(vertexes.get(11), vertexes.get(5));
		List<Edge<String>> expectedList = new ArrayList<>(6);

		expectedList.add(new Edge<String>(new Vertex<>("11"), new Vertex<>("10")));
		expectedList.add(new Edge<String>(new Vertex<>("10"), new Vertex<>("9")));
		expectedList.add(new Edge<String>(new Vertex<>("9"), new Vertex<>("6")));
		expectedList.add(new Edge<String>(new Vertex<>("6"), new Vertex<>("3")));
		expectedList.add(new Edge<String>(new Vertex<>("3"), new Vertex<>("4")));
		expectedList.add(new Edge<String>(new Vertex<>("4"), new Vertex<>("5")));

		logger.debug("Result path:" + resultList.toString());

		assertArrayEquals(expectedList.toArray(), resultList.toArray());

	}

	@Test
	public void testDirectedGraph_when_expected_path_thenPrintPath_ver1() {
		logger.debug("Test directed graph and checking expected result path version 1");

		List<Vertex<String>> vertexes = TestUtil.createVertexes();
		Graph<String> graph = TestUtil.createDirectedGraph(vertexes);
		List<Edge<String>> resultList = graph.getPath(vertexes.get(0), vertexes.get(11));
		List<Edge<String>> expectedList = new ArrayList<>(6);

		expectedList.add(new Edge<String>(new Vertex<>("0"), new Vertex<>("1")));
		expectedList.add(new Edge<String>(new Vertex<>("1"), new Vertex<>("2")));
		expectedList.add(new Edge<String>(new Vertex<>("2"), new Vertex<>("3")));
		expectedList.add(new Edge<String>(new Vertex<>("3"), new Vertex<>("4")));
		expectedList.add(new Edge<String>(new Vertex<>("4"), new Vertex<>("6")));
		expectedList.add(new Edge<String>(new Vertex<>("6"), new Vertex<>("9")));
		expectedList.add(new Edge<String>(new Vertex<>("9"), new Vertex<>("10")));
		expectedList.add(new Edge<String>(new Vertex<>("10"), new Vertex<>("11")));

		logger.debug("Result path:" + resultList.toString());

		assertArrayEquals(expectedList.toArray(), resultList.toArray());

	}

	@Test
	public void testUndirectedGraph_when_expected_path_thenPrintPath_ver2() {

		logger.debug("Test undirected graph and checking expected result path version 2");

		List<Vertex<String>> vertexes = TestUtil.createVertexes();

		Graph<String> graph = TestUtil.createUndirectedGraph(vertexes);

		List<Edge<String>> resultList = graph.getPath(vertexes.get(11), vertexes.get(5));
		List<Edge<String>> expectedList = new ArrayList<>(6);

		expectedList.add(new Edge<String>(new Vertex<>("11"), new Vertex<>("10")));
		expectedList.add(new Edge<String>(new Vertex<>("10"), new Vertex<>("9")));
		expectedList.add(new Edge<String>(new Vertex<>("9"), new Vertex<>("6")));
		expectedList.add(new Edge<String>(new Vertex<>("6"), new Vertex<>("3")));
		expectedList.add(new Edge<String>(new Vertex<>("3"), new Vertex<>("4")));
		expectedList.add(new Edge<String>(new Vertex<>("4"), new Vertex<>("5")));

		logger.debug("Result path:" + resultList.toString());

		assertArrayEquals(expectedList.toArray(), resultList.toArray());

	}

	@Test
	public void testDirectedGraph_when_path_is_not_existed_thenPrintPath_ver2() {
		logger.debug("Test directed graph and checking expected result path version 2");

		List<Vertex<String>> vertexes = TestUtil.createVertexes();
		Graph<String> graph = TestUtil.createDirectedGraph(vertexes);
		List<Edge<String>> resultList = graph.getPath(vertexes.get(14), vertexes.get(8));
		List<Edge<String>> expectedList = new ArrayList<>(6);

		expectedList.add(new Edge<String>(new Vertex<>("0"), new Vertex<>("1")));
		expectedList.add(new Edge<String>(new Vertex<>("1"), new Vertex<>("2")));
		expectedList.add(new Edge<String>(new Vertex<>("2"), new Vertex<>("3")));
		expectedList.add(new Edge<String>(new Vertex<>("3"), new Vertex<>("4")));
		expectedList.add(new Edge<String>(new Vertex<>("4"), new Vertex<>("6")));
		expectedList.add(new Edge<String>(new Vertex<>("6"), new Vertex<>("9")));
		expectedList.add(new Edge<String>(new Vertex<>("9"), new Vertex<>("10")));
		expectedList.add(new Edge<String>(new Vertex<>("10"), new Vertex<>("11")));

		logger.debug("Result path:" + resultList.toString());

		assertTrue(resultList.size() == 0);

	}

	@Test
	public void testDirectedGraph_when_expected_path_thenPrintAllValues_ver2() {
		logger.debug("Test directed graph and checking expected result path version 2");

		List<Vertex<String>> vertexes = TestUtil.createVertexes();
		Graph<String> graph = TestUtil.createDirectedGraph(vertexes);
		List<Edge<String>> resultList = graph.getPath(vertexes.get(2), vertexes.get(9));
		List<Edge<String>> expectedList = new ArrayList<>(6);

		expectedList.add(new Edge<String>(new Vertex<>("2"), new Vertex<>("3")));
		expectedList.add(new Edge<String>(new Vertex<>("3"), new Vertex<>("4")));
		expectedList.add(new Edge<String>(new Vertex<>("4"), new Vertex<>("6")));
		expectedList.add(new Edge<String>(new Vertex<>("6"), new Vertex<>("9")));

		logger.debug("Result path:" + resultList.toString());

		assertArrayEquals(expectedList.toArray(), resultList.toArray());

	}

	@Test
	public void testUndirectedGraph_when_edge_not_existed() {
		logger.debug("Test Undirected graph and checking expected result path is not existed");

		List<Vertex<String>> vertexes = TestUtil.createVertexes();
		Vertex<String> unAvailableVertex = new Vertex<>("-99");
		vertexes.add(unAvailableVertex);

		Graph<String> graph = TestUtil.createUndirectedGraph(vertexes);
		List<Edge<String>> resultList = graph.getPath(unAvailableVertex, vertexes.get(5));

		assertTrue(resultList.size() == 0);

		resultList = graph.getPath(vertexes.get(5), unAvailableVertex);

		logger.debug("Result path:" + resultList.toString());

		assertTrue(resultList.size() == 0);

	}

	@Test
	public void testDirectedGraph_when_path_not__existed_thenPrintAllValues() {
		logger.debug("Test Undirected graph and checking expected result path is not existed");

		List<Vertex<String>> vertexes = TestUtil.createVertexes();
		Vertex<String> unAvailableVertex = new Vertex<>("-99");
		vertexes.add(unAvailableVertex);

		Graph<String> graph = TestUtil.createDirectedGraph(vertexes);
		List<Edge<String>> resultList = graph.getPath(unAvailableVertex, vertexes.get(5));

		logger.debug("Result path:" + resultList.toString());

		assertTrue(resultList.size() == 0);

	}

}
