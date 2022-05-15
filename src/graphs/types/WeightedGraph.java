package types;

public interface WeightedGraph extends Graph {

	void addEdgeBetween(Integer v, Integer w, Double weight);

	Double getWeightOfEdge(Integer v, Integer w);

	boolean hasNegativeEdge();

}
