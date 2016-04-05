package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

public abstract class MyController {
	
	public static void redirectToUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("cliente.jsp");
		view.forward(request, response);
	}
	
	protected abstract void action(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException;

}
