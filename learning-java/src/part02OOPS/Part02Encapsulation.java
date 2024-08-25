package part02OOPS;

/*
 * 
 * Binding methods and variables together is encapsulation.
 * we do it using getter and setter
 * 
 */

class EncapsulationEx1 {
	
	private int age = 27;
	/*
	 * sometimes we don't want direct interference so we create private variables.
	 */
	private String name = "Anurag";
	
	public int getAge() {
		/*
		 * only way to access private variable by using these public methods. i.e. getter
		 */
		return age;
	}
	
	public String getName() {		
		return name;
	}
	
	public void setAge(int age) {
		/*
		 * we can override value of private variable using this keyword in these public methods. i.e. setter
		 */ 
		this.age = age;
	}
	
	public void setName(String nam) {	
		/*
		 * we can also apply conditions / validations before setting the values
		 */ 
		if( validData(nam)) {
			name = nam;
		}
	}
	
	private boolean validData(String str) {		
		/*
		 * example of private method.
		 */
		return str.length() > 2;
	}
}

public class Part02Encapsulation {
	public static void main(String[] args) {
		EncapsulationEx1 ex1 = new EncapsulationEx1();
		
		System.out.println(ex1.getAge());
		/*
		 * we are calling a public method to fetch private variable.
		 * 
		 * output -> 27
		 */

		// anurag.name = "Nitish";	
		/*
		 * we can't directly change private variable like below.
		 */

		ex1.setName("N");
		System.out.println(ex1.getName());
		/*
		 * we are updating a private variable using public method if conditions met and then we are fetching it in next line.
		 * 
		 * output -> Anurag
		 */
		
		ex1.setName("Nitish");
		System.out.println(ex1.getName());
		/*
		 * we are updating a private variable using public method if conditions met and then we are fetching it in next line.
		 * 
		 * output -> Nitish
		 */
		
		ex1.setAge(28);
		System.out.println(ex1.getAge());
		/*
		 * we are updating a private variable using public method and then we are fetching it in next line.
		 * 
		 * output -> 28
		 */
	}
}
