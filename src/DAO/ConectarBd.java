/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vidal
 */
public class ConectarBd {
        public Connection conexao;
    
    public ConectarBd(){
        carregarDriver();
    }
    public void carregarDriver()
    {
        try{
          Class.forName("org.postgresql.Driver");
        }
        catch(ClassNotFoundException e){
            System.out.println("Erro ao carregar o driver");
        }
    }
    public Connection obterConexao(){
        try{
            String host = "jdbc:postgresql://localhost:5432/lanchonete";
            String usuario = "postgres";
            String senha = "admin";
            conexao = DriverManager.getConnection(host, usuario, senha);
            System.out.println("Conectado ao BD com sucesso");
    }
    catch(SQLException e){
        System.out.println("Erro de conexao com o BD");
        System.out.println(e.getMessage()); 
    }
        return conexao;
}  
    
}
    
