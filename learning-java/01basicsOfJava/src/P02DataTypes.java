public class P02DataTypes {
	/*
	 * main is the start of code execution
	 */
	public static void main(String[] args) {
		System.out.println("hey, I am the first program!");
		
		/*
		 * char (2 byte)
		 * it will only accept single quote, double is for string
		 */
		char c = 'k';
		System.out.println(c);
		
		/*
		 * byte (1 byte)
		 */
		byte num2 = 127;
		System.out.println(num2);
		
		/*
		 * short (2 byte)
		 */
	    short num3 = 558;
	    System.out.println(num3);
	    
	    /*
	     * int (4 byte)
	     * It is default type
	     */
	    int num1 = 9;
	    System.out.println(num1);
	    
	    /*
	     * long (8 byte)
	     * Have to use l(L) with value
	     */
	    long num4 = 55561l;
	    System.out.println(num4);
	    
	    /*
	     * float (4 byte)
	     * have to use f(F) with value
	     */
	    float num5 = 6.5f;
	    System.out.println(num5);
	    
	    /*
	     * double (8 byte)
	     * it is default type
	     */
	    double num6 = 6.5;
	    System.out.println(num6);
	    
	    /*
	     * Default value is false
	     */
	    boolean b = false;
	    boolean a = true;
	    System.out.println(b+ "," +a);
	    
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
	    
	    float ff1 = 10;
	    float fs1 = 5;
	    System.out.println(ff1/fs1); // 2.0

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
	    System.out.println(bb); // 45.0
	    
	    /*
	     * explicit type casting example
	     */
	    double aaa = 25.5;
	    byte bbbb;
	    bbbb = (byte)aaa;
	    System.out.println(bbbb); // 25
	    
	    int aaaaa = 65;
	    char bbbbb;
	    bbbbb = (char)aaaaa;
	    System.out.println(bbbbb); // A
	    
	    /*
	     * int id default even if you add byte and byte
	     */
	    byte a1 = 10;
	    byte b1 = 20;
	    int res = a1 + b1;
	    System.out.println(res); // 30
	}
}
