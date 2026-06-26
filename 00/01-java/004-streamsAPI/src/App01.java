import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Employee01 {
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

	Employee01(int id, String name, String department, double salary){
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



public class App01 {
	public static void main(String[] args) {
		/**
		 * older way
		 */
		List<Employee01> employees = Arrays.asList(
		        new Employee01(1, "Anurag", "IT", 90000),
		        new Employee01(2, "Rahul", "HR", 60000),
		        new Employee01(3, "John", "IT", 20000),
		        new Employee01(4, "David", "Finance", 70000)
		);
		
		List<Employee01> resultOlderWay = new ArrayList<>();
		for(Employee01 e : employees){
		    if(e.getDepartment().equals("IT")){
		    	resultOlderWay.add(e);
		    }
		}
		System.out.println(resultOlderWay);
		
		
		
		/**
		 * newer way
		 */
		List<Employee01> resultNewerWay = employees.stream()
		        .filter(emp -> emp.getDepartment().equals("IT"))
		        .collect(Collectors.toList());
		System.out.println(resultNewerWay);
		
		
		
		/**
		 * chaining multiple filters
		 */
		List<Employee01> resultNewerWayMultipleFilters = employees.stream()
		        .filter(emp -> emp.getDepartment().equals("IT"))
		        .filter(emp -> emp.getSalary() > 80000)
		        .collect(Collectors.toList());
		System.out.println(resultNewerWayMultipleFilters);
		
		
		
		List<Employee01> sorted = employees.stream()
		        .sorted(Comparator.comparing(Employee01::getSalary))
		        .collect(Collectors.toList());
		System.out.println(sorted);
		
		
		
		List<Employee01> sortedDesc = employees.stream()
		        .sorted(Comparator.comparing(Employee01::getSalary)
		        .reversed())
		        .collect(Collectors.toList());
		System.out.println(sortedDesc);
		
		
		
		List<String> uniqueDepartments = employees.stream()
		        .map(Employee01::getDepartment)
		        .distinct()
		        .collect(Collectors.toList());
		System.out.println(uniqueDepartments);
		
		
		
		List<Employee01> limitList = employees.stream()
		.sorted(Comparator.comparing(Employee01::getSalary).reversed())
		.limit(3)
		.collect(Collectors.toList());
		System.out.println(limitList);
		
		
		
		List<Employee01> skip = employees.stream().skip(3).limit(3).collect(Collectors.toList());
		System.out.println(skip);
		
		
		
		long total = employees.stream().filter(e -> e.getDepartment().equals("IT")).count();
		System.out.println(total);
		
		
		
		boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 100000);
		System.out.println(anyMatch);
		
		
		
		boolean allMatch = employees.stream().allMatch(e -> e.getSalary() > 50000);
		System.out.println(allMatch);
		
		
		
		boolean nonMatch = employees.stream().noneMatch(e -> e.getSalary() < 50000);
		System.out.println(nonMatch);
		
		
		
		Employee01 findFirst = employees.stream().filter(e -> e.getDepartment().equals("IT")).findFirst().orElse(null);
		System.out.println(findFirst);
		
		
		
		employees.stream().forEach(System.out::println);
		
		
		
		double sum = employees.stream().map(Employee01::getSalary).reduce(0.0, Double::sum);
		System.out.println(sum);
		
		
		
		double max = employees.stream().map(Employee01::getSalary).reduce(Double::max).orElse(0.0);
		System.out.println(max);
		
		
		
		String names = employees.stream().map(Employee01::getName).reduce("",(a,b) -> a + " " + b);
		System.out.println(names);
		
		
		
		Set<String> collectToSet = employees.stream().map(Employee01::getName).collect(Collectors.toSet());
		System.out.println(collectToSet);
		
		
		
		Map<Integer,String> collectToMap = employees.stream().collect(Collectors.toMap(Employee01::getId, Employee01::getName));
		System.out.println(collectToMap);
		
		
		
		String joining = employees.stream().map(Employee01::getName).collect(Collectors.joining(", "));
		System.out.println(joining);
	}
}
