package types;

import java.util.Iterator;

public abstract class AbstractGraph implements Graph {

	protected Integer numberOfVertices;
	protected Integer numberOfEdges;
	protected boolean allowsEdgeToSelf;
	protected boolean allowsMultipleEdgesToSameVertex;

	protected AbstractGraph() {
		allowsEdgeToSelf = allowsMultipleEdgesToSameVertex = false;
	}

	public AbstractGraph(Integer numberOfVertices) {
		this();
		if (numberOfVertices == null)
			throw new IllegalArgumentException("Integer value cannot be null.");
		if (numberOfVertices < 1)
			throw new IllegalArgumentException("Integer value must be greater than 0.");

		this.numberOfVertices = numberOfVertices;
		initializeProperties();
	}

	protected abstract void initializeProperties();

	public Integer maxDegree() {
		Integer maxDegree = 0;
		for (int v = 0; v < getNumberOfVertices(); v++) {
			maxDegree = Math.max(maxDegree, getDegree(v));
		}
		return maxDegree;
	}

	public Integer getNumberOfVertices() {
		return numberOfVertices;
	}

	public Integer getDegree(Integer vertex) {
		Integer degree = 0;
		Iterator<Integer> neighbors = getAdjacentVerticesTo(vertex);
		while (neighbors.hasNext()) {
			degree++;
			neighbors.next();
		}
		return degree;
	}

	protected boolean isValidEdge(Integer v, Integer w) throws IllegalArgumentException {

		boolean result = false;
		if (!allowsEdgeToSelf && v == w)
			throw new IllegalArgumentException("Edge to self not allowed");
		if (!allowsMultipleEdgesToSameVertex && hasEdgeIncidentOn(v, w))
			throw new IllegalArgumentException("Duplicated edge on " + v + "and" + w);
		result = true;

		return result;
	}

	public Integer getNumberOfEdges() {
		return numberOfEdges;
	}
	
	@Override
	public Double averageDegree() {
		return 1.0 * getNumberOfEdges() / getNumberOfVertices();
	}
}
