<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Home - Cadastro de Palavras</title>
	</head>
	<body>
		<header>
			<h1> O Jogo da Forca</h1>
		</header>
		<section>
			<h3> Cadastro de Palavras</h3>
			<p>Olá caro usuário, logo abaixo você deve cadastrar palavras para iniciar no jogo. </p>
			<p> Para que você possa jogar, antes é necessário que você cadastre no mínimo 5 palavras </p>
			<form action="cadastro-palavras" method="POST">
				<label> Ainda faltam cadastrar ${quantidadeDePalavras}/5</label>
				<label> Palavras </label>
				<input type="text" name="palavra">
				<button type="submit">Cadastrar Palavras</button>
				<button type="Reset">Limpar Palavras</button>
				<button type="button" href="/jogar" ${podeJogar}>Jogar</button>
			</form>
		</section>
		
		<footer>
			<p> Desenvolvido por: </p>
			<p> Daniel Teixeira - 135026-9 </p>
			<p> Gabriel Sousa Kraszczuk - 135025-1 </p>
			<small> &copy; 2016 - Todos os Direitos Reservados </small>
		</footer>

	</body>
</html>