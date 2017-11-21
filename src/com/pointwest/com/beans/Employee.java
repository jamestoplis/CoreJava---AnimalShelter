public class Employee {
	private int employeeId;

	public Employee() {
		this.employeeId = 1;
	}

	public void setEmployeeId( int employeeId ) {
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String greet() {
		System.out.println( "WHAAZZAAAAAP" );
	}
}