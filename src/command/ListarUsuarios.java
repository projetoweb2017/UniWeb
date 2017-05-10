package command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Cadastro;
import Service.CadastroService;



public class ListarUsuarios implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String chave = request.getParameter("data[search]");
		
		CadastroService cadastro = new CadastroService();
		ArrayList<Cadastro> lista = null;
		HttpSession session = request.getSession();
		if (chave != null && chave.length() > 0) {
			lista = cadastro.listarCadastros(chave);
		} else {
			lista = cadastro.listarCadastros();
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("Home.jsp");
		dispatcher.forward(request, response);
    

	}

}
