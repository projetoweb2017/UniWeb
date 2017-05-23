package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Model.Login;

@WebFilter("/*")
public class LogFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Login login = (Login)session.getAttribute("logado");
		
		if(login == null){
			System.out.println(req.getParameter("command"));
		} else {
			System.out.println(login.getUsuario()+ " -> " + req.getParameter("command"));
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
		if(login == null){
			System.out.println(req.getParameter("command"));
		} else {
			System.out.println(req.getParameter("command")+" -> " + login.getUsuario());
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
