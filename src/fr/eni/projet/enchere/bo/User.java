package fr.eni.projet.enchere.bo;

public class User {
	
	private int no_utilisateur;
	private String pseudo;
	private String surname;
	private String name;
	private String mail;
	private String phone;
	private String street;
	private String postalCode;
	private String city;
	private String password;
	private int credit;
	private boolean administrateur;
	
	//GETTER & SETTER
	public int getNo_utilisateur() {
		return no_utilisateur;
	}
	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getSurname() {
		return surname;
	}
	public void setNom(String nom) {
		this.surname = nom;
	}
	public String getName() {
		return name;
	}
	public void setName(String prenom) {
		this.name = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String email) {
		this.mail = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String telephone) {
		this.phone = telephone;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String rue) {
		this.street = rue;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String code_postal) {
		this.postalCode = code_postal;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String ville) {
		this.city = ville;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String mot_de_passe) {
		this.password = mot_de_passe;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public boolean isAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}
	
	// CONSTRUCTEUR
	public User(int no_utilisateur, String pseudo, String name, String surname, String mail, String phone,
			String street, String postalCode, String city, String password, int credit, boolean administrateur) {
		
		this.no_utilisateur = no_utilisateur;
		this.pseudo = pseudo;
		this.surname = name;
		this.name = surname;
		this.mail = mail;
		this.phone = phone;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.password = password;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	
	
	public User(String pseudo, String surname, String name, String mail, String phone, String street, String postalCode,
			String city, String password, int credit, boolean administrateur) {
		
		this.pseudo = pseudo;
		this.surname = surname;
		this.name = name;
		this.mail = mail;
		this.phone = phone;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.password = password;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	// ToString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [no_utilisateur=");
		builder.append(no_utilisateur);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append(", nom=");
		builder.append(surname);
		builder.append(", prenom=");
		builder.append(name);
		builder.append(", email=");
		builder.append(mail);
		builder.append(", telephone=");
		builder.append(phone);
		builder.append(", rue=");
		builder.append(street);
		builder.append(", code_postal=");
		builder.append(postalCode);
		builder.append(", ville=");
		builder.append(city);
		builder.append(", mot_de_passe=");
		builder.append(password);
		builder.append(", credit=");
		builder.append(credit);
		builder.append(", administrateur=");
		builder.append(administrateur);
		builder.append("]");
		return builder.toString();
	}
}