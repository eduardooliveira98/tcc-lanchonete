/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DOMAIN.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author vidal
 */
public class ProdutosDAO {
    Connection con = null;
    PreparedStatement ps = null;
public ResultSet listarProdutos(){
    ResultSet rs = null;
        try {
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            String sql = "select * from produtos ORDER BY tipo";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("produtos obtidos com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO OBTER PRODUTOS!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }
  public ResultSet consultarProdutos(int i){
    ResultSet rs = null;
        try {
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            String sql = "select * from produtos where iditem = ?";
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            System.out.println("produtoss obtidos com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO OBTER produtos!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }//FIM consultarCliente
  public void  incluirProduto(DOMAIN.Produto produto){
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            String sql = "INSERT INTO public.produtos(nomeitem, preco, tipo)VALUES ( ?, ?, ?)";
        try {
            ps = con.prepareCall(sql);
            
            ps.setString(1, produto.getNomeitem());
            ps.setFloat(2, produto.getPreco());
            ps.setString(3, produto.getTipo());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto Incluido com Sucesso"); 
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"ERRO no incluir-Produto:" + e.getMessage());//identifica onde esta o ERRO
        }//fim catch
    }
  public void alterarProduto (DOMAIN.Produto produto){
        ConectaBd conexao = new ConectaBd();
        con = conexao.obterConexao();
        String sql = "update produtos set  nomeitem=?, preco=?, tipo=? where iditem = ?";
        try {
            ps = con.prepareCall(sql);
            
            ps.setString(1, produto.getNomeitem());
            ps.setFloat(2, produto.getPreco());
            ps.setString(3, produto.getTipo());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto Alterado com Sucesso"); 
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"ERRO no alterar-Produto:" + e.getMessage());//identifica onde esta o ERRO
        }//fim catch
        
        
    }
    public ResultSet pesquisarProdutoPorNome(String nome){
            ResultSet rs = null;
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            try{
                String sql = "Select * from produtos where nomeitem like ?";
                ps = con.prepareCall(sql);
                ps.setString(1, "%" + nome + "%");
                rs = ps.executeQuery();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "ERRO AO PESQUISAR!");
                System.out.println(e.getMessage());
            }
            return rs;
        }
    public void excluir(DOMAIN.Produto produto){
        ConectaBd conexao=new ConectaBd();
            con = conexao.obterConexao();
            try{
                String sql = "delete from produto where idProduto=?";
                ps= con.prepareStatement(sql);
                ps.setInt(1, produto.getIditem());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR Produto!");
                System.out.println(e.getMessage());
            }
      
        }
   
}
