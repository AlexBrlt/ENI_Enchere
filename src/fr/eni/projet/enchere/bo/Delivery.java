package fr.eni.projet.enchere.bo;

public class Delivery {

	private int no_article;
	private String rue;
	private String code_postal;
	private String ville;

	// GETTER & SETTER

	public int getNo_article() {
		return no_article;
	}

	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	// Constructeur

	public Delivery(int no_article, String rue, String code_postal, String ville) {
		
		this.no_article = no_article;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}

	// ToString

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Retrait [no_article=");
		builder.append(no_article);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", code_postal=");
		builder.append(code_postal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append("]");
		return builder.toString();
	}

}
