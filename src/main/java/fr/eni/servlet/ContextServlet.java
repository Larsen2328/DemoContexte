package fr.eni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ContextServlet
 */
@WebServlet("/ContextServlet")
public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Contexte application
		ServletContext application = this.getServletContext();
		application.setAttribute("app",
				"Visible par : Tous les utilisateurs\nDurée de vie : Tant que l'application tourne\nStocké sur : Serveur");

		// Contexte session
		HttpSession session = request.getSession();
		session.setAttribute("session", "Visible par : moi\nDurée de vie : La session\nStocké sur : Serveur");

		// Contexte requête
		request.setAttribute("req", "Visible par : moi\nDurée de vie : La requête\nStocké sur : Serveur");

		// cookie

		Cookie cookie = new Cookie("cookiePerso", "Bonjour");
		cookie.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(cookie);

		request.setAttribute("cookiePerso", cookie);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
