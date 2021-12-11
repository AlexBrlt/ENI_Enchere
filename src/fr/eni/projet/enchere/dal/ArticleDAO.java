package fr.eni.projet.enchere.dal;

import java.util.List;

import fr.eni.projet.enchere.bo.Article;

public interface ArticleDAO {
	
	public Article insertArticle(Article nouvelArticle) throws DALException;
	List<Article> selectByCategorie(int no_categorie) throws DALException;
	public List<Article> selectByMotCle(String motcle) throws DALException;
	public List<Article> selectByMotCleAndCategorie(String motcle, int no_category) throws DALException;
	public Article selectArticle(int no_article) throws DALException;
	
}
