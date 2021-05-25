/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao.azure;

import java.util.List;
import java.util.Map;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author luik
 */
public class ConexaoBanco {
    //Atributo e construtor inicio.
    private JdbcTemplate jdbcTemplate;
    
    private ConexaoBanco(){
        BasicDataSource dataSource = new BasicDataSource();
        
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    //Atributo e construtor fim.
    
    //Inicio Select.
    public List listarTodos(){
        List<Map<String, Object>> lista = jdbcTemplate.queryForList("select * from tb_maquina");
        return lista;
    }
}
