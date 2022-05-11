package streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeMgmt {

	public static void main(String[] args) {
		List<Employee> list = Employee.getEmployeesList();

		list.stream().sorted(Comparator.comparingInt(Employee::getId)).forEach(System.out::println);
		list.stream().max(Comparator.comparingInt(Employee::getAge)).stream().forEach(System.out::println);
		list.stream().min(Comparator.comparingInt(Employee::getAge)).stream().forEach(System.out::println);
		//======================String occurrence count start===========================//
		List<String> strList = Arrays.asList("abc","abc","abc","bcd");
		HashMap<String,Long> occuranceCount = strList.stream().collect(Collectors.groupingBy(s -> s, HashMap::new, Collectors.counting()));
		System.out.println(occuranceCount);
		Map<String, Long> charCount = strList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(charCount);
		//======================String occurrence count end===========================//
		
		//Query 3.1 : How many male and female employees are there in the organization?
		Map<String, Long> maleFemaleCount = list.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println("Count Male Female:"+maleFemaleCount);
		//Query 3.2 : Print the name of all departments in the organization?
		list.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
		
		//Query 3.3 :What is the average age of male and female employees?
		Map<String, Double> avgAgeMaleFemale = list.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
		System.out.println("Avarage Age Male Female:"+avgAgeMaleFemale);
		
		//Query 3.4 : Get the details of highest paid employee in the organization?
		Employee highestPaidEmployee = list.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
		System.out.println("Highest Paid Employee:"+highestPaidEmployee);
		
		//Query 3.5 : Get the names of all employees who have joined after 2015?
		List<String> empListAfter2015 = list.stream().filter(e -> 2015>e.getYearOfJoining()).map(Employee::getName).collect(Collectors.toList());
		System.out.println("empListAfter2015:"+empListAfter2015);
		
		//Query 3.6 : Count the number of employees in each department?
		Map<String, Long> deptCount = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		System.out.println("deptCount:"+deptCount);
		
		//Query 3.7 : What is the average salary of each department?
		Map<String, Double> avgSalEachDept = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("avgSalEachDept:"+avgSalEachDept);
		
		//Query 3.8 : Get the details of youngest male employee in the product development department?
		Employee youngMaleEmpInProdDevDept = list.stream().filter(e ->  e.getGender()=="Male" && "Product Development".equals(e.getDepartment())).min(Comparator.comparingInt(Employee::getAge)).get();
		System.out.println("youngest emp product dev:"+youngMaleEmpInProdDevDept);
		
		//Query 3.9 : Who has the most working experience in the organization?
		Employee mostExperienced = list.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).get();
		System.out.println("mostExperienced:"+mostExperienced);
		
		//Query 3.10 : How many male and female employees are there in the sales and marketing team?
		Map<String, Long> maleFemaleInSales = list.stream().filter(e -> "Sales And Marketing".equals(e.getDepartment())).collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println("maleFemaleInSales:"+maleFemaleInSales);
		
		//Query 3.11 : What is the average salary of male and female employees?
		Map<String, Double> avgMaleFemaleSalary = list.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("avgMaleFemaleSalary:"+avgMaleFemaleSalary);
		
		//Query 3.12 : List down the names of all employees in each department?
		Map<String, List<Employee>> listAllEmplDept = list.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("listAllEmplDept:"+listAllEmplDept);
		
		//Query 3.13 : What is the average salary and total salary of the whole organization?
		DoubleSummaryStatistics avgSalryAndTotalSal = list.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("avarage salry:"+avgSalryAndTotalSal.getAverage()+"--total salary:"+avgSalryAndTotalSal.getSum());
		
		//Query 3.14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
		Map<Boolean, List<Employee>> partitionEmployeesByAge=list.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));
		System.out.println("partitionEmployeesByAge:"+partitionEmployeesByAge);
		
		//Query 3.15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
		String oldestEmplDept = list.stream().max(Comparator.comparingInt(Employee::getAge)).map(Employee::getDepartment).get();
		System.out.println("oldestEmplDept:"+oldestEmplDept);
		
		//Wipro : find second largest salary employee
		Employee secondLargestSalary = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
				 .skip(1).findFirst().get();
		System.out.println("secondLargestSalary:"+secondLargestSalary);
	}
}


