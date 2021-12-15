package fr.eni.projet.enchere.servlets;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class SellerDisplay
 */
@WebServlet("/SellerDisplay")
public class SellerDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		String nomDePseudo = (String) request.getAttribute("pseudo");
		System.out.println(nomDePseudo);
		
		List<User> listPseudo = new ArrayList<User>();
		
		try {
			listPseudo = UserManager.getInstance().getByPseudo(nomDePseudo);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User utilisateur = listPseudo.get(0); 
		
		request.setAttribute("pseudo", utilisateur.getPseudo());
		request.setAttribute("surname", utilisateur.getSurname());
		request.setAttribute("name", utilisateur.getName());
		request.setAttribute("mail", utilisateur.getMail());
		request.setAttribute("phone", utilisateur.getPhone());
		request.setAttribute("street", utilisateur.getStreet());
		request.setAttribute("postalCode", utilisateur.getPostalCode());
		request.setAttribute("city", utilisateur.getCity());

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/SellerDisplay.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
