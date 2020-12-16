package file_handling.service;

import java.io.Console;
import java.util.ArrayList;

import file_handling.manager.ConsoleManager;
import file_handling.manager.FileManager;
import file_handling.model.Club;
import file_handling.model.Member;

public class MemberService {

	private boolean done;
	private FileManager fileManager;
	private ArrayList<Club> clubs = new ArrayList<>();

	public MemberService() {
		done = false;
		fileManager = new FileManager();
	}

	public void run() {

		init();
		// print the beautiful app title
		printApplicationTitle();

		String answer;

		do {
			// print the menu & get the user's answer back in return
			answer = printMenu();

			// handle the user action
			handleAction(answer);

		} while (!answer.equalsIgnoreCase(UserActions.EXIT.getValue())); // loop while until user wants to exit

		done = true;
	}

	private void init() {
		fileManager.initFile();
		clubs = fileManager.readClubsFromFile();
	}

	private void handleAction(String action) {
		if (action.equalsIgnoreCase(UserActions.LIST_CLUBS.getValue())) {
			listClubs();
		}
		if (action.equalsIgnoreCase(UserActions.LIST_MEMBERS.getValue())) {
			listMembersOfClub();
		}
		if (action.equalsIgnoreCase(UserActions.ADD_MEMBER.getValue())) {
			addMemberOfClub();
		}
		if (action.equalsIgnoreCase(UserActions.REMOVE_MEMBER.getValue())) {
			deleteMemberOfClub();
		}
		if (action.equalsIgnoreCase(UserActions.ADD_CLUBS.getValue())) {
			addClub();
		}

	}

	private void printApplicationTitle() {
		ConsoleManager.getInstance().consoleLineBreak();
		ConsoleManager.getInstance().printLine();
		ConsoleManager.getInstance().printToConsole("Members Manager", true);
		ConsoleManager.getInstance().printLine();
		ConsoleManager.getInstance().consoleLineBreak();
	}

	private void listClubs() {

		clubs = fileManager.readClubsFromFile();
		for (Club club : clubs) {
			ConsoleManager.getInstance().printToConsole("Nom du club: " + club.getName(), true);
		}

	}
	
	private void addClub() {

		clubs = fileManager.readClubsFromFile();
		
		ConsoleManager.getInstance().printToConsole("name of club: ", true);
		String clubName = ConsoleManager.getInstance().readUserInput();

		Club club = new Club(clubName);

		fileManager.addClubFile(club);
		clubs = fileManager.readClubsFromFile();

	}

	private void listMembersOfClub() {

		clubs = fileManager.readClubsFromFile();
		int answer = -1;
		while (answer < 0 || answer > clubs.size()) {

			ConsoleManager.getInstance().printToConsole("Which club? ", true);
			int index = 0;
			for (Club club : clubs) {
				ConsoleManager.getInstance().printToConsole(index + " - " + club.getName(), true);
				index++;
			}
			answer = ConsoleManager.getInstance().readUserInputInteger();

		}
		for (Member member : clubs.get(answer).getMembers()) {
			ConsoleManager.getInstance().printToConsole(member.getFirstName() + " "+ member.getLastname(), true);
		}
		if (clubs.get(answer).getMembers().isEmpty()) {
			ConsoleManager.getInstance().printToConsole("aucun membre pour l'instant", true);
		}

	}

	private void addMemberOfClub() {

		clubs = fileManager.readClubsFromFile();
		int answer = -1;
		while (answer < 0 || answer > clubs.size()) {

			ConsoleManager.getInstance().printToConsole("Which club? ", true);
			int index = 0;
			for (Club club : clubs) {
				ConsoleManager.getInstance().printToConsole(index + " - " + club.getName(), true);
				index++;
			}
			answer = ConsoleManager.getInstance().readUserInputInteger();

		}
		ConsoleManager.getInstance().printToConsole("firstname: ", true);
		String firstname = ConsoleManager.getInstance().readUserInput();
		ConsoleManager.getInstance().printToConsole("lastname: ", true);
		String lastname = ConsoleManager.getInstance().readUserInput();
		ConsoleManager.getInstance().printToConsole("age: ", true);
		int age = ConsoleManager.getInstance().readUserInputInteger();

		Member member = new Member(firstname, lastname, age);

		fileManager.addMemberOfClub(answer, member);
		clubs = fileManager.readClubsFromFile();

	}

	private void deleteMemberOfClub() {

		clubs = fileManager.readClubsFromFile();
		int indexClub = -1;
		while (indexClub < 0 || indexClub > clubs.size()) {

			ConsoleManager.getInstance().printToConsole("Which club? ", true);
			int index = 0;
			for (Club club : clubs) {
				ConsoleManager.getInstance().printToConsole(index + " - " + club.getName(), true);
				index++;
			}
			indexClub = ConsoleManager.getInstance().readUserInputInteger();

		}
		int indexMember = -1;
		while (indexMember < 0 || indexMember > clubs.get(indexClub).getMembers().size()) {

			ConsoleManager.getInstance().printToConsole("Which member? ", true);
			int index = 0;
			for (Member member: clubs.get(indexClub).getMembers()) {
				ConsoleManager.getInstance().printToConsole(index + " - " + member.getFirstName() + " "+ member.getLastname(), true);
				index++;
			}
			indexMember = ConsoleManager.getInstance().readUserInputInteger();

		}


		fileManager.deleteMemberOfAClub(indexClub, indexMember);
		clubs = fileManager.readClubsFromFile();

	}

	private String printMenu() {
		boolean rightAnswer = false;
		String answer = "";

		do {
			// print the option menu

			ConsoleManager.getInstance().consoleLineBreak();
			ConsoleManager.getInstance().printToConsole("What do you want to do ? ", true);
			ConsoleManager.getInstance().printToConsole(UserActions.LIST_CLUBS.getValue() + " - List clubs ", true);
			ConsoleManager.getInstance().printToConsole(UserActions.ADD_CLUBS.getValue() + " - Add a club ", true);
			ConsoleManager.getInstance().printToConsole(UserActions.LIST_MEMBERS.getValue() + " - List members of club",
					true);
			ConsoleManager.getInstance().printToConsole(UserActions.ADD_MEMBER.getValue() + " - Add a member of a club",
					true);
			ConsoleManager.getInstance()
					.printToConsole(UserActions.REMOVE_MEMBER.getValue() + " - Delete a member of a club", true);
			ConsoleManager.getInstance().printToConsole(UserActions.EXIT.getValue() + " - Quitter", true);

			// ask user answer
			answer = ConsoleManager.getInstance().readUserInput();

			if (UserActions.containsAction(answer)) {
				rightAnswer = true;
			}
		} while (!rightAnswer);

		return answer;
	}
}
