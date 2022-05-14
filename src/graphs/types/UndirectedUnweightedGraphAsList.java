package types;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class UndirectedUnweightedGraphAsList extends AbstractUnweightedGraphAsList implements UndirectedGraph {

	public UndirectedUnweightedGraphAsList(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public UndirectedUnweightedGraphAsList(File file) throws IOException {
		super(file);
	}

	@Override
	public void addEdgeBetween(Integer v, Integer w) {
		Iterator<Integer> adjacentsToV = edges.get(v).iterator();
		Iterator<Integer> adjacentsToW = edges.get(w).iterator();
		int indexInV = 0;
		int indexInW = 0;
		while (adjacentsToV.hasNext()) {
			if (adjacentsToV.next() < w)
				indexInV++;
			else
				break;
		}
		while(adjacentsToW.hasNext()) {
			if (adjacentsToW.next() < v)
				indexInW++;
			else
				break;
		}
		
		edges.get(v).add(indexInV, w);
		edges.get(w).add(indexInW, v);
		numberOfEdges ++;
	}


}
