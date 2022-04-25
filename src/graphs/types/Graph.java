package types;

import java.util.Iterator;

public interface Graph {

	Integer getNumberOfVertices();

	Integer getNumberOfEdges();

	Integer getDegree(Integer vertex);

	Integer maxDegree();

	Double averageDegree(Graph graph);

	void addEdge(Integer v, Integer w);

	boolean isValidEdge(Integer v, Integer w);

	Iterator<Integer> getAdjacentVerticesTo(Integer v);

	String toString();
}
