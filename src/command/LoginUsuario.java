package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Login;
import Service.LoginService;

public class LoginUsuario implements Command {
	
	private boolean status;

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String pUsuario = request.getParameter("usuario");
		String pSenha = request.getParameter("senha");

		LoginService lose = new LoginService();

		status = lose.checkLogin(pUsuario, pSenha);

		Login lo = Login.getInstance();

		if (status == true) {
			if (lo.getCargo().equals("Colaborador")) {
				RequestDispatcher view = request.getRequestDispatcher("Home.jsp");
				view.forward(request, response);

			} else {
				if (lo.getCargo().equals("Avaliador")) {
					RequestDispatcher view = request.getRequestDispatcher("Home.jsp");
					view.forward(request, response);

				} else {
					RequestDispatcher view = request.getRequestDispatcher("Home.jsp");
					view.forward(request, response);

				}
			}

		}

	}

}
