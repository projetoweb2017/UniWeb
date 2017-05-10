package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Cadastro;
import Service.CadastroService;


public class VisualizarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String pId = request.getParameter("id");
			String pNome = request.getParameter("nomeCompleto");
			String pData = request.getParameter("dataDeNascimento");
			String pEmail = request.getParameter("email");
			String pTelefoneR = request.getParameter("telefoneResidencial");
			String pTelefoneC = request.getParameter("telefoneCelular");

			
			int id = -1;
			try {
				id = Integer.parseInt(pId);
			} catch (NumberFormatException e) {

			}

			Cadastro cadastro = new Cadastro();
			cadastro.setId(id);
			cadastro.setNomeCompleto(pNome);
			cadastro.setDataDeNascimento(pData);
			cadastro.setEmail(pEmail);
			cadastro.setTelefoneResidencial(pTelefoneR);
			cadastro.setTelefoneCelular(pTelefoneC);
			CadastroService cs = new CadastroService();
			
			RequestDispatcher view = null;

			cadastro = cs.Carregar(cadastro.getId());
			request.setAttribute("cadastro", cadastro);
			view = request.getRequestDispatcher("VisualizarUsuario.jsp");

			view.forward(request, response);

	}

}
