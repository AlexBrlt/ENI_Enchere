package fr.eni.projet.enchere.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import fr.eni.projet.enchere.bll.ArticleManager;
import fr.eni.projet.enchere.bll.BLLException;
import fr.eni.projet.enchere.bo.Article;
import fr.eni.projet.enchere.dal.DALException;



/**
 * Servlet implementation class AddArticleServlet
 */
@WebServlet("/AddArticle")
public class AddArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JSP_AJOUT_ARTICLE = "/WEB-INF/JSP/AddArticle.jsp";
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Afficher la vue
		RequestDispatcher rd = request.getRequestDispatcher(JSP_AJOUT_ARTICLE);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupérer les paramètres du formulaire
		String nameArticle = request.getParameter("nameArticle");
		String description = request.getParameter("description");
		// TODO passer en string catégorie
		String noCategorie = request.getParameter("categories");
		int no_categorie = 0;
		switch (noCategorie) {
		case "Ameublement":
			no_categorie = 1;
			break;

		case "Informatique":
			no_categorie = 2;
			break;
		case "Vetement":
			no_categorie = 3;
			break;
		case "Sport&Loisirs":
			no_categorie = 4;
			break;
		}
		
		System.out.println(request.getParameter("categories"));
			
		int priceStart = Integer.valueOf(request.getParameter("points"));
				//String photoArticle = request.getParameter("formFile");
		String dateStartAuction = request.getParameter("StartAuction");
		String dateEndAuction = request.getParameter("EndAuction");
		
		// On remplace le character T des strings date pour pouvoir les parse
		dateStartAuction = dateStartAuction.replace('T', ' ');
		dateEndAuction = dateEndAuction.replace('T', ' ');

		// Conversion des paramètres
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.US);
		LocalDateTime dateTimeStart = LocalDateTime.parse(dateStartAuction, formatter);
		LocalDateTime dateTimeEnd = LocalDateTime.parse(dateEndAuction, formatter);
		
		// Ajouter Article
		HttpSession session = request.getSession();
		
		int no_user = (int)session.getAttribute("no_user");
		Article article = new Article(nameArticle, description, dateTimeStart, dateTimeEnd, priceStart, no_categorie,no_user); 
		
			try {
				ArticleManager.getInstance().ajouterArticle(article);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
		dispatcher.forward(request, response);
	}

}
