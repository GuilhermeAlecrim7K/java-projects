package sorting.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import sorting.InsertionSort;

class InsertionSortTests {

	List<Integer> testList;
	
	private void createInstanceOfArrayList(){
		testList = new ArrayList<>();		
	}
	
	@AfterEach
	void tearDown() {
		testList = null;
	}
	
	@Test
	void shouldOrderArrayFromDecreasingOrder() {
		int[] array = {4, 3, 2, 1};
		InsertionSort.sort(array);
		assertEquals(1, array[0]);
		assertEquals(2, array[1]);
		assertEquals(3, array[2]);
		assertEquals(4, array[3]);
	}

	@Test
	void shouldOrderFromDecreasingOrder() {
		createInstanceOfArrayList();
		testList.add(4);
		testList.add(3);
		testList.add(2);
		testList.add(1);
		InsertionSort.sort(testList);
		assertEquals(1, testList.get(0));
		assertEquals(2, testList.get(1));
		assertEquals(3, testList.get(2));
		assertEquals(4, testList.get(3));
	}
	
	@Test
	void shouldOrderFromRandom() {
		createInstanceOfArrayList();
		testList.add(2);
		testList.add(5);
		testList.add(4);
		testList.add(10);
		InsertionSort.sort(testList);
		assertEquals(2, testList.get(0));
		assertEquals(4, testList.get(1));
		assertEquals(5, testList.get(2));
		assertEquals(10, testList.get(3));
	}
	
	@Test
	void shouldOrderFromRandom2() {
		createInstanceOfArrayList();
		testList.add(5);
		testList.add(2);
		testList.add(4);
		testList.add(6);
		testList.add(1);
		testList.add(3);
		InsertionSort.sort(testList);
		assertEquals(1, testList.get(0));
		assertEquals(2, testList.get(1));
		assertEquals(3, testList.get(2));
		assertEquals(4, testList.get(3));
		assertEquals(5, testList.get(4));
		assertEquals(6, testList.get(5));
	}
	
	@Test
	void shouldOrderFromRandom3() {
		createInstanceOfArrayList();
		testList.add(31);
		testList.add(41);
		testList.add(59);
		testList.add(26);
		testList.add(41);
		testList.add(58);
		InsertionSort.sort(testList);
		assertEquals(26, testList.get(0));
		assertEquals(31, testList.get(1));
		assertEquals(41, testList.get(2));
		assertEquals(41, testList.get(3));
		assertEquals(58, testList.get(4));
		assertEquals(59, testList.get(5));
	}
	
	@Test
	void shouldOrderIntoDecreasingFromIncreasingOrder() {
		createInstanceOfArrayList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		InsertionSort.sortIntoDecreasing(testList);
		assertEquals(4, testList.get(0));
		assertEquals(3, testList.get(1));
		assertEquals(2, testList.get(2));
		assertEquals(1, testList.get(3));
	}
	
	@Test
	void shouldOrderIntoDecreasingFromRandom() {
		createInstanceOfArrayList();
		testList.add(58);
		testList.add(41);
		testList.add(26);
		testList.add(59);
		testList.add(41);
		testList.add(31);
		InsertionSort.sortIntoDecreasing(testList);
		assertEquals(59, testList.get(0));
		assertEquals(58, testList.get(1));
		assertEquals(41, testList.get(2));
		assertEquals(41, testList.get(3));
		assertEquals(31, testList.get(4));
		assertEquals(26, testList.get(5));
	}

}
