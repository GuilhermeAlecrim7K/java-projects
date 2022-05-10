package searching;

import java.util.List;

public class LinearSearch {
	
	public static Integer search(int v, List<Integer> list) {
		Integer index = 0;
		while(list.get(index) < v && index < list.size()) {
			index++;
		}
		Integer result = (v == list.get(index)) ? index : null;
		return result;
	}
	
}
