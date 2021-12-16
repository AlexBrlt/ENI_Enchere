package fr.eni.projet.enchere.bo;

import java.time.LocalDateTime;

public class Article {

	private int noArticle;
	private String nameArticle;
	private String description;
	private LocalDateTime dateStartAuction;
	private LocalDateTime dateEndAuction;
	private int priceStart;
	private int priceSold;
	private int noUser;
	private int noCategorie;
	private String categorie;
	private User seller;
	private User buyer;
	
	//TODO Un article a besoin d'un point de retrait


	// GETTER & SETTER
	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public String getNameArticle() {
		return nameArticle;
	}
	public void setNameArticle(String nameArticle) {
		this.nameArticle = nameArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDateStartAuction() {
		return dateStartAuction;
	}
	public void setDateStartAuction(LocalDateTime dateStartAuction) {
		this.dateStartAuction = dateStartAuction;
	}
	public LocalDateTime getDateEndAuction() {
		return dateEndAuction;
	}
	public void setDateEndAuction(LocalDateTime dateEndAuction) {
		this.dateEndAuction = dateEndAuction;
	}
	public int getPriceStart() {
		return priceStart;
	}
	public void setPriceStart(int priceStart) {
		this.priceStart = priceStart;
	}
	public int getPriceSold() {
		return priceSold;
	}
	public void setPriceSold(int priceSold) {
		this.priceSold = priceSold;
	}
	public int getNoUser() {
		return noUser;
	}
	public void setNoUser(int noUser) {
		this.noUser = noUser;
	}
	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}	
	public String getCategorie() {
		return this.categorie;
	}
	
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}
	public User getBuyer() {
		return buyer;
	}
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}


	// CONSTRUCTEUR

	public Article(int noArticle, String nameArticle, String description, LocalDateTime dateStartAuction,
			LocalDateTime dateEndAuction, int priceStart, int priceSold, int noUser, int noCategorie) {
		
		this.noArticle = noArticle;
		this.nameArticle = nameArticle;
		this.description = description;
		this.dateStartAuction = dateStartAuction;
		this.dateEndAuction = dateEndAuction;
		this.priceStart = priceStart;
		this.priceSold = priceSold;
		this.noUser = noUser;
		this.noCategorie = noCategorie;
	}
	
	public Article(int noArticle, String nameArticle, String description, LocalDateTime dateStartAuction,
			LocalDateTime dateEndAuction, int priceStart, int priceSold, int noUser, int noCategorie, String categorie,
			User seller, User buyer) {
		
		this.noArticle = noArticle;
		this.nameArticle = nameArticle;
		this.description = description;
		this.dateStartAuction = dateStartAuction;
		this.dateEndAuction = dateEndAuction;
		this.priceStart = priceStart;
		this.priceSold = priceSold;
		this.noUser = noUser;
		this.noCategorie = noCategorie;
		this.categorie = categorie;
		this.seller = seller;
		this.buyer = buyer;
	}
	
	public Article(String nameArticle, String description, LocalDateTime dateStartAuction, LocalDateTime dateEndAuction,
			int priceStart, int noCategorie, int noUser) {
		
		this.nameArticle = nameArticle;
		this.description = description;
		this.dateStartAuction = dateStartAuction;
		this.dateEndAuction = dateEndAuction;
		this.priceStart = priceStart;
		this.noCategorie = noCategorie;
		this.noUser=noUser;
	}

	// ToString
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Article [getNoArticle()=");
		stringBuilder.append(getNoArticle());
		stringBuilder.append(", getNameArticle()=");
		stringBuilder.append(getNameArticle());
		stringBuilder.append(", getDescription()=");
		stringBuilder.append(getDescription());
		stringBuilder.append(", getDateStartAuction()=");
		stringBuilder.append(getDateStartAuction());
		stringBuilder.append(", getDateEndAuction()=");
		stringBuilder.append(getDateEndAuction());
		stringBuilder.append(", getPriceStart()=");
		stringBuilder.append(getPriceStart());
		stringBuilder.append(", getPriceSold()=");
		stringBuilder.append(getPriceSold());
		stringBuilder.append(", getNoUser()=");
		stringBuilder.append(getNoUser());
		stringBuilder.append(", getNoCategorie()=");
		stringBuilder.append(getNoCategorie());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}



}
