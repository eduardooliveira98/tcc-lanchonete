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
public class ComandaDAO {
        Connection con = null;
    PreparedStatement ps = null;
public ResultSet listarComandas(){
    ResultSet rs = null;
        try {
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            String sql = "select * from comanda where status = true ORDER BY dtabertura";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("Comandas obtidos com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO OBTER Comandas!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }
public ResultSet contaComandas(){
    ResultSet rs = null;
        try {
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            String sql = "select idcomanda from comanda ORDER BY idcomanda";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("Comandas obtidos com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO OBTER Comandas!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }
  public ResultSet consultarComandas(int i){
    ResultSet rs = null;
        try {
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            String sql = "select * from comanda where idcomanda = ?";
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            System.out.println("Comanda obtidos com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO OBTER comandas!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }  
  public ResultSet consultarComandaspormesa(int i){
    ResultSet rs = null;
        try {
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            String sql = "select * from comanda where mesa = ? and status=true";
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            System.out.println("Comanda obtidos com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO OBTER comandas!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }//FIM consultarCliente
  public void  incluirComanda(DOMAIN.Comanda comanda){
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            String sql = "INSERT INTO public.comanda(mesa, valortotal, status, dtabertura, idfuncionario)VALUES ( ?, ?,?,?,?)";
        try {
            ps = con.prepareCall(sql);
            
            ps.setInt(1, comanda.getMesa());
            ps.setFloat(2, comanda.getValortotal());
            ps.setBoolean(3, comanda.isStatus());
            ps.setDate(4, comanda.getDtabertura());
            ps.setInt(5, comanda.getIdfuncionario());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Comanda Incluido com Sucesso"); 
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"ERRO no incluir-Comanda:" + e.getMessage());//identifica onde esta o ERRO
        }//fim catch
    }
  public void alterarComanda (DOMAIN.Comanda comanda){
        ConectaBd conexao = new ConectaBd();
        con = conexao.obterConexao();
        String sql = "update comanda set mesa=?, valortotal=?, status=?, dtfechamento=? where idcomanda = ?";
        try {
            ps = con.prepareCall(sql);
            
            ps.setInt(1, comanda.getMesa());
            ps.setFloat(2, comanda.getValortotal());
            ps.setBoolean(3, comanda.isStatus());
            ps.setDate(4, comanda.getDtfechamento());
            ps.setInt(5, comanda.getIdcomanda());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Comanda Alterado com Sucesso"); 
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"ERRO no alterar-Comanda:" + e.getMessage());//identifica onde esta o ERRO
        }//fim catch
        
        
    }public void alterarComandatotal (DOMAIN.Comanda comanda){
        ConectaBd conexao = new ConectaBd();
        con = conexao.obterConexao();
        String sql = "update comanda set  valortotal=?, mesa=? where idcomanda = ?";
        try {
            ps = con.prepareCall(sql);
            
            
            ps.setFloat(1, comanda.getValortotal());
            ps.setInt(2, comanda.getMesa());
            ps.setInt(3, comanda.getIdcomanda());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Comanda Alterado com Sucesso"); 
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"ERRO no alterar-Comanda:" + e.getMessage());//identifica onde esta o ERRO
        }//fim catch
        
        
    }
  
    public ResultSet pesquisarporid(int nome){
            ResultSet rs = null;
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            try{
                String sql = "Select * from comanda where idcomanda = ?";
                ps = con.prepareCall(sql);
                ps.setInt(1, nome);
                rs = ps.executeQuery();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "ERRO AO PESQUISAR!");
                System.out.println(e.getMessage());
            }
            return rs;
    }
    public void excluir(DOMAIN.Comanda comanda){
        ConectaBd conexao=new ConectaBd();
            con = conexao.obterConexao();
            try{
                String sql = "delete from comanda where idcomanda=?";
                ps= con.prepareStatement(sql);
                ps.setInt(1, comanda.getIdcomanda());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Comanda excluido com sucesso!");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR Comanda!");
                System.out.println(e.getMessage());
            }
}}
