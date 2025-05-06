/**
 * DS - a way to organize data to process it easily.
 * 
 * Two types of data structures, Linear and non-linear.
 * 
 * Linear has data elements arranged in sequential manner, each member is connected to previous 
 * or next member via index and easy to traversal, examples are array, linked list, stack, queue etc.
 * 
 * Non-linear can be multi level, not connected to previous or next element traversal is bit tough,
 * examples are tree, graph etc.
 * 
 * Algorithm is a set of instructions to perform a task.
 * 
 * Analysis of algorithm can be done using time and space complexity.
 * Time complexity - amount of time taken by algorithm to run.
 * Space complexity - amount of space/memory taken by algorithm to run.
 * 
 * Asymptotic analysis - evaluating performance of an algorithms in terms of input size and its increase.
 * Asymptotic notations - mathematical tools to describe the running time in terms of input size, three types
 * of asymptotic notations.
 * Omega notation - formal way to express lower bound, lower bound means best amount of time an algorithm can 
 * take to complete.
 * Big O notation - formal way to express upper bound
 * Theta notation - formal way to express lower and upper bound, means its a way to average of upper and lower.
 * 
 * Rule for big O -
 * Assignment operator - 1 unit time
 * Return statement - 1 unit of time
 * Arithmetic operation - 1 unit of time
 * Logical operator - 1 unit of time
 * Other small/single operations - 1 unit of time
 * Drop lower value terms
 * Drop constant multipliers
 */

class DSA01BasicsEx1 {
	/**
	 * time complexity of constant algorithm-
	 */
	public int sum(int x, int y) {
		
		/**
		 * x assignment takes one unit, similarly y takes.
		 * addition means arithmetic operator takes one unit.
		 * value assignment to res will take one unit.
		 * 
		 * total 4 unit
		 */
		int res = x + y;
		
		/**
		 * returning the result will also take one unit.
		 * before final return, we are assigning value as well so it will again take one unit.
		 * 
		 * total 6 unit
		 */
		return res;
		
		/**
		 * total time taken by this method is 6 unit
		 * also a constant algorithm bcos input can be any value but will take 6 units of time.
		 * 
		 * after dropping constant multiplier, T = C i.e. O(1)
		 * will be straight line graph b/w time and volume
		 */
	}
	
	/**
	 * time complexity of linear algorithm-
	 */
	public int findSum(int n) {
		
		/**
		 * Initialize a constant with 0 value - 1 unit
		 */
		int sum = 0;
		
		/**
		 * int i = 0 will take one unit
		 * 
		 * fetching vale of i, fetching value of n and comparing, each will take 1 unit
		 * also it will depend on value of n, so total will be 3(n + 1)
		 * 
		 * I++ -> fetching value of i, incrementing it and assigning it back, total 3 unit,
		 * also it will depend on value of n, so total will be 3n
		 * 
		 * total will be 1 + 3(n + 1) + 3n =>6n + 4
		 */
		for(int i = 1; i <= n; i++) {
			
			/**
			 * fetching value of sum, fetching value of i, adding it and assigning it back,
			 * means total 4 unit and it will happen n times so count will be 4n.
			 */
			sum = sum + i;
		}
		
		/**
		 * accessing sum and returning sum will be 2 unit.
		 */
		return sum;
		
		/**
		 * total will be 1 + 6n + 4 + 4n + 2 =>10n + 7
		 * 
		 * after dropping lower value terms and constant multiplier, T = n i.e O(n)
		 * will be linear graph b/w time and volume, time is proportional to n.
		 */
	}
	
	/**
	 * time complexity of polynomial algorithm-
	 */
	public void print(int n) {
		/**
		 * 1 + 3(n + 1) + 3n = 6n + 4
		 */
		for(int i = 1; i <= n; i++) {
			/**
			 * n(1 + 3(n + 1) + 3n) = n(6n + 4) = 6n*n + 4n
			 */
			for (int j = 1; j <= n; j++) {
				/**
				 * accessing i, accessing j and printing it, total 3 unit
				 * n*n(1 + 1 + 1) = 3n*n
				 */
				System.out.println("i= "+i+", j= "+j);
			}
			/**
			 * will be printed n*1 times means n
			 */
			System.out.println("end of inner loop");
		}
		/**
		 * will be printed 1 time
		 */
		System.out.println("end of outer loop");
		
		/**
		 * total is -> 6n + 4 + 6n*n + 4n + 3n*n + n = 9n*n + 11n + 4,
		 * after dropping lower value terms and constant multiplier, T = n*n i.e. O(n*n)
		 * will be parabolic graph b/w time and volume
		 */
	}
}

public class DSA01Basics {
	public static void main(String[] args) {
		DSA01BasicsEx1 utils = new DSA01BasicsEx1();
		
		int sum = utils.sum(5,7);
		System.out.println(sum);
		
		System.out.println("\n\n");
		int findSum = utils.findSum(3);
		System.out.println(findSum);
		
		System.out.println("\n\n");
		utils.print(4);
	}
}
