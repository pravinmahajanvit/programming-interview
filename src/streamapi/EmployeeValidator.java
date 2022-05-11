package streamapi;

import java.util.function.Function;


public interface EmployeeValidator extends Function<Employee, ValidationResult> {

	
	static EmployeeValidator emailNoValid() {
		return employee ->employee.getEmail().contains("@") ? ValidationResult.SUCCESS: ValidationResult.EMAIL_NOT_VALID;
	}
	static EmployeeValidator isAbove25Valid() {
		return em ->em.getAge() >25 ? ValidationResult.SUCCESS: ValidationResult.IS_NOT_ABOVE_25;
	}
	default EmployeeValidator and (EmployeeValidator other) {
		return employee -> {
			ValidationResult result=this.apply(employee);
			return result.equals(ValidationResult.SUCCESS) ? other.apply(employee):result;
		};
	}
}
