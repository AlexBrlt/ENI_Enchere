package fr.eni.projet.enchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.enchere.bo.User;


@WebServlet( "/profil"	)


public class profilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public profilServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Modifier le setAttribute car les élements à afficher dans la jps profil (venant de la servlet profil) sont en durs pour le moment.
		request.setAttribute("user", new User("", "", "", "", "", "", ""));
		request.getRequestDispatcher("/WEB-INF/JSP/profil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
