package Service;

import java.util.ArrayList;
import java.util.List;

import DAO.CadastroDAO;
import Model.Cadastro;



public class CadastroService {
	
	CadastroDAO dao = new CadastroDAO();
	
	
	public Cadastro InserirCadastro(Cadastro ca) {
		dao.InserirCadastro(ca);
		return ca;
	}
	
	public Cadastro Carregar(int id) {
		return dao.carregar(id);
	}
	
	public boolean CheckUsuario(String Usuario){
		return dao.CheckUsuario(Usuario);
	}
	
	public boolean CheckEmail(String Email) {
		return dao.CheckEmail(Email);
	}
	
	public List<Cadastro> carregarTodosCadastros(){
		return dao.carregarTodosCadastros();
	}

	public void atualizar(Cadastro cadastro){
		dao.atualizar(cadastro);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public ArrayList<Cadastro> listarCadastros(){
		return dao.listarCadastros();
	}
	public ArrayList<Cadastro> listarCadastros(String chave){
		return dao.listarCadastros(chave);
	}
}
