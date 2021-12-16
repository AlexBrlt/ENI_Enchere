package fr.eni.projet.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import fr.eni.projet.enchere.bo.Article;
import fr.eni.projet.enchere.bo.Auction;
import fr.eni.projet.enchere.bo.User;
import fr.eni.projet.enchere.dal.DALException;
import fr.eni.projet.enchere.dal.UserDAO;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

public class UserDAOJdbcImpl implements UserDAO {

	private static final String SQL_INSERT_USER = "INSERT INTO UTILISATEURS VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	private final static String SQL_UPDATE_USER = "UPDATE UTILISATEURS SET " +
			 "pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?, credit=?, administrateur=? " +
			 "WHERE no_utilisateur=?";
	private final static String SQL_SELECT_USER_BY_PSEUDO_AND_EMAIL = "SELECT * from UTILISATEURS where pseudo = ? OR email = ? ";
	private final static String SQL_SELECT_USER_BY_PSEUDO = "SELECT * from UTILISATEURS where pseudo = ? ";
	private final static String SQL_SELECT_USER_BY_EMAIL = "SELECT * from UTILISATEURS where email = ? ";
	private final static String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur=?";		
	private final static String USER_LIST_ARTICLE = "SELECT * from UTILISATEURS\r\n" + 
			"LEFT JOIN ARTICLES_VENDUS ON UTILISATEURS.no_utilisateur = ARTICLES_VENDUS.no_utilisateur\r\n" + 
			"\r\n" + 
			"WHERE UTILISATEURS.no_utilisateur=?";
	private final static String USER_LIST_AUCTION = "SELECT * from UTILISATEURS\r\n" + 
			"INNER JOIN ENCHERES ON UTILISATEURS.no_utilisateur = ENCHERES.no_utilisateur\r\n" + 
			"\r\n" + 
			"WHERE UTILISATEURS.no_utilisateur=?";
	
	public UserDAOJdbcImpl() {

	}

