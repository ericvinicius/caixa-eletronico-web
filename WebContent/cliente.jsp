<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="/style/css/bootstrap.min.css" >
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Caixa Eletronico Web</title>
</head>
<body>
	<fieldset>
		<legend>Dados da Conta</legend>
		Numero da Conta:            ${user.conta.numero}<br>
		Nome:                       ${user.conta.titular}<br>
		Saldo:                   R$ ${user.conta.saldo}<br>
	</fieldset>
	
	<fieldset>
		<legend>Sacar</legend>
		<jsp:include page="sacar.jsp" />
	</fieldset>
	
	<fieldset>
		<legend>Transferencia</legend>
		<jsp:include page="transferencia.jsp" />
	</fieldset>
	<fieldset>
		<legend>Movimentacoes (${user.movimentacoes.size()})</legend>
		<jsp:include page="movimentacoes.jsp" />
	</fieldset>
	
	
</body>
</html>