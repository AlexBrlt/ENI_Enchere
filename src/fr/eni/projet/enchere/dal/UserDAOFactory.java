package fr.eni.projet.enchere.dal;


import fr.eni.projet.enchere.dal.jdbc.ArticleDAOjdbcimpl;
import fr.eni.projet.enchere.dal.jdbc.EnchereDAOjdbcimpl;
import fr.eni.projet.enchere.dal.jdbc.UserDAOJdbcImpl;
import jdk.internal.dynalink.beans.StaticClass;

public class UserDAOFactory {
	
	/**
	 * Fournit une instance d'une classe
	 * se comportant comme un RepasDAO
	 * 
	 * @return Une instance
	 */
	public static UserDAO getUserDAO() {
		
		return new UserDAOJdbcImpl();
	}
	
	public static ArticleDAO getArticleDAO() {
		
		return new ArticleDAOjdbcimpl();
	}
	
	public static AuctionDAO getEnchere() {
		
		return new EnchereDAOjdbcimpl();
		
	}

}
