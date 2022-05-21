package algorithms;

import java.util.Iterator;

import types.Graph;
import types.UndirectedGraph;

public class ConnectedComponentsSearch {

	private Graph graph;
	private boolean[] visitedVertices;
	private int[] componentId;
	private int connectedComponentsCount;

	public ConnectedComponentsSearch(UndirectedGraph graph) {
		this.graph = graph;
		visitedVertices = new boolean[graph.getNumberOfVertices()];
		componentId = new int[graph.getNumberOfVertices()];
		mapConnectedComponents();
	}

	private void mapConnectedComponents() {
		for (int v = 0; v < graph.getNumberOfVertices(); v++) {
			if (!visitedVertices[v]) {
				dfsOnVertex(v);
				connectedComponentsCount++;
			}
		}
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
