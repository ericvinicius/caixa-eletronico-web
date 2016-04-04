<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Conta" %>
<%@page import="java.util.List" %>
<%@page import="model.Movimentacao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Caixa Eletronico Web</title>
</head>
<body>
	<fieldset>
		<legend>Dados da Conta</legend>
		<%Conta to = (Conta)request.getAttribute("cliente"); %>
		<%List<Movimentacao> movimentacoes = (List<Movimentacao>) request.getAttribute("movimentacoes");  %>
		Tamanho das movimentacoes: <%=movimentacoes.size()%><br>
		Numero da Conta:           <%=to.getNumero()  %><br>
		Nome:                      <%=to.getTitular() %><br>
		Saldo:                   R$<%=to.getSaldo()   %><br>
	</fieldset>
	
	<fieldset>
		<legend>Sacar</legend>
		<form action="cliente" method="post">
			<label>
				Valor:
				<input type="text" name="valor" />
			</label>
			<input type="hidden" name="acao" value="SacarController" />
			<input type="hidden" name="numero" value="${cliente.numero}" />
			<input type="submit" value="Sacar" />
		</form>
	</fieldset>
	
	
</body>
</html>