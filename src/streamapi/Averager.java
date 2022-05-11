package streamapi;

import java.util.List;
import java.util.function.DoubleConsumer;

class Averager implements DoubleConsumer{
    private double total = 0;
    private double count = 0;
        
    public double average() {
        return count > 0 ? ((double) total)/count : 0;
    }
        
    public void accept(double i) { total += i; count++; }
    
    public void combine(Averager other) {
        total += other.total;
        count += other.count;
    }
    
  //  public String toString() {
   // 	return String.format("Total Salaries = %d, Number Developers = %d, Average Salary = %.2f", this.total, this.count, average());
  //  }
    
    public static void main(String[] args) {
		List<Employee> employeesList = Employee.getEmployeesList();
		Averager averageCollect = employeesList.stream()
				.map(Employee::getSalary)
				.collect(Averager::new, Averager::accept, Averager::combine);

		System.out.println(averageCollect);
	}
}
		


