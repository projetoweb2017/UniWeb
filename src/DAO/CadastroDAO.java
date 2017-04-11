package DAO;

import Model.Cadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroDAO {

	private boolean check = false;

	public int InserirCadastro(Cadastro ca) {

		String sqlInsert = "INSERT INTO cadastro (Nome_Completo, Data_de_Nascimento, Sexo, Email, Telefone_Residencial, Telefone_Celular, Universidade, Curso, Usuario, Senha, PerguntaSecreta, Cargo, Categoria)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlInsert);) {
			stmt.setString(1, ca.getNomeCompleto());
			stmt.setString(2, ca.getDataDeNascimento());
			stmt.setString(3, ca.getSexo());
			stmt.setString(4, ca.getEmail());
			stmt.setString(5, ca.getTelefoneResidencial());
			stmt.setString(6, ca.getTelefoneCelular());
			stmt.setString(7, ca.getUniversidade());
			stmt.setString(8, ca.getCurso());
			stmt.setString(9, ca.getUsuario());
			stmt.setString(10, ca.getSenha());
			stmt.setString(11, ca.getPerguntaSecreta());
			stmt.setString(12, ca.getCargo());
			stmt.setString(13, ca.getCategoria());
			stmt.execute();

			String sqlQuery = "SELECT LAST_INSERT_ID()";

			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					ca.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ca.getId();
	}

	public Cadastro carregar(int id) {
		Cadastro cadastro = new Cadastro();
		cadastro.setId(id);
		String sqlSelect = "SELECT Nome_Completo, Data_de_Nascimento, Sexo , Email , Telefone_Celular, Curso FROM cadastro WHERE cadastro.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, cadastro.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					cadastro.setNomeCompleto(rs.getString("Nome_Completo"));
					cadastro.setDataDeNascimento(rs.getString("Data_de_Nascimento"));
					cadastro.setSexo(rs.getString("Sexo"));
					cadastro.setEmail(rs.getString("Email"));
					cadastro.setTelefoneCelular(rs.getString("Telefone_Celular"));
					cadastro.setCurso(rs.getString("Curso"));
				} else {
					cadastro.setId(-1);
					cadastro.setNomeCompleto(null);
					cadastro.setDataDeNascimento(null);
					cadastro.setSexo(null);
					cadastro.setEmail(null);
					cadastro.setTelefoneCelular(null);
					cadastro.setCurso(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return cadastro;
	}

	public boolean CheckUsuario(String Usuario) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro WHERE Usuario = ?");
			stmt.setString(1, Usuario);
			rs = stmt.executeQuery();

			if (rs.next()) {
				check = true;
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Já existe este Usuário registrado.");
			Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return check;
	}

	public boolean CheckEmail(String Email) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro WHERE Email = ?");
			stmt.setString(1, Email);
			rs = stmt.executeQuery();

			if (rs.next()) {
				check = true;
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Já existe este email registrado");
			Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return check;
	}

	// Usado na tela Registros do Superior para carregar todos os cadastros
	public List<Cadastro> CarregarCadastros() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Cadastro cadastro = new Cadastro();

				cadastro.setId(rs.getInt(1));
				cadastro.setNomeCompleto(rs.getString(2));
				cadastro.setEmail(rs.getString(14));
				cadastro.setCargo(rs.getString(23));
				cadastro.setCategoria(rs.getString(24));

				cadastros.add(cadastro);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return cadastros;
	}

	// Usado na tela Registros do Superior para carregar todos os cadastros no
	// campo de busca
	public List<Cadastro> CarregarCadastrosBuscar(String nome) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro Where Nome_Completo LIKE ?");
			stmt.setString(2, "%" + nome + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Cadastro cadastro = new Cadastro();

				cadastro.setId(rs.getInt(1));
				cadastro.setNomeCompleto(rs.getString(2));
				cadastro.setEmail(rs.getString(14));
				cadastro.setCargo(rs.getString(23));
				cadastro.setCategoria(rs.getString(24));

				cadastros.add(cadastro);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return cadastros;
	}

	// Usado na tela Registros do Superior para carregar apenas os colaboradores
	public List<Cadastro> CarregarCadastrosColaborador() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro Where Cargo = 'Colaborador'");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Cadastro cadastro = new Cadastro();

				cadastro.setId(rs.getInt(1));
				cadastro.setNomeCompleto(rs.getString(2));
				cadastro.setEmail(rs.getString(14));
				cadastro.setCargo(rs.getString(23));
				cadastro.setCategoria(rs.getString(24));

				cadastros.add(cadastro);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return cadastros;
	}

	// Usado na tela Registros do Superior para carregar apenas os avaliadores
	public List<Cadastro> CarregarCadastrosAvaliador() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro Where Cargo = 'Avaliador'");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Cadastro cadastro = new Cadastro();

				cadastro.setId(rs.getInt(1));
				cadastro.setNomeCompleto(rs.getString(2));
				cadastro.setEmail(rs.getString(14));
				cadastro.setCargo(rs.getString(23));
				cadastro.setCategoria(rs.getString(24));

				cadastros.add(cadastro);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return cadastros;
	}

	// Usado na tela Registros do Superior para carregar os superiores
	public List<Cadastro> CarregarCadastrosSuperior() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cadastro Where Cargo = 'Superior'");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Cadastro cadastro = new Cadastro();

				cadastro.setId(rs.getInt(1));
				cadastro.setNomeCompleto(rs.getString(2));
				cadastro.setEmail(rs.getString(14));
				cadastro.setCargo(rs.getString(23));
				cadastro.setCategoria(rs.getString(24));

				cadastros.add(cadastro);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar sugestões: " + e.getMessage());

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return cadastros;
	}

	public List<Cadastro> carregarTodosCadastros() {
		
		Cadastro cadastro;

		List<Cadastro> lista = new ArrayList<Cadastro>();
		
		

		String sqlSelect = "SELECT ID , Nome_Completo, Data_de_Nascimento, Sexo , Email , Telefone_Residencial , Telefone_Celular, Universidade , Curso , Cargo , Categoria FROM cadastro;";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {

			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {

					cadastro = new Cadastro();

					cadastro.setId(rs.getInt("ID"));
					cadastro.setNomeCompleto(rs.getString("Nome_Completo"));
					cadastro.setDataDeNascimento(rs.getString("Data_de_Nascimento"));
					cadastro.setSexo(rs.getString("Sexo"));
					cadastro.setEmail(rs.getString("Email"));
					cadastro.setTelefoneResidencial(rs.getString("Telefone_Residencial"));
					cadastro.setTelefoneCelular(rs.getString("Telefone_Celular"));
					cadastro.setUniversidade(rs.getString("Universidade"));
					cadastro.setCurso(rs.getString("Curso"));
					cadastro.setCargo(rs.getString("Cargo"));
					cadastro.setCategoria(rs.getString("Categoria"));
					
					lista.add(cadastro);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
}
