package library;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Book {

	private int id;
	private String title;
	private LocalDate publishDate;
	private ArrayList<Emprunt> emprunts;
	

	
	public Book(int id, String title) {
		this.id = id;
		this.title = title;
		this.publishDate = LocalDate.now();
		emprunts = new ArrayList<>();
	}

	public void addEmprunt(Emprunt emprunt) {
		this.emprunts.add(emprunt);
	}
	
	public void removeEmprunt(Emprunt emprunt) {
		this.emprunts.add(emprunt);
	}

	public ArrayList<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(ArrayList<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}
