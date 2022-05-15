package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import types.*;

class ConstructorTests {

	static File tinyUnwG;
	static File tinyWG;
	static File mediumUnwG;
	static File largeUnwG;
	static File nullFile = null;

	static Integer validInteger = 1;
	static Integer invalidInteger = 0;
	static final Integer nullInteger = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		tinyUnwG = new File("src\\graphs\\graphs-txt\\tinyUG.txt");
		tinyWG = new File("src\\graphs\\graphs-txt\\tinyWG.txt");
		mediumUnwG = new File("src\\graphs\\graphs-txt\\mediumUG.txt");
		largeUnwG = new File("src\\graphs\\graphs-txt\\largeUG.txt");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		tinyWG = null;
		tinyUnwG = null;
		mediumUnwG = null;
		largeUnwG = null;
	}

	@Test
	void integerConstructorShouldNotThrowWithGraphAsList() {
		assertDoesNotThrow(() -> {
			new DirectedWeightedGraphAsList(validInteger);
			new DirectedUnweightedGraphAsList(validInteger);
			new UndirectedWeightedGraphAsList(validInteger);
			new UndirectedUnweightedGraphAsList(validInteger);
		});
	}

	@Test
	void integerConstructorShouldNotThrowWithGraphAsMatrix() {
		assertDoesNotThrow(() -> {
			new DirectedWeightedGraphAsMatrix(validInteger);
			new DirectedUnweightedGraphAsMatrix(validInteger);
			new UndirectedWeightedGraphAsMatrix(validInteger);
			new UndirectedUnweightedGraphAsMatrix(validInteger);
		});
	}

	@Test
	void fileConstructorShouldNotThrowWithGraphAsList() {
		assertDoesNotThrow(() -> {
			new DirectedWeightedGraphAsList(tinyWG);
			new UndirectedWeightedGraphAsList(tinyWG);
			new DirectedUnweightedGraphAsList(tinyUnwG);
			new UndirectedUnweightedGraphAsList(tinyUnwG);
		});
	}

	@Test
	void fileConstructorShouldNotThrowWithGraphAsMatrix() {
		assertDoesNotThrow(() -> {
			new DirectedWeightedGraphAsMatrix(tinyWG);
			new UndirectedWeightedGraphAsMatrix(tinyWG);
			new DirectedUnweightedGraphAsMatrix(tinyUnwG);
			new UndirectedUnweightedGraphAsMatrix(tinyUnwG);
		});
	}

	@Test
	void shouldCreateUnweightedGraphFromMediumSizedFile() {
		assertDoesNotThrow(() -> {
			new DirectedUnweightedGraphAsList(mediumUnwG);
			new DirectedUnweightedGraphAsMatrix(mediumUnwG);
			new UndirectedUnweightedGraphAsList(mediumUnwG);
			new UndirectedUnweightedGraphAsMatrix(mediumUnwG);
		});
	}

	@Test
	void shouldCreateUnweightedGraphAsListFromLargeSizedFile() {
		assertDoesNotThrow(() -> {
			new DirectedUnweightedGraphAsList(largeUnwG);
			new UndirectedUnweightedGraphAsList(largeUnwG);
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
			new DirectedWeightedGraphAsList(nullInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new DirectedWeightedGraphAsMatrix(nullInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedUnweightedGraphAsList(nullInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedUnweightedGraphAsMatrix(nullInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedWeightedGraphAsList(nullInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedWeightedGraphAsMatrix(nullInteger);
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
			new DirectedWeightedGraphAsList(invalidInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new DirectedWeightedGraphAsMatrix(invalidInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedUnweightedGraphAsList(invalidInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedUnweightedGraphAsMatrix(invalidInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedWeightedGraphAsList(invalidInteger);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedWeightedGraphAsMatrix(invalidInteger);
		});
	}

	@Test
	void fileConstructorShouldThrowIllegalArgumentExceptionWithNullFile() {
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new DirectedUnweightedGraphAsList(nullFile);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new DirectedUnweightedGraphAsMatrix(nullFile);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new DirectedWeightedGraphAsList(nullFile);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new DirectedWeightedGraphAsMatrix(nullFile);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedUnweightedGraphAsList(nullFile);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedUnweightedGraphAsMatrix(nullFile);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedWeightedGraphAsList(nullFile);
		});
		assertThrowsExactly(IllegalArgumentException.class, () -> {
			new UndirectedWeightedGraphAsMatrix(nullFile);
		});
	}

}
