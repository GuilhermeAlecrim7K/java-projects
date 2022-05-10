package sorting;

import java.util.List;

public class InsertionSort {
	
	public static void sort(int[] list) {
		for (int i = 1; i < list.length; i++) {
			int currValue = list[i];
			int j = i - 1;
			for (; j >= 0 && list[j] > currValue; j--) {
				list[j+1] = list[j];
			}
			list[j+1] = currValue;
		}
	}
	
	public static void sort(List<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			Integer currValue = list.get(i);
			int j = i-1;
			for (; (j >= 0) && (list.get(j) > currValue); j--){
				list.set(j + 1, list.get(j));
			}
			list.set(j + 1, currValue);
		}
	}
	
	public static void sortIntoDecreasing(List<Integer> list) {
		for (int i = list.size() - 2; i >= 0; i--) {
			Integer currValue = list.get(i);
			Integer j = i + 1;
			for (; j < list.size() && list.get(j) > currValue; j++) {
				list.set(j - 1, list.get(j));
			}
			list.set(j-1, currValue);
		}
	}
}
