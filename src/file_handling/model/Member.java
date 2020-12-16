package file_handling.model;

import java.io.Serializable;

public class Member implements Serializable {
	
	private int index;
	private String firstname;
	private String lastname;
	private int age;
	
	public Member(String firstname,String lastname,int age) {

		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}
	
	public String getFirstName() {
		return this.firstname;
	}
	
	public String getLastname() {
		return this.lastname;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
}
