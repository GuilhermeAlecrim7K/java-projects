package types;

import java.io.File;
import java.io.IOException;

public abstract class AbstractGraphAsMatrix extends AbstractGraph {

	public AbstractGraphAsMatrix(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public AbstractGraphAsMatrix(File file) throws IOException {
		super(file);
	}

	@Override
	public Double averageDegree(Graph graph) {
		// TODO Auto-generated method stub
		return null;
	}

}
