package fr.eni.projet.enchere.dal;

import java.util.List;

import fr.eni.projet.enchere.bll.BLLException;
import fr.eni.projet.enchere.bo.Article;

public interface ArticleDAO {
	
	public Article insertArticle(Article nouvelArticle) throws DALException;
	List<Article> selectByCategory(String libelle) throws DALException;
	public List<Article> selectByMotCle(String motcle) throws DALException;
	public List<Article> selectByMotCleAndCategory(String motcle, String libelle) throws DALException;
	public Article selectArticle(int no_article) throws DALException;
	public Article selectByNoArticle (int no_article) throws DALException;
	public List<Article> selectArticleHome() throws DALException;
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
}
