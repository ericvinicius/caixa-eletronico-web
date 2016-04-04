<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Efetuar Saque</title>
</head>
<body>
	<h3>Efetuar Saque</h3>
	<form action="efetuarSaque" method="post">
		<div>
			<label>
				Numero Conta:
				<input type="text" name="numero" />
			</label>
			<label>
				Valor:
				<input type="text" name="valor" />
			</label>
		</div>
		
		<input type="submit" value="Salvar" />
	</form>
</body>
</html>