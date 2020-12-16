package exercicesSuite;

import java.util.Comparator;

public class MemberFirstNameComparator implements Comparator<Member> {

	@Override
	public int compare(Member o1, Member o2) {
		return o1.getFirstName().compareTo(o2.getFirstName());
	}

}
