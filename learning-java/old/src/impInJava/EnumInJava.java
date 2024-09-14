/*
 * constant - doesn't change the value - own type and grouped constant.
 * enum is a class and interface.
 * 
 * we can achieve in java using finally and enum.
 * when we have a contant as a group and has a own data data type then we use enum, for eg:
 * 
 * Monday to Sunday are the days of a week, they won't change and all of them belong to week
 * so we can call it as group constant.
 */
package impInJava;

enum Week {
	MON, TUE, WED, THU, FRI, SAT, SUN;
}

class EnumInJavaEx1{
	public EnumInJavaEx1() {
		Week w = Week.MON;
		System.out.println(w);
		
		System.out.println("######################");
		
		int index = Week.THU.ordinal();
		System.out.println(index);
		
		System.out.println("######################");
		
		Week wk[] = Week.values();
		for(Week en: wk) {
			System.out.println(en + " is and index is: " + en.ordinal());
		}
	}
}

class EnumInJavaEx2{
	enum Result {
		PASS, FAIL, NOT_APPEARED;
		
		int marks;
		
		Result(){
			System.out.println("Constructor of enum");
		}
		
		void setMarks(int marks) {
			this.marks= marks;
		}
		
		int getMarks() {
			return marks;
		}
	}
	
	public EnumInJavaEx2() {
		/*
		 * here constructor is also being called as per length of enum
		 * bcos each time we create enum, enum class is getting created behind the scene.
		 * 
		 * class Result extends Enum {
		 * 
		 * }
		 * public static final Result PASS = new Result;
		 * public static final Result FAIL = new Result;
		 * public static final Result NOT_APPEARED = new Result;
		 */
		Result.PASS.setMarks(77);
		int marks = Result.PASS.getMarks();
		System.out.println(marks);
		
		int marks1 = Result.FAIL.getMarks();
		System.out.println(marks1);
	}
}

class EnumInJavaEx3{
	enum Result {
		PASS, FAIL, NOT_APPEARED;
	}
	int i = 10;
	
	public EnumInJavaEx3() {
		Result res = Result.PASS;
		
		switch(res){
			case PASS: System.out.println("passed the exam");
			break;
			
			case FAIL: System.out.println("faiuled the exam");
			break;
			
			case NOT_APPEARED: System.out.println("not appeared");
			break;
			
			default: System.out.println("data not available");
		}
	}
}

public class EnumInJava {
	public static void main(String[] args) {
		//new EnumInJavaEx1();
		
		System.out.println("************************");
		
		//new EnumInJavaEx2();
		
		System.out.println("************************");
		
		//new EnumInJavaEx3();
	}
}
