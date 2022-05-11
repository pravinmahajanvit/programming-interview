package streamapi;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmpMgmtExercize1 {
	public static void main(String[] args) {
		List<Employee> list = Employee.getEmployeesList();
		//List of employee object, Convert into map using Java 8, key should be employee ID and value should be employee Object.
		list.stream().collect(Collectors.toMap(Employee::getId,Function.identity(),(x,y) -> x,HashMap::new));
		
		//Query 3.1 : How many male and female employees are there in the organization?
		list.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		
		//Query 3.2 : Print the name of all departments in the organization?
		list.stream().distinct().map(Employee::getDepartment).distinct().forEach(System.out::println);
		
		//What is the average age of male and female employees?
		list.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
		
		//Query 3.4 : Get the details of highest paid employee in the organization?
		Employee employee = list.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
		
		//Query 3.5 : Get the names of all employees who have joined after 2015?
		list.stream().filter(e -> 2015 >e.getYearOfJoining()).map(Employee::getName).forEach(System.out::println);
		
		//Query 3.6 : Count the number of employees in each department?
		list.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		
		//Query 3.7 : What is the average salary of each department?
		list.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
		
		//Query 3.8 : Get the details of youngest male employee in the product development department?
		list.stream().filter(e->e.getGender().equals("Product Development") && e.getDepartment().equals("Product Development")).min(Comparator.comparingInt(Employee::getAge));
	}
}
