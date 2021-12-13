package fr.eni.projet.enchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.enchere.bll.ArticleManager;
import fr.eni.projet.enchere.bll.AuctionManager;
import fr.eni.projet.enchere.bll.BLLException;
import fr.eni.projet.enchere.bo.Article;
import fr.eni.projet.enchere.bo.Auction;

/**
 * Servlet implementation class ArticleBuying
 */
@WebServlet("/achatArticle")
public class AuctionInProgress extends HttpServlet {
	private static final long serialVersionUID = 1L;
private static final String Details = "/WEB-INF/JSP/AuctionInProgress.jsp" ;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Auction enchereAuction = null;
		Article article = null;
		System.out.println("salut");
		
		try {
			 article =ArticleManager.getInstance().selectArticle(12);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		request.setAttribute("articledesciption", article.getDescription());
		request.setAttribute("articlesStartPrice", article.getPriceStart());
		request.setAttribute("articlemeilleuroffre", article.getPriceSold());
		request.setAttribute("articlefinenchere", article.getDateEndAuction());
		
		try {
			 enchereAuction = AuctionManager.getInstance().selectbynoarticle(12);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int enchereprix;
		
		
		System.out.println(enchereAuction.getMontant());
	//	Integer encherepourArticle = Integer.valueOf(enchereAuction.getMontant());
		if (Integer.valueOf(enchereAuction.getMontant())==null) {
			
			enchereprix=0;
			
		} else {
		
			enchereprix = enchereAuction.getMontant();

		}
		
		request.setAttribute("encherefaite", enchereAuction.getMontant());
		
		
		request.setAttribute("articleretraitstreet", article.getBuyer().getStreet());
		request.setAttribute("articleretraitpostal", article.getBuyer().getPostalCode());
		request.setAttribute("articleretraitCity", article.getBuyer().getCity());
		request.setAttribute("articleretraitname", article.getBuyer().getName());
		
		request.setAttribute("articleretraitpseudo", article.getBuyer().getPseudo());
		
		
		//pour la servlet afficher profil 
		request.setAttribute("articleretraitpseudo", article.getBuyer().getPseudo());
		
		
		
		
		System.out.println(request.getAttribute("articledesciption"));
		RequestDispatcher dispatcher = request.getRequestDispatcher(Details);
		dispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(Details);
		dispatcher.forward(request, response);
	
	}

}
