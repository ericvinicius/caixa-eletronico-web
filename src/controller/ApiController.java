package controller;

import static javax.servlet.http.HttpServletResponse.SC_NOT_ACCEPTABLE;
import static javax.servlet.http.HttpServletResponse.SC_OK;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dao.ContaDAO;
import dao.MovimentacaoDAO;
import model.Conta;
import model.Movimentacao;
import to.ContaTO;

@WebServlet("/api")
public class ApiController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String acao = request.getParameter("acao");
		System.out.println("-1231231231231231---------");
		if(acao.equals("clientes")){
			List<Conta> contas = new ContaDAO().lista();
			JSONArray contasJSON = new JSONArray(contas);
			response.getWriter().print(contasJSON.toString());
			
		} else {
			response.setStatus(SC_NOT_ACCEPTABLE);
			return;
		}
		response.setStatus(SC_OK);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String acao = request.getParameter("acao");
		if(acao.equals("sacar")){
			String conta = request.getParameter("conta");
			String valor = request.getParameter("valor");
			ContaTO contaTO = new ContaTO(Integer.parseInt(conta));
			try{
				ContaDAO contaDAO = new ContaDAO();
				contaDAO.efetuaSaque(contaTO, new BigDecimal(valor));
			} catch (RuntimeException e){
				response.setStatus(SC_NOT_ACCEPTABLE);
				return;
			}
			
		}  else if(acao.equals("movimentacoes")){
			String conta = request.getParameter("conta");
			ContaTO contaTO = new ContaTO(Integer.parseInt(conta));
			List<Movimentacao> movimentacoes = new MovimentacaoDAO().getMovimentacoes(contaTO);
			JSONArray movimentacoesJSON = new JSONArray(movimentacoes);
			response.getWriter().print(movimentacoesJSON.toString());
		
		} else {
			response.setStatus(SC_NOT_ACCEPTABLE);
			return;
		}
		response.setStatus(SC_OK);
	}

}
