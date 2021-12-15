package fr.eni.projet.enchere.bll;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.enchere.bo.Article;
import fr.eni.projet.enchere.bo.User;
import fr.eni.projet.enchere.dal.ArticleDAO;
import fr.eni.projet.enchere.dal.DALException;
import fr.eni.projet.enchere.dal.UserDAO;
import fr.eni.projet.enchere.dal.DAOFactory;

public class ArticleManager {

	private static ArticleManager instance;

	private static ArticleDAO dao;

	private ArticleManager() {
		dao = DAOFactory.getArticleDAO();
	};

	public static ArticleManager getInstance() {
		if (instance == null) {
			instance = new ArticleManager();
		}
		return instance;
	}
	
	public List<Article> selectArticleHome() throws BLLException{
		List<Article> listArticle = new ArrayList<Article>();
		
		try {
			listArticle = dao.selectArticleHome();
			} catch (DALException e) {
			e.printStackTrace();
			BLLException error = new BLLException();
			throw error;
		}
		return listArticle;
		
	}
	public Article selectArticle(int noArticle) throws BLLException {
		
		BLLException ex = new BLLException();

		try {
			validationNo_article(noArticle, ex);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Article article = dao.selectArticle(noArticle);

			return article;
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}

		
		
	}
	
	
	public Article selectByNo_Article(int noArticle) throws BLLException {
		
		BLLException ex = new BLLException();

		try {
			validationNo_article(noArticle, ex);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Article article = dao.selectByNoArticle(noArticle);

			return article;
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}

		
		
	}

	public Article ajouterArticle(Article nouvelArticle) throws BLLException {

		BLLException ex = new BLLException();

		
		validationDate_Debut(nouvelArticle.getDateStartAuction(), ex);
		validationDate_Fin(nouvelArticle.getDateEndAuction(), ex);
		validationNo_Categorie(nouvelArticle.getNoCategorie(), ex);
		validationDescription(nouvelArticle.getDescription(), ex);
		validationNom_Article(nouvelArticle.getNameArticle(), ex);
		validationNo_utilisateur(nouvelArticle.getNoUser(), ex);
		
		
		if(ex.hasErreur()) {
			throw ex;
		}
		
		try {
			Article article = dao.insertArticle(nouvelArticle);

			return article;
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}
		

	}
	
	public Article modfierArticle(Article modifyArticle) throws BLLException {
		
		BLLException ex = new BLLException();

		validationNo_article(modifyArticle.getNoArticle(), ex);
		validationDate_Debut(modifyArticle.getDateStartAuction(), ex);
		validationDate_Fin(modifyArticle.getDateEndAuction(), ex);
		validationNo_Categorie(modifyArticle.getNoCategorie(), ex);
		validationDescription(modifyArticle.getDescription(), ex);
		validationNom_Article(modifyArticle.getNameArticle(), ex);
		validationNo_utilisateur(modifyArticle.getNoUser(), ex);

		Article article = null;
		try {
			article = dao.insertArticle(modifyArticle);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BLLException();
		}

		return article;
		
	}

	public List<Article> getByCategorie(int no_categorie) throws BLLException {

		BLLException ex = new BLLException();

		if (ex.hasErreur()) {
			throw ex;
		}

		try {
			return dao.selectByCategorie(no_categorie);
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}

	}

	public List<Article> getByMotCle(String motcle) throws BLLException {

		BLLException ex = new BLLException();

		if (ex.hasErreur()) {
			throw ex;
		}

		try {
			return dao.selectByMotCle(motcle);
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}

	}

	private void validationNo_article(int no_article, BLLException ex) throws BLLException {
		if (no_article < 1) {
			ex.ajouterErreur(new ParameterException("Le numero d'article doit être un entier positif >= 1"));
		}
	}

	private void validationNom_Article(String nom_article, BLLException ex) {
		if (nom_article == null || nom_article.isEmpty() || nom_article.length() > 30) {
			ex.ajouterErreur(new ParameterException(
					"Le nom de l'article est obligatoire et doit avoir une longueur comprise entre 1 et 30"));
		}
	}

	private void validationDescription(String description, BLLException ex) {
		if (description == null || description.isEmpty() || description.length() > 300) {
			ex.ajouterErreur(new ParameterException(
					"La description est obligatoire et doit avoir une longueur comprise entre 1 et 300"));
		}
	}

	private void validationDate_Debut(LocalDateTime date_debut, BLLException ex) {
		if (date_debut == null) {
			ex.ajouterErreur(new ParameterException("La date de début est obligatoire "));
		}
	}

	private void validationDate_Fin(LocalDateTime date_fin, BLLException ex) {
		if (date_fin == null) {
			ex.ajouterErreur(new ParameterException("La date de fin est obligatoire "));
		}
	}

	private void validationNo_utilisateur(int no_user, BLLException ex) throws BLLException {
		if (no_user < 1) {
			ex.ajouterErreur(new ParameterException("Le numero d'utilisateur doit être un entier positif >= 1"));
		}
	}

	private void validationNo_Categorie(int no_categorie, BLLException ex) throws BLLException {
		if (no_categorie < 1) {
			ex.ajouterErreur(new ParameterException("Le numero de categorie doit être un entier positif >= 1"));
		}
	}

}
