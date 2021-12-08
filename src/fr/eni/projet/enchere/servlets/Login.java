package fr.eni.projet.enchere.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.enchere.bll.BLLException;
import fr.eni.projet.enchere.bll.UserManager;
import fr.eni.projet.enchere.bo.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/JSP/Login.jsp";
	private static final String VUETRUE = "/WEB-INF/JSP/Home.jsp";
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
			utilisateurs = UserManager.getInstance().detailPseudo(userID);
		} catch (BLLException e) {

			e.printStackTrace();
		}
		
		User user = utilisateurs.get(0);
	
		String pseudo = user.getPseudo();
		String mot_de_passe = user.getMot_de_passe();
	
		
		
			if (pseudo.equals(userID) && mot_de_passe.equals(password)) {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(VUETRUE);
				dispatcher.forward(request, response);
				
			} else {
				System.out.println("Coucou");
				RequestDispatcher dispatcher = request.getRequestDispatcher(VUEFALSE);
				dispatcher.forward(request, response);	
			}	
	}
}
