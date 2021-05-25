/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programinhassqlite;
 
import conexoes.ConexaoConfigSqlite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author bruno
 */
public class SelectSqlite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        ConexaoConfigSqlite conexaoSQLite = new ConexaoConfigSqlite();
        conexaoSQLite.conectar();
        ResultSet resultSet = null;
        Statement statement = null;
        
        
        
        
        String query = "select id, title as titulo FROM urls;";
        
        statement = conexaoSQLite.criarStatement();
        
        try{
            resultSet = statement.executeQuery(query);
            System.out.println(resultSet);
            while(resultSet.next()){
                System.out.println("Dados do históricos");
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("title"));
                System.out.println(resultSet.getTime("last_visit_time"));
                System.out.println(resultSet.getTimestamp("last_visit_time"));
                System.out.println(resultSet.getDate("last_visit_time"));
                System.out.println("------------------------");
                
                /*
                SELECT datetime(last_visit_time / 1000000 + (strftime('%s', '1601-01-01')), 'unixepoch', 'localtime')FROM urls;
                */
            }
        }catch (SQLException e){
            System.out.println("Algum erro");
        }finally{
            try{
                resultSet.close();
                statement.close();
                conexaoSQLite.desconectar();
            }catch(SQLException ex){
                System.out.println("Erro de fechamento");
            }
        }
        
    }
    
}
