package streamapi;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmpMgmtExercize2 {
	public static void main(String[] args) {
		List<Employee> list = Employee.getEmployeesList();
		//List of employee object, Convert into map using Java 8, key should be employee ID and value should be employee Object.
		list.stream().collect(Collectors.toMap(Employee::getId,Function.identity())).forEach((x,y) -> System.out.println(y));

		//Query 3.1 : How many male and female employees are there in the organization?
		
		
		//Query 3.2 : Print the name of all departments in the organization?
		
		
		//What is the average age of male and female employees?
		
		
		//Query 3.4 : Get the details of highest paid employee in the organization?
		
		
		//Query 3.5 : Get the names of all employees who have joined after 2015?
		
		
		//Query 3.6 : Count the number of employees in each department?
		
		
		//Query 3.7 : What is the average salary of each department?
		
		
		//Query 3.8 : Get the details of youngest male employee in the product development department?
		
		
		//Query 3.9 : Who has the most working experience in the organization?
		
		//Query 3.10 : How many male and female employees are there in the sales and marketing team?
					
		//Query 3.11 : What is the average salary of male and female employees?
				
		//Query 3.12 : List down the names of all employees in each department?
				
		//Query 3.13 : What is the average salary and total salary of the whole organization?
				
		//Query 3.14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
				
		//Query 3.15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
				
		//Wipro : find second largest salary employee
	}
}
