package types;

import java.io.*;
import java.util.Iterator;

public abstract class AbstractGraph implements Graph {

	protected Integer numberOfVertices;
	protected Integer numberOfEdges;

	public AbstractGraph(Integer numberOfVertices) {
		if (numberOfVertices == null)
			throw new IllegalArgumentException("Integer value cannot be null.");
		if (numberOfVertices < 1)
			throw new IllegalArgumentException("Integer value must be greater than 0.");
				
		this.numberOfVertices = numberOfVertices;
		initializeLocalVariables();
	}

	public AbstractGraph(File file) throws IOException {
		if (file == null)
			throw new IllegalArgumentException("File not found");
		
		BufferedReader reader = new BufferedReader(new FileReader(file));

		numberOfVertices = Integer.parseInt(reader.readLine());
		numberOfEdges = Integer.parseInt(reader.readLine());

		if (numberOfEdges <= 0 || this.getNumberOfVertices() <= 0) {
			reader.close();
			throw new IllegalArgumentException(
					"File does not contain a valid number of vertices/edges.");
		}
		
		initializeLocalVariables();

		String line;
		try {
			while ((line = reader.readLine()) != null) {
				String[] vertices;
				vertices = line.split(" ");
				Integer v = Integer.parseInt(vertices[0]);
				Integer w = Integer.parseInt(vertices[1]);
				addEdge(v, w);
			}
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			throw new IllegalArgumentException("Error in reading edges.");
		} finally {
			reader.close();
		}
	}

	protected abstract void initializeLocalVariables();

	public Integer getDegree(Integer vertex) {
		Iterator<Integer> neighbors = getAdjacentVerticesTo(vertex);
		Integer degree = 0;
		while (neighbors.hasNext()) {
			degree++;
			neighbors.next();
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

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Number of Vertices: ").append(getNumberOfVertices()).append(" | ").append("Number of Edges: ")
				.append(getNumberOfEdges()).append(System.lineSeparator()).append("List of Edges: ")
				.append(System.lineSeparator());
		for (Integer vertex = 0; vertex < getNumberOfVertices(); vertex++) {
			Iterator<Integer> neighbors = getAdjacentVerticesTo(vertex);
			String vertexEdges = new String(""); 
			while (neighbors.hasNext()) {
				Integer neighbor = neighbors.next();
				String thisEdge = getStringOfEdge(vertex, neighbor);
				vertexEdges = vertexEdges.concat(thisEdge + (thisEdge.isEmpty() ? "" : neighbors.hasNext() ? "," : ""));
			}
			result.append(vertexEdges.isEmpty() ? "" : "[" + vertexEdges + "]");
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
