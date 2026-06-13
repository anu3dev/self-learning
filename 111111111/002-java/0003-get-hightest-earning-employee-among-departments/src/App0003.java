import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class App0003{
	public class AllEmployeeAmongDepartments {
		public String name;
		public double salary;
		public String department;
		
		public AllEmployeeAmongDepartments(String name, String department, double salary) {
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
	
	
	
	
	public List<AllEmployeeAmongDepartments> getEmployeeList() {
		List<AllEmployeeAmongDepartments> empArrayList = new ArrayList<>(Arrays.asList(
				new AllEmployeeAmongDepartments("anurag", "IT", 29000),
				new AllEmployeeAmongDepartments("anjan", "SALES", 69000),
				new AllEmployeeAmongDepartments("amar", "SALES", 12000),
				new AllEmployeeAmongDepartments("nitish", "HR", 99000),
				new AllEmployeeAmongDepartments("seema", "IT", 79000)
				));
		
		return empArrayList;
	}
	
	
	
	public List<String> getDepartmentList(){
		List<String> dep = new ArrayList<String>();
		
		for(AllEmployeeAmongDepartments emp : getEmployeeList()) {
			if(!dep.contains(emp.getDepartment())) {
				dep.add(emp.getDepartment());
			}
		}
		
		return dep;
	}
	
	
	
	public List<AllEmployeeAmongDepartments> getHighestEarningFromEachDepartment(){
		List<AllEmployeeAmongDepartments> emp = new ArrayList<>();
		
		AllEmployeeAmongDepartments tempHighestEarningEmployee = null;
		
		for(String d : getDepartmentList()) {
			for(AllEmployeeAmongDepartments e : getEmployeeList()) {
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
		
		return emp;
	}
	
	
	
	public AllEmployeeAmongDepartments getHighestEarningAmongDepartmnets(){	
		
		// normal way
		AllEmployeeAmongDepartments tempHighestEarningEmployee1 = null;
		
		for(AllEmployeeAmongDepartments e : getEmployeeList()) {
			if(tempHighestEarningEmployee1 == null || 
					tempHighestEarningEmployee1.getSalary() < e.getSalary()) {
				tempHighestEarningEmployee1 = e;
			}
		}

		

		// steam way
		AllEmployeeAmongDepartments tempHighestEarningEmployee2 = getEmployeeList().stream()
				.max(Comparator.comparingDouble(AllEmployeeAmongDepartments::getSalary))
				.orElse(null);
		return tempHighestEarningEmployee2;
	}
	
	
	
	public static void main(String[] args) {
		App0003 app = new App0003();
		
		System.out.println("department list : " + app.getDepartmentList());
		System.out.println();
		System.out.println("highest earning from each dept : " + app.getHighestEarningFromEachDepartment());
		System.out.println();
		System.out.println("highest earning employee : " + app.getHighestEarningAmongDepartmnets());
	}
}