import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee02 {
    private int id;
    private String name;
    private String department;
    private double salary;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

    String getDepartment() {
    	return this.department;
    }
	public void setDepartment(String department) {
		this.department = department;
	}

    Employee02(int id, String name, String department, double salary){
    	this.id = id;
    	this.name = name;
    	this.department = department;
    	this.salary = salary;
    }
    
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}
}



public class App02 {
	public static void main(String[] args) {
		List<Employee02> employees = Arrays.asList(
			    new Employee02(1, "Anurag", "IT", 90000),
			    new Employee02(2, "Rahul", "HR", 60000),
			    new Employee02(3, "John", "IT", 120000),
			    new Employee02(4, "David", "Finance", 70000),
			    new Employee02(5, "Amit", "IT", 85000),
			    new Employee02(6, "Priya", "HR", 65000),
			    new Employee02(7, "Neha", "Finance", 95000)
			);
		
		
		
		Map<String, List<Employee02>> groupEmpByDept = employees.stream()
		        .collect(Collectors.groupingBy(Employee02::getDepartment));
		System.out.println(groupEmpByDept);
		
		
		
		Map<String, Long> countEmpDeptWise = employees.stream()
				.collect(Collectors.groupingBy(
				Employee02::getDepartment,
				Collectors.counting()
				));
		System.out.println(countEmpDeptWise);
		
		
		
		Map<String, Double> avgSalaryByDept = employees.stream()
				.collect(Collectors.groupingBy(
				Employee02::getDepartment,
				Collectors.averagingDouble(Employee02::getSalary)
				));
		System.out.println(avgSalaryByDept);
		
		
		
		Map<String, Double> totalSalaryDeptWise = employees.stream()
				.collect(Collectors.groupingBy(
				Employee02::getDepartment,
				Collectors.summingDouble(Employee02::getSalary)
				));
		System.out.println(totalSalaryDeptWise);
		
		
		
		Map<String, Optional<Employee02>> highestPaidEmpInEachDept = employees.stream()
				.collect(Collectors.groupingBy(
				Employee02::getDepartment,
				Collectors.maxBy(
				Comparator.comparing(Employee02::getSalary)
				)
				));
		System.out.println(highestPaidEmpInEachDept);
		
		
		
		Map<String,List<String>> empNamesDeptWise = employees.stream()
				.collect(Collectors.groupingBy(
				Employee02::getDepartment,
				Collectors.mapping(
				Employee02::getName,
				Collectors.toList()
				)
				));
		System.out.println(empNamesDeptWise);
	}
}
