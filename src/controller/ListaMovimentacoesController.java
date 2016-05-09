package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import model.Conta;
import model.Movimentacao;

@WebServlet("/movimentacoes")
public class ListaMovimentacoesController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json"); 
		Integer numero = Integer.parseInt(request.getParameter("numero"));
		Conta conta = new Conta(numero).carrega();
		List<Movimentacao> movimentacoes = Movimentacao.getMovimentacoes(conta);
		List<JSONObject> movs = new ArrayList<>();
		try {
			for (Movimentacao movimentacao : movimentacoes) {
				movs.add(movimentacao.toJSON());
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

}
