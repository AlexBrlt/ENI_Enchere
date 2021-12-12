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
import fr.eni.projet.enchere.bll.BLLException;
import fr.eni.projet.enchere.bo.Article;

/**
 * Servlet implementation class ArticleBuying
 */
@WebServlet("/achatArticle")
public class AuctionInProgress extends HttpServlet {
	private static final long serialVersionUID = 1L;
private static final String Details = "/WEB-INF/JSP/AuctionInProgress.jsp" ;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
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
		request.setAttribute("articleretraitstreet", article.getSeller().getStreet());
		
		System.out.println(request.getAttribute("articledesciption"));
		RequestDispatcher dispatcher = request.getRequestDispatcher(Details);
		dispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(Details);
		dispatcher.forward(request, response);
	
	}

}
