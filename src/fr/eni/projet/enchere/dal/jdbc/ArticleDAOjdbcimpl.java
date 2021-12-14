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
	
	private static final String SQL_SELECT_ARTICLES_PART_1 = "SELECT ARTICLES_VENDUS.no_article AS article_number, nom_article, description, date_debut_encheres, "
			+ "date_fin_encheres, prix_initial" + 
			", prix_vente, ARTICLES_VENDUS.no_utilisateur, ARTICLES_VENDUS.no_categorie, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, "
			+ "mot_de_passe, credit, administrateur, libelle FROM ARTICLES_VENDUS INNER JOIN UTILISATEURS ON UTILISATEURS.no_utilisateur=ARTICLES_VENDUS.no_utilisateur " + 
			"INNER JOIN CATEGORIES ON CATEGORIES.no_categorie = ARTICLES_VENDUS.no_categorie WHERE ARTICLES_VENDUS.no_article=?";
	
	private static final String ARTICLE_NUMBER="article_number";
	private static final String NOM_ARTICLE="nom_article";
	private static final String DESCRIPTION="description";
	private static final String DATE_DEBUT_ENCHERES="date_debut_encheres";
	private static final String DATE_FIN_ENCHERES="date_fin_encheres";
	private static final String PRIX_INITIAL ="prix_initial";
	private static final String PRIX_VENTE ="prix_vente";
	private static final String NO_USER ="no_utilisateur";
	private static final String NO_CATEGORIE ="no_categorie";
	private static final String PSEUDO ="pseudo";
	private static final String NOM ="nom";
	private static final String PRENOM ="prenom";
	private static final String EMAIL ="email";
	private static final String TELEPHONE ="telephone";
	private static final String RUE ="rue";
	private static final String CODE_POSTAL ="code_postal";
	private static final String VILLE ="ville";
	private static final String MOT_DE_PASSE ="mot_de_passe";
	private static final String CREDIT ="credit";
	private static final String ADMINISTRATEUR ="administrateur";
	private static final String LIBELLE ="libelle";
	
	private static final String SQL_SELECT_ARTICLES_PART_2 = "SELECT ENCHERES.no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, "
			+ "administrateur FROM ENCHERES INNER JOIN UTILISATEURS ON ENCHERES.no_utilisateur=UTILISATEURS.no_utilisateur " + 
			"INNER JOIN ARTICLES_VENDUS ON ARTICLES_VENDUS.no_article=ENCHERES.no_article WHERE ENCHERES.no_article=?";
	
	
	private static final String SQL_SELECT_BY_NO_ARTICLE ="select * from UTILISATEURS\r\n" + 
			"inner join ARTICLES_VENDUS ON UTILISATEURS.no_utilisateur=ARTICLES_VENDUS.no_utilisateur\r\n" + 
			"inner join CATEGORIES ON ARTICLES_VENDUS.no_categorie=CATEGORIES.no_categorie\r\n" + 
			"where ARTICLES_VENDUS.no_article = ?";
	
	public Article selectArticle (int no_article) throws DALException{
		String nameArticle = null;
		String description = null;
		LocalDateTime dateStartAuction = null;
		LocalDateTime dateEndAuction = null;
		int priceStart = 0;
		int priceSold = 0;
		int noUser = 0;
		int noCategorie = 0;
		String categorie = null;
		User seller = null;
		User buyer = null;
		String pseudo = null;
		String surname = null;
		String name = null;
		String mail = null;
		String phone = null;
		String street = null;
		String postalCode = null;
		String city = null;
		String password = null;
		int credit = 0;
		boolean administrateur = false;
		String libelle = null;
		
		Article article = null;
		
		
		
		Connection cnx = ConnectionProvider.getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		try {
			pstmt = cnx.prepareStatement(SQL_SELECT_ARTICLES_PART_1);
			
			pstmt.setInt(1, no_article);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				nameArticle = rs.getString(NOM_ARTICLE);
				description = rs.getString(DESCRIPTION);
				dateStartAuction = rs.getTimestamp(DATE_DEBUT_ENCHERES).toLocalDateTime();
				dateEndAuction = rs.getTimestamp(DATE_FIN_ENCHERES).toLocalDateTime();
				priceStart = rs.getInt(PRIX_INITIAL);
				priceSold = rs.getInt(PRIX_VENTE);
				noUser = rs.getInt(NO_USER);
				noCategorie = rs.getInt(NO_CATEGORIE);
				categorie = rs.getString(LIBELLE);
				noUser = rs.getInt(NO_USER);
				pseudo = rs.getString(PSEUDO);
				surname = rs.getString(NOM);
				name = rs.getString(PRENOM);
				mail = rs.getString(EMAIL);
				phone = rs.getString(TELEPHONE);
				street = rs.getString(RUE);
				postalCode = rs.getString(CODE_POSTAL);
				city = rs.getString(VILLE);
				password = rs.getString(MOT_DE_PASSE);
				credit = rs.getInt(CREDIT);
				administrateur = rs.getBoolean(ADMINISTRATEUR);
				libelle = rs.getString(LIBELLE);
				
				seller = new User(noUser, pseudo, name, surname, mail, phone, street, postalCode, city, password, credit, administrateur);
				
				article = new Article(noUser, nameArticle, description, dateStartAuction, dateEndAuction, priceStart, priceSold, noUser, noCategorie);
				article.setCategorie(libelle);
				article.setSeller(seller);
			}
			
			pstmt2 = cnx.prepareStatement(SQL_SELECT_ARTICLES_PART_2);
			
			pstmt2.setInt(1, no_article);
			
			ResultSet rs2 = pstmt2.executeQuery();
			
			
				
			
			
			if(rs2.next()) {
				
				noUser = rs2.getInt(NO_USER);
				pseudo = rs2.getString(PSEUDO);
				surname = rs2.getString(NOM);
				name = rs2.getString(PRENOM);
				mail = rs2.getString(EMAIL);
				phone = rs2.getString(TELEPHONE);
				street = rs2.getString(RUE);
				postalCode = rs2.getString(CODE_POSTAL);
				city = rs2.getString(VILLE);
				password = rs2.getString(MOT_DE_PASSE);
				credit = rs2.getInt(CREDIT);
				administrateur = rs2.getBoolean(ADMINISTRATEUR);
				
				buyer = new User(noUser, pseudo, name, surname, mail, phone, street, postalCode, city, password, credit, administrateur);
				article.setBuyer(buyer);
			}
			
			if(!rs.next()){
				buyer = new User(-1, "", "", "", "", "", "", "", "", "", 0, false);
				article.setBuyer(buyer);
			}
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException();
		}
		 
		return article;
	}
	
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
			
			cnx.close();

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
			
			cnx.close();
			
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
	
	
	
	public Article selectByNoArticle (int no_article) throws DALException{
		String nameArticle;
		String description;
		LocalDateTime dateStartAuction;
		LocalDateTime dateEndAuction;
		int priceStart;
		int priceSold;
		int noUser;
		int noCategorie;
		String categorie;
		User seller;
		User buyer;
		String pseudo;
		String surname;
		String name;
		String mail;
		String phone;
		String street;
		String postalCode;
		String city;
		String password;
		int credit;
		boolean administrateur;
		String libelle;
		
		Article article = null;
		
		Connection cnx = ConnectionProvider.getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		try {
			pstmt = cnx.prepareStatement(SQL_SELECT_BY_NO_ARTICLE);
			
			pstmt.setInt(1, no_article);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				nameArticle = rs.getString(NOM_ARTICLE);
				description = rs.getString(DESCRIPTION);
				dateStartAuction = rs.getTimestamp(DATE_DEBUT_ENCHERES).toLocalDateTime();
				dateEndAuction = rs.getTimestamp(DATE_FIN_ENCHERES).toLocalDateTime();
				priceStart = rs.getInt(PRIX_INITIAL);
				priceSold = rs.getInt(PRIX_VENTE);
				noUser = rs.getInt(NO_USER);
				noCategorie = rs.getInt(NO_CATEGORIE);
				categorie = rs.getString(LIBELLE);
				noUser = rs.getInt(NO_USER);
				pseudo = rs.getString(PSEUDO);
				surname = rs.getString(NOM);
				name = rs.getString(PRENOM);
				mail = rs.getString(EMAIL);
				phone = rs.getString(TELEPHONE);
				street = rs.getString(RUE);
				postalCode = rs.getString(CODE_POSTAL);
				city = rs.getString(VILLE);
				password = rs.getString(MOT_DE_PASSE);
				credit = rs.getInt(CREDIT);
				administrateur = rs.getBoolean(ADMINISTRATEUR);
				libelle = rs.getString(LIBELLE);
				
				buyer = new User(noUser, pseudo, name, surname, mail, phone, street, postalCode, city, password, credit, administrateur);
				
				article = new Article(noUser, nameArticle, description, dateStartAuction, dateEndAuction, priceStart, priceSold, noUser, noCategorie);
				article.setCategorie(libelle);
				article.setBuyer(buyer);
			}
			
			
			
			cnx.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException();
		}
		 
		return article;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
