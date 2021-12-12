package fr.eni.projet.enchere.bll;

import java.util.List;

import fr.eni.projet.enchere.bo.Article;
import fr.eni.projet.enchere.bo.Auction;
import fr.eni.projet.enchere.dal.AuctionDAO;
import fr.eni.projet.enchere.dal.DALException;
import fr.eni.projet.enchere.dal.UserDAO;
import fr.eni.projet.enchere.dal.DAOFactory;

public class AuctionManager {
	
	private static AuctionManager instance;
	
	private static AuctionDAO dao;
	
	private AuctionManager() {
		dao = DAOFactory.getEnchere();
	};

	public static AuctionManager getInstance() {
		if(instance == null) {
			instance = new AuctionManager();
		}
		return instance;
	}
	
	public Auction ajouterArticle(Auction nouvelEnchere) throws BLLException {

		BLLException ex = new BLLException();

		
		if(ex.hasErreur()) {
			throw ex;
		}
		
		try {
			Auction article = dao.insertEnchere(nouvelEnchere);

			return article;
		} catch (DALException e) {
			e.printStackTrace();
			ex.ajouterErreur(e);
			throw ex;
		}
		

	}
	
public Auction modfierAuction(Auction modifyAuction) throws BLLException {
		
		BLLException ex = new BLLException();


		Auction auction = null;
		try {
			auction = dao.updateEnchere(modifyAuction);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BLLException();
		}

		return auction;
		
	}


	
	
	
	
}


