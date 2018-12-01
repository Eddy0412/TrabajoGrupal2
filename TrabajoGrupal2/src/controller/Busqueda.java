package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbManager.Crud;
import model.Registros;


@WebServlet("/Busqueda")
public class Busqueda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	private Crud crud = new Crud(); 
	
    public Busqueda() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Registros> registros = new ArrayList<>();
		if(request.getParameter("contactName")!=null && !request.getParameter("contactName").isEmpty())
			registros = crud.selectFacturasByNombre(request.getParameter("contactName"));
		else if(request.getParameter("phoneNumber")!=null && !request.getParameter("phoneNumber").isEmpty())
			registros = crud.selectFacturasByTelefono(request.getParameter("phoneNumber"));
		
		if(registros.isEmpty())
			request.setAttribute("error","No hay registro con ese nombre o numero de telefono");
		
		request.setAttribute("registros", registros);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Contacts.jsp");
		dispatcher.forward(request, response);

	}

}