	public User insertUser(User nouveauUser) {

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (PreparedStatement) = ordre SQL
		int no_user = -1;
		PreparedStatement ordre = null;
		try {
			ordre = cnx.prepareStatement(SQL_INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
			
			// Paramétrer l'objet de commande
			String pseudo = nouveauUser.getPseudo();
			String nom = nouveauUser.getSurname();
			String prenom = nouveauUser.getName();
			String email = nouveauUser.getMail();
			String telephone = nouveauUser.getPhone();
			String rue = nouveauUser.getStreet();
			String code_postal = nouveauUser.getPostalCode();
			String ville = nouveauUser.getCity();
			String mot_de_passe = nouveauUser.getPassword();
			int credit = 100;
			
			
			boolean administrateur = false;
			administrateur = nouveauUser.isAdministrateur();
			int value;

			if (administrateur == true) {

				value = 1;

			} else {

				value = 0;

			}

			ordre.setString(1, pseudo);
			ordre.setString(2, nom);
			ordre.setString(3, prenom);
			ordre.setString(4, email);
			ordre.setString(5, telephone);
			ordre.setString(6, rue);
			ordre.setString(7, code_postal);
			ordre.setString(8, ville);
			ordre.setString(9, mot_de_passe);
			ordre.setInt(10, credit);
			ordre.setInt(11, value);
			

			// Execute l'ordre SQL
			ordre.executeUpdate();

			// Récupérer l'identifiant du client généré par la base de données
			ResultSet rs = ordre.getGeneratedKeys();
			if (rs.next()) {
				no_user = rs.getInt(1); // 1 : première colonne du résultat (qui n'en contient qu'une)
				
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return nouveauUser;

	}
	
	
	public User updateUser(User usermodifie) {
		
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (PreparedStatement) = ordre SQL
		int no_user = -1;
		PreparedStatement ordre = null;
		try {
			ordre = cnx.prepareStatement(SQL_UPDATE_USER);
			
			// Paramétrer l'objet de commande
			String pseudo = usermodifie.getPseudo();
			String nom = usermodifie.getSurname();
			String prenom = usermodifie.getName();
			String email = usermodifie.getMail();
			String telephone = usermodifie.getPhone();
			String rue = usermodifie.getStreet();
			String code_postal = usermodifie.getPostalCode();
			String ville = usermodifie.getCity();
			String mot_de_passe = usermodifie.getPassword();
			no_user	=	usermodifie.getNo_utilisateur();
			int credit = usermodifie.getCredit();
//			int credit = usermodifie.getCredit();
			
			boolean administrateur = false;
			administrateur = usermodifie.isAdministrateur();
			int value;

			if (administrateur == true) {

				value = 1;

			} else {

				value = 0;

			}

			ordre.setString(1, pseudo);
			ordre.setString(2, nom);
			ordre.setString(3, prenom);
			ordre.setString(4, email);
			ordre.setString(5, telephone);
			ordre.setString(6, rue);
			ordre.setString(7, code_postal);
			ordre.setString(8, ville);
			ordre.setString(9, mot_de_passe);
			ordre.setInt(10, credit);
			ordre.setInt(11, value);
			ordre.setInt(12, no_user);
			// Execute l'ordre SQL
			ordre.executeUpdate();

			

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return usermodifie;

	}
	
	
	/* En tant qu’utilisateur, je peux afficher le profil d’un utilisateur. 
	 * Le pseudo, nom, prénom, email, téléphone, rue, code postal, ville sont affichés.*/
	
	@Override
	public List<User> selectBypseudoAndMail(String login) throws DALException  {
		List<User> utilisateurs = new ArrayList<User>();
		
		try(Connection cnx = ConnectionProvider.getConnection();) {
			
			PreparedStatement ordre = cnx.prepareStatement(SQL_SELECT_USER_BY_PSEUDO_AND_EMAIL);
			ordre.setString(1, login);
			ordre.setString(2, login);
			
			
			ResultSet rs = ordre.executeQuery();
			while(rs.next()) {
				
				int no_utilisateur = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String code_postal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String mot_de_passe = rs.getString("mot_de_passe");
				int  credit =  rs.getInt("credit");
				User u = new User(no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, false);

						utilisateurs.add(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return utilisateurs;
	}
	
	public void delete(int no_utilisateur) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection();) {	
			
			PreparedStatement ordre = cnx.prepareStatement(DELETE);
			ordre.setInt(1, no_utilisateur);
			
			//n = nombre de lignes supprim�es (ici, soit 1 soit 0).
			int n = ordre.executeUpdate();
			
			//return n == 1;//si 1 ligne supprim�e --> true, sinon false
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
	}

	@Override
	public List<User> selectByPseudo(String pseudonym) throws DALException {
		
		List<User> utilisateurs = new ArrayList<User>();
		
		try(Connection cnx = ConnectionProvider.getConnection();) {
			
			PreparedStatement ordre = cnx.prepareStatement(SQL_SELECT_USER_BY_PSEUDO);
			ordre.setString(1, pseudonym);
			
			ResultSet rs = ordre.executeQuery();
			while(rs.next()) {
				
				int no_utilisateur = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String code_postal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String mot_de_passe = rs.getString("mot_de_passe");
				int  credit =  rs.getInt("credit");
				User u = new User(no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, false);

						utilisateurs.add(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return utilisateurs;
		

	}

	@Override
	public List<User> selectByMail(String mail) throws DALException {
		
		List<User> utilisateurs = new ArrayList<User>();
		
		try(Connection cnx = ConnectionProvider.getConnection();) {
			
			PreparedStatement ordre = cnx.prepareStatement(SQL_SELECT_USER_BY_EMAIL);
			ordre.setString(1, mail);
			
			ResultSet rs = ordre.executeQuery();
			while(rs.next()) {
				
				int no_utilisateur = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String code_postal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String mot_de_passe = rs.getString("mot_de_passe");
				int  credit =  rs.getInt("credit");
				User u = new User(no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, false);

						utilisateurs.add(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return utilisateurs;
	}
	
	
	@Override
	public User userAchatVente(int no_user) throws DALException{
		List<Article> articles = new ArrayList<Article>();
		List<Auction> encheres = new ArrayList<Auction>();
		User u = null;
		int no_utilisateur = 0;String pseudo = null;String nom = null;String prenom = null;String email = null;
		String telephone = null;String rue = null;String code_postal = null;String ville = null;String mot_de_passe = null;
		int credit = 0;int numero_article;String nom_article;String description;
		LocalDateTime date_start_auction;LocalDateTime date_end_auction=null;int price_start=0;
		int priceSold=0;int no_categorie=0;int no_auction=0;LocalDateTime date_auction=null;
		int price_auction=0;int no_article = 0; int no_article_auction=0;
		
		try(Connection cnx = ConnectionProvider.getConnection();) {
			
			PreparedStatement ordre = cnx.prepareStatement(USER_LIST_ARTICLE);
			ordre.setInt(1, no_user);
				
			ResultSet rs = ordre.executeQuery();

				while(rs.next()) {
					
					no_utilisateur = rs.getInt("no_utilisateur");
					pseudo = rs.getString("pseudo");
					nom = rs.getString("nom");
					prenom = rs.getString("prenom");
					email = rs.getString("email");
					telephone = rs.getString("telephone");
					rue = rs.getString("rue");
					code_postal = rs.getString("code_postal");
					ville = rs.getString("ville");
					mot_de_passe = rs.getString("mot_de_passe");
					credit = rs.getInt("credit");
					numero_article = rs.getInt("no_article");
					nom_article = rs.getString("nom_article");
					description = rs.getString("description");
					
					if (rs.getTimestamp("date_debut_encheres")==null) {
						date_start_auction = null;
					} else {
						date_start_auction = rs.getTimestamp("date_debut_encheres").toLocalDateTime();
					}
					
					if (rs.getTimestamp("date_debut_encheres")==null) {
						date_end_auction = null;
					} else {
						date_end_auction =rs.getTimestamp("date_fin_encheres").toLocalDateTime();
					}
										
					price_start = rs.getInt("prix_initial");
					priceSold = rs.getInt("prix_vente");
					no_categorie = rs.getInt("no_categorie");
					

					Article article = new Article(numero_article, nom_article, description, date_start_auction, date_end_auction, price_start, priceSold, no_utilisateur, no_categorie);
					articles.add(article);	
	
				}

			PreparedStatement ordre2 = cnx.prepareStatement(USER_LIST_AUCTION);
			ordre2.setInt(1, no_user);
			
			ResultSet rs2 = ordre2.executeQuery();
			
				while(rs2.next()) {
					
					
					no_auction = rs2.getInt("no_enchere");
					date_auction = rs2.getTimestamp("date_enchere").toLocalDateTime();
					price_auction = rs2.getInt("montant_enchere");
					no_article_auction = rs2.getInt("no_article");
					
					Auction enchere = new Auction(no_auction, date_auction, price_auction, no_article_auction, no_utilisateur);
					encheres.add(enchere);	
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		return u = new User(no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, false, articles, encheres);	
	}
	
	
	

}
