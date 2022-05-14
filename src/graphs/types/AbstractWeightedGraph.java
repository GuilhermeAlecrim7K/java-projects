package types;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class AbstractWeightedGraph extends AbstractGraph implements WeightedGraph {
	

	public AbstractWeightedGraph(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public AbstractWeightedGraph(File file) throws IOException {
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
				Integer weight = Integer.parseInt(vertices[2]);
				addEdgeBetween(v, w, weight);
			}
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			throw new IllegalArgumentException("Error in reading edges.");
		} finally {
			reader.close();
		}
	}

}
