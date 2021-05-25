/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao.azure;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author luik
 */
public class Connector {

    private BasicDataSource dataSource;

    public Connector() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://cinesolutions.database.windows.net:1433;database=cinesolutions");
        dataSource.setUsername("cinesolutions@cinesolutions");
        dataSource.setPassword("#Gfgrupo6");
        //jdbc:sqlserver://cinesolutions.database.windows.net:1433;database=cinesolutions;user=cinesolutions@cinesolutions;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }

}
