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
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author vidal
 */
public class FuncionariosDao {
    Connection con = null;
    PreparedStatement ps = null;
public ResultSet listarFuncionario(){
    ResultSet rs = null;
        try {
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            String sql = "select * from funcionarios ORDER BY idfuncionario";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("funcionarios obtidos com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO OBTER CLIENTES!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }
  public ResultSet consultarFuncionario(int i){
    ResultSet rs = null;
        try {
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            String sql = "select * from funcionarios where idfuncionario = ?";
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            System.out.println("funcionarios obtidos com sucesso");
        } catch (Exception e) {
            System.out.println("ERRO AO OBTER CLIENTES!");
            System.out.println(e.getMessage());
        }//Fim catch
        return rs;
    }//FIM consultarCliente
  public void  incluirFuncionario(DOMAIN.Funcionario funcionario){
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            String sql = "INSERT INTO public.funcionarios(nomefuncionario, rgFuncionario, cpfFuncionario, telFuncionario, cargo, dtCadastro, dtDemissao,  endereco)VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareCall(sql);
            
            ps.setString(1, funcionario.getNomeFuncionario());
            ps.setString(2, funcionario.getrG());
            ps.setString(3, funcionario.getcPF());
            ps.setString(4, funcionario.getTelefone());
            ps.setString(5, funcionario.getCargo());
            if(funcionario.getDtCadastro()==null)
                return;
            ps.setDate(6, funcionario.getDtCadastro());
            ps.setDate(7, funcionario.getDtDemissao());
            ps.setString(8, funcionario.getEndereço());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Funcionário Incluido com Sucesso"); 
        } catch (Exception e) {
        System.out.println("ERRO no incluir-Funcionário:" + e.getMessage());//identifica onde esta o ERRO
        }//fim catch
    }//Fim inserirCliente
  public void alterarFuncionario (DOMAIN.Funcionario funcionario){
        ConectaBd conexao = new ConectaBd();
        con = conexao.obterConexao();
        String sql = "update funcionarios set  nomefuncionario=?, rgfuncionario=?, cpffuncionario=?, telfuncionario=?, cargo=?, dtcadastro=?, dtdemissao=?, endereco=?,status=? where idfuncionario = ?";
        try {
            ps = con.prepareCall(sql);
            
            ps.setString(1, funcionario.getNomeFuncionario());
            ps.setString(2, funcionario.getrG());
            ps.setString(3, funcionario.getcPF());
            ps.setString(4, funcionario.getTelefone());
            ps.setString(5, funcionario.getCargo());
            ps.setDate(6, funcionario.getDtCadastro());
            ps.setDate(7, funcionario.getDtDemissao());
            ps.setString(8, funcionario.getEndereço());
            ps.setInt(10, funcionario.getIdFuncionario());
            ps.setInt(9, funcionario.getStatus());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente Alterado com Sucesso"); 
        } catch (Exception e) {
        System.out.println("ERRO no alterar-Cliente:" + e.getMessage());//identifica onde esta o ERRO
        }//fim catch
        
        
    }//Fim inserirCliente
    public ResultSet pesquisarFuncionarioPorNome(String nome){
            ResultSet rs = null;
            ConectaBd conexao = new ConectaBd();
            con = conexao.obterConexao();
            try{
                String sql = "Select * from funcionarios where nomefuncionario like ?";
                ps = con.prepareCall(sql);
                ps.setString(1, "%" + nome + "%");
                rs = ps.executeQuery();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "ERRO AO PESQUISAR!");
                System.out.println(e.getMessage());
            }
            return rs;
        }//fim do método pesquisarClientePorNome
   
}
