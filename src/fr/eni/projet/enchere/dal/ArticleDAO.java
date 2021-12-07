package fr.eni.projet.enchere.dal;

import fr.eni.projet.enchere.bo.Article;

public interface ArticleDAO {
	
	public Article insertArticle(Article nouvelArticle) throws DALException;

}
