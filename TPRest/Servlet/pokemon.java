package fr.polytech.TPRest.Servlet;

public class pokemon {
	String 	nom;
	int 	niveau;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public pokemon(String nom, int niveau) {
		super();
		this.nom = nom;
		this.niveau = niveau;
	}
	public pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "pokemon [nom=" + nom + ", niveau=" + niveau + "]";
	}
	
	
}
