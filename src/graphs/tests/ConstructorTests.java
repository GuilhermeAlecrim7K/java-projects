package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import types.*;

class ConstructorTests {

	static Graph g;
	static UndirectedGraph ug;
	static DirectedGraph dg;
	static AbstractGraph ag;
	static AbstractGraphAsList agl;
	static AbstractGraphAsMatrix agm;
	static UndirectedGraphAsList ugl;
	static UndirectedGraphAsMatrix ugm;
	static DirectedGraphAsList dgl;
	static DirectedGraphAsMatrix dgm;

	static File tinyG;
	static File mediumG;
	static File largeG;
	static File nullFile = null;

	static Integer validInteger = 1;
	static Integer invalidInteger = 0;
	static final Integer nullInteger = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		tinyG = new File("src\\graphs\\tinyG.txt");
		mediumG = new File("src\\graphs\\mediumG.txt");
		largeG = new File("src\\graphs\\largeG.txt");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		tinyG = null;
		mediumG = null;
		largeG = null;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		g = null;
		dg = null;
		ug = null;
		ag = null;
		agl = null;
		agm = null;
		dgl = null;
		dgm = null;
	}

	@Test
	void integerConstructorShouldNotThrowWithGraphAsList() {
		assertDoesNotThrow(() -> {
			new DirectedGraphAsList(validInteger);
			new UndirectedGraphAsList(validInteger);
		});
	}

	@Test
	void integerConstructorShouldNotThrowWithGraphAsMatrix() {
		assertDoesNotThrow(() -> {
			new DirectedGraphAsMatrix(validInteger);
			new UndirectedGraphAsMatrix(validInteger);
		});
	}

	@Test
	void fileConstructorShouldNotThrowWithGraphAsList() {
		assertDoesNotThrow(() -> {
			new DirectedGraphAsList(tinyG);
			new UndirectedGraphAsList(tinyG);
		});
	}

	@Test
	void fileConstructorShouldNotThrowWithGraphAsMatrix() {
		assertDoesNotThrow(() -> {
			new DirectedGraphAsMatrix(tinyG);
			new UndirectedGraphAsMatrix(tinyG);
		});
	}

	@Test
	void integerConstructorShouldThrowIllegalArgumentExceptionWithNullValue() {
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new DirectedGraphAsList(nullInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new DirectedGraphAsMatrix(nullInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedGraphAsList(nullInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedGraphAsMatrix(nullInteger);
		});
	}

	@Test
	void integerConstructorShouldThrowIllegalArgumentExceptionWithInvalidInteger() {
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new DirectedGraphAsList(invalidInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new DirectedGraphAsMatrix(invalidInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedGraphAsList(invalidInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedGraphAsMatrix(invalidInteger);
		}, "Test");
	}

	@Test
	void fileConstructorShouldThrowIllegalArgumentExceptionWithInvalidNumberOfEdges() {
		
	}

}
