package types;

import java.io.File;
import java.io.IOException;

public class UndirectedWeightedGraphAsList extends AbstractWeightedGraphAsList implements UndirectedGraph {

	public UndirectedWeightedGraphAsList(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public UndirectedWeightedGraphAsList(File file) throws IOException {
		super(file);
	}

	@Override
	public void addEdgeBetween(Integer v, Integer w, Double weight) {
		edges.get(v).put(w, weight);
		edges.get(w).put(v, weight);
		numberOfEdges++;
	}

}
