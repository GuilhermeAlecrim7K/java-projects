package types;

import java.util.Iterator;

public interface Graph {

	public Integer getNumberOfVertices();

	public Integer getNumberOfEdges();

	Integer getDegreeOfVertex(Integer vertex);

	Integer getHighestDegree();

	Double getAverageDegree();

	Iterator<Integer> getAdjacentVerticesTo(Integer v);

	public boolean hasEdgeIncidentOn(Integer v, Integer w);

	String toString();
}
