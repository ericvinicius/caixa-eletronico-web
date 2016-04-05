<form action="cliente" method="post">
	<label> 
		Valor: 
		<input type="text" name="valor" />
	</label> 
	<input type="hidden" name="acao" value="SacarController" /> 
	<input type="hidden" name="numero" value="${user.conta.numero}" /> 
	<input type="submit" value="Sacar" />
</form>