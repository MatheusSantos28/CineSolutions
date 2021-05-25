        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.looca;

import conexao.azure.Connector;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author luik
 */
public class InsertUso {
    public static void main(String[] args) {

        Connector config = new Connector();

        ApiLooca dados = new ApiLooca();

        JdbcTemplate con = new JdbcTemplate(config.getDataSource());
        
        
        for (int i = 0; i < 100; i++) {
            System.out.println("inserindo dados...");
            //INSERT NO BANCO DE DADOS
            con.update("INSERT INTO tb_uso values (?,?,?,?,?,?,?,?,?)",
                    dados.usoProcessador(),
                    dados.usoDisco1(),
                    dados.totalDisponivelDisco1(),
                    dados.usoRam(),
                    dados.totalDisponivelRam(),
                    dados.data(),
                    16,
                    dados.usoDisco2(),
                    dados.totalDisponivelDisco2()
            );
        }
        System.out.println("Inserção concluída");
        
        
        /*
        con.update("INSERT INTO tb_maquina VALUES (?,?,?,?,?,?,?)",
                    "maquina-talita",
                    dados.processador.getNome(),
                    dados.sistema.getSistemaOperacional(),
                    8,
                    dados.totalDisco1(),
                    dados.totalRam(),
                    dados.totalDisco2()
                );
        System.out.println("Inserção tb_maquina concluída");
        */
    }
}
