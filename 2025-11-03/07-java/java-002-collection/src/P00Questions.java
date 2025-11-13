// "Alice", "Finance", 92000
// "Charlie", "Marketing", 78000
// "Bob", "IT", 88000
// "Diana", "Finance", 105000
// "Evan", "IT", 67000
// "Fiona", "HR", 83000

import java.util.ArrayList;
import java.util.List;

class Employee{
	String name;
	String department;
	double salary;
	
	public Employee(String name, String department, double salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	public double getSalary() {
		return this.salary;
	}
}

class Utils{
	public void getHighestEarningEmployeeDetails() {
		// creating employees arraylist
		List<Employee> employees = new ArrayList<Employee>() ;
				
		// inserting value to employees arraylist
		employees.add(new Employee("Alice", "Finance", 92000));
		employees.add(new Employee("Charlie", "Marketing", 78000));
		employees.add(new Employee("Bob", "IT", 88000));
		employees.add(new Employee("Diana", "Finance", 105000));
		employees.add(new Employee("Evan", "IT", 67000));
		employees.add(new Employee("Fiona", "HR", 83000));
				
		// creating departments arraylist
		List<String> departments = new ArrayList<String>();
				
		// adding unique department value to departments arraylist
		for(Employee e : employees) {
			if(!departments.contains(e.getDepartment())) {
				departments.add(e.getDepartment());
			}
		}
				
		// Initializing a Employee list with null
		Employee highestIncomeEmployee = null;
				
		// fetching list with highest income
		for(String d : departments) {
			for(Employee e : employees) {
				if(e.getDepartment().equals(d)) {
					if(highestIncomeEmployee == null 
							|| highestIncomeEmployee.getSalary() < e.getSalary()) {
						highestIncomeEmployee = e;
					}
				}
			}
		}
				
		// printing result
		System.out.println("highest salary is : " + highestIncomeEmployee.getSalary()
		+ " department name is : " + highestIncomeEmployee.getDepartment());
	}
}
public class P00Questions{
	public static void main(String[] args) {
		// get highest earning employee
		Utils utils = new Utils();
		utils.getHighestEarningEmployeeDetails();
	}
}