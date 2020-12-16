package file_handling.manager;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import file_handling.model.Club;
import file_handling.model.Member;

public class FileManager {

	private String currentPath;

	public FileManager() {
		currentPath = "C:\\Users\\Khele\\Desktop\\test";

	}

	public void initFile() {

		File currentFolder = new File(currentPath);

		File file = currentFolder.listFiles()[0];

		if (readClubsFromFile().isEmpty()) {

			try (FileOutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				Club club = new Club("OM");

				ArrayList<Club> clubs = new ArrayList<>();
				clubs.add(club);
				oos.writeObject(club);
				System.out.println("club créé!");

			} catch (Exception e) {

			}

		}

	}

	public ArrayList<Club> readClubsFromFile() {
		File currentFolder = new File(currentPath);

		ArrayList<Club> clubs = new ArrayList<>();

		for (File file : currentFolder.listFiles()) {

			try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
				Club club;

				while ((club = (Club) ois.readObject()) != null) {
					clubs.add(club);
				}

			} catch (IOException | ClassNotFoundException e) {
				if (e instanceof EOFException) {

				} else {
					e.printStackTrace();
				}
			}

		}

		return clubs;
	}

	public void addMemberOfClub(int index, Member member) {
		File currentFolder = new File(currentPath);

		File file = currentFolder.listFiles()[index];

		int counter = 0;

		Club myClub = null;
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis);) {
			Club club;
			while ((club = (Club) ois.readObject()) != null) {

				if (counter == index) {
					myClub = club;
				}
				counter++;
			}

		} catch (IOException | ClassNotFoundException e) {
			if (e instanceof EOFException) {

			} else {
				e.printStackTrace();
			}
		}
		if (myClub != null) {
			myClub.addMember(member);
			try (FileOutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				Club club;
				ConsoleManager.getInstance().printToConsole("membre ajouté", true);
				oos.writeObject(myClub);

			} catch (IOException e) {
				if (e instanceof EOFException) {

				} else {
					e.printStackTrace();
				}
			}
		}

	}

	public void addClubFile(Club club) {
		File currentFolder = new File(currentPath);

		System.out.println(currentFolder + "\\" + club.getName());
		File file = new File(currentFolder + "\\" + club.getName() + ".txt");

		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			oos.writeObject(club);
			System.out.println("club créé!");

		} catch (Exception e) {

		}
	}

	public void deleteMemberOfAClub(int index, int memberIndex) {
		File currentFolder = new File(currentPath);

		File file = currentFolder.listFiles()[0];

		int counter = 0;

		Club myClub = null;
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis);) {
			Club club;
			while ((club = (Club) ois.readObject()) != null) {

				if (counter == index) {
					myClub = club;
				}
				counter++;
			}

		} catch (IOException | ClassNotFoundException e) {
			if (e instanceof EOFException) {

			} else {
				e.printStackTrace();
			}
		}
		if (myClub != null) {
			myClub.removeMember(memberIndex);
			try (FileOutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				Club club;
				ConsoleManager.getInstance().printToConsole("membre supprimé", true);
				oos.writeObject(myClub);

			} catch (IOException e) {
				if (e instanceof EOFException) {

				} else {
					e.printStackTrace();
				}
			}
		}

	}

}
