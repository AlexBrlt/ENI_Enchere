package fr.eni.projet.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import fr.eni.projet.enchere.bo.Article;
import fr.eni.projet.enchere.bo.User;
import fr.eni.projet.enchere.dal.ArticleDAO;
import fr.eni.projet.enchere.dal.DALException;

public class ArticleDAOjdbcimpl implements ArticleDAO {

	private static final String SQL_INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_MODIFY_ARTICLE = "UPDATE ARTICLES_VENDUS SET nom_article = ?, description =?, date_debut_encheres = ?, "
			+ "date_fin_encheres = ?, prix_initial = ?, prix_vente = ?, no_utilisateur = ?, no_categorie = ? WHERE no_article = ?";
	private static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ? ";
	private static final String SQL_INSERT_RETRAIT_ARTICLE = "INSERT INTO RETRAITS VALUES ( ?, ?, ?, ?)";
	private static final String SQL_SELECT_BY_CATEGORIE = "SELECT * FROM ARTICLES_VENDUS WHERE no_categorie = ?";
	private static final String SQL_SELECT_BY_MOTCLE = "SELECT * FROM ARTICLES_VENDUS WHERE like ?";
	private static final String SQL_SELECT_BY_MOTCLE_STRING_AND_CATEGORIE = "SELECT * FROM ARTICLES_VENDUS WHERE like ? AND WHERE no_categorie = ?";
	
	
	
	
	
