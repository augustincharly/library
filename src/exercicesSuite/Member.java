package exercicesSuite;

import java.util.Date;

public class Member implements Comparable<Member>  {
	
	private Integer id;
	private String firstName;
	private String lastName;
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public Member(Integer id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public int compareTo(Member o) {
		if (id < o.id) {
			return -1;
		} else if (id > o.id) {
			return 1;
		} else {
			return 0;
		}
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	
	
	

}
