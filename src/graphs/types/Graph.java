package types;

import java.util.Iterator;

public interface Graph {
	
	Integer getNumberOfVertices();
	
	Integer getNumberOfEdges();

	void addEdge(Integer v, Integer w);
	
	boolean isValidEdge(Integer v, Integer w);

	Iterator<Integer> getAdjacentVerticesTo(Integer v);

	String toString();
}
