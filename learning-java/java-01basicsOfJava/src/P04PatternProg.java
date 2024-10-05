/*
 * 
 * print 5 star in a line
 * print 5*5 like square
 * print few letters
 * 
 */
class PrintSquare {
	PrintSquare(){
		int num = 9;
		
		for(int i = 0; i < num; i++) { 
			for(int j = 0; j < num; j++) {
				if (i + j == (num - 1)/2 || i -j == (num - 1)/2) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}

public class P04PatternProg {
	public static void main(String[] args) {
		new PrintSquare();
	}
}
