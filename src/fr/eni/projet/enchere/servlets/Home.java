
package fr.eni.projet.enchere.servlets;

import java.io.IOException;
<<<<<<< Updated upstream
import java.util.ArrayList;
=======

>>>>>>> Stashed changes
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.enchere.bll.ArticleManager;
import fr.eni.projet.enchere.bll.BLLException;
import fr.eni.projet.enchere.bo.Article;
<<<<<<< Updated upstream
import sun.security.jca.GetInstance;
=======

>>>>>>> Stashed changes


/**
 * Servlet implementation class Home
 */
@WebServlet(urlPatterns = {"/", "/home"})
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/JSP/Home.jsp";
	private static final String LIST_ARTICLE = "listArticle";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> listArticle = null;
		try {
			listArticle = ArticleManager.getInstance().selectArticleHome();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute(LIST_ARTICLE, listArticle);
			
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	
		 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< Updated upstream
		this.doGet(request, response);
=======
		List<Article> listArticle = null;

		String categories = request.getParameter("categories");
		String saisieUtilisateur = request.getParameter("recherche").toLowerCase().trim(); 
	
		if(!categories.equals("") && !saisieUtilisateur.equals("")) {
			listArticle = ArticleManager.getInstance().getByMotCleAndCategory(motcle, category);
		} else if (!categories.equals("")) {
			listArticle = ArticleManager.getInstance().getByCategorie(category);
		} else if (!saisieUtilisateur.equals("")) {
			listArticle = ArticleManager.getInstance().getByMotCle(motcle);
		} else{
			this.doGet(request, response);
		}
	
>>>>>>> Stashed changes
	}




}
