
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class EmployeeEx1 {
	private String name;
	private int age;
	
	public EmployeeEx1(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public EmployeeEx1(int age) {
		super();
		name = "Rohan";
		this.age = age;
	}
	
	public EmployeeEx1() {
		super();
		name = "Mehu";
		age = 16;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return name+ " "+ age;
	}
}

class Ex1 {
	public Ex1 () {
		
		EmployeeEx1 emp1 = new EmployeeEx1();
		System.out.println(emp1);
		
		System.out.println("######################");
		
		EmployeeEx1 emp2 =new EmployeeEx1(18);
		System.out.println(emp2);
		
		System.out.println("######################");
		
		EmployeeEx1 emp3 = new EmployeeEx1("Rohit",24);
		System.out.println(emp3);
		
		System.out.println("######################");
		
		ArrayList<EmployeeEx1> arrayListl = new ArrayList<>();
		
		arrayListl.add(emp1);
		arrayListl.add(emp2);
		arrayListl.add(emp3);
		
		System.out.println(arrayListl);
	}
}

class EmployeeEx2 implements Comparable<EmployeeEx2> {
	String name;
	int age;
	int id;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public EmployeeEx2() {
		super();
		name = "Mehu";
		age = 16;
		id = 2;
	}
	
	public EmployeeEx2(int age) {
		super();
		name = "Rohan";
		this.age = age;
		id = 3;
	}
	
	public EmployeeEx2(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Employee2 [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	
	public int compareTo(EmployeeEx2 ref1) {
		if(this.id > ref1.id)
			return 1;
		else 
			return -1;
	}
}

class Ex2 {
	public Ex2() {
		EmployeeEx2 emp1 = new EmployeeEx2();
		EmployeeEx2 emp2 = new EmployeeEx2(18);
		EmployeeEx2 emp3 = new EmployeeEx2("Zain", 15, 1);
		
		ArrayList<EmployeeEx2> arrayList1 = new ArrayList<>();
		
		arrayList1.add(emp1);
		arrayList1.add(emp2);
		arrayList1.add(emp3);
		
		System.out.println(arrayList1);
	}
}

class EmployeeEx3 {
	String name;
	int age;
	int id;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public EmployeeEx3() {
		super();
		name = "Mehu";
		age = 16;
		id = 2;
	}
	
	public EmployeeEx3(int age) {
		super();
		name = "Rohan";
		this.age = age;
		id = 3;
	}
	
	public EmployeeEx3(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Employee3 [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
}

class Ex3 {
	public Ex3() {
		EmployeeEx3 emp1 = new EmployeeEx3();
		EmployeeEx3 emp2 = new EmployeeEx3(18);
		EmployeeEx3 emp3 = new EmployeeEx3("Zain", 15, 1);
		
		ArrayList<EmployeeEx3> arrayList1 = new ArrayList<>();
		
		arrayList1.add(emp1);
		arrayList1.add(emp2);
		arrayList1.add(emp3);
		
		System.out.println(arrayList1);
		
		System.out.println("##################");
		
		Comparator<EmployeeEx3> com = (EmployeeEx3 ref1, EmployeeEx3 ref2) -> {
			if (ref1.id > ref2.id)
				return 1;
			else
				return -1;
		};

		Collections.sort(arrayList1, com);
		
		System.out.println(arrayList1);
	}
}

public class P16Comparator {
	public static void main(String[] args) {
		
		//new Ex1();
				
		//new Ex2();
				
		//new Ex3();
	}
}
