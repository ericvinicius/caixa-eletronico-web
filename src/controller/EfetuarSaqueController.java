package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/efetuarSaque")
public class EfetuarSaqueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EfetuarSaqueController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valorAsString = request.getParameter("valor");
		long id = Long.parseLong(request.getParameter("id"));
		
		Double valor = new Double(0.0);
		if(valorAsString != null){
			valor = Double.parseDouble(valorAsString);
		}
		
		PrintWriter writer = response.getWriter();
		writer.println("<html>Sacou R$" + valor + "<html>");
	}

}
