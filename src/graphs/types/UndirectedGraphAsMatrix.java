package types;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class UndirectedGraphAsMatrix extends AbstractGraphAsMatrix implements UndirectedGraph {

	public UndirectedGraphAsMatrix(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public UndirectedGraphAsMatrix(File file) throws IOException {
		super(file);
	}

	@Override
	public void addEdge(Integer v, Integer w) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<Integer> getAdjacentVerticesTo(Integer v) {
		// TODO Auto-generated method stub
		return null;
	}

}
