import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class App{
	public class Employee {
		public String name;
		public double salary;
		public String department;
		
		public Employee(String name, String department, double salary) {
			this.name = name;
			this.department = department;
			this.salary = salary;
		}
		
		public String getDepartment() {
			return department;
		}
		
		public double getSalary() {
			return salary;
		}

		@Override
		public String toString() {
			return "Employee [name=" + name + ", salary=" + salary + ", department=" + department + "]";
		}
	}
	
	
	
	
	public List<Employee> getEmployeeList() {
		List<Employee> empArrayList = new ArrayList<App.Employee>(Arrays.asList(
				new Employee("anurag", "IT", 29000),
				new Employee("anjan", "SALES", 69000),
				new Employee("amar", "SALES", 12000),
				new Employee("nitish", "HR", 99000),
				new Employee("seema", "IT", 79000)
				));
		
		return empArrayList;
	}
	
	
	
	public List<String> getDepartmentList(){
		List<String> dep = new ArrayList<String>();
		
		for(Employee emp : getEmployeeList()) {
			if(!dep.contains(emp.getDepartment())) {
				dep.add(emp.getDepartment());
			}
		}
		
		System.out.println(dep);
		return dep;
	}
	
	
	
	public List<Employee> getHighestEarningFromEachDepartment(){
		List<Employee> emp = new ArrayList<App.Employee>();
		
		Employee tempHighestEarningEmployee = null;
		
		for(String d : getDepartmentList()) {
			for(Employee e : getEmployeeList()) {
				if(e.getDepartment().equals(d)) {
					if(tempHighestEarningEmployee == null || 
							tempHighestEarningEmployee.getSalary() < e.getSalary()) {
						tempHighestEarningEmployee = e;
					}
				}
			}
			emp.add(tempHighestEarningEmployee);
			tempHighestEarningEmployee = null;
		}
		
		System.out.println(emp);
		return emp;
	}
	
	
	
	public Employee getHighestEarningAmongDepartmnets(){	
		
		// normal way
		Employee tempHighestEarningEmployee1 = null;
		
		for(Employee e : getEmployeeList()) {
			if(tempHighestEarningEmployee1 == null || 
					tempHighestEarningEmployee1.getSalary() < e.getSalary()) {
				tempHighestEarningEmployee1 = e;
			}
		}
		System.out.println(tempHighestEarningEmployee1);

		
		// steam way
		Employee tempHighestEarningEmployee2 = getEmployeeList().stream()
				.max(Comparator.comparingDouble(Employee::getSalary))
				.orElse(null);
		return tempHighestEarningEmployee2;
	}
	
	
	
	public static void main(String[] args) {
		App app = new App();
		
		app.getDepartmentList();
		app.getHighestEarningFromEachDepartment();
		app.getHighestEarningAmongDepartmnets();
	}
}