package algorithms;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import types.Graph;

public class ConnectedComponentsSearch {

	private Graph graph;
	private boolean[] visitedVertices;
	private int[] componentId;
	private int connectedComponentsCount;

	public ConnectedComponentsSearch(Graph graph) {
		this.graph = graph;
		visitedVertices = new boolean[graph.getNumberOfVertices()];
		componentId = new int[graph.getNumberOfVertices()];
		mapConnectedComponents();
	}

	private void mapConnectedComponents() {
		int[] verticesSortedByInDegree = getVerticesIndexSortedByInDegree();
		for (int v : verticesSortedByInDegree) {
			if (!visitedVertices[v]) {
				dfsOnVertex(v);
				connectedComponentsCount++;
			}
		}
	}
	
	private int[] getVerticesIndexSortedByInDegree() {
		int[] array = new int[graph.getNumberOfVertices()];
		int vertex = 0;
		Arrays.fill(array, vertex++);
		//TODO: How to order in such way?
//		LinkedList<Integer> vertices = new LinkedList<>();
//		for (int i = 0; i < graph.getNumberOfVertices(); i++) {
//			
//		}
		return array;
	}

	private void dfsOnVertex(int v) {
		visitedVertices[v] = true;
		componentId[v] = connectedComponentsCount;
		Iterator<Integer> neighbors = graph.getAdjacentVerticesTo(v);
		while (neighbors.hasNext()) {
			int w = neighbors.next();
			if (!visitedVertices[w]) {
				dfsOnVertex(w);
			}
		}
	}

	public int getNumberOfConnectedComponents() {
		return connectedComponentsCount;
	}

	public boolean connected(int v, int w) {
		return componentId[v] == componentId[w];
	}

}