	public Article insertArticle(Article nouvelArticle) {
		String pseudo;String nom;String prenom;String email;String telephone;String rue = null;
		String code_postal = null;String ville = null;

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Inserer L'article

		// Obtient une objet de commande (PreparedStatement) = ordre SQL
		int no_Article = -1;
		PreparedStatement ordre = null;
		try {
			ordre = cnx.prepareStatement(SQL_INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			
			// Paramétrer l'objet de commande
			String nom_article = nouvelArticle.getNameArticle();
			String description = nouvelArticle.getDescription();
			LocalDateTime date_debut_encheres = nouvelArticle.getDateStartAuction();
			LocalDateTime date_fin_encheres = nouvelArticle.getDateEndAuction();
			int prix_initial = nouvelArticle.getPriceStart();
			int prix_vente = nouvelArticle.getPriceSold();
			int no_utilisateur = nouvelArticle.getNoUser();
			int no_categorie = nouvelArticle.getNoCategorie();
			
			
			
			
			ordre.setString(1, nom_article);
			ordre.setString(2, description);
			ordre.setTimestamp(3, Timestamp.valueOf(date_debut_encheres));
			ordre.setTimestamp(4, Timestamp.valueOf(date_fin_encheres));
			ordre.setInt(5, prix_initial);
			
			if ((Integer)prix_vente == null) {
				ordre.setNull(6, java.sql.Types.INTEGER);
			} else {
				ordre.setInt(6, prix_vente);

			}
			
			ordre.setInt(7, no_utilisateur);
			ordre.setInt(8, no_categorie);
			
			// Execute l'ordre SQL
			ordre.executeUpdate();

			// Récupérer l'identifiant de l'Article généré par la base de données
			ResultSet rs = ordre.getGeneratedKeys();
			if (rs.next()) {
				no_Article = rs.getInt(1); // 1 : première colonne du résultat (qui n'en contient qu'une)
				nouvelArticle.setNoArticle(no_Article);;
			}
			
			PreparedStatement ordre2 = cnx.prepareStatement(SQL_SELECT_USER_BY_ID);
			ordre2.setInt(1, no_utilisateur);
			System.out.println(no_utilisateur);
			ResultSet rs2 = ordre2.executeQuery();
			while(rs2.next()) {
				
				 pseudo = rs2.getString("pseudo");
				 System.out.println(pseudo);
				 nom = rs2.getString("nom");
				 prenom = rs2.getString("prenom");
				 email = rs2.getString("email");
				 telephone = rs2.getString("telephone");
				 rue = rs2.getString("rue");
				 code_postal = rs2.getString("code_postal");
				 ville = rs2.getString("ville");

			}
			
			PreparedStatement ordre3 = cnx.prepareStatement(SQL_INSERT_RETRAIT_ARTICLE);
			ordre3.setInt(1, no_Article);
			ordre3.setString(2, rue );
			ordre3.setString(3, code_postal );
			ordre3.setString(4, ville );
			
			ordre3.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return nouvelArticle;
	}
	
	
	
	
	public void modifyArticle (Article article) throws DALException {
		Connection cnx = ConnectionProvider.getConnection();
		
		try {
			PreparedStatement pstmt = cnx.prepareStatement(SQL_MODIFY_ARTICLE);
			pstmt.setString(1, article.getNameArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setTimestamp(3, Timestamp.valueOf(article.getDateStartAuction()));
			pstmt.setTimestamp(4, Timestamp.valueOf(article.getDateEndAuction()));
			pstmt.setInt(5, article.getPriceStart());
			int priceSold = article.getPriceSold();
			
			if ((Integer)priceSold == null) {
				pstmt.setNull(6, Types.INTEGER);
			} else {
				pstmt.setInt(6, priceSold);

			}

			pstmt.setInt(7, article.getNoUser());
			pstmt.setInt(8, article.getNoCategorie());
			pstmt.setInt(9, article.getNoArticle());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
	}
	
	
	public List<Article> selectByCategorie(int no_categorie) throws DALException  {
		List<Article> articles = new ArrayList<Article>();
		
		try(Connection cnx = ConnectionProvider.getConnection();) {
			
			PreparedStatement ordre = cnx.prepareStatement(SQL_SELECT_BY_CATEGORIE);
			ordre.setInt(1, no_categorie);
			
			
			ResultSet rs = ordre.executeQuery();
			while(rs.next()) {
				
				int no_article = rs.getInt("no_article");
				String nom_article = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDateTime date_debut_encheres = rs.getTimestamp("date_debut_encheres").toLocalDateTime();
				LocalDateTime date_fin_encheres = rs.getTimestamp("date_fin_encheres").toLocalDateTime();
				int prix_initial = rs.getInt("prix_initial");
				int prix_vente = rs.getInt("prix_vente");
				int no_utilisateur = rs.getInt("no_utilisateur");
				
				Article a = new Article(no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie);

						articles.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return articles;
	}
	
	
	public List<Article> selectByMotCle(String motcle) throws DALException  {
		List<Article> articles = new ArrayList<Article>();
		
		try(Connection cnx = ConnectionProvider.getConnection();) {
			
			PreparedStatement ordre = cnx.prepareStatement(SQL_SELECT_BY_MOTCLE_STRING_AND_CATEGORIE);
			ordre.setString(1,"%"+motcle+"%");
			
			
			ResultSet rs = ordre.executeQuery();
			while(rs.next()) {
				
				int no_article = rs.getInt("no_article");
				String nom_article = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDateTime date_debut_encheres = rs.getTimestamp("date_debut_encheres").toLocalDateTime();
				LocalDateTime date_fin_encheres = rs.getTimestamp("date_fin_encheres").toLocalDateTime();
				int prix_initial = rs.getInt("prix_initial");
				int prix_vente = rs.getInt("prix_vente");
				int no_utilisateur = rs.getInt("no_utilisateur");
				int no_categorie = rs.getInt("no_categorie");
				
				Article a = new Article(no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie);

						articles.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return articles;
	}
	
	public List<Article> selectByMotCleAndCategorie(String motcle, int no_category) throws DALException  {
		List<Article> articles = new ArrayList<Article>();
		
		try(Connection cnx = ConnectionProvider.getConnection();) {
			
			PreparedStatement ordre = cnx.prepareStatement(SQL_SELECT_BY_CATEGORIE);
			ordre.setString(1,"%"+motcle+"%");
			ordre.setInt(2, no_category);
			
			
			ResultSet rs = ordre.executeQuery();
			while(rs.next()) {
				
				int no_article = rs.getInt("no_article");
				String nom_article = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDateTime date_debut_encheres = rs.getTimestamp("date_debut_encheres").toLocalDateTime();
				LocalDateTime date_fin_encheres = rs.getTimestamp("date_fin_encheres").toLocalDateTime();
				int prix_initial = rs.getInt("prix_initial");
				int prix_vente = rs.getInt("prix_vente");
				int no_utilisateur = rs.getInt("no_utilisateur");
				int no_categorie = rs.getInt("no_categorie");
				
				Article a = new Article(no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie);

						articles.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return articles;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
