package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import types.*;

class ConstructorTests {

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

	@Test
	void integerConstructorShouldNotThrowWithGraphAsList() {
		assertDoesNotThrow(() -> {
			new DirectedUnweightedGraphAsList(validInteger);
			new UndirectedUnweightedGraphAsList(validInteger);
		});
	}

	@Test
	void integerConstructorShouldNotThrowWithGraphAsMatrix() {
		assertDoesNotThrow(() -> {
			new DirectedUnweightedGraphAsMatrix(validInteger);
			new UndirectedUnweightedGraphAsMatrix(validInteger);
		});
	}

	@Test
	void fileConstructorShouldNotThrowWithGraphAsList() {
		assertDoesNotThrow(() -> {
			new DirectedUnweightedGraphAsList(tinyG);
			new UndirectedUnweightedGraphAsList(tinyG);
		});
	}

	@Test
	void fileConstructorShouldNotThrowWithGraphAsMatrix() {
		assertDoesNotThrow(() -> {
			new DirectedUnweightedGraphAsMatrix(tinyG);
			new UndirectedUnweightedGraphAsMatrix(tinyG);
		});
	}

	@Test
	void shouldCreateGraphFromMediumSizedFile() {
		assertDoesNotThrow(() -> {
			new DirectedUnweightedGraphAsList(mediumG);
			new DirectedUnweightedGraphAsMatrix(mediumG);
			new UndirectedUnweightedGraphAsList(mediumG);
			new UndirectedUnweightedGraphAsMatrix(mediumG);
		});
	}

	@Test
	void shouldCreateGraphAsListFromLargeSizedFile() {
		assertDoesNotThrow(() -> {
			new DirectedUnweightedGraphAsList(largeG);
			new UndirectedUnweightedGraphAsList(largeG);
		});
	}

	@Test
	void integerConstructorShouldThrowIllegalArgumentExceptionWithNullValue() {
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new DirectedUnweightedGraphAsList(nullInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new DirectedUnweightedGraphAsMatrix(nullInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedUnweightedGraphAsList(nullInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedUnweightedGraphAsMatrix(nullInteger);
		});
	}

	@Test
	void integerConstructorShouldThrowIllegalArgumentExceptionWithInvalidInteger() {
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new DirectedUnweightedGraphAsList(invalidInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new DirectedUnweightedGraphAsMatrix(invalidInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedUnweightedGraphAsList(invalidInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedUnweightedGraphAsMatrix(invalidInteger);
		}, "Test");
	}

	@Test
	void fileConstructorShouldThrowIllegalArgumentExceptionWithNullFile() {
		assertThrows(IllegalArgumentException.class, () -> {
			new DirectedUnweightedGraphAsList(nullFile);
		});
	}

}
