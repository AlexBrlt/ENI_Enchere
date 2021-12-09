package fr.eni.projet.enchere.bll;

import fr.eni.projet.enchere.dal.AuctionDAO;
import fr.eni.projet.enchere.dal.UserDAO;
import fr.eni.projet.enchere.dal.UserDAOFactory;

public class AuctionManager {
	
	private static AuctionManager instance;
	
	private static AuctionDAO dao;
	
	private AuctionManager() {
		dao = UserDAOFactory.getEnchere();
	};

	public static AuctionManager getInstance() {
		if(instance == null) {
			instance = new AuctionManager();
		}
		return instance;
	}
	
}


