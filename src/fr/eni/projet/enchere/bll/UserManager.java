package fr.eni.projet.enchere.bll;

import java.util.List;
import fr.eni.projet.enchere.bo.User;
import fr.eni.projet.enchere.dal.DALException;
import fr.eni.projet.enchere.dal.UserDAO;
import fr.eni.projet.enchere.dal.DAOFactory;

public class UserManager {
	
	private static UserManager instance;
	
	private static UserDAO dao;
	
	private UserManager() {
		dao = DAOFactory.getUserDAO();
	};

	public static UserManager getInstance() {
		if(instance == null) {
			instance = new UserManager();
		}
		return instance;
	}


	
	public User ajouterUser(User nouveauUser) throws BLLException {
		
		
		BLLException ex = new BLLException();
		
		validationPseudo(nouveauUser.getPseudo(), ex);
		validationNom(nouveauUser.getName(), ex);
		validationPrenom(nouveauUser.getSurname(), ex);
		validationTelephone(nouveauUser.getPhone(), ex);
		validationEmail(nouveauUser.getMail(), ex);
		validationVille(nouveauUser.getStreet(), ex);
		validationCode_postal(nouveauUser.getPostalCode(), ex);
		
		
		
		if(ex.hasErreur()) {
			throw ex;
		}
		
		try {
			User utilisateur = dao.insertUser(nouveauUser);
			
			return utilisateur;
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}
		
		
		
		
	}
	
	public User mettreajourUser(User userModifie) throws BLLException {
		
		BLLException ex = new BLLException();
		
		validationPseudo(userModifie.getPseudo(), ex);
		validationNom(userModifie.getName(), ex);
		validationPrenom(userModifie.getSurname(), ex);
		validationTelephone(userModifie.getPhone(), ex);
		validationEmail(userModifie.getMail(), ex);
		validationVille(userModifie.getCity(), ex);
		validationCode_postal(userModifie.getPostalCode(), ex);
		validationRue(userModifie.getStreet(), ex);
		
		if(ex.hasErreur()) {
			throw ex;
		}
		
		try {
			User utilisateur = dao.updateUser(userModifie) ;
			return utilisateur;
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}
		
		
	
		
		
	
	
	
	}
	
	public void removeUser(int no_utilisateur) throws BLLException {
		
		BLLException ex = new BLLException();
		validationId(no_utilisateur, ex);
		
	
		// A faire vérife
	//	validationId(idArticle, ex);   
		
		if(ex.hasErreur()) {
			throw ex;
		}
		
		try {
			dao.delete(no_utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}
		
	}
	
	public List<User> SeLoguer(String user_Pseudo_mail) throws BLLException {
		BLLException ex = new BLLException();
		
		validationPseudo(user_Pseudo_mail, ex);
		
		if(ex.hasErreur()) {
			throw ex;
		}
		
		try {
			return dao.selectBypseudoAndMail(user_Pseudo_mail);
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}
		
		
	}
	
	public List<User> getByPseudo(String user_Pseudo) throws BLLException {
		BLLException ex = new BLLException();
		
		validationPseudo(user_Pseudo, ex);
		
		if(ex.hasErreur()) {
			throw ex;
		}
		
		try {
			return dao.selectByPseudo(user_Pseudo);
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}
		
		
	}
	
	public List<User> getByMail(String user_mail) throws BLLException {
		BLLException ex = new BLLException();
		
		validationPseudo(user_mail, ex);
		
		if(ex.hasErreur()) {
			throw ex;
		}
		
		try {
			return dao.selectByMail(user_mail);
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}

	}
	
	public User userBuyAndSold(int no_user) throws BLLException{
		
		
		BLLException ex = new BLLException();
		
		
		
		if(ex.hasErreur()) {
			throw ex;
		}
		
		try {
			return dao.userAchatVente(no_user);
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}

	}
		
		
		
		
		

	

	private void validationId(int no_user, BLLException ex) throws BLLException {
		if(no_user < 1) {
			ex.ajouterErreur(new ParameterException("L'id doit être un entier positif >= 1"));
		}
	}
	
	private void validationPseudo(String pseudo, BLLException ex) {
		if(pseudo == null || pseudo.isEmpty()|| pseudo.length() > 30) {
			ex.ajouterErreur(new ParameterException("Le pseudo est obligatoire et doit avoir une longueur comprise entre 1 et 30"));
		}
	}
		private void validationNom(String nom, BLLException ex) {
			if(nom == null || nom.isEmpty()|| nom.length() > 30) {
				ex.ajouterErreur(new ParameterException("Le nom est obligatoire et doit avoir une longueur comprise entre 1 et 30"));
			}	
		}
		private void validationPrenom(String prenom, BLLException ex) {
			if(prenom == null || prenom.isEmpty()|| prenom.length() > 30) {
				ex.ajouterErreur(new ParameterException("Le prenom est obligatoire et doit avoir une longueur comprise entre 1 et 30"));
			}	
		}
		
		private void validationEmail(String email, BLLException ex) {
			if(email == null || email.isEmpty()|| email.length() > 50) {
				ex.ajouterErreur(new ParameterException("L'email est obligatoire et doit avoir une longueur comprise entre 1 et 30"));
			}	
		}
		
		private void validationTelephone(String telephone, BLLException ex) {
			if(telephone == null || telephone.isEmpty()|| telephone.length() > 15) {
				ex.ajouterErreur(new ParameterException("Le telephone est obligatoire et doit avoir une longueur comprise entre 1 et 15"));
			}	
		}
		
		private void validationRue(String rue, BLLException ex) {
			if(rue == null || rue.isEmpty()|| rue.length() > 30) {
				ex.ajouterErreur(new ParameterException("Le nom est obligatoire et doit avoir une longueur comprise entre 1 et 30"));
			}	
		}
		
		private void validationCode_postal(String code_postal, BLLException ex) {
			if(code_postal == null || code_postal.isEmpty()|| code_postal.length() > 10) {
				ex.ajouterErreur(new ParameterException("Le nom est obligatoire et doit avoir une longueur comprise entre 1 et 10"));
			}	
		}
		
		private void validationVille(String ville, BLLException ex) {
			if(ville == null || ville.isEmpty()|| ville.length() > 50) {
				ex.ajouterErreur(new ParameterException("Le nom est obligatoire et doit avoir une longueur comprise entre 1 et 50"));
			}	
		}
		
		private void validationPseudoAndMailUnique(String ville, BLLException ex) {
			if(ville == null || ville.isEmpty()|| ville.length() > 50) {
				ex.ajouterErreur(new ParameterException("Le nom est obligatoire et doit avoir une longueur comprise entre 1 et 50"));
			}	
		}
		
	
	}	
	


















