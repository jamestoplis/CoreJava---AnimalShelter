public class Employee {
	private int employeeId;
	private String firstName;

	public Employee() {
		this.employeeId = 1;
		this.firstName = "Andres";
	}

	public void setEmployeeId( int employeeId ) {
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setFirstName( String firstName ) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String greet() {
		System.out.println( "WHAAZZAAAAAP" );
	}
}
