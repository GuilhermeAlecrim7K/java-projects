package types;

import java.io.File;
import java.io.IOException;

public class UndirectedWeightedGraphAsMatrix extends AbstractWeightedGraphAsMatrix implements UndirectedGraph {

	public UndirectedWeightedGraphAsMatrix(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public UndirectedWeightedGraphAsMatrix(File file) throws IOException {
		super(file);
	}

	@Override
	public void addEdgeBetween(Integer v, Integer w, Double weight) {
		edges[v][w] = weight.doubleValue();
		edges[w][v] = weight.doubleValue();
		numberOfEdges++;
	}

}
