package types;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class AbstractWeightedGraphAsList extends AbstractWeightedGraph {

	ArrayList<HashMap<Integer, Integer>> edges;

	public AbstractWeightedGraphAsList(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public AbstractWeightedGraphAsList(File file) throws IOException {
		super(file);
	}

	@Override
	protected void initializeProperties() {
		numberOfEdges = 0;
		edges = new ArrayList<>();
		for (int i = 0; i < getNumberOfVertices(); i++) {
			edges.add(new HashMap<>());
		}
	}

	@Override
	public Integer getWeightOfEdge(Integer v, Integer w) {
		return edges.get(v).get(w);
	}

	@Override
	public boolean hasNegativeEdge() {
		boolean hasNegativeEdge = false;
		for (HashMap<Integer, Integer> vertex : edges) {
			for (Map.Entry<Integer, Integer> vertexWeightPair : vertex.entrySet()) {
				if (vertexWeightPair.getValue() < 0) {
					hasNegativeEdge = true;
					break;
				}
			}
			if (hasNegativeEdge)
				break;
		}
		return hasNegativeEdge;
	}

	@Override
	public Iterator<Integer> getAdjacentVerticesTo(Integer v) {
		return edges.get(v).keySet().iterator();
	}

	@Override
	public boolean hasEdgeIncidentOn(Integer v, Integer w) {
		return edges.get(v).containsKey(w);
	}

}
