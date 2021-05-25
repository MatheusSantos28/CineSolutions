/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao.azure;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ms108
 */
public class ConnectionLocal {
    
    
     private BasicDataSource dataSource;
     private JdbcTemplate jdbcTemplate;

    public ConnectionLocal() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/cinesolutions");
        dataSource.setUsername("root");
        dataSource.setPassword("urubu100");
        //jdbc:sqlserver://cinesolutions.database.windows.net:1433;database=cinesolutions;user=cinesolutions@cinesolutions;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;
    }

    public Connection getDataSource() throws SQLException {
        return dataSource.getConnection();
    }

}
