import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/description/

class Solution0004 {
	// Time complexity: O(n^2)
	// Space complexity: O(1)
	public int[] getBruteForceSolution(int[] array, int target){
		for(int i = 0; i < array.length; i++){
			for(int j = i + 1; j < array.length; j++){
				if(array[i] + array[j] == target){
					return new int[] {array[i], array[j]};
				}
			}
		}
		return new int[] {};
	}



	// Time complexity: O(n)
	// Space complexity: O(n)
	public int[] getHashMapSolution(int[] array, int target){

		Map<Integer, Integer> hashMap = new HashMap<>();

		for(int i = 0; i < array.length; i++){

			int missingValue = target - array[i];

			if(hashMap.containsKey(missingValue)){
				return new int[] {array[hashMap.get(missingValue)], array[i]};
			}

			hashMap.put(array[i], i);
		}

		return new int[] {};
	}
}



public class App0004{
	public static void main(String[] args) {

		int[] array = {23, 28, 31, 76, 12, 8, 29};
		int target = 31;

		Solution0004 soln = new Solution0004();

		System.out.println(Arrays.toString(soln.getBruteForceSolution(array, target)));
		System.out.println(Arrays.toString(soln.getHashMapSolution(array, target)));
	}
}