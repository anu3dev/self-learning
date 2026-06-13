// https://leetcode.com/problems/contains-duplicate/description/

import java.util.HashSet;
import java.util.Set;

class Solution0006 {
	// Time complexity: O(n)
	// Space complexity: O(n)
	public boolean getBruteForceSolution(int[] arr){

		Set<Integer> hashSet = new HashSet<>();

        for(Integer num : arr){
            hashSet.add(num);
        }

        return hashSet.size() != arr.length;
	}



	// Time complexity: O(n)
	// Space complexity: O(n)
	public boolean getOptimizeSolution(int[] arr){

		Set<Integer> hashSet = new HashSet<>();

        for(Integer num : arr){
            if(hashSet.contains(num)){
				return true;
			}
			hashSet.add(num);
        }

		return false;
	}
}



public class App0006{
	public static void main(String[] args) {

		int[] arr1 = {1,2,3,1};
		int[] arr2 = {1,2,3,4};
		int[] arr3 = {1,1,1,3,3,4,3,2,4,2};

		Solution0006 sln = new Solution0006();

		System.out.println(sln.getBruteForceSolution(arr1));
		System.out.println(sln.getBruteForceSolution(arr2));
		System.out.println(sln.getBruteForceSolution(arr3));

		System.out.println(sln.getOptimizeSolution(arr1));
		System.out.println(sln.getOptimizeSolution(arr2));
		System.out.println(sln.getOptimizeSolution(arr3));
	}
}