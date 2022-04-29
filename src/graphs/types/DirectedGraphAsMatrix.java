package types;

import java.io.File;
import java.io.IOException;

public class DirectedGraphAsMatrix extends AbstractGraphAsMatrix implements DirectedGraph {

	public DirectedGraphAsMatrix(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public DirectedGraphAsMatrix(File file) throws IOException {
		super(file);
	}

}
