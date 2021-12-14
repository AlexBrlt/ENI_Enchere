package fr.eni.projet.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.eni.projet.enchere.bo.Article;
import fr.eni.projet.enchere.bo.Category;
import fr.eni.projet.enchere.dal.DALException;

public class CategoriesDAOimpl {
	private static final String SQL_SELECT_CATEGORY_BY_LIBELLE = "SELECT * FROM CATEGORIES WHERE libelle = ?";
	
	
	public HashMap<Integer, String> selectByLibelle() throws DALException  {
		HashMap<Integer, String> categories =  new HashMap<Integer, String>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement ordre = cnx.prepareStatement(SQL_SELECT_CATEGORY_BY_LIBELLE);
		    
		    
			ResultSet rs = ordre.executeQuery();
			
			while(rs.next()) {
				int numero_categorie = rs.getInt("no_categorie");
				String name_libelle = rs.getString("libelle");
				
				//A revoir car pas compris ce passage de code
				Category c = new Category(numero_categorie, name_libelle);
				categories.put(numero_categorie, name_libelle);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		return categories;
	}
}
