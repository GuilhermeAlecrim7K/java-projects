package types;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public abstract class AbstractUnweightedGraph extends AbstractGraph implements UnweightedGraph{

	public AbstractUnweightedGraph(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public AbstractUnweightedGraph(File file) throws IOException {
		if (file == null)
			throw new IllegalArgumentException("File not found");

		BufferedReader reader = new BufferedReader(new FileReader(file));

		numberOfVertices = Integer.parseInt(reader.readLine());
		numberOfEdges = Integer.parseInt(reader.readLine());

		if (numberOfEdges <= 0 || this.getNumberOfVertices() <= 0) {
			reader.close();
			throw new IllegalArgumentException("File does not contain a valid number of vertices/edges.");
		}

		initializeProperties();

		String line;
		try {
			while ((line = reader.readLine()) != null) {
				String[] vertices;
				vertices = line.split(" ");
				Integer v = Integer.parseInt(vertices[0]);
				Integer w = Integer.parseInt(vertices[1]);
				addEdgeBetween(v, w);
			}
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			throw new IllegalArgumentException("Error in reading edges.");
		} finally {
			reader.close();
		}
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

}
