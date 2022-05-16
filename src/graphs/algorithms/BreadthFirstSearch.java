package algorithms;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import types.UnweightedGraph;

public class BreadthFirstSearch {

	UnweightedGraph graph;
	int[] distanceTo;
	int[] pathTo;
	boolean[] visitedVertices;
	private final Integer NO_PATH_FOUND = Integer.MIN_VALUE;
	private final Integer INFINITY = Integer.MAX_VALUE;
	private final Integer SOURCE = -1;

	public BreadthFirstSearch(UnweightedGraph graph, Integer source) {
		this.graph = graph;
		visitedVertices = new boolean[graph.getNumberOfVertices()];
		distanceTo = new int[graph.getNumberOfVertices()];
		pathTo = new int[graph.getNumberOfVertices()];
		Arrays.fill(distanceTo, INFINITY);
		Arrays.fill(pathTo, NO_PATH_FOUND);
		distanceTo[source] = 0;
		pathTo[source] = SOURCE;
		search(source);
	}

	private void search(Integer startingPoint) {
		visitedVertices[startingPoint] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startingPoint);
		while (!queue.isEmpty()) {
			Integer v = queue.poll();
			Iterator<Integer> neighbors = graph.getAdjacentVerticesTo(v);
			while (neighbors.hasNext()) {
				Integer w = neighbors.next();
				if (!visitedVertices[w]) {
					queue.add(w);
					pathTo[w] = v;
					distanceTo[w] = distanceTo[v] + 1;
					visitedVertices[w] = true;
				}
			}
		}
	}

	public Iterator<Integer> getPathTo(Integer vertex) {
		List<Integer> result = new LinkedList<>();
		if (sourceHasPathTo(vertex)) {
			for (int i = vertex; i != SOURCE; i = pathTo[i]) {
				result.add(0, i);
			}
		}
		return result.iterator();
	}

	public boolean sourceHasPathTo(Integer vertex) {
		return visitedVertices[vertex] && pathTo[vertex] != SOURCE;
	}
}
