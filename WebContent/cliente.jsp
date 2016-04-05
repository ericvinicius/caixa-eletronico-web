<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Caixa Eletronico Web</title>
</head>
<body>
	<fieldset>
		<legend>Dados da Conta</legend>
		Tamanho das movimentacoes:  ${user.movimentacoes.size()}<br>
		Numero da Conta:            ${user.conta.numero}<br>
		Nome:                       ${user.conta.titular}<br>
		Saldo:                   R$ ${user.conta.saldo}<br>
	</fieldset>
	
	<fieldset>
		<legend>Sacar</legend>
		<jsp:include page="sacar.jsp" />
	</fieldset>
	
	<fieldset>
		<legend>Movimentacoes</legend>
	</fieldset>
	
	
</body>
</html>