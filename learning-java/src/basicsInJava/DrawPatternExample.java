package basicsInJava;

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

class DrawPatternExample {	
	public static void main(String[] args) {
		new PrintSquare();
	}
}