<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<form action="cliente" method="post">
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Do Usuario</th>
				<th>Para Usuario</th>
				<th>Tipo Operação</th>
				<th>Tipo Movimentação</th>
				<th>Valor</th>
				<th>Data</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${user.movimentacoes}" var="movimentacao">
				<tr>
					<td>${movimentacao.id}</td>
					<td>${movimentacao.fromConta.titular}</td>
					<td>${movimentacao.toConta.titular}</td>
					<td>${movimentacao.tipoOperacao}</td>
					<td>${movimentacao.tipoMovimentacao}</td>
					<td>R$ ${movimentacao.valor}</td>
					<td>${movimentacao.date.toLocalDate()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>