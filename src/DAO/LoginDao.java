/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author vidal
 */
public class LoginDao {
            Connection con = null;
    PreparedStatement ps = null;

  public ResultSet consultarlogin(String i){
    ResultSet rs = null;
        try {
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            String sql = "select * from login where nick = ?";
            
            ps = con.prepareStatement(sql);
            ps.setString(1, i);
            rs = ps.executeQuery();
            System.out.println("login obtidos com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO OBTER login!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }//FIM consultarCliente
  
  public void  incluirlogin(DOMAIN.Login login){
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            String sql = "INSERT INTO public.login(nick, password, idfuncionario)VALUES ( ?, ?,?)";
        try {
            ps = con.prepareCall(sql);
            
            ps.setInt(3, login.getIdFuncionario());
            ps.setString(1, login.getNick());
            ps.setString(2, login.getPassword());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "login Incluido com Sucesso"); 
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"ERRO no incluir-login:" + e.getMessage());//identifica onde esta o ERRO
        }//fim catch
    }
  public void alterarsenha (DOMAIN.Login login){
        ConectaBd conexao = new ConectaBd();
        con = conexao.obterConexao();
        String sql = "update login set  password where nick = ?";
        try {
            ps = con.prepareCall(sql);
            
            ps.setString(1, login.getPassword());
            ps.setString(2, login.getNick());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "login Alterado com Sucesso"); 
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"ERRO no alterar-login:" + e.getMessage());//identifica onde esta o ERRO
        }//fim catch
        
        
    }
    public void excluir(DOMAIN.Login login){
        ConectaBd conexao=new ConectaBd();
            con = conexao.obterConexao();
            try{
                String sql = "delete from login where nick=?";
                ps= con.prepareStatement(sql);
                ps.setString(1, login.getNick());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "login excluido com sucesso!");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR login!");
                System.out.println(e.getMessage());
            }
}
}
