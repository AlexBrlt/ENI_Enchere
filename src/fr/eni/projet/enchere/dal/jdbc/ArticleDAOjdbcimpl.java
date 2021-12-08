package fr.eni.projet.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.enchere.bo.Article;
import fr.eni.projet.enchere.bo.User;
import fr.eni.projet.enchere.dal.ArticleDAO;
import fr.eni.projet.enchere.dal.DALException;

public class ArticleDAOjdbcimpl implements ArticleDAO {

	private static final String SQL_INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ? ";
	private static final String SQL_INSERT_RETRAIT_ARTICLE = "INSERT INTO RETRAITS VALUES ( ?, ?, ?, ?)";
	private static final String SQL_SELECT_BY_CATEGORiE = "SELECT * FROM ARTICLES_VENDUS WHERE no_categorie = ?";
	
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
			String nom_article = nouvelArticle.getNom_article();
			String description = nouvelArticle.getDescription();
			LocalDateTime date_debut_encheres = nouvelArticle.getDate_debut_encheres();
			LocalDateTime date_fin_encheres = nouvelArticle.getDate_fin_encheres();
			int prix_initial = nouvelArticle.getPrix_initial();
			int prix_vente = nouvelArticle.getPrix_initial();
			int no_utilisateur = nouvelArticle.getNo_utilisateur();
			int no_categorie = nouvelArticle.getNo_categorie();
			

			ordre.setString(1, nom_article);
			ordre.setString(2, description);
			ordre.setDate(3, Date.valueOf(date_debut_encheres.toLocalDate()));
			ordre.setDate(4, Date.valueOf(date_fin_encheres.toLocalDate()));
			ordre.setInt(5, prix_initial);
			ordre.setInt(6, prix_vente);
			ordre.setInt(7, no_utilisateur);
			ordre.setInt(8, no_categorie);
			

			// Execute l'ordre SQL
			ordre.executeUpdate();

			// Récupérer l'identifiant de l'Article généré par la base de données
			ResultSet rs = ordre.getGeneratedKeys();
			if (rs.next()) {
				no_Article = rs.getInt(1); // 1 : première colonne du résultat (qui n'en contient qu'une)
				nouvelArticle.setNo_article(no_Article);;
			}
			
			PreparedStatement ordre2 = cnx.prepareStatement(SQL_SELECT_USER_BY_ID);
			ordre.setInt(1, no_utilisateur);
			
			
			ResultSet rs2 = ordre2.executeQuery();
			while(rs.next()) {
				
				 pseudo = rs.getString("pseudo");
				 nom = rs.getString("nom");
				 prenom = rs.getString("prenom");
				 email = rs.getString("email");
				 telephone = rs.getString("telephone");
				 rue = rs.getString("rue");
				 code_postal = rs.getString("code_postal");
				 ville = rs.getString("ville");

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
	
	public List<Article> selectByCategorie(int no_categorie) throws DALException  {
		List<Article> articles = new ArrayList<Article>();
		
		try(Connection cnx = ConnectionProvider.getConnection();) {
			
			PreparedStatement ordre = cnx.prepareStatement(SQL_SELECT_BY_CATEGORiE);
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
	
	
	
	
	
	
	

}
