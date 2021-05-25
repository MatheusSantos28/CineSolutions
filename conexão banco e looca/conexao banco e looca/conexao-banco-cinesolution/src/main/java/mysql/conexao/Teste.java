/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.conexao;

import api.looca.ApiLooca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author luik
 */
public class Teste {
    /*
    usoProcessador = dados.usoProcessador();
        usoRam = dados.usoRam();
        usoDisco1 = dados.usoDisco1();
        usoDisco2 = dados.usoDisco2();
        totalDiscoDisponivel1 = dados.totalDisco1();
        totalDiscoDisponivel2 = dados.totalDisco2();
        totalRamDisponivel = dados.totalDisponivelRam();
        data = dados.data();
    */
 
    public static void main(String[] args) {
        
        ApiLooca dados = new ApiLooca();
        try {
            // create a mysql database connection
            String url = "jdbc:mysql://localhost/cinesolutions";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "urubu100");

        
            // the mysql insert statement
            String query = "insert into tb_uso (uso_disco, disco_disponivel, uso_ram, ram_disponivel, data_uso, fk_maquina, uso_disco2, disco_disponivel2) values (?,?,?,?,?,?,?,?)";

            
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            preparedStmt.setDouble(1, dados.usoDisco1());
            preparedStmt.setDouble(2, dados.totalDisco1());
            preparedStmt.setDouble(3, dados.usoRam());
            preparedStmt.setDouble(4, dados.totalDisponivelRam());
            preparedStmt.setString(5, dados.data());
            preparedStmt.setInt(6, 1);
            preparedStmt.setDouble(7, dados.usoDisco2());
            preparedStmt.setDouble(8, dados.totalDisco2());
   
            
            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
