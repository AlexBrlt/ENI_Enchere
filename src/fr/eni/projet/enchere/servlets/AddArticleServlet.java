package fr.eni.projet.enchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class AddArticleServlet
 */
@WebServlet("/AddArticleServlet")
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
				String nomArticle = request.getParameter("nameArticle");
				String descriptionArticle = request.getParameter("description");
				String categoryArticle = request.getParameter("categories");
				String photoArticle = request.getParameter("formFile");
				String pointArticle = request.getParameter("points");
				String debutEnchere = request.getParameter("StartAuction");
				String finEnchere = request.getParameter("EndAuction");
				
				String rueUser = request.getParameter("rue");
				String codePostalUser = request.getParameter("codePostal");
				String villeUser = request.getParameter("ville");
			
		//Vérification
		System.out.println("nom Article : " + nomArticle);
	}

}
