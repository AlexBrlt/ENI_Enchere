package fr.eni.projet.enchere.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.enchere.bll.BLLException;
import fr.eni.projet.enchere.bll.UserManager;
import fr.eni.projet.enchere.bo.Article;
import fr.eni.projet.enchere.bo.Auction;
import fr.eni.projet.enchere.bo.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/JSP/Login.jsp";
	private static final String VUETRUE = "/home";
	private static final String VUEFALSE = "/WEB-INF/JSP/Login.jsp";
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getParameter("userID");
		String userID=request.getParameter("userID");
		System.out.println(userID);
		
		request.getParameter("password");
		String password=request.getParameter("password");
		System.out.println(password);
		
		
		List<User> utilisateurs = null;
		try {
			utilisateurs = UserManager.getInstance().SeLoguer(userID);
		} catch (BLLException e) {

			e.printStackTrace();
		}
		
		for(User s : utilisateurs)
	        System.out.println(s);
		
		
		if (utilisateurs.isEmpty()) {
			
			System.out.println("Coucou");
			RequestDispatcher dispatcher = request.getRequestDispatcher(VUEFALSE);
			dispatcher.forward(request, response);
		
			
			
		} else {
			
			User user = utilisateurs.get(0);
			String pseudo = user.getPseudo();
			String email = user.getMail();
			String mot_de_passe = user.getPassword();
			User userArticleEnchere = null;
		
			
			
				if ((pseudo.equals(userID) || email.equals(userID)) && mot_de_passe.equals(password)) {
					System.out.println("ici");
					
					
					try {
						 userArticleEnchere = UserManager.getInstance().userBuyAndSold(user.getNo_utilisateur());
					} catch (BLLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					 
					
					HttpSession session = request.getSession();
					
					session.setMaxInactiveInterval(300);
					
					session.setAttribute("user", user);
					session.setAttribute("articleUser", userArticleEnchere.getList_article());
					session.setAttribute("auctionUser", userArticleEnchere.getList_Auction());
					session.setAttribute("no_user", user.getNo_utilisateur());
					System.out.println(session.getAttribute("user").toString());

					for (Article art : userArticleEnchere.getList_article()) {
					    System.out.println(art);
					}
					
					for (Auction auct : userArticleEnchere.getList_Auction()) {
					    System.out.println(auct);
					}	
					
					RequestDispatcher dispatcher = request.getRequestDispatcher(VUETRUE);
					dispatcher.forward(request, response);
					
				} else {
					System.out.println("salut");
					RequestDispatcher dispatcher = request.getRequestDispatcher(VUEFALSE);
					dispatcher.forward(request, response);	
				}
		}
	}
}
