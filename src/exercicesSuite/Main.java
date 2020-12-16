package exercicesSuite;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import sun.jvm.hotspot.gc.shared.CollectedHeap;
import sun.util.resources.LocaleData;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Book> books = new ArrayList<>();
		
		books.add(new Book(0, "Le livre de la jungle", "l'histoire de Mowgli"));
		books.add(new Book(0, "1984", "l'histoire d'une dystopie"));
		books.add(new Book(0, "Sapiens", "l'histoire de l'humanité"));
		
		
		Book monLivre = new Book(0, "Sapiens", "l'histoire de l'humanité");
		
		System.out.println("Vérification...");
		Member member1 = new Member(1, "John", "Doe");
		Member member2 = new Member(2, "Augustin", "Charly");
		Member member3 = new Member(3, "Barney", "Merchant");
		Member member4 = new Member(4, "Zack", "Aris");
		ArrayList<Member> members = new ArrayList<>(Arrays.asList(member1,member4,member2,member3));
		MemberIdComparator idComparator = new MemberIdComparator();
		MemberFirstNameComparator firstNameComparator = new MemberFirstNameComparator();
		MemberLastNameComparator lastNameComparator = new MemberLastNameComparator();

//		System.out.println("-------------  sans tri -----------");
//		for (Member member : members) {
//			System.out.println(member);
//		}
//		Collections.sort(members, idComparator);
//		System.out.println("-------------  par id -----------");
//		for (Member member : members) {
//			System.out.println(member);
//		}
//		System.out.println("-------------- par firstname  -----------");
//		Collections.sort(members, firstNameComparator);
//		for (Member member : members) {
//			System.out.println(member);
//		}
//		System.out.println("-------------- par lastname  -----------");
//		Collections.sort(members, lastNameComparator);
//		for (Member member : members) {
//			System.out.println(member);
//		}
		
		
		System.out.println(LocalDate.of(1989, 8, 15));
		DateFormat format = new SimpleDateFormat("yyyy-mm");
		LocalDateTime today = LocalDateTime.now();
		System.out.println(today.format(DateTimeFormatter.ofPattern("dd-M-yyyy")));
	}

}
