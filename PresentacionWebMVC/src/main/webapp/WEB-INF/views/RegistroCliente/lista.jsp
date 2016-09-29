<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ page session="false" %>
<html>
<head>
	<title>Lista de Clientes</title>
</head>
<body>
	<h3>Lista de Clientes</h3>
	<table border="1" style="width: 100%">
		<thead>
			<tr>
				<th>idCliente</th>
				<th>RazonSocial</th>
				<th>NIC</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listacliente}" var="cli">
				<tr>
					<td>${cli.idCliente}</td>
					<td>${cli.razonSocial}</td>
					<td> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>