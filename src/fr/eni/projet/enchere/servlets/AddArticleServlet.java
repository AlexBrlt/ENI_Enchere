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
//		int noCategorie = Integer.valueOf(request.getParameter("categories"));
		int noCategorie = 1;
		int noUser=1;
		int priceStart = Integer.valueOf(request.getParameter("points"));
				//String photoArticle = request.getParameter("formFile");
		String dateStartAuction = request.getParameter("StartAuction");
		String dateEndAuction = request.getParameter("EndAuction");
		dateStartAuction = dateStartAuction.replace('T', ' ');
		dateEndAuction = dateEndAuction.replace('T', ' ');

		//Conversion des paramètres
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.US);
		LocalDateTime dateTimeStart = LocalDateTime.parse(dateStartAuction, formatter);
		LocalDateTime dateTimeEnd = LocalDateTime.parse(dateEndAuction, formatter);
		
		//Ajouter Article
		Article article = new Article(nameArticle, description, dateTimeStart, dateTimeEnd, priceStart, noCategorie, 1);

	
			try {
				ArticleManager.getInstance().ajouterArticle(article);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp");
		dispatcher.forward(request, response);
	}

}
