package types;

import java.io.File;
import java.io.IOException;

public class UndirectedGraphAsList extends AbstractGraphAsList implements UndirectedGraph {

	public UndirectedGraphAsList(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public UndirectedGraphAsList(File file) throws IOException {
		super(file);
	}

	@Override
	public void addEdge(Integer v, Integer w) {
		edges.get(v).add(w);
		edges.get(w).add(v);
		numberOfEdges++;
	}

}
