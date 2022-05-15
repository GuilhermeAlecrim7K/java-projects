package types;

import java.io.File;
import java.io.IOException;

public class DirectedWeightedGraphAsList extends AbstractWeightedGraphAsList implements DirectedGraph {

	public DirectedWeightedGraphAsList(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public DirectedWeightedGraphAsList(File file) throws IOException {
		super(file);
	}

	@Override
	public void addEdgeBetween(Integer v, Integer w, Double weight) {
		edges.get(v).put(w, weight);
		numberOfEdges++;
	}

}
