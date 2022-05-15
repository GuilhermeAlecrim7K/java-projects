package types;

import java.io.File;
import java.io.IOException;

public class UndirectedUnweightedGraphAsMatrix extends AbstractUnweightedGraphAsMatrix implements UndirectedGraph {

	public UndirectedUnweightedGraphAsMatrix(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public UndirectedUnweightedGraphAsMatrix(File file) throws IOException {
		super(file);
	}

	@Override
	public void addEdgeBetween(Integer v, Integer w) {
		edges[v][w] = true;
		edges[w][v] = true;
		numberOfEdges++;
	}

}
