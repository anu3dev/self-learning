// "Alice", "Finance", 92000
// "Charlie", "Marketing", 78000
// "Bob", "IT", 88000
// "Diana", "Finance", 105000
// "Evan", "IT", 67000
// "Fiona", "HR", 83000

import java.util.ArrayList;

// employee class
class Employee{
	String name;
	String department;
	double salary;
	
	// employee constructor to handle employee object values
	public Employee(String name, String department, double salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	// department getter
	public String getDepartment() {
		return department;
	}
	
	// salary getter
	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}
}

class Utils{
	public ArrayList<Employee> addEmployeeToArrayList() {
		// creating employees array list
		ArrayList<Employee> employees = new ArrayList<>();
		
		// adding employee details to employee array list as employee object
		employees.add(new Employee("Alice", "Finance", 92000));
		employees.add(new Employee("Charlie", "Marketing", 78000));
		employees.add(new Employee("Bob", "IT", 88000));
		employees.add(new Employee("Diana", "Finance", 105000));
		employees.add(new Employee("Evan", "IT", 67000));
		employees.add(new Employee("Fiona", "HR", 83000));
		
		return employees;
	}
	
	public ArrayList<String> getArrayListWithUniqueDepartmentValue(){
		ArrayList<Employee> employeeList = addEmployeeToArrayList();
		
		// creating departments arraylist with unique values
		ArrayList<String> departments = new ArrayList<>();
		
		for(Employee emp : employeeList) {
			if(!departments.contains(emp.getDepartment())) {
				departments.add(emp.getDepartment());
			}
		}
		
		return departments;
	}
	
	public Employee getHighestEarningEmployeeDetailsAmongDepartments() {
		ArrayList<Employee> employeeList = addEmployeeToArrayList();
		
		// getting employee object with high salary
		Employee employeeWithHighestSalary = null;
		
		for(Employee emp : employeeList) {
			if(employeeWithHighestSalary == null ||
					employeeWithHighestSalary.getSalary() < emp.getSalary()) {
				employeeWithHighestSalary = emp;
			}
		}
		
		return employeeWithHighestSalary;
	}
	
	public ArrayList<Employee> getHighestEarningEmployeeDetailsFromEachDepartment(){
		ArrayList<String> departmentList = getArrayListWithUniqueDepartmentValue();
		ArrayList<Employee> employeeList = addEmployeeToArrayList();
		
		ArrayList<Employee> finalFilteredEmployeeArrayList = new ArrayList<>();
		
		Employee highestEarningEmployeeDetailsFromEachDepartment = null;
				
		for(String dept : departmentList) {
			for(Employee emp : employeeList) {
				if(emp.getDepartment().equals(dept)) {
					if(highestEarningEmployeeDetailsFromEachDepartment == null || 
							highestEarningEmployeeDetailsFromEachDepartment.getSalary() < emp.getSalary() || 
									!highestEarningEmployeeDetailsFromEachDepartment.getDepartment().equals(dept)) {
						highestEarningEmployeeDetailsFromEachDepartment = emp;
					}
				}
			}
			finalFilteredEmployeeArrayList.add(highestEarningEmployeeDetailsFromEachDepartment);
		}
		
		return finalFilteredEmployeeArrayList;
	}
	
	public ArrayList<Employee> getHighestEarningEmployeeDetailsFromEachDepartmentInSortedOrder(){		
		// selection sort example
		ArrayList<Employee> highestSalaryFromEachDept1 = getHighestEarningEmployeeDetailsFromEachDepartment();
		
		for(int i = 0; i < highestSalaryFromEachDept1.size(); i++) {
			for(int j = i + 1; j < highestSalaryFromEachDept1.size(); j++) {
				if(highestSalaryFromEachDept1.get(j).getSalary() < highestSalaryFromEachDept1.get(i).getSalary()) {
					Employee temp = highestSalaryFromEachDept1.get(j);
					highestSalaryFromEachDept1.set(j, highestSalaryFromEachDept1.get(i));
					highestSalaryFromEachDept1.set(i, temp);
				}
			}
		}
		
		// bubble sort example
		ArrayList<Employee> highestSalaryFromEachDept2 = getHighestEarningEmployeeDetailsFromEachDepartment();
		
		for(int i = 0; i < highestSalaryFromEachDept2.size() - 1; i++) {
			for(int j = 0; j < highestSalaryFromEachDept2.size() - 1 - i; j++) {
				if(highestSalaryFromEachDept2.get(j + 1).getSalary() < highestSalaryFromEachDept2.get(j).getSalary()) {
					Employee temp = highestSalaryFromEachDept2.get(j + 1);
					highestSalaryFromEachDept2.set(j + 1, highestSalaryFromEachDept2.get(j));
					highestSalaryFromEachDept2.set(j, temp);
				}
			}
		}
		
		// quick sort example
		ArrayList<Employee> highestSalaryFromEachDept3 = getHighestEarningEmployeeDetailsFromEachDepartment();
		
		return quickSorting(highestSalaryFromEachDept3);
	}
	
	public ArrayList<Employee> quickSorting(ArrayList<Employee> emp){
		
	    if (emp.size() < 2) {
	        return emp;
	    }
		
		Employee pivot = emp.get(emp.size() -1);
		ArrayList<Employee> left = new ArrayList<Employee>();
		ArrayList<Employee> right = new ArrayList<Employee>();
		
		for(int i = 0; i < emp.size() - 1; i++) {
			if(emp.get(i).getSalary() < pivot.getSalary()) {
				left.add(emp.get(i));
			} else {
				right.add(emp.get(i));
			}
		}
		
		ArrayList<Employee> sortedArrayList = new ArrayList<Employee>();
		
		sortedArrayList.addAll(quickSorting(left));
		sortedArrayList.add(pivot);
		sortedArrayList.addAll(quickSorting(right));
		
		return sortedArrayList;
	}
	
	public String getReverse(String str) {
		String rev = "";
		
		for(int i = str.length() - 1; i >= 0; i--) {
			rev += str.charAt(i);
		};
		return rev;
	}
	
	public boolean isPalindrome(String str) {
		for(int i = 0; i < str.length()/2; i++) {
			if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		};
		return true;
	}
	
	public int getReverse(int num) {
		if (num < 0) return 0;
		
		int temp = num;
		int rev = 0;

		while(temp != 0) {
			rev = rev * 10 + temp % 10;
			temp = temp / 10;
		}
		
		return rev;
	}
	
	public boolean isPalindrome(int num) {
		
		return num == getReverse(num);
	}
}

public class P00Questions{
	public static void main(String[] args) {
		Utils utils = new Utils();
		
		System.out.println(utils.getHighestEarningEmployeeDetailsAmongDepartments());
		
		System.out.println(utils.getHighestEarningEmployeeDetailsFromEachDepartment());
		
		System.out.println(utils.getHighestEarningEmployeeDetailsFromEachDepartmentInSortedOrder());
		
		System.out.println("reverse is : " + utils.getReverse("anurag"));
		
		System.out.println("reverse is : " + utils.getReverse(9876));
		
		System.out.println("is palindrome : " + utils.isPalindrome("madam"));
		
		System.out.println("is palindrome : " + utils.isPalindrome("listen"));
		
		System.out.println("is palindrome : " + utils.isPalindrome(12321));
		
		System.out.println("is palindrome : " + utils.isPalindrome(12345));
	}
}