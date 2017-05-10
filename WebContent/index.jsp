<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Uni - Universidade Novo Intelecto</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegacao -->
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Login</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="controller.do" method="post">
            <!-- area de campos do form -->
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="nome">Usuário</label>
                    <input type="text" class="form-control" name="usuario" id="usuario" required maxlength="20" placeholder="Digite o seu Usuário">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="fone">Senha</label>
                    <input type="tel" class="form-control" name="senha" id="senha" maxlength="20" placeholder="Digite a sua Senha">
                </div>
            </div>
        
            <label for= "avisoCadastro" style="padding-right:10px" >Caso não tenha uma conta</label><a href="Cadastro.jsp" class="btn btn-primary btn-xs">Clique Aqui</a>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="LoginUsuario">Entrar</button>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>