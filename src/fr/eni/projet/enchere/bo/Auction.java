package fr.eni.projet.enchere.bo;

import java.time.LocalDateTime;

public class Auction {

	private int no_enchere;
	private LocalDateTime date_enchere;
	private int montant;
	private int no_article;
	private int no_utilisateur;

	// GETTER & SETTER

	public int getNo_enchere() {
		return no_enchere;
	}

	public void setNo_enchere(int no_enchere) {
		this.no_enchere = no_enchere;
	}

	public LocalDateTime getDate_enchere() {
		return date_enchere;
	}

	public void setDate_enchere(LocalDateTime date_enchere) {
		this.date_enchere = date_enchere;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public int getNo_article() {
		return no_article;
	}

	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}

	public int getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	// CONSTRUCTEUR

	public Auction(int no_enchere, LocalDateTime date_enchere, int montant, int no_article, int no_utilisateur) {
		
		this.no_enchere = no_enchere;
		this.date_enchere = date_enchere;
		this.montant = montant;
		this.no_article = no_article;
		this.no_utilisateur = no_utilisateur;

		// ToString

	}
	
	
	

	public Auction(LocalDateTime date_enchere, int montant, int no_article, int no_utilisateur) {
		
		this.date_enchere = date_enchere;
		this.montant = montant;
		this.no_article = no_article;
		this.no_utilisateur = no_utilisateur;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Auction [no_enchere=");
		builder.append(no_enchere);
		builder.append(", date_enchere=");
		builder.append(date_enchere);
		builder.append(", montant=");
		builder.append(montant);
		builder.append(", no_article=");
		builder.append(no_article);
		builder.append(", no_utilisateur=");
		builder.append(no_utilisateur);
		builder.append("]");
		return builder.toString();
	}

}
