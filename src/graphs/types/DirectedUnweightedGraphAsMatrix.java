package types;

import java.io.File;
import java.io.IOException;

public class DirectedUnweightedGraphAsMatrix extends AbstractUnweightedGraphAsMatrix implements DirectedGraph {

	public DirectedUnweightedGraphAsMatrix(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public DirectedUnweightedGraphAsMatrix(File file) throws IOException {
		super(file);
	}

	@Override
	public void addEdgeBetween(Integer v, Integer w) {
		edges[v][w] = true;
		numberOfEdges++;
	}

}
