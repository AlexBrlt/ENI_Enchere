package fr.eni.projet.enchere.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.enchere.bll.ArticleManager;
import fr.eni.projet.enchere.bll.BLLException;
import fr.eni.projet.enchere.bo.Article;
import fr.eni.projet.enchere.bo.User;

/**
 * Servlet implementation class ModifyArticle
 */
@WebServlet("/ModifyArticle")
public class ModifyArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/JSP/ModifyArticle.jsp";
	
	private static final String ARTICLE = "article"; 
	private static final String NAME_ARTICLE = "nameArticle";   
	private static final String DESCRIPTION = "description";
	private static final String DATE_START_AUCTION = "StartAuction";
	private static final String DATE_END_AUCTION = "EndAuction";
	private static final String PRICE_START = "points";
	
	private static final String USER = "user";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nameArticle = request.getParameter(NAME_ARTICLE);
		String description = request.getParameter(DESCRIPTION);
		String dateStartAuction = request.getParameter(DATE_START_AUCTION)+ " 00:00:00";
		String dateEndAuction = request.getParameter(DATE_END_AUCTION) + " 00:00:00";
		int priceStart = Integer.valueOf(request.getParameter(PRICE_START));
		Integer priceSold = null; // On peut modifier l'article puisqu'il n'est pas vendu
		
		// BON CODE, SERT A RECUPERER LE NUMERO UTILISATEUR
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute(USER);
//		int noUser = user.getNo_utilisateur();
		
		int noCategorie = 2;
		int noArticle = 1;

		//Conversion des paramètres
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US);
		LocalDateTime dateTimeStart = LocalDateTime.parse(dateStartAuction, formatter);
		LocalDateTime dateTimeEnd = LocalDateTime.parse(dateEndAuction, formatter);
		System.out.println(dateTimeStart.toString());
		
		System.out.println(noArticle);
		System.out.println(nameArticle);
		System.out.println(description);
		System.out.println(dateTimeStart.toString());
		System.out.println(dateTimeEnd.toString());
		System.out.println(priceStart);
		System.out.println(priceSold);
		System.out.println(noCategorie);
		
		//Ajouter Article
		Article article = new Article(noArticle, nameArticle, description, dateTimeStart, dateTimeEnd, priceStart, priceSold, noCategorie, 1);
		
		try {
			ArticleManager.getInstance().modfierArticle(article);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//TODO La catégorie
		
//		private int noArticle;
//		private String nameArticle;
//		private String description;
//		private LocalDateTime dateStartAuction;
//		private LocalDateTime dateEndAuction;
//		private int priceStart;
//		private int priceSold;
//		private int noUser;
//		private int noCategorie;
	}

}
