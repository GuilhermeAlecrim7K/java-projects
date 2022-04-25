package types;

import java.io.File;
import java.io.IOException;

public abstract class AbstractGraphAsList extends AbstractGraph {

	public AbstractGraphAsList(Integer numberOfVertices) {
		super(numberOfVertices);
	}

	public AbstractGraphAsList(File file) throws IOException {
		super(file);
	}

	@Override
	public Double averageDegree(Graph graph) {
		// TODO Auto-generated method stub
		return null;
	}

}
