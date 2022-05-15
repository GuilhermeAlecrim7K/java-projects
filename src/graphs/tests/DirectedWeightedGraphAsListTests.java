package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Iterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import types.DirectedWeightedGraphAsList;

class DirectedWeightedGraphAsListTests {

	static DirectedWeightedGraphAsList dwgl;

	@BeforeEach
	void setUp() throws Exception {
		dwgl = new DirectedWeightedGraphAsList(13);
		dwgl.addEdgeBetween(0, 5, 2.0);
		dwgl.addEdgeBetween(4, 3, 11.0);
		dwgl.addEdgeBetween(0, 1, 1.0);
		dwgl.addEdgeBetween(9, 12, 6.0);
		dwgl.addEdgeBetween(6, 4, 1.0);
		dwgl.addEdgeBetween(5, 4, 15.0);
		dwgl.addEdgeBetween(0, 2, 1.0);
		dwgl.addEdgeBetween(11, 12, 9.0);
		dwgl.addEdgeBetween(9, 10, 14.0);
		dwgl.addEdgeBetween(0, 6, 17.0);
		dwgl.addEdgeBetween(7, 8, 11.0);
		dwgl.addEdgeBetween(9, 11, 15.0);
		dwgl.addEdgeBetween(5, 3, 0.0);

	}

	@AfterEach
	void tearDown() throws Exception {
		dwgl = null;
	}

	@Test
	void getNumberOfVerticesTests() {
		assertEquals(dwgl.getNumberOfVertices(), 13);
	}

	@Test
	void getNumberOfEdgesTests() {
		assertEquals(13, dwgl.getNumberOfEdges());

		dwgl.addEdgeBetween(5, 9, 15.0);
		assertEquals(14, dwgl.getNumberOfEdges());
	}

	@Test
	void getDegreeOfVertexTests() {
		assertEquals(4, dwgl.getDegreeOfVertex(0));
		assertEquals(0, dwgl.getDegreeOfVertex(1));
		assertEquals(0, dwgl.getDegreeOfVertex(2));
		assertEquals(0, dwgl.getDegreeOfVertex(3));
		assertEquals(1, dwgl.getDegreeOfVertex(4));
		assertEquals(2, dwgl.getDegreeOfVertex(5));
		assertEquals(1, dwgl.getDegreeOfVertex(6));
		assertEquals(1, dwgl.getDegreeOfVertex(7));
		assertEquals(0, dwgl.getDegreeOfVertex(8));
		assertEquals(3, dwgl.getDegreeOfVertex(9));
		assertEquals(0, dwgl.getDegreeOfVertex(10));
		assertEquals(1, dwgl.getDegreeOfVertex(11));
		assertEquals(0, dwgl.getDegreeOfVertex(12));
	}

	@Test
	void getHighestDegreeTests() {
		assertEquals(4, dwgl.getHighestDegree());
	}

	@Test
	void getAverageDegreeTests() {
		assertEquals(1.0, dwgl.getAverageDegree(), 0.01);
	}

	@Test
	void getAdjacentVerticesToTests() {
		Iterator<Integer> iterator = dwgl.getAdjacentVerticesTo(0);
		HashSet<Integer> adjSet = new HashSet<>(4);
		adjSet.add(1);
		adjSet.add(5);
		adjSet.add(2);
		adjSet.add(6);
		boolean allVerticesFound = true;

		while (iterator.hasNext()) {
			if (adjSet.contains(iterator.next()))
				iterator.remove();
			else
				allVerticesFound = false;
		}

		assertTrue(allVerticesFound && !iterator.hasNext());
	}

	@Test
	void hasEdgeIncidentOnTests() {
		assertTrue(dwgl.hasEdgeIncidentOn(4, 3));
		assertFalse(dwgl.hasEdgeIncidentOn(3, 4));
	}

	@Test
	void getWeightOfEdgeTests() {
		assertEquals(2.0, dwgl.getWeightOfEdge(0, 5), 0.01);
		assertEquals(11.0, dwgl.getWeightOfEdge(4, 3), 0.01);
		assertEquals(1.0, dwgl.getWeightOfEdge(0, 1), 0.01);
		assertEquals(6.0, dwgl.getWeightOfEdge(9, 12), 0.01);
		assertEquals(1.0, dwgl.getWeightOfEdge(6, 4), 0.01);
		assertEquals(15.0, dwgl.getWeightOfEdge(5, 4), 0.01);
		assertEquals(1.0, dwgl.getWeightOfEdge(0, 2), 0.01);
		assertEquals(9.0, dwgl.getWeightOfEdge(11, 12), 0.01);
		assertEquals(14.0, dwgl.getWeightOfEdge(9, 10), 0.01);
		assertEquals(17.0, dwgl.getWeightOfEdge(0, 6), 0.01);
		assertEquals(11.0, dwgl.getWeightOfEdge(7, 8), 0.01);
		assertEquals(15.0, dwgl.getWeightOfEdge(9, 11), 0.01);
		assertEquals(0.0, dwgl.getWeightOfEdge(5, 3), 0.01);

		assertTrue(dwgl.getWeightOfEdge(9, 1).isInfinite());
	}

	@Test
	void hasNegativeEdgeTests() {
		assertFalse(dwgl.hasNegativeEdge());
		dwgl.addEdgeBetween(12, 13, -5.0);
		assertTrue(dwgl.hasNegativeEdge());
	}

}
