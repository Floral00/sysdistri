package fr.polytech.TPRest.Servlet;

public class person {
	String firstName;
	String lastName;
	
	public person() {
		super();
	}
	
	public person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
