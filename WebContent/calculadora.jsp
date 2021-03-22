<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<title>Calculadora</title>
</head>
<body>
	<%
		String resposta = (String) request.getAttribute("resposta");
	if (resposta == null)
		resposta = "";

	String lista = "";
	HttpSession sessao = request.getSession(false);
	if (sessao != null) {
		List<String> listaRespostas = (List<String>) sessao.getAttribute("listaRespostas");
		if (listaRespostas != null) {
			for (String resp : listaRespostas) {
		lista += String.format("<li> %s </li>", resp);
			}
		}
	}
	%>



	<h1>CALCULADORA</h1>
	<div class="gx-5">
		<div>
			<h6><%=resposta%></h6>
		</div>


		<form action="calcula" method="get">
			<div class="col-md-6">
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Valor
						um</label> <input type="number" class="form-control" name="valor_um"
						id="exampleFormControlInput1" placeholder="digite um valor...">
				</div>

				<div class="mb-3">
					<label for="exampleFormControlInput2" class="form-label">Valor
						dois</label> <input type="number" class="form-control" name="valor_dois"
						id="exampleFormControlInput2" placeholder="digite um valor...">
				</div>

				<input type="submit" class="btn btn-primary" value="SOMAR"
					name="operacao"> <input type="submit"
					class="btn btn-primary" value="DIMINUIR" name="operacao"> <input
					type="submit" class="btn btn-primary" value="MULTIPLICAR"
					name="operacao"> <input type="submit"
					class="btn btn-primary" value="DIVIDIR" name="operacao">
			</div>
		</form>
	</div>


	<div>
		<h6>RESULTADOS</h6>
		<ul>
			<%=lista%>

		</ul>
	</div>
</body>
</html>