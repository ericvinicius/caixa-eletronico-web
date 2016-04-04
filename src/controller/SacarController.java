package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conta;
import model.Movimentacao;

public class SacarController extends MyController {

	@Override
	public void action(HttpServletRequest request, HttpServletResponse response, Conta conta,
			List<Movimentacao> movimentacoes) throws ServletException, IOException {
		BigDecimal valor = new BigDecimal(request.getParameter("valor"));
		conta.efetuaSaque(valor);
		
		request.setAttribute("cliente", conta);
		redirectToUser(request, response);
	}

}
