package types;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class UndirectedGraphAsList extends AbstractGraphAsList implements UndirectedGraph {

	public UndirectedGraphAsList(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public UndirectedGraphAsList(File file) throws IOException {
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
