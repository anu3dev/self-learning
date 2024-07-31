/*
 * Identifier -> Identifiers in Java are names that distinguish between different Java entities, such as classes,
 * methods, variables, and packages.
 * 
 * Keywords => try, catch, throw, final, for while etc., more than 40 keywords are there.
 * 
 * type casting => type casting => changing data from one type to another
 * implicit and explicit
 * 
 * only underscore and dollar can be used in variable name.
 * 
 * Datatypes => primitive and non-primitive
 * primitive => byte, short, int, long, float, double, char and boolean.
 * non-primitive => Array, Class, String, and Interface
 * 
 * literals => way to write value of variable
 * 
 * operator
 */
package basicsInJava;


public class DataTypes {
	public static void main(String[] args) {
	    // variables
	    byte num2 = 127;         // byte (1 byte)
	    short num3 = 558;        // short (2 byte)
	    int num1 = 9;            // int (4 byte) and default type
	    long num4 = 55561l;      // long (8 byte) => have to use l(L) with value
	    
	    float num5 = 6.5f;       // float (4 byte) => double is default and have to use f(F) with value
	    double num6 = 6.5;       // double (8 byte)
	    
	    char c = 'k';            // char (2 byte) => it will only accept single quote, double is for string
	    
	    boolean b = false;		 // default value
	    boolean a = true;
	    
	    System.out.println(+num2+ "," +num3+ "," +num1+ "," +num4+ "," +num5+ "," +num6+ "," +c+ "," +b+ "," +a);
	    
	    /*
	     * sample example
	     */
	    int f = 12;
	    int s = 5;
	    int ri = f/s;
	    float rf = f/s;
	    System.out.println(+ri+ "," +rf); // output -> 2, 2.0
	    
	    double ad = 0.0;
	    double bd = 0.0;
	    System.out.println(ad/bd);  	  // output -> NaN
	    
	    float ff = 12;
	    float fs = 5;
	    System.out.println(ff/fs); // 2.4

	    /*
	     * literals example
	     */
	    int booleanValue = 0b101;
	    int hexValue = 0x5E1;
	    int countZero = 10_00_00_00;
	    double intergerVal = 56;
	    System.out.println(+booleanValue+ "," +hexValue+ "," +countZero+ "," +intergerVal);

	    /*
	     * implicit type casting example
	     */
	    byte aa = 45;
	    double bb;
	    bb = aa;
	    System.out.println(bb);
	    
	    /*
	     * explicit type casting example
	     */
	    double aaa = 25.5;
	    byte bbbb;
	    bbbb = (byte)aaa;
	    System.out.println(bbbb);
	    
	    int aaaaa = 65;
	    char bbbbb;
	    bbbbb = (char)aaaaa;
	    System.out.println(bbbbb);
	    
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
