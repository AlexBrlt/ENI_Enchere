package fr.eni.projet.enchere.bo;

public class Category {

	private int no_categorie;
	private String libelle;

	// GETTER & SETTER

	public int getNo_categorie() {
		return no_categorie;
	}

	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	// CONSTRUCTEUR

	public Category(int no_categorie, String libelle) {
		
		this.no_categorie = no_categorie;
		this.libelle = libelle;
	}

	// ToString

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categories [no_categorie=");
		builder.append(no_categorie);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append("]");
		return builder.toString();
	}

}
