package fr.eni.projet.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.enchere.bo.Article;
import fr.eni.projet.enchere.bo.Auction;
import fr.eni.projet.enchere.bo.User;
import fr.eni.projet.enchere.dal.AuctionDAO;
import fr.eni.projet.enchere.dal.DALException;

public class EnchereDAOjdbcimpl implements AuctionDAO{
	
	private static final String SQL_INSERT_ENCHERE = "INSERT INTO ENCHERES VALUES ( ?, ?, ?, ?)";
	private static final String SQL_UPDATE_ENCHERE = "UPDATE ENCHERES SET date_enchere = ?, montant_enchere =?, no_utilisateur = ? where no_article = ?";
	private static final String SQL_SELECT_BY_NO_ARTICLE = "select * from ENCHERES where no_article =?";
	
	public Auction insertEnchere(Auction nouvelEnchere) throws DALException{

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (PreparedStatement) = ordre SQL
		int no_auction = -1;
		PreparedStatement ordre = null;
		try {
			ordre = cnx.prepareStatement(SQL_INSERT_ENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
			
			// Paramétrer l'objet de commande
			
			LocalDateTime date_enchere = nouvelEnchere.getDate_enchere();
			int montant_enchere = nouvelEnchere.getMontant();
			int no_article = nouvelEnchere.getNo_article();
			int no_utilisateur = nouvelEnchere.getNo_utilisateur();
			
			
			ordre.setTimestamp(1, Timestamp.valueOf(date_enchere));
			ordre.setInt(2, montant_enchere);
			ordre.setInt(3, no_article);
			ordre.setInt(4, no_utilisateur);

			// Execute l'ordre SQL
			ordre.executeUpdate();

			// Récupérer l'identifiant du repas généré par la base de données
			ResultSet rs = ordre.getGeneratedKeys();
			if (rs.next()) {
				no_auction = rs.getInt(1); // 1 : première colonne du résultat (qui n'en contient qu'une)
				nouvelEnchere.setNo_utilisateur(no_auction);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return nouvelEnchere;

	}
	
	
	
	public Auction updateEnchere(Auction nouvelEnchere) throws DALException{

		// Obtenir une connexion

		Connection cnx = ConnectionProvider.getConnection();

		// Obtient une objet de commande (PreparedStatement) = ordre SQL
		int no_auction = -1;
		PreparedStatement ordre = null;
		try {
			
			ordre = cnx.prepareStatement(SQL_UPDATE_ENCHERE);
			
			// Paramétrer l'objet de commande
			
			LocalDateTime date_enchere = nouvelEnchere.getDate_enchere();
			int montant_enchere = nouvelEnchere.getMontant();
			int no_article = nouvelEnchere.getNo_article();
			int no_utilisateur = nouvelEnchere.getNo_utilisateur();
			
		
			ordre.setTimestamp(1, Timestamp.valueOf(date_enchere));
			ordre.setInt(2, montant_enchere);			
			ordre.setInt(3, no_utilisateur);
			ordre.setInt(4, no_article);

			// Execute l'ordre SQL
			ordre.executeUpdate();


		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return nouvelEnchere;

	}
	
	public Auction selectByNo_article(int no_article) throws DALException  {
		Auction enchere = null;int no_enchere=0;LocalDateTime date_enchere=null;
		int montant_enchere = 0;int no_utilisateur=0;
		int numero_article=0;
		try(Connection cnx = ConnectionProvider.getConnection();) {
			
			PreparedStatement ordre = cnx.prepareStatement(SQL_SELECT_BY_NO_ARTICLE);
			ordre.setInt(1, no_article);
			
			
			ResultSet rs = ordre.executeQuery();
			
			
			
			if(rs.next()) {
				
				 no_enchere = rs.getInt("no_enchere");
				 date_enchere = rs.getTimestamp("date_enchere").toLocalDateTime();
				 montant_enchere =rs.getInt("montant_enchere");
				 numero_article = rs.getInt("no_article");

				 no_utilisateur = rs.getInt("no_utilisateur");
				
				 
			cnx.close();		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return enchere = new Auction(no_enchere, date_enchere, montant_enchere, numero_article, no_utilisateur);
	}
	
	
	

}
