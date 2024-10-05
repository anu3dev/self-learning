/*
 * 
 * constant doesn't change the value.
 * Enum is a own type of grouped constant, it is also a class and interface.
 * 
 * we can achieve in java using finally and enum.
 * 
 * when we have a constant as a group and has a own data data type then we use enum, for exp:
 * Monday to Sunday are the days of a week, they won't change and all of them belong to week
 * so we can call it as group constant.
 * 
 */

enum Week {
	MON, TUE, WED, THU, FRI, SAT, SUN;
}

class EnumEx1{
	public EnumEx1() {
		Week w = Week.MON;
		System.out.println(w);
				
		int index = Week.THU.ordinal();
		System.out.println(index);
				
		Week wk[] = Week.values();
		for(Week en: wk) {
			System.out.println(en + " has index value " + en.ordinal());
		}
	}
}

enum ResultEx1 {
	PASS, FAIL, NOT_APPEARED;
	
	private int marks;
	
	/*
	 * 
	 * here constructor is also being called as per length of enum
	 * bcos each time we create enum, enum class is getting created behind the scene.
	 * 
	 */
	ResultEx1(){
		System.out.println("Constructor of enum");
	}
	
	void setMarks(int marks) {
		this.marks= marks;
	}
	
	int getMarks() {
		return marks;
	}
}

class EnumEx2{
	public EnumEx2() {
		/*
		 * 
		 * class Result extends Enum {}
		 * 
		 * public static final Result PASS = new Result;
		 * public static final Result FAIL = new Result;
		 * public static final Result NOT_APPEARED = new Result;
		 * 
		 */
		ResultEx1.PASS.setMarks(77);
		int marks1 = ResultEx1.PASS.getMarks();
		System.out.println(marks1);
		
		int marks2 = ResultEx1.FAIL.getMarks();
		System.out.println(marks2);
	}
}

class EnumEx3{
	enum ResultEx2 {
		PASS, FAIL, NOT_APPEARED;
	}
	int i = 10;
	
	public EnumEx3() {
		ResultEx2 res = ResultEx2.PASS;
		
		switch(res){
			case PASS: System.out.println("passed the exam");
			break;
			
			case FAIL: System.out.println("failed the exam");
			break;
			
			case NOT_APPEARED: System.out.println("not appeared");
			break;
			
			default: System.out.println("data not available");
		}
	}
}

public class P01Enum {
	public static void main(String[] args) {
		//new EnumEx1();
		
		//new EnumEx2();
		
		//new EnumEx3();
	}
}

