package fr.eni.projet.enchere.dal;

import java.util.List;

import fr.eni.projet.enchere.bo.User;

public interface UserDAO {
	
	public User updateUser(User nouveauUser) throws DALException;
	public User insertUser(User nouveauUser) throws DALException;
	List<User> selectByPseudo(String pseudo) throws DALException;
	public void delete(int no_utilisateur) throws DALException;
}