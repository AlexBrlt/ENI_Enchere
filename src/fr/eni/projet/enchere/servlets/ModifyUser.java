package fr.eni.projet.enchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.enchere.bo.User;

/**
 * Servlet implementation class ModifyUser
 */
@WebServlet(name = "ModifyUserServlet", urlPatterns = { "/ModifyUser" })
public class ModifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PSEUDO = "pseudo"; 
	private static final String NAME = "name";
	private static final String SURNAME = "surname";
	private static final String STREET = "street";
	private static final String EMAIL = "email";
	private static final String TELEPHONE = "telephone";
	private static final String POSTAL_CODE = "postalCode";
	private static final String CITY = "city";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/ModifyUser.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter(PSEUDO)!=null) {
			
			String pseudo = request.getParameter(PSEUDO);
			String name = request.getParameter(NAME);
			String surname = request.getParameter(SURNAME);
			String street = request.getParameter(STREET);
			String mail = request.getParameter(EMAIL);
			String phone = request.getParameter(TELEPHONE);
			String postalCode = request.getParameter(POSTAL_CODE);
			String city = request.getParameter(CITY);
			
			User userModifie = new User();
		}
		

		

		
		
	}
}
