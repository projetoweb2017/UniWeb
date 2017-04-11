<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Uni - Visualizar Cadastros</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
        <!-- Barra superior com os menus de navegação -->
		<c:import url="Menu.jsp"/>
        <!-- Container Principal -->
        <div id="main" class="container">
            <h3 class="page-header">Lista de Cadastros</h3>

                <div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome Completo</th>
                                    <th>Data de Nascimento</th>
                                    <th>Sexo</th>
                                    <th>E-Mail</th>
                                    <th>Telefone Residencial</th>
                                    <th>Telefone Celular</th>
                                    <th>Cargo</th>
                                    <th>Categoria</th>
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="cadastro" items="${lista }">
                                       <tr>
                                            <td>
                                               ${cadastro.id}
                                            </td>
                                            <td>
                                                ${cadastro.nomeCompleto}
                                            </td>
                                            <td>
                                                ${cadastro.dataDeNascimento}
                                            </td>
                                            <td>
                                                ${cadastro.sexo}
                                            </td>
                                            <td>
                                                ${cadastro.email}
                                            </td>
                                            <td>
                                                ${cadastro.telefoneResidencial}
                                            </td>
                                            <td>
                                                ${cadastro.telefoneCelular}
                                            </td>
                                             <td>
                                                ${cadastro.cargo}
                                            </td>
                                            <td>
                                                ${cadastro.categoria}
                                            </td>
                                        </tr>
                            </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>

            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="index.jsp" class="btn btn-default">Voltar</a>
                </div>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>

</html>