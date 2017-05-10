<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Uni - Cadastro</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegacao -->
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Cadastro</h3>


		<!-- Formulario para inclusao de clientes -->
		<form action="Cadastro.do" method="post">
			<!-- area de campos do form -->
			<div class="row">
				<div class="form-group col-md-6">
					<label for="nome">Nome Completo</label> <input type="text"
						class="form-control" name="nome" id="nome" required
						maxlength="100" placeholder="Digite o seu nome">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="nome">Data de Nascimento</label> <input type="text"
						class="form-control" name="dataDeNascimento" id="dataDeNascimento"
						required maxlength="10"
						placeholder="Digite como o Exemplo: 11/12/2013">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="nome">Sexo</label>
					<p></p>
					<select name='sexo' class="form-control">
						<option value='001'>Selecione o seu sexo</option>
						<option value='Masculino'>Masculino</option>
						<option value='Feminino'>Feminino</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="fone">Email</label> <input type="tel"
						class="form-control" name="email" id="email" maxlength="100"
						placeholder="Digite o seu e-mail">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="fone">Telefone Residencial</label> <input type="tel"
						class="form-control" name="telR" id="telR" maxlength="20"
						placeholder="Digite o seu telefone residencial">
				</div>
				<div class="form-group col-md-3">
					<label for="fone">Telefone Celular</label> <input type="tel"
						class="form-control" name="telC" id="telC" maxlength="20"
						placeholder="Digite o seu telefone celular	">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="fone">Universidade</label> <input type="tel"
						class="form-control" name="universidade" id="universidade"
						maxlength="50" placeholder="Digite o seu telefone celular	">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="fone">Curso</label> <select name='curso'
						class="form-control">
						<option value='000'>Selecione o seu curso</option>
						<option value='002'>Masculino</option>
						<option value='003'>Feminino</option>
						<option value='004'>Feminino</option>
						<option value='005'>Feminino</option>
						<option value='006'>aaa</option>
					</select>
				</div>
			</div>
			<hr />
			<hr>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="fone">Usuário</label> <input type="tel"
						class="form-control" name="usuario" id="usuario" maxlength="50"
						placeholder="Digite o seu Usuario">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-3">
					<label for="fone">Senha</label> <input type="password"
						class="form-control" name="senha" id="senha" maxlength="50"
						placeholder="Digite a sua Senha">
				</div>
				<div class="form-group col-md-3">
					<label for="fone">Confirmar Senha</label> <input type="password"
						class="form-control" name="confsenha" id="confsenha"
						maxlength="50" placeholder="Digite a sua Senha">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="fone">Pergunta Secreta</label> <input type="tel"
						class="form-control" name="pergunta" id="pergunta" maxlength="50"
						placeholder="Pergunta: Qual é a sua comida favorita?">
				</div>
			</div>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="acao"
						value="Criar">Criar</button>
					<a href="index.jsp" class="btn btn-default">Voltar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>