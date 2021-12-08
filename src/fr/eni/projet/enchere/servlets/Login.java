package fr.eni.projet.enchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(VUEFALSE);
		dispatcher.forward(request, response);
		
	}
	
	

}