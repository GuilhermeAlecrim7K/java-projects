package types;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class AbstractGraphAsList extends AbstractGraph {

	protected ArrayList<LinkedList<Integer>> edges;

	public AbstractGraphAsList(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public AbstractGraphAsList(File file) throws IOException {
		super(file);
	}

	@Override
	protected void initializeLocalVariables() {
		numberOfEdges = 0;
		edges = new ArrayList<>(numberOfVertices);
		for (int i = 0; i < numberOfVertices; i++) {
			edges.add(new LinkedList<Integer>());
		}
	}

	@Override
	public boolean hasEdgeIncidentOn(Integer v, Integer w) {
		return edges.get(v).contains(w);
	}

	@Override
	public Iterator<Integer> getAdjacentVerticesTo(Integer v) {
		return edges.get(v).iterator();
	}

}
