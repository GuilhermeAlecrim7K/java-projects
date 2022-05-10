package types;

import java.util.Iterator;

public interface Graph {

	Integer getDegree(Integer vertex);

	Integer maxDegree();

	Double averageDegree();

	void addEdge(Integer v, Integer w);

	Iterator<Integer> getAdjacentVerticesTo(Integer v);

	String toString();

	public Integer getNumberOfVertices();

	public Integer getNumberOfEdges();
	
	public boolean hasEdgeIncidentOn(Integer v, Integer w);
}
