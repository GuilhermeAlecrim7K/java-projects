package algorithms;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import types.UnweightedGraph;

public class DepthFirstSearch {

	UnweightedGraph graph;
	private Integer[] pathTo;
	private boolean[] visitedVertices;
	private final Integer NO_PATH_FOUND = Integer.MIN_VALUE;
	private final Integer SOURCE = -1;

	public DepthFirstSearch(UnweightedGraph graph, Integer source) {
		this.graph = graph;
		pathTo = new Integer[graph.getNumberOfVertices()];
		visitedVertices = new boolean[graph.getNumberOfVertices()];
		Arrays.fill(pathTo, NO_PATH_FOUND);
		pathTo[source] = SOURCE;
		search(source);
	}

	private void search(Integer startingPoint) {
		visitedVertices[startingPoint] = true;
		Iterator<Integer> neighbors = graph.getAdjacentVerticesTo(startingPoint);
		while (neighbors.hasNext()) {
			Integer v = neighbors.next();
			if (!visitedVertices[v]) {
				pathTo[v] = startingPoint;
				search(v);
			}
		}
	}

	public Iterator<Integer> getPathTo(Integer vertex) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		if (pathTo[vertex] != NO_PATH_FOUND) {
			for (int i = vertex; i != SOURCE; i = pathTo[i])
				result.add(0, i);
		}
		return result.iterator();
	}
	
	public boolean hasPathTo(Integer vertex) {
		return visitedVertices[vertex];
	}
}
