package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import algorithms.BreadthFirstSearch;
import types.DirectedUnweightedGraphAsList;
import types.DirectedUnweightedGraphAsMatrix;
import types.UndirectedUnweightedGraphAsList;
import types.UndirectedUnweightedGraphAsMatrix;
import types.UnweightedGraph;

class BreadthFirstSearchTests {

	static File graphConstructor;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		graphConstructor = new File("src\\graphs\\graphs-txt\\tinyUG.txt");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		graphConstructor = null;
	}

	private void bfsUndirectedStartingFromVerticesZeroOneTwoThreeFourFiveSix(UnweightedGraph g, int startingPoint) {
		BreadthFirstSearch searcher = new BreadthFirstSearch(g, startingPoint);
		for (int i = 0; i < 7; i++)
			if (i != startingPoint)
				assertTrue(searcher.sourceHasPathTo(i));

		for (int i = 7; i < 13; i++)
			assertFalse(searcher.sourceHasPathTo(i));
	}

	@Test
	void bfsUndirectedStartingFromFirstConnectedComponentTests() throws IOException {
		Integer[] vertices = { 0, 1, 2, 3, 4, 5, 6 };
		for (Integer v : vertices) {
			bfsUndirectedStartingFromVerticesZeroOneTwoThreeFourFiveSix(
					new UndirectedUnweightedGraphAsList(graphConstructor), v);
			bfsUndirectedStartingFromVerticesZeroOneTwoThreeFourFiveSix(
					new UndirectedUnweightedGraphAsMatrix(graphConstructor), v);
		}
	}

	private void bfsUndirectedStartingFromVerticesSevenEight(UnweightedGraph g, Integer startingPoint) {
		BreadthFirstSearch searcher = new BreadthFirstSearch(g, startingPoint);
		for (int i = 7; i < 9; i++) {
			if (i != startingPoint)
				assertTrue(searcher.sourceHasPathTo(i));

		}

		Integer[] unreachableVertices = { 0, 1, 2, 3, 4, 5, 6, 9, 10, 11, 12 };
		for (Integer v : unreachableVertices)
			assertFalse(searcher.sourceHasPathTo(v));
	}

	@Test
	void bfsUndirectedStartingFromSecondConnectedComponentTests() throws IOException {
		for (int i = 7; i < 9; i++) {
			bfsUndirectedStartingFromVerticesSevenEight(new UndirectedUnweightedGraphAsList(graphConstructor), i);
			bfsUndirectedStartingFromVerticesSevenEight(new UndirectedUnweightedGraphAsMatrix(graphConstructor), i);
		}
	}

	private void bfsUndirectedStartingFromVerticesNineTenElevenTwelve(UnweightedGraph g, int startingPoint) {
		BreadthFirstSearch searcher = new BreadthFirstSearch(g, startingPoint);
		for (int i = 0; i < 9; i++)
			assertFalse(searcher.sourceHasPathTo(i));

		for (int i = 9; i < 13; i++)
			if (i != startingPoint)
				assertTrue(searcher.sourceHasPathTo(i));
	}

	@Test
	void bfsUndirectedStartingFromThirdConnectedComponentTests() throws IOException {
		for (int i = 9; i < 13; i++) {
			bfsUndirectedStartingFromVerticesNineTenElevenTwelve(new UndirectedUnweightedGraphAsList(graphConstructor),
					i);
			bfsUndirectedStartingFromVerticesNineTenElevenTwelve(
					new UndirectedUnweightedGraphAsMatrix(graphConstructor), i);
		}
	}

	private void bfsDirectedStartingFromVerticesOneTwoThreeEightTenTwelve(UnweightedGraph g, int startingPoint) {
		BreadthFirstSearch searcher = new BreadthFirstSearch(g, startingPoint);
		for (int i = 0; i < 13; i++)
			if (i != startingPoint)
				assertFalse(searcher.sourceHasPathTo(i));
	}

	@Test
	void bfsDirectedStartingWithVerticesWithZeroOutDegreeTests() throws IOException {
		Integer[] vertices = { 1, 2, 3, 8, 10, 12 };
		for (Integer v : vertices) {
			bfsDirectedStartingFromVerticesOneTwoThreeEightTenTwelve(
					new DirectedUnweightedGraphAsList(graphConstructor), v);
			bfsDirectedStartingFromVerticesOneTwoThreeEightTenTwelve(
					new DirectedUnweightedGraphAsMatrix(graphConstructor), v);
		}
	}

	private void bfsDirectedTests(UnweightedGraph g, int startingPoint, int[] reachable, int[] unreachable) {
		BreadthFirstSearch searcher = new BreadthFirstSearch(g, startingPoint);

		for (int v : reachable)
			if (v != startingPoint)
				assertTrue(searcher.sourceHasPathTo(v));

		for (int v : unreachable)
			assertFalse(searcher.sourceHasPathTo(v));
	}

	@Test
	void bfsDirectedStartingFromVertexZero() throws IOException {
		UnweightedGraph gl = new DirectedUnweightedGraphAsList(graphConstructor);
		UnweightedGraph gm = new DirectedUnweightedGraphAsMatrix(graphConstructor);

		int[] reachable = { 0, 1, 2, 3, 4, 5, 6 };
		int[] unreachable = { 7, 8, 9, 10, 11, 12 };
		bfsDirectedTests(gl, 0, reachable, unreachable);
		bfsDirectedTests(gm, 0, reachable, unreachable);
	}

	@Test
	void bfsDirectedStartingFromVertexFive() throws IOException {
		UnweightedGraph gl = new DirectedUnweightedGraphAsList(graphConstructor);
		UnweightedGraph gm = new DirectedUnweightedGraphAsMatrix(graphConstructor);

		int[] reachable = { 3, 4, 5 };
		int[] unreachable = { 0, 1, 2, 6, 7, 8, 9, 10, 11, 12 };
		bfsDirectedTests(gl, 5, reachable, unreachable);
		bfsDirectedTests(gm, 5, reachable, unreachable);
	}

	@Test
	void bfsDirectedStartingFromVertexSix() throws IOException {
		UnweightedGraph gl = new DirectedUnweightedGraphAsList(graphConstructor);
		UnweightedGraph gm = new DirectedUnweightedGraphAsMatrix(graphConstructor);

		int[] reachable = { 3, 4, 6 };
		int[] unreachable = { 0, 1, 2, 5, 7, 8, 9, 10, 11, 12 };
		bfsDirectedTests(gl, 6, reachable, unreachable);
		bfsDirectedTests(gm, 6, reachable, unreachable);
	}

	@Test
	void bfsDirectedStartingFromVertexSeven() throws IOException {
		UnweightedGraph gl = new DirectedUnweightedGraphAsList(graphConstructor);
		UnweightedGraph gm = new DirectedUnweightedGraphAsMatrix(graphConstructor);

		int[] reachable = { 7, 8 };
		int[] unreachable = { 0, 1, 2, 3, 4, 5, 6, 9, 10, 11, 12 };
		bfsDirectedTests(gl, 7, reachable, unreachable);
		bfsDirectedTests(gm, 7, reachable, unreachable);
	}

	@Test
	void bfsDirectedStartingFromVertexNine() throws IOException {
		UnweightedGraph gl = new DirectedUnweightedGraphAsList(graphConstructor);
		UnweightedGraph gm = new DirectedUnweightedGraphAsMatrix(graphConstructor);

		int[] reachable = { 9, 10, 11, 12 };
		int[] unreachable = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		bfsDirectedTests(gl, 9, reachable, unreachable);
		bfsDirectedTests(gm, 9, reachable, unreachable);
	}

	@Test
	void bfsDirectedStartingFromVertexEleven() throws IOException {
		UnweightedGraph gl = new DirectedUnweightedGraphAsList(graphConstructor);
		UnweightedGraph gm = new DirectedUnweightedGraphAsMatrix(graphConstructor);

		int[] reachable = { 11, 12 };
		int[] unreachable = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		bfsDirectedTests(gl, 11, reachable, unreachable);
		bfsDirectedTests(gm, 11, reachable, unreachable);
	}

	private void shortestPath(UnweightedGraph g, int v, int w, int[] expectedPath) {
		BreadthFirstSearch searcher = new BreadthFirstSearch(g, v);
		Iterator<Integer> realPath = searcher.getPathTo(w);
		boolean result = true;
		for (int i = 0; i < expectedPath.length && result == true && realPath.hasNext(); i++) {
			result = expectedPath[i] == realPath.next();
		}
		assertTrue(result);
	}

	@Test
	void bfsUndirectedShortestPath() throws IOException {
		int[] zeroToOne = { 0, 1 }, zeroToTwo = { 0, 2 }, zeroToThree = { 0, 5, 3 }, zeroToFive = { 0, 5 },
				zeroToSix = { 0, 6 },

				oneToZero = { 1, 0 }, oneToTwo = { 1, 0, 2 }, oneToThree = { 1, 0, 5, 3 }, oneToFive = { 1, 0, 5 },
				oneToSix = { 1, 0, 6 },

				twoToZero = { 2, 0 }, twoToOne = { 2, 0, 1 }, twoToThree = { 2, 0, 5, 3 }, twoToFive = { 2, 0, 5 },
				twoToSix = { 2, 0, 6 },

				threeToZero = { 3, 5, 0 }, threeToOne = { 3, 5, 0, 1 }, threeToTwo = { 3, 5, 0, 2 },
				threeToFour = { 3, 4 }, threeToFive = { 3, 5 }, threeToSix = { 3, 4, 6 },

				fourToThree = { 4, 3 }, fourToFive = { 4, 5 }, fourToSix = { 4, 6 },

				fiveToZero = { 5, 0 }, fiveToOne = { 5, 0, 1 }, fiveToTwo = { 5, 0, 2 }, fiveToThree = { 5, 3 },
				fiveToFour = { 5, 4 },

				sixToZero = { 6, 0 }, sixToOne = { 6, 0, 1 }, sixToTwo = { 6, 0, 2 }, sixToThree = { 6, 4, 3 },
				sixToFour = { 6, 4 },

				sevenToEight = { 7, 8 },

				eightToSeven = { 8, 7 },

				nineToTen = { 9, 10 }, nineToEleven = { 9, 11 }, nineToTwelve = { 9, 12 },

				tenToNine = { 10, 9 }, tenToEleven = { 10, 9, 11 }, tenToTwelve = { 10, 9, 12 },

				elevenToNine = { 11, 9 }, elevenToTen = { 11, 9, 10 }, elevenToTwelve = { 11, 12 },

				twelveToNine = { 12, 9 }, twelveToTen = { 12, 9, 10 }, twelveToEleven = { 12, 11 };

		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 0, 1, zeroToOne);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 0, 1, zeroToOne);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 0, 2, zeroToTwo);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 0, 2, zeroToTwo);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 0, 3, zeroToThree);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 0, 3, zeroToThree);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 0, 5, zeroToFive);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 0, 5, zeroToFive);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 0, 6, zeroToSix);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 0, 6, zeroToSix);

		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 1, 0, oneToZero);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 1, 0, oneToZero);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 1, 2, oneToTwo);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 1, 2, oneToTwo);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 1, 3, oneToThree);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 1, 3, oneToThree);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 1, 5, oneToFive);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 1, 5, oneToFive);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 1, 6, oneToSix);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 1, 6, oneToSix);

		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 2, 0, twoToZero);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 2, 0, twoToZero);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 2, 1, twoToOne);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 2, 1, twoToOne);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 2, 3, twoToThree);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 2, 3, twoToThree);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 2, 5, twoToFive);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 2, 5, twoToFive);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 2, 6, twoToSix);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 2, 6, twoToSix);

		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 3, 0, threeToZero);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 3, 0, threeToZero);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 3, 1, threeToOne);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 3, 1, threeToOne);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 3, 2, threeToTwo);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 3, 2, threeToTwo);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 3, 4, threeToFour);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 3, 4, threeToFour);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 3, 5, threeToFive);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 3, 5, threeToFive);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 3, 6, threeToSix);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 3, 6, threeToSix);

		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 4, 3, fourToThree);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 4, 3, fourToThree);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 4, 5, fourToFive);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 4, 5, fourToFive);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 4, 6, fourToSix);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 4, 6, fourToSix);

		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 5, 0, fiveToZero);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 5, 0, fiveToZero);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 5, 1, fiveToOne);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 5, 1, fiveToOne);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 5, 2, fiveToTwo);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 5, 2, fiveToTwo);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 5, 3, fiveToThree);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 5, 3, fiveToThree);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 5, 4, fiveToFour);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 5, 4, fiveToFour);

		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 6, 0, sixToZero);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 6, 0, sixToZero);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 6, 1, sixToOne);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 6, 1, sixToOne);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 6, 2, sixToTwo);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 6, 2, sixToTwo);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 6, 3, sixToThree);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 6, 3, sixToThree);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 6, 4, sixToFour);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 6, 4, sixToFour);

		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 7, 8, sevenToEight);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 7, 8, sevenToEight);

		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 8, 7, eightToSeven);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 8, 7, eightToSeven);

		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 9, 10, nineToTen);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 9, 10, nineToTen);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 9, 11, nineToEleven);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 9, 11, nineToEleven);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 9, 12, nineToTwelve);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 9, 12, nineToTwelve);

		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 10, 9, tenToNine);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 10, 9, tenToNine);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 10, 11, tenToEleven);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 10, 11, tenToEleven);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 10, 12, tenToTwelve);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 10, 12, tenToTwelve);

		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 11, 9, elevenToNine);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 11, 9, elevenToNine);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 11, 10, elevenToTen);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 11, 10, elevenToTen);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 11, 12, elevenToTwelve);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 11, 12, elevenToTwelve);

		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 12, 9, twelveToNine);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 12, 9, twelveToNine);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 12, 10, twelveToTen);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 12, 10, twelveToTen);
		shortestPath(new UndirectedUnweightedGraphAsList(graphConstructor), 12, 11, twelveToEleven);
		shortestPath(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 12, 11, twelveToEleven);
	}

	@Test
	void bfsDirectedShortestPath() throws IOException {
		int[] zeroToOne = { 0, 1 }, zeroToTwo = { 0, 2 }, zeroToThree = { 0, 5, 3 }, zeroToFive = { 0, 5 },
				zeroToSix = { 0, 6 },

				fourToThree = { 4, 3 },

				fiveToThree = { 5, 3 }, fiveToFour = { 5, 4 },

				sixToThree = { 6, 4, 3 }, sixToFour = { 6, 4 },

				sevenToEight = { 7, 8 },

				nineToTen = { 9, 10 }, nineToEleven = { 9, 11 }, nineToTwelve = { 9, 12 },

				elevenToTwelve = { 11, 12 };
		
		shortestPath(new DirectedUnweightedGraphAsList(graphConstructor), 0, 1, zeroToOne);
		shortestPath(new DirectedUnweightedGraphAsMatrix(graphConstructor), 0, 1, zeroToOne);
		shortestPath(new DirectedUnweightedGraphAsList(graphConstructor), 0, 2, zeroToTwo);
		shortestPath(new DirectedUnweightedGraphAsMatrix(graphConstructor), 0, 2, zeroToTwo);
		shortestPath(new DirectedUnweightedGraphAsList(graphConstructor), 0, 3, zeroToThree);
		shortestPath(new DirectedUnweightedGraphAsMatrix(graphConstructor), 0, 3, zeroToThree);
		shortestPath(new DirectedUnweightedGraphAsList(graphConstructor), 0, 5, zeroToFive);
		shortestPath(new DirectedUnweightedGraphAsMatrix(graphConstructor), 0, 5, zeroToFive);
		shortestPath(new DirectedUnweightedGraphAsList(graphConstructor), 0, 6, zeroToSix);
		shortestPath(new DirectedUnweightedGraphAsMatrix(graphConstructor), 0, 6, zeroToSix);

		shortestPath(new DirectedUnweightedGraphAsList(graphConstructor), 4, 3, fourToThree);
		shortestPath(new DirectedUnweightedGraphAsMatrix(graphConstructor), 4, 3, fourToThree);
		
		shortestPath(new DirectedUnweightedGraphAsList(graphConstructor), 5, 3, fiveToThree);
		shortestPath(new DirectedUnweightedGraphAsMatrix(graphConstructor), 5, 3, fiveToThree);
		shortestPath(new DirectedUnweightedGraphAsList(graphConstructor), 5, 4, fiveToFour);
		shortestPath(new DirectedUnweightedGraphAsMatrix(graphConstructor), 5, 4, fiveToFour);

		shortestPath(new DirectedUnweightedGraphAsList(graphConstructor), 6, 3, sixToThree);
		shortestPath(new DirectedUnweightedGraphAsMatrix(graphConstructor), 6, 3, sixToThree);
		shortestPath(new DirectedUnweightedGraphAsList(graphConstructor), 6, 4, sixToFour);
		shortestPath(new DirectedUnweightedGraphAsMatrix(graphConstructor), 6, 4, sixToFour);

		shortestPath(new DirectedUnweightedGraphAsList(graphConstructor), 7, 8, sevenToEight);
		shortestPath(new DirectedUnweightedGraphAsMatrix(graphConstructor), 7, 8, sevenToEight);

		shortestPath(new DirectedUnweightedGraphAsList(graphConstructor), 9, 10, nineToTen);
		shortestPath(new DirectedUnweightedGraphAsMatrix(graphConstructor), 9, 10, nineToTen);
		shortestPath(new DirectedUnweightedGraphAsList(graphConstructor), 9, 11, nineToEleven);
		shortestPath(new DirectedUnweightedGraphAsMatrix(graphConstructor), 9, 11, nineToEleven);
		shortestPath(new DirectedUnweightedGraphAsList(graphConstructor), 9, 12, nineToTwelve);
		shortestPath(new DirectedUnweightedGraphAsMatrix(graphConstructor), 9, 12, nineToTwelve);

		shortestPath(new DirectedUnweightedGraphAsList(graphConstructor), 11, 12, elevenToTwelve);
		shortestPath(new DirectedUnweightedGraphAsMatrix(graphConstructor), 11, 12, elevenToTwelve);

	}

	@Test
	void bfsUndirectedEmptyPath() throws IOException {
		BreadthFirstSearch s;

		for (int i = 0; i < 13; i++) {
			s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsList(graphConstructor), i);
			assertFalse(s.getPathTo(i).hasNext());
			s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsMatrix(graphConstructor), i);
			assertFalse(s.getPathTo(i).hasNext());
		}

		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsList(graphConstructor), 0);
		for (int i = 7; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());
		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 0);
		for (int i = 7; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());

		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsList(graphConstructor), 1);
		for (int i = 7; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());
		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 1);
		for (int i = 7; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());

		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsList(graphConstructor), 2);
		for (int i = 7; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());
		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 2);
		for (int i = 7; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());

		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsList(graphConstructor), 3);
		for (int i = 7; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());
		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 3);
		for (int i = 7; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());

		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsList(graphConstructor), 4);
		for (int i = 7; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());
		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 4);
		for (int i = 7; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());

		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsList(graphConstructor), 5);
		for (int i = 7; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());
		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 5);
		for (int i = 7; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());

		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsList(graphConstructor), 6);
		for (int i = 7; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());
		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 6);
		for (int i = 7; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());

		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsList(graphConstructor), 7);
		for (int i = 0; i < 7; i++)
			assertFalse(s.getPathTo(i).hasNext());
		for (int i = 9; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());

		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 7);
		for (int i = 0; i < 7; i++)
			assertFalse(s.getPathTo(i).hasNext());
		for (int i = 9; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());

		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsList(graphConstructor), 8);
		for (int i = 0; i < 7; i++)
			assertFalse(s.getPathTo(i).hasNext());
		for (int i = 9; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());
		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 8);
		for (int i = 0; i < 7; i++)
			assertFalse(s.getPathTo(i).hasNext());
		for (int i = 9; i < 13; i++)
			assertFalse(s.getPathTo(i).hasNext());

		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsList(graphConstructor), 9);
		for (int i = 0; i < 9; i++)
			assertFalse(s.getPathTo(i).hasNext());
		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 9);
		for (int i = 0; i < 9; i++)
			assertFalse(s.getPathTo(i).hasNext());

		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsList(graphConstructor), 10);
		for (int i = 0; i < 9; i++)
			assertFalse(s.getPathTo(i).hasNext());
		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 10);
		for (int i = 0; i < 9; i++)
			assertFalse(s.getPathTo(i).hasNext());

		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsList(graphConstructor), 11);
		for (int i = 0; i < 9; i++)
			assertFalse(s.getPathTo(i).hasNext());
		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 11);
		for (int i = 0; i < 9; i++)
			assertFalse(s.getPathTo(i).hasNext());

		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsList(graphConstructor), 12);
		for (int i = 0; i < 9; i++)
			assertFalse(s.getPathTo(i).hasNext());
		s = new BreadthFirstSearch(new UndirectedUnweightedGraphAsMatrix(graphConstructor), 12);
		for (int i = 0; i < 9; i++)
			assertFalse(s.getPathTo(i).hasNext());
	}

	@Test
	void bfsDirectedEmptyPath() throws IOException {
		int [] zeroOutDegreeVertices = { 1, 2, 3, 8, 10, 12 };
		int [] unreachableFromZeroOutDegreeVertices = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		for (int v : zeroOutDegreeVertices) {
			BreadthFirstSearch s = new BreadthFirstSearch(new DirectedUnweightedGraphAsList(graphConstructor), v);
			for (int w : unreachableFromZeroOutDegreeVertices) {
				assertFalse(s.getPathTo(w).hasNext());
			}
			s = new BreadthFirstSearch(new DirectedUnweightedGraphAsMatrix(graphConstructor), v);
			for (int w : unreachableFromZeroOutDegreeVertices) {
				assertFalse(s.getPathTo(w).hasNext());
			}
		}
		
		int [] unreachableFromZero = { 0, 7, 8, 9, 10, 11, 12};
		for (int w : unreachableFromZero) {
			BreadthFirstSearch s = new BreadthFirstSearch(new DirectedUnweightedGraphAsList(graphConstructor), 0);
			assertFalse(s.getPathTo(w).hasNext());
		}
		
		int [] unreachableFromFour = { 0, 1, 2, 5, 6, 7, 8, 9, 10, 11, 12 };
		for (int w : unreachableFromFour) {
			BreadthFirstSearch s = new BreadthFirstSearch(new DirectedUnweightedGraphAsList(graphConstructor), 4);
			assertFalse(s.getPathTo(w).hasNext());
		}
		
		int [] unreachableFromFive = { 0, 1, 2, 5, 6, 7, 8, 9, 10, 11, 12 };
		for (int w : unreachableFromFive) {
			BreadthFirstSearch s = new BreadthFirstSearch(new DirectedUnweightedGraphAsList(graphConstructor), 5);
			assertFalse(s.getPathTo(w).hasNext());
		}
		
		int [] unreachableFromSix = { 0, 1, 2, 5, 6, 7, 8, 9, 10, 11, 12 };
		for (int w : unreachableFromSix) {
			BreadthFirstSearch s = new BreadthFirstSearch(new DirectedUnweightedGraphAsList(graphConstructor), 6);
			assertFalse(s.getPathTo(w).hasNext());
		}
		
		int [] unreachableFromSeven = { 0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12 };
		for (int w : unreachableFromSeven) {
			BreadthFirstSearch s = new BreadthFirstSearch(new DirectedUnweightedGraphAsList(graphConstructor), 7);
			assertFalse(s.getPathTo(w).hasNext());
		}
		
		int [] unreachableFromNine = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int w : unreachableFromNine) {
			BreadthFirstSearch s = new BreadthFirstSearch(new DirectedUnweightedGraphAsList(graphConstructor), 9);
			assertFalse(s.getPathTo(w).hasNext());
		}
		
		int [] unreachableFromEleven = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		for (int w : unreachableFromEleven) {
			BreadthFirstSearch s = new BreadthFirstSearch(new DirectedUnweightedGraphAsList(graphConstructor), 11);
			assertFalse(s.getPathTo(w).hasNext());
		}
		
	}
}
