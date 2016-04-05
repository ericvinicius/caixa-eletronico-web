<form action="cliente" method="post">
	<label> 
		Para: 
		<input type="text" name="conta" />
	</label> 
	<label> 
		Valor: 
		<input type="text" name="valor" />
	</label> 
	<input type="hidden" name="acao" value="TransferenciaController" /> 
	<input type="submit" value="Transferir" />
</form>