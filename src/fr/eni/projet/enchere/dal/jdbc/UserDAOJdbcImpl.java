package fr.eni.projet.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;


import fr.eni.projet.enchere.bo.User;
import fr.eni.projet.enchere.dal.DALException;
import fr.eni.projet.enchere.dal.UserDAO;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

public class UserDAOJdbcImpl implements UserDAO {

	private static final String SQL_INSERT_USER = "INSERT INTO UTILISATEURS VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	private final static String SQL_UPDATE_USER = "UPDATE UTILISATEURS SET " +
			 "pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?, credit=?, administrateur=? " +
			 "WHERE idArticle=?";
	private final static String SQL_SELECT_USER_BY_PSEUDO = "select * from UTILISATEURS where pseudo = ? ";
	private final static String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur=?";												
	
	public UserDAOJdbcImpl() {

	}

	public User insertUser(User nouveauUser) {

		// Obtenir une connexion
		Connection cnx = ConnectionProvider.getConnection();

		// Inserer le repas
		// ET
		// Insérer chaque aliment du repas
		// REM : on ne vérifier pas que le meme nom d'aliment est déjà présnt en base de
		// données

		// Obtient une objet de commande (PreparedStatement) = ordre SQL
		int no_user = -1;
		PreparedStatement ordre = null;
		try {
			ordre = cnx.prepareStatement(SQL_INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
			
			// Paramétrer l'objet de commande
			String pseudo = nouveauUser.getPseudo();
			String nom = nouveauUser.getNom();
			String prenom = nouveauUser.getPrenom();
			String email = nouveauUser.getEmail();
			String telephone = nouveauUser.getTelephone();
			String rue = nouveauUser.getRue();
			String code_postal = nouveauUser.getCode_postal();
			String ville = nouveauUser.getVille();
			String mot_de_passe = nouveauUser.getMot_de_passe();
			int credit = nouveauUser.getCredit();
			
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

			// Récupérer l'identifiant du repas généré par la base de données
			ResultSet rs = ordre.getGeneratedKeys();
			if (rs.next()) {
				no_user = rs.getInt(1); // 1 : première colonne du résultat (qui n'en contient qu'une)
				nouveauUser.setNo_utilisateur(no_user);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return nouveauUser;

	}
	
	
	public User updateUser(User usermodifie) {
		
		Connection cnx = ConnectionProvider.getConnection();

		// Inserer le repas
		// ET
		// Insérer chaque aliment du repas
		// REM : on ne vérifier pas que le meme nom d'aliment est déjà présnt en base de
		// données

		// Obtient une objet de commande (PreparedStatement) = ordre SQL
		int no_user = -1;
		PreparedStatement ordre = null;
		try {
			ordre = cnx.prepareStatement(SQL_UPDATE_USER);
			
			// Paramétrer l'objet de commande
			String pseudo = usermodifie.getPseudo();
			String nom = usermodifie.getNom();
			String prenom = usermodifie.getPrenom();
			String email = usermodifie.getEmail();
			String telephone = usermodifie.getTelephone();
			String rue = usermodifie.getRue();
			String code_postal = usermodifie.getCode_postal();
			String ville = usermodifie.getVille();
			String mot_de_passe = usermodifie.getMot_de_passe();
			int credit = 100;
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
	public List<User> selectByPseudo(String selectPseudo) throws DALException  {
		List<User> utilisateurs = new ArrayList<User>();
		
		try(Connection cnx = ConnectionProvider.getConnection();) {
			
			PreparedStatement ordre = cnx.prepareStatement(SQL_SELECT_USER_BY_PSEUDO);
			ordre.setString(1, selectPseudo);
			
			
			ResultSet rs = ordre.executeQuery();
			while(rs.next()) {
				
				int no_utilisateur = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String code_postal = rs.getString("code-postal");
				String ville = rs.getString("ville");
				User u = new User(no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, null, 0, false);

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
	
	
	
	
	

}
