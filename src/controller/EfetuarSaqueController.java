package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conta;

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
		Integer numero = Integer.parseInt(request.getParameter("numero"));

		BigDecimal valor = new BigDecimal(valorAsString);
		Conta conta = new Conta(numero);
		conta.efetuaSaque(valor);
		
		PrintWriter writer = response.getWriter();
		writer.println("<html>Sacou R$" + valor.doubleValue() + "! Saldo atual R$ " + conta.getSaldo().doubleValue() + "<html>");
	}

}
