package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import types.*;
import algorithms.ConnectedComponentsSearch;

class ConnectedComponentsSearchTests {

	private static File tinyUG;
	private static File mediumUG;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		tinyUG = new File("src\\graphs\\graphs-txt\\tinyUG.txt");
		mediumUG = new File("src\\graphs\\graphs-txt\\mediumUG.txt");
	}

	@Test
	void graphProcessingDoesNotThrowTests() {
		assertDoesNotThrow(() -> {
			new ConnectedComponentsSearch(new UndirectedUnweightedGraphAsList(tinyUG));
		});
		assertDoesNotThrow(() -> {
			new ConnectedComponentsSearch(new UndirectedUnweightedGraphAsMatrix(tinyUG));
		});
		assertDoesNotThrow(() -> {
			new ConnectedComponentsSearch(new UndirectedUnweightedGraphAsList(new File("src\\graphs\\graphs-txt\\tinyWG.txt")));
		});
		assertDoesNotThrow(() -> {
			new ConnectedComponentsSearch(new UndirectedUnweightedGraphAsMatrix(new File("src\\graphs\\graphs-txt\\tinyWG.txt")));
		});
		assertDoesNotThrow(() -> {
			new ConnectedComponentsSearch(new UndirectedUnweightedGraphAsList(mediumUG));
		});
		assertDoesNotThrow(() -> {
			new ConnectedComponentsSearch(new UndirectedUnweightedGraphAsMatrix(mediumUG));
		});
	}
	
	private void getNumberOfConnectedComponentsTests(UndirectedGraph g, File f, int expected) {
		ConnectedComponentsSearch searcher = new ConnectedComponentsSearch(g);
		assertEquals(expected, searcher.getNumberOfConnectedComponents());
	}
	
	@Test
	void getNumberOfConnectedComponentsTests() throws IOException {
		UndirectedGraph g; File f;
		
		f = new File("src\\graphs\\graphs-txt\\tinyUG.txt");
		
		g = new UndirectedUnweightedGraphAsList(f);
		getNumberOfConnectedComponentsTests(g, f, 3);
		
		g = new UndirectedUnweightedGraphAsMatrix(f);
		getNumberOfConnectedComponentsTests(g, f, 3);
		
		f = new File("src\\graphs\\graphs-txt\\mediumUG.txt");
		
		g = new UndirectedUnweightedGraphAsList(f);
		getNumberOfConnectedComponentsTests(g, f, 1);
		
		g = new UndirectedUnweightedGraphAsMatrix(f);
		getNumberOfConnectedComponentsTests(g, f, 1);

		f = new File("src\\graphs\\graphs-txt\\tinyWG.txt");
		
		g = new UndirectedWeightedGraphAsList(f);
		getNumberOfConnectedComponentsTests(g, f, 3);
		
		g = new UndirectedWeightedGraphAsMatrix(f);
		getNumberOfConnectedComponentsTests(g, f, 3);
	
	}

}
