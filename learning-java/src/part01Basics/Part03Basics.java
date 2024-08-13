package part01Basics;
/*
 * 
 * Operator -
 * 
 */
public class Part03Basics {
	public static void main (String[] args) {
		/*
	     * post and pre increment and decrement / unary operator
	     */
	    int numm = 5;
	    int numm1;
	    numm1 = numm++;
	    System.out.println(+numm+ "," +numm1);
	    
	    int nummm = 5;
	    int nummm1;
	    nummm1 = ++nummm;
	    System.out.println(+nummm+ "," +nummm1);
	    
	    int nummmx = 5;
	    int nummm1x;
	    nummm1x = ++nummmx + --nummmx + nummmx++ + nummmx++ + --nummmx;
	    System.out.println(nummm1x); // 6 + 5 + 5 + 6 + 6	    
	}
}
