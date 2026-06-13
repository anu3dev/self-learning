// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution0005 {
	// Time complexity: O(n^2)
	// Space complexity: O(1)
	public int getBruteForceSolution(int[] arr){

		int tempProfit = 0;

		for(int i = 0; i < arr.length; i++){
			for(int j = i + 1; j < arr.length; j++){
				if(arr[j] - arr[i] > tempProfit){
					tempProfit = arr[j] - arr[i];
				}
			}
		}

		return tempProfit;
	}



	// Time complexity: O(n)
	// Space complexity: O(1)
	public int getOptimizeSolution(int[] arr){

		int buyValue = arr[0];
		int tempProfit = 0;

		for(int i = 0; i < arr.length; i++){
			if(arr[i] < buyValue){
				buyValue = arr[i];
			} else if(arr[i] - buyValue > tempProfit){
				tempProfit = arr[i] - buyValue;
			}
		}

		return tempProfit;
	}
}



public class App0005{
	public static void main(String[] args) {

		int[] prices1 = {7,1,5,3,6,4};
		int[] prices2 = {7,6,4,3,1};

		Solution0005 sln = new Solution0005();

		System.out.println(sln.getBruteForceSolution(prices1));
		System.out.println(sln.getBruteForceSolution(prices2));

		System.out.println(sln.getOptimizeSolution(prices1));
		System.out.println(sln.getOptimizeSolution(prices2));
	}
}