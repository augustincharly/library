package file_handling.model;

import java.io.Serializable;
import java.util.ArrayList;



public class Club implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Member> members;
	private String name;

	public Club(String name) {
		members = new ArrayList<>();
		this.name = name;
	}
	
	public void addMember(Member member) {
		member.setIndex(members.size());
		this.members.add(member);
	}
	
	public void removeMember(int index) {
		this.members.remove(index);
	}
	
	public ArrayList<Member> getMembers(){
		return members;
	}
	
	public String getName() {
		return this.name;
	}
	
}
