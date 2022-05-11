package streamapi;

public class Main {

	public static void main(String[] args) throws Exception {
		Employee employee=new Employee(111, "Jiya Brein", 26, "Female", "HR", 2011, 25000.0,"jiyagmail.com");
		ValidationResult result = EmployeeValidator.emailNoValid()
				.and(EmployeeValidator.isAbove25Valid())
				.apply(employee);
		
		if(result !=ValidationResult.SUCCESS) {
			throw new Exception(result.name());
		}
	}
}
