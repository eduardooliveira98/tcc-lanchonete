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
public class ComandaItensDao {
      Connection con = null;
    PreparedStatement ps = null;
public ResultSet listarComandasitens(DOMAIN.ComandaItens comandaItens){
    ResultSet rs = null;
        try {
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            String sql = "select * from comanda_itens where idcomanda=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, comandaItens.getIdcomanda());
            rs = ps.executeQuery();
            System.out.println("Comandas_itens obtidos com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO OBTER Comandas_itens!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }

  public ResultSet consultarComandasItens(int i){
    ResultSet rs = null;
        try {
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            String sql = "select iditem, qtd,id from comanda_itens where idcomanda = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            System.out.println("Comanda_itens obtidos com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO OBTER comanda_itens!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }
  public void  incluirComandaItens(DOMAIN.ComandaItens comandaItens){
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            String sql = "INSERT INTO public.comanda_itens(idcomanda,iditem,qtd)VALUES ( ?, ?,?)";
        try {
            ps = con.prepareCall(sql);
            
            ps.setInt(1, comandaItens.getIdcomanda());
            ps.setInt(2, comandaItens.getIditem());
            ps.setInt(3, comandaItens.getQtd());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Comanda_itens Incluido com Sucesso"); 
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"ERRO no incluir-Comanda_itens:" + e.getMessage());//identifica onde esta o ERRO
        }//fim catch
    }
  public void alterarComandaItens (DOMAIN.ComandaItens comandaItens){
        ConectaBd conexao = new ConectaBd();
        con = conexao.obterConexao();
        String sql = "update comanda set  qtd=? where iditem=? and idcomada = ?";
        try {
            ps = con.prepareCall(sql);
            ps.setInt(1, comandaItens.getQtd());
            ps.setInt(1, comandaItens.getIditem());
            ps.setInt(2, comandaItens.getIdcomanda());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Comanda_itens Alterado com Sucesso"); 
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"ERRO no alterar-Comanda_itens:" + e.getMessage());//identifica onde esta o ERRO
        }//fim catch
        
        
    }
    public void excluir(DOMAIN.ComandaItens comandaItens){
        ConectaBd conexao=new ConectaBd();
            con = conexao.obterConexao();
            int a=comandaItens.getIdcomanda();System.out.println(a);
            int b=comandaItens.getIditem();System.out.println(b);
            int c=comandaItens.getId();
            try{
                String sql = "delete from comanda_itens where idcomanda=? and iditem=? and id=?";
              
                ps= con.prepareStatement(sql);
                ps.setInt(1, a);
                ps.setInt(2, b);  
                ps.setInt(3, c);
                ps.executeUpdate();System.out.println(sql);
                JOptionPane.showMessageDialog(null, "Comanda_itens excluido com sucesso!");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR Comanda_itens!");
                System.out.println(e.getMessage());
            }
}
}
