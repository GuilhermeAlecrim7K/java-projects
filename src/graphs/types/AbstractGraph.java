package types;

import java.io.*;
import java.util.Iterator;

public abstract class AbstractGraph implements Graph {

	protected Integer numberOfVertices;
	protected Integer numberOfEdges;

	public AbstractGraph(Integer numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
	}

	public AbstractGraph(File file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));

		this.numberOfVertices = Integer.parseInt(reader.readLine());
		this.numberOfEdges = Integer.parseInt(reader.readLine());

		if (this.getNumberOfEdges() <= 0 || this.getNumberOfVertices() <= 0) {
			reader.close();
			throw new IllegalArgumentException(
					"Error in attribution of number of vertices/edges in the two first lines of the document");
		}

		String line;
		while ((line = reader.readLine()) != null) {
			try {
				String[] edge;
				edge = line.split("-");
				Integer v = Integer.parseInt(edge[0]);
				Integer w = Integer.parseInt(edge[1]);
				addEdge(v, w);
			} catch (Exception e) {
				reader.close();
				throw new IllegalArgumentException("Error in reading edges.");
			}
		}

		reader.close();
	}

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
		String result = "Number of Vertices: " + getNumberOfVertices() + " | " + "Number of Edges: "
				+ getNumberOfEdges() + System.lineSeparator() + "List of Edges: " + System.lineSeparator();
		for (Integer vertex = 0; vertex < getNumberOfVertices(); vertex++) {
			Iterator<Integer> neighbors = getAdjacentVerticesTo(vertex);
			while (neighbors.hasNext()) {
				Integer neighbor = neighbors.next();
				result.concat(getStringOfEdge(vertex, neighbor));
			}
		}
		return result;
	}

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
