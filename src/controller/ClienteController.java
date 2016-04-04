package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import to.MovimentacaoTO;
import model.Conta;
import model.Movimentacao;

@WebServlet("/cliente")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClienteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//TODO: Enviar para tela de "login"
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valorAsString = request.getParameter("valor");
		Integer numero = Integer.parseInt(request.getParameter("numero"));

		BigDecimal valor = new BigDecimal(valorAsString);
		Conta conta = new Conta(numero).carrega();
		conta.efetuaSaque(valor);
		
		List<MovimentacaoTO> movimentacoes = new Movimentacao().getMovimentacoes(conta);
		
		request.setAttribute("movimentacoes", movimentacoes);
		request.setAttribute("cliente", conta);
		RequestDispatcher view = request.getRequestDispatcher("cliente.jsp");
		view.forward(request, response);
	}
}
