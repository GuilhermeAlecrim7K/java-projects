package types;

public interface WeightedGraph extends Graph {
	
	void addEdgeBetween(Integer v, Integer w, Integer weight);
	
	Integer getWeightOfEdge(Integer v, Integer w);
	
	boolean hasNegativeEdge();
	
}
