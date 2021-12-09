package fr.eni.projet.enchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.enchere.bll.UserManager;
import fr.eni.projet.enchere.bo.User;
import fr.eni.projet.enchere.dal.DALException;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/JSP/CreateUser.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(VUE);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String pseudo = request.getParameter("pseudo");
		
		String surname = request.getParameter("surname");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String street = request.getParameter("street");
		String postalCode = request.getParameter("cp");
		String city = request.getParameter("city");
		String password = request.getParameter("password");
		
		System.out.println("salut");

		User user = new User(pseudo, surname, name, mail, phone, street, postalCode, city, password, 100, false);

		try {
		UserManager.getInstance().ajouterUser(user);
		} catch (DALException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/Login.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
