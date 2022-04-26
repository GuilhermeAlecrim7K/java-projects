package types;

import java.io.*;
import java.util.Iterator;

public abstract class AbstractGraph implements Graph {

	protected Integer numberOfVertices;
	protected Integer numberOfEdges;

	public AbstractGraph(Integer numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
		initializeLocalVariables();
	}

	public AbstractGraph(File file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));

		this.numberOfVertices = Integer.parseInt(reader.readLine());
		this.numberOfEdges = Integer.parseInt(reader.readLine());

		initializeLocalVariables();

		if (this.getNumberOfEdges() <= 0 || this.getNumberOfVertices() <= 0) {
			reader.close();
			throw new IllegalArgumentException(
					"Error in attribution of number of vertices/edges in the two first lines of the document");
		}

		String line;
		try {
			while ((line = reader.readLine()) != null) {
				String[] edge;
				edge = line.split(" ");
				Integer v = Integer.parseInt(edge[0]);
				Integer w = Integer.parseInt(edge[1]);
				addEdge(v, w);
			}
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			throw new IllegalArgumentException("Error in reading edges.");
		} finally {
			reader.close();
			numberOfEdges /= 2;
		}
	}

	protected abstract void initializeLocalVariables();

	public Integer getDegree(Integer vertex) {
		Iterator<Integer> neighbors = getAdjacentVerticesTo(vertex);
		Integer degree = 0;
		while (neighbors.hasNext()) {
			degree++;
		}
		return degree;
	}

	public Integer maxDegree() {
		Integer maxDegree = 0;
		for (int v = 0; v < getNumberOfVertices(); v++) {
			maxDegree = Math.max(maxDegree, getDegree(v));
		}
		return maxDegree;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Number of Vertices: ").append(getNumberOfVertices()).append(" | ").append("Number of Edges: ")
				.append(getNumberOfEdges()).append(System.lineSeparator()).append("List of Edges: ")
				.append(System.lineSeparator());
		for (Integer vertex = 0; vertex < getNumberOfVertices(); vertex++) {
			Iterator<Integer> neighbors = getAdjacentVerticesTo(vertex);
			while (neighbors.hasNext()) {
				Integer neighbor = neighbors.next();
				result.append(getStringOfEdge(vertex, neighbor)).append(System.lineSeparator());
			}
		}
		return result.toString();
	}

	protected void validateEdge(Integer v, Integer w) throws IllegalArgumentException {
		if (hasEdgeIncidentOn(v, w))
			throw new IllegalArgumentException("Duplicated edge on " + v + "and" + w);
	}

	public Double averageDegree() {
		return 1.0 * numberOfEdges / numberOfVertices;
	}

	public abstract boolean hasEdgeIncidentOn(Integer v, Integer w);

	protected String getStringOfEdge(Integer v, Integer w) {
		return v + "-" + w;
	}

	public Integer getNumberOfVertices() {
		return numberOfVertices;
	}

	public Integer getNumberOfEdges() {
		return numberOfEdges;
	}

}
