public class Employee {
	private int id;
	private String firstName;

	public Employee() {
		this.id = 1;
		this.firstName = "Andres";
	}

	public void setId( int id ) {
		this.id = id;
	}

	public int getId() {
		return id;
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
