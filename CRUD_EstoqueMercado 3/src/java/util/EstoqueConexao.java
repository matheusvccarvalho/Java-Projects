/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author famyo
 */
public class EstoqueConexao {
    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        //Verificar em seu computador
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/estoqueconexao"; //Verificar em seu computador
        String USERNAME = "root"; //Verificar em seu computador
        String PASSWORD = "200320031932fff"; //Verificar em seu computador
        
        // O método forName carrega e inicia o driver passado por parâmetro
        Class.forName(DRIVER);
        // Estabelecendo a conexão
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
}
