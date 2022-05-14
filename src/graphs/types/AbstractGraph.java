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

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Number of Vertices: " + getNumberOfVertices() + " | ");
		result.append("Number of Edges: " + getNumberOfEdges() + System.lineSeparator());
		result.append("List of Edges: " + System.lineSeparator());
		result.append(getStringOfEdges());
		return result.toString();
	}

	private String getStringOfEdges() {
		StringBuilder result = new StringBuilder();
		for (Integer vertex = 0; vertex < getNumberOfVertices(); vertex++) {
			Iterator<Integer> neighbors = getAdjacentVerticesTo(vertex);
			String vertexEdges = new String(vertex + "-> ");
			while (neighbors.hasNext()) {
				Integer neighbor = neighbors.next();
				vertexEdges = vertexEdges.concat(neighbor.toString() + (neighbors.hasNext() ? ", " : ""));
			}
			result.append(vertexEdges.equals(vertex + "-> ") ? "" :  "[" + vertexEdges + "]" + System.lineSeparator());
		}
		return result.toString();
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
