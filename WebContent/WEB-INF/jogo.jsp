<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Jogo da Forca</title>
		<link rel="stylesheet" href="<c:url value="/jogo.css" />">
	</head>
	<body>
		<header>
			<h1>Jogo da Forca</h1>
		</header>
		<section>
			<ol class="letras">
				<c:forEach var="letra" items="${forca.palavra.toCharArray()}">
					<li class="letra"></li>
				</c:forEach>
			</ol>
			
			<form method="POST">
				<label for="letra">Chute uma letra</label>
				<input type="text" name="letra" id="letra" size="2">
				<button type="submit">Chutar!</button>
			</form>
		</section>
		
		<footer>
			<p>Desenvolvido por:</p>
			<p>Daniel Teixeira - 135026-9</p>
			<p>Gabriel Sousa Kraszczuk - 135025-1</p>
			<small> &copy; 2016 - Todos os Direitos Reservados</small>
		</footer>
	</body>
</html>