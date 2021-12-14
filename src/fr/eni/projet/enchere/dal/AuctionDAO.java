package fr.eni.projet.enchere.dal;

import fr.eni.projet.enchere.bo.Auction;

public interface AuctionDAO {
	Auction updateEnchere(Auction nouvelEnchere) throws DALException;
	Auction insertEnchere(Auction nouvelEnchere) throws DALException;
	public Auction selectByNo_article(int no_article) throws DALException;
	

}
