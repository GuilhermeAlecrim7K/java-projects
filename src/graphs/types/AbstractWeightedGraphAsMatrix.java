package types;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class AbstractWeightedGraphAsMatrix extends AbstractWeightedGraph {
	
	Double[][] edges;

	public AbstractWeightedGraphAsMatrix(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public AbstractWeightedGraphAsMatrix(File file) throws IOException {
		super(file);
	}
	
	@Override
	protected void initializeProperties() {
		edges = new Double[getNumberOfVertices()][getNumberOfVertices()];
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges.length; j++) {
				edges[i][j] = Double.POSITIVE_INFINITY;
			}
		}
	}
	
	@Override
	public Integer getWeightOfEdge(Integer v, Integer w) {
		return edges[v][w].intValue();
	}
	
	@Override
	public boolean hasNegativeEdge() {
		boolean hasNegativeEdge = false;
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges.length; j++) {
				if (edges[i][j] < 0) {
					hasNegativeEdge = true;
					break;
				}
			}
			if (hasNegativeEdge)
				break;
		}
		return hasNegativeEdge;
	}
	
	@Override
	public boolean hasEdgeIncidentOn(Integer v, Integer w) {
		return Double.isFinite(edges[v][w]);
	}
	
	@Override
	public Iterator<Integer> getAdjacentVerticesTo(Integer v) {
		LinkedList<Integer> neighbors = new LinkedList<>();
		for (int i = 0; i < edges.length; i++) {
			if (Double.isFinite(edges[v][i]))
				neighbors.add(i);
		}
		return neighbors.iterator();
	}

}
