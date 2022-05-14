package types;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractUnweightedGraphAsMatrix extends AbstractUnweightedGraph {

	protected boolean[][] edges;

	public AbstractUnweightedGraphAsMatrix(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public AbstractUnweightedGraphAsMatrix(File file) throws IOException {
		super(file);
	}

	@Override
	protected void initializeProperties() {
		numberOfEdges = 0;
		edges = new boolean[getNumberOfVertices()][getNumberOfVertices()];
		for (int i = 0; i < getNumberOfVertices(); i++) {
			for (int j = 0; j < getNumberOfVertices(); j++) {
				edges[i][j] = false;
			}
		}
	}

	@Override
	public boolean hasEdgeIncidentOn(Integer v, Integer w) {
		return edges[v][w];
	}

	@Override
	public Iterator<Integer> getAdjacentVerticesTo(Integer v) {
		List<Integer> result = new ArrayList<>(numberOfVertices);
		for (int i = 0; i < numberOfVertices; i++) {
			if (edges[v][i])
				result.add(i);
		}
		return result.iterator();
	}

}
