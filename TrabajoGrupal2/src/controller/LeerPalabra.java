package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Palindromo;

/**
 * Servlet implementation class LeerPalabra
 */
@WebServlet("/LeerPalabra")
public class LeerPalabra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeerPalabra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		
		if(request.getParameter("palabra")!=null && !request.getParameter("palabra").isEmpty())
		{
			Palindromo palindromo = new Palindromo(request.getParameter("palabra"));
			if(palindromo.isPalindromo())
				request.setAttribute("isPalindromo", true);
			else
				request.setAttribute("isPalindromo", false);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("Palindromo.jsp");
		dispatcher.forward(request, response);
		
	}

}
