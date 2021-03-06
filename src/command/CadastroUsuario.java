package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Cadastro;
import Service.CadastroService;

public class CadastroUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		Cadastro ca = new Cadastro();
        CadastroService se = new CadastroService();
        
        //Carrega os campos para as Strings
        String pNome = request.getParameter("nome");
		String pData = request.getParameter("dataDeNascimento");
		String pSexo = request.getParameter("sexo");
		String pEmail = request.getParameter("email");
		String pResidencial = request.getParameter("telR");
		String pCelular = request.getParameter("telC");
		String pUniversidade = request.getParameter("universidade");
		String pCurso = request.getParameter("curso");
		
		
		
		String pUsuario = request.getParameter("usuario");
		String pSenha = request.getParameter("senha");
		String pSecreta = request.getParameter("pergunta");
		
		//Cria o objeto CA
		ca.setNomeCompleto(pNome);
		ca.setDataDeNascimento(pData);
		ca.setSexo(pSexo);
		ca.setEmail(pEmail);
		ca.setTelefoneResidencial(pResidencial);
		ca.setTelefoneCelular(pCelular);
		ca.setUniversidade(pUniversidade);
		ca.setCurso(pCurso);
		
		ca.setUsuario(pUsuario);
		ca.setSenha(pSenha);
		ca.setPerguntaSecreta(pSecreta);
		
		
		se.InserirCadastro(ca);	
		ca = se.Carregar(ca.getId());
		
		
		
		//enviar para o jsp
		request.setAttribute("cadastro", ca);
		RequestDispatcher view =
		request.getRequestDispatcher("index.jsp");
		view.forward(request, response);

	}

}
