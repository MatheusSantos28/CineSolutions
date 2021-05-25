/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite.conexao;
 
import conexao.azure.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author luik
 */
public class SelectSqlite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connector config = new Connector();
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());
        ConexaoConfigSqlite conexaoSQLite = new ConexaoConfigSqlite();
        conexaoSQLite.conectar();
        ResultSet resultSet = null;
        Statement statement = null;
        
        
        
        
        //String query = "select * from urls;";
        String query = "SELECT id, title as titulo, datetime(last_visit_time / 1000000 + (strftime('%s', '1601-01-01')), 'unixepoch', 'localtime') as data_hora FROM urls;";
    
        statement = conexaoSQLite.criarStatement();
        
        try{
            resultSet = statement.executeQuery(query);
            System.out.println(resultSet);
            /*
            con.update("TRUNCATE TABLE tb_historico");
            while(resultSet.next()){
              
                System.out.println("Dados do históricos");
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("titulo"));
                System.out.println(resultSet.getString("data_hora"));
                System.out.println("------------------------");
                
                
                con.update("INSERT INTO tb_historico values (?,?,?)",
                    resultSet.getString("titulo"),
                    resultSet.getString("data_hora"),
                    16
                );
                
                SELECT datetime(last_visit_time / 1000000 + (strftime('%s', '1601-01-01')), 'unixepoch', 'localtime')FROM urls;
                
            }
            */
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
