package types;

import java.util.Iterator;

public interface Graph {

	public Integer getNumberOfVertices();

	public Integer getNumberOfEdges();

	Integer getDegree(Integer vertex);

	Integer maxDegree();

	Double averageDegree();

	Iterator<Integer> getAdjacentVerticesTo(Integer v);

	public boolean hasEdgeIncidentOn(Integer v, Integer w);

	String toString();
}
