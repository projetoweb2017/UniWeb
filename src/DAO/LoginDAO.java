package DAO;


import Model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDAO {

	Login lo = Login.getInstance();
	
    public boolean checkLogin(String usuario , String senha){
        
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      boolean check = false;
              
      try {
            stmt = con.prepareStatement("SELECT * FROM cadastro WHERE Usuario = ? and Senha = ?");
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            
            if(rs.next()){
            	lo.setId(rs.getInt(1));
            	lo.setNomeCompleto(rs.getString(2));
            	lo.setDataDeNascimento(rs.getString(3));
            	lo.setSexo(rs.getString(4));
            	lo.setEmail(rs.getString(5));
            	lo.setTelefoneResidencial(rs.getString(6));
            	lo.setTelefoneCelular(rs.getString(7));
            	lo.setUniversidade(rs.getString(8));
            	lo.setCurso(rs.getString(9));
            	lo.setUsuario(rs.getString(10));
            	lo.setSenha(rs.getString(11));
            	lo.setPerguntaSecreta(rs.getString(12));
            	lo.setCargo(rs.getString(13));
            	lo.setCategoria(rs.getString(14));
            	
            check = true;

            }
            
       }catch (SQLException ex) {
        Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally {
          ConnectionFactory.closeConnection(con, stmt, rs);
      }
      return check;
   }
    
    public boolean AlterarInformacoesColaborador(int ID){
    	
       
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        boolean check = false;
                
        try {
              stmt = con.prepareStatement("UPDATE cadastro SET Nome_Completo = ? , Data_de_Nascimento = ? , Email = ? , Telefone_Residencial = ? , Telefone_Celular = ? , Usuario= ? , Senha = ? , Curso = ? WHERE ID= ?");
              stmt.setString(1, lo.getNomeCompleto());
              stmt.setString(2, lo.getDataDeNascimento());
              stmt.setString(3, lo.getEmail());
              stmt.setString(4, lo.getTelefoneResidencial());
              stmt.setString(5, lo.getTelefoneCelular());
              stmt.setString(6, lo.getUsuario());
              stmt.setString(7, lo.getSenha());
              stmt.setString(8, lo.getCurso());
              stmt.setInt(9, lo.getId());
              stmt.executeUpdate();
              
         }catch (SQLException ex) {
          Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
         }finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return check;
     }
    
    public boolean AlterarInformacoesAvaliador(int ID){
    	
       
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        boolean check = false;
                
        try {
              stmt = con.prepareStatement("UPDATE cadastro SET Nome_Completo = ? , Data_de_Nascimento = ? , Email = ? , Telefone_Residencial = ? , Telefone_Celular = ? , Usuario= ? , Senha = ? WHERE ID= ?");
              stmt.setString(1, lo.getNomeCompleto());
              stmt.setString(2, lo.getDataDeNascimento());
              stmt.setString(3, lo.getEmail());
              stmt.setString(4, lo.getTelefoneResidencial());
              stmt.setString(5, lo.getTelefoneCelular());
              stmt.setString(6, lo.getUsuario());
              stmt.setString(7, lo.getSenha());
              stmt.setInt(9, lo.getId());
              stmt.executeUpdate();
              
         }catch (SQLException ex) {
          Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
         }finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return check;
     }
    
}
