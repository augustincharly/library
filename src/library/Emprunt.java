package library;

import java.util.Date;

public class Emprunt {

	private int id;
	private Date dateEmprunt;
	private Date dateRetour;
	private String firstnameEmprunteur;
	private String lastnameEmprunteur;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public String getFirstnameEmprunteur() {
		return firstnameEmprunteur;
	}

	public void setFirstnameEmprunteur(String firstnameEmprunteur) {
		this.firstnameEmprunteur = firstnameEmprunteur;
	}

	public String getLastnameEmprunteur() {
		return lastnameEmprunteur;
	}

	public void setLastnameEmprunteur(String lastnameEmprunteur) {
		this.lastnameEmprunteur = lastnameEmprunteur;
	}

}
