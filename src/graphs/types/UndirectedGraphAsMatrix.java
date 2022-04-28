package types;

import java.io.File;
import java.io.IOException;

public class UndirectedGraphAsMatrix extends AbstractGraphAsMatrix implements UndirectedGraph {

	public UndirectedGraphAsMatrix(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public UndirectedGraphAsMatrix(File file) throws IOException {
		super(file);
	}

	@Override
	public void addEdge(Integer v, Integer w) {
		super.addEdge(v, w);
		super.addEdge(w, v);
	}

}
