package types;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class DirectedUnweightedGraphAsList extends AbstractUnweightedGraphAsList implements DirectedGraph {

	public DirectedUnweightedGraphAsList(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public DirectedUnweightedGraphAsList(File file) throws IOException {
		super(file);
	}

	@Override
	public void addEdgeBetween(Integer v, Integer w) {
		LinkedList<Integer> adjacentsToV = edges.get(v);
		int index = 0;
		for (Integer neighbor : adjacentsToV) {
			if (neighbor > w)
				break;
			index++;
		}
		edges.get(v).add(index, w);
		numberOfEdges++;
	}

}
