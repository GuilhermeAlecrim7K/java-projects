package types;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractGraphAsMatrix extends AbstractGraph {

	protected Integer[][] edges;

	public AbstractGraphAsMatrix(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public AbstractGraphAsMatrix(File file) throws IOException {
		super(file);
	}

	@Override
	protected void initializeLocalVariables() {
		numberOfEdges = 0;
		edges = new Integer[numberOfVertices][numberOfVertices];
		for (int i = 0; i < numberOfVertices; i++) {
			for (int j = 0; j < numberOfVertices; j++) {
				edges[i][j] = Integer.MAX_VALUE;
			}
		}
	}
	
	public void addEdge(Integer v, Integer w) {
		edges[v][w] = 1;
		numberOfEdges++;
	}
	
	public Double averageDegree() {
		return 2.0 * numberOfEdges / numberOfVertices;
	}

	@Override
	public boolean hasEdgeIncidentOn(Integer v, Integer w) {
		return edges[v][w] != Integer.MAX_VALUE;
	}

	@Override
	public Iterator<Integer> getAdjacentVerticesTo(Integer v) {
		List<Integer> result = new ArrayList<>(numberOfVertices);
		for (int i = 0; i < numberOfVertices; i++) {
			if (edges[v][i] != Integer.MAX_VALUE)
				result.add(i);
		}
		return result.iterator();
	}

}
