package types;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class AbstractUnweightedGraphAsList extends AbstractUnweightedGraph {

	protected ArrayList<LinkedList<Integer>> edges;

	public AbstractUnweightedGraphAsList(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public AbstractUnweightedGraphAsList(File file) throws IOException {
		super(file);
	}

	@Override
	protected void initializeProperties() {
		numberOfEdges = 0;
		edges = new ArrayList<>(getNumberOfVertices());
		for (int i = 0; i < getNumberOfVertices(); i++) {
			edges.add(new LinkedList<Integer>());
		}
	}

	@Override
	public boolean hasEdgeIncidentOn(Integer v, Integer w) {
		return edges.get(v).contains(w);
	}

	@Override
	public Iterator<Integer> getAdjacentVerticesTo(Integer v) {
		return Collections.unmodifiableList(edges.get(v)).iterator();
	}

}
