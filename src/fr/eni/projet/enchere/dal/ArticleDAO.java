package fr.eni.projet.enchere.dal;

import java.util.List;

import fr.eni.projet.enchere.bo.Article;

public interface ArticleDAO {
	
	public Article insertArticle(Article nouvelArticle) throws DALException;
	List<Article> selectByCategorie(int no_categorie) throws DALException;
	
}
