package types;

import java.io.File;
import java.io.IOException;

public class DirectedWeightedGraphAsMatrix extends AbstractWeightedGraphAsMatrix implements DirectedGraph{

	public DirectedWeightedGraphAsMatrix(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public DirectedWeightedGraphAsMatrix(File file) throws IOException {
		super(file);
	}

	@Override
	public void addEdgeBetween(Integer v, Integer w, Integer weight) {
		edges[v][w] = weight.doubleValue();
		numberOfEdges++;
	}

}
