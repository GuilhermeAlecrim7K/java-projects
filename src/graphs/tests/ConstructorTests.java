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
	void integerConstructorDoesNotThrowWithGraphAsList() {
		assertDoesNotThrow(new Executable() {
			@Override
			public void execute() throws Throwable {
				new DirectedGraphAsList(validInteger);
				new UndirectedGraphAsList(validInteger);
			}
		});
	}

	@Test
	void integerConstructorDoesNotThrowWithGraphAsMatrix() {
		assertDoesNotThrow(new Executable() {
			@Override
			public void execute() throws Throwable {
				new DirectedGraphAsMatrix(validInteger);
				new UndirectedGraphAsMatrix(validInteger);
			}
		});
	}

	@Test
	void fileConstructorDoesNotThrowWithGraphAsList() {
		assertDoesNotThrow(new Executable() {
			public void execute() throws Throwable {
				new DirectedGraphAsList(tinyG);
				new UndirectedGraphAsList(tinyG);
			}
		});
	}

	@Test
	void fileConstructorDoesNotThrowWithGraphAsMatrix() {
		assertDoesNotThrow(new Executable() {
			@Override
			public void execute() throws Throwable {
				new DirectedGraphAsMatrix(tinyG);
				new UndirectedGraphAsMatrix(tinyG);
			}
		});
	}
	
	@Test
	void integerConstructorExceptionalCases() {
		
	}
	
	@Test
	void fileConstructorExceptionalCases() {
		
	}

}
