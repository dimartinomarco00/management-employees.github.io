package com.webapp.crud_employees.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.crud_employees.dao.DipendenteDao;
import com.webapp.crud_employees.model.Dipendente;


@WebServlet("/")
public class DipendenteController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private DipendenteDao dipendenteDao;
       
    
    public DipendenteController() 
    {
        dipendenteDao = new DipendenteDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getServletPath();
		
		switch(action)
		{
			case "/view-insert-form": mostraFormInserimento(request, response); break;
			case "/view-edit-form": mostraFormModifica(request, response); break;
			case "/insert": inserisciDipendente(request, response); break;
			case "/delete": eliminaDipendente(request, response); break;
			case "/update": modificaDipendente(request, response); break;
			case "/view-list": visualizzaListaDipendenti(request, response); break;
			default:
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/index.jsp");
				requestDispatcher.forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    doGet(request, response);
	}
	
	
	private void mostraFormInserimento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/add-new-employee.jsp");
		requestDispatcher.forward(request, response);
	}
	
	private void mostraFormModifica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		Dipendente dipendenteEsistente = dipendenteDao.selezionaDipendente(id);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/add-new-employee.jsp");
		request.setAttribute("dipendente", dipendenteEsistente);
		requestDispatcher.forward(request, response);
	}
	
	private void inserisciDipendente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String eta = request.getParameter("eta");
		String sesso = request.getParameter("sesso");
		String dataNascita = request.getParameter("data");
		//LocalDate dataNascita = LocalDate.parse(request.getParameter("data"));
		String email = request.getParameter("email");
		String numeroTelefono = request.getParameter("telefono");
		String salario = request.getParameter("salario");
    	
		
		Dipendente dipendente = new Dipendente(nome, cognome, eta, sesso, dataNascita, email, numeroTelefono, salario);
		dipendenteDao.inserisciDipendente(dipendente);
		
		response.sendRedirect("view-list");
	}
	
	private void eliminaDipendente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		dipendenteDao.eliminaDipendente(id);
		
		response.sendRedirect("view-list");
	}
	
	private void modificaDipendente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String eta = request.getParameter("eta");
		String sesso = request.getParameter("sesso");
		String dataNascita = request.getParameter("data");
		//LocalDate dataNascita = LocalDate.parse(request.getParameter("data"));
		String email = request.getParameter("email");
		String numeroTelefono = request.getParameter("telefono");
		String salario = request.getParameter("salario");
		
		Dipendente dipendenteModificato = new Dipendente(id, nome, cognome, eta, sesso, dataNascita, email, numeroTelefono, salario);
		
		dipendenteDao.modificaDipendente(dipendenteModificato);
		
		response.sendRedirect("view-list");
	}
	
	private void visualizzaListaDipendenti(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Dipendente> listaDipendenti = dipendenteDao.selezionaTuttiIDipendenti();
		
		request.setAttribute("listaDipendenti", listaDipendenti);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/index.jsp");
		requestDispatcher.forward(request, response);
	}
}
