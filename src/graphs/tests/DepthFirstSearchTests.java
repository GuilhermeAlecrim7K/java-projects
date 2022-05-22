package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import algorithms.DepthFirstSearch;
import types.*;

class DepthFirstSearchTests {

	static File graphConstructor;
	static UnweightedGraph graph;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		graphConstructor = new File("src\\graphs\\graphs-txt\\tinyUG.txt");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		graphConstructor = null;
		graph = null;
	}

	private void dfsUndirectedStartingFromVerticesZeroOneTwoThreeFourFiveSix(UnweightedGraph g, int startingPoint) {
		DepthFirstSearch searcher = new DepthFirstSearch(g, startingPoint);
		for (int i = 0; i < 7; i++)
			if (i != startingPoint)
				assertTrue(searcher.sourceHasPathTo(i));

		for (int i = 7; i < 13; i++)
			assertFalse(searcher.sourceHasPathTo(i));
	}

	@Test
	void dfsUndirectedStartingFromFirstConnectedComponentTests() throws IOException {
		Integer[] vertices = { 0, 1, 2, 3, 4, 5, 6 };
		for (Integer v : vertices) {
			dfsUndirectedStartingFromVerticesZeroOneTwoThreeFourFiveSix(
					new UndirectedUnweightedGraphAsList(graphConstructor), v);
			dfsUndirectedStartingFromVerticesZeroOneTwoThreeFourFiveSix(
					new UndirectedUnweightedGraphAsMatrix(graphConstructor), v);
		}
	}

	private void dfsUndirectedStartingFromVerticesSevenEight(UnweightedGraph g, Integer startingPoint) {
		DepthFirstSearch searcher = new DepthFirstSearch(g, startingPoint);
		for (int i = 7; i < 9; i++)
			if (i != startingPoint)
				assertTrue(searcher.sourceHasPathTo(i));

		Integer[] unreachableVertices = { 0, 1, 2, 3, 4, 5, 6, 9, 10, 11, 12 };
		for (Integer v : unreachableVertices)
			assertFalse(searcher.sourceHasPathTo(v));
	}

	@Test
	void dfsUndirectedStartingFromSecondConnectedComponentTests() throws IOException {
		for (int i = 7; i < 9; i++) {
			dfsUndirectedStartingFromVerticesSevenEight(new UndirectedUnweightedGraphAsList(graphConstructor), i);
			dfsUndirectedStartingFromVerticesSevenEight(new UndirectedUnweightedGraphAsMatrix(graphConstructor), i);
		}
	}

	private void dfsUndirectedStartingFromVerticesNineTenElevenTwelve(UnweightedGraph g, int startingPoint) {
		DepthFirstSearch searcher = new DepthFirstSearch(g, startingPoint);
		for (int i = 0; i < 9; i++)
			assertFalse(searcher.sourceHasPathTo(i));

		for (int i = 9; i < 13; i++)
			if (i != startingPoint)
				assertTrue(searcher.sourceHasPathTo(i));
	}

	@Test
	void dfsUndirectedStartingFromThirdConnectedComponentTests() throws IOException {
		for (int i = 9; i < 13; i++) {
			dfsUndirectedStartingFromVerticesNineTenElevenTwelve(new UndirectedUnweightedGraphAsList(graphConstructor),
					i);
			dfsUndirectedStartingFromVerticesNineTenElevenTwelve(
					new UndirectedUnweightedGraphAsMatrix(graphConstructor), i);
		}
	}

	private void dfsDirectedStartingFromVerticesOneTwoThreeEightTenTwelve(UnweightedGraph g, int startingPoint) {
		DepthFirstSearch searcher = new DepthFirstSearch(g, startingPoint);
		for (int i = 0; i < 13; i++)
			if (i != startingPoint)
				assertFalse(searcher.sourceHasPathTo(i));
	}

	@Test
	void dfsDirectedStartingWithVerticesWithZeroOutDegreeTests() throws IOException {
		Integer[] vertices = { 1, 2, 3, 8, 10, 12 };
		for (Integer v : vertices) {
			dfsDirectedStartingFromVerticesOneTwoThreeEightTenTwelve(
					new DirectedUnweightedGraphAsList(graphConstructor), v);
			dfsDirectedStartingFromVerticesOneTwoThreeEightTenTwelve(
					new DirectedUnweightedGraphAsMatrix(graphConstructor), v);
		}
	}

	private void dfsDirectedTests(UnweightedGraph g, int startingPoint, int[] reachable, int[] unreachable) {
		DepthFirstSearch searcher = new DepthFirstSearch(g, startingPoint);

		for (int v : reachable) {
			if (v != startingPoint)
				assertTrue(searcher.sourceHasPathTo(v));
		}

		for (int v : unreachable) {
			assertFalse(searcher.sourceHasPathTo(v));
		}
	}

	@Test
	void dfsDirectedStartingFromVertexZero() throws IOException {
		UnweightedGraph gl = new DirectedUnweightedGraphAsList(graphConstructor);
		UnweightedGraph gm = new DirectedUnweightedGraphAsMatrix(graphConstructor);

		int[] reachable = { 0, 1, 2, 3, 4, 5, 6 };
		int[] unreachable = { 7, 8, 9, 10, 11, 12 };
		dfsDirectedTests(gl, 0, reachable, unreachable);
		dfsDirectedTests(gm, 0, reachable, unreachable);
	}

	@Test
	void dfsDirectedStartingFromVertexFive() throws IOException {
		UnweightedGraph gl = new DirectedUnweightedGraphAsList(graphConstructor);
		UnweightedGraph gm = new DirectedUnweightedGraphAsMatrix(graphConstructor);

		int[] reachable = { 3, 4, 5 };
		int[] unreachable = { 0, 1, 2, 6, 7, 8, 9, 10, 11, 12 };
		dfsDirectedTests(gl, 5, reachable, unreachable);
		dfsDirectedTests(gm, 5, reachable, unreachable);
	}

	@Test
	void dfsDirectedStartingFromVertexSix() throws IOException {
		UnweightedGraph gl = new DirectedUnweightedGraphAsList(graphConstructor);
		UnweightedGraph gm = new DirectedUnweightedGraphAsMatrix(graphConstructor);

		int[] reachable = { 3, 4, 6 };
		int[] unreachable = { 0, 1, 2, 5, 7, 8, 9, 10, 11, 12 };
		dfsDirectedTests(gl, 6, reachable, unreachable);
		dfsDirectedTests(gm, 6, reachable, unreachable);
	}

	@Test
	void dfsDirectedStartingFromVertexSeven() throws IOException {
		UnweightedGraph gl = new DirectedUnweightedGraphAsList(graphConstructor);
		UnweightedGraph gm = new DirectedUnweightedGraphAsMatrix(graphConstructor);

		int[] reachable = { 7, 8 };
		int[] unreachable = { 0, 1, 2, 3, 4, 5, 6, 9, 10, 11, 12 };
		dfsDirectedTests(gl, 7, reachable, unreachable);
		dfsDirectedTests(gm, 7, reachable, unreachable);
	}

	@Test
	void dfsDirectedStartingFromVertexNine() throws IOException {
		UnweightedGraph gl = new DirectedUnweightedGraphAsList(graphConstructor);
		UnweightedGraph gm = new DirectedUnweightedGraphAsMatrix(graphConstructor);

		int[] reachable = { 9, 10, 11, 12 };
		int[] unreachable = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		dfsDirectedTests(gl, 9, reachable, unreachable);
		dfsDirectedTests(gm, 9, reachable, unreachable);
	}

	@Test
	void dfsDirectedStartingFromVertexEleven() throws IOException {
		UnweightedGraph gl = new DirectedUnweightedGraphAsList(graphConstructor);
		UnweightedGraph gm = new DirectedUnweightedGraphAsMatrix(graphConstructor);

		int[] reachable = { 11, 12 };
		int[] unreachable = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		dfsDirectedTests(gl, 11, reachable, unreachable);
		dfsDirectedTests(gm, 11, reachable, unreachable);
	}

	@Test
	void dfsOnMediumConnectedGraph() throws Exception {
		
		File f = new File("src\\graphs\\graphs-txt\\mediumUG.txt");
		UnweightedGraph g = new UndirectedUnweightedGraphAsList(f);
		DepthFirstSearch searcher = new DepthFirstSearch(g, 0);
		
		for (int i = 1; i < g.getNumberOfVertices(); i++) {
			assertTrue(searcher.sourceHasPathTo(i));
		}
	}

}
