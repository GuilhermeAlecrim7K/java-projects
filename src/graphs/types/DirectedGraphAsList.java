package types;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class DirectedGraphAsList extends AbstractGraphAsList implements DirectedGraph {

	public DirectedGraphAsList(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public DirectedGraphAsList(File file) throws IOException {
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
