/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario.login;

import conexao.azure.Connector;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author luik
 */
public class Usuario {
    private String email;
    private String senha;

    Connector config = new Connector();
    JdbcTemplate con = new JdbcTemplate(config.getDataSource());

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Boolean validarLogin() {
        List listarLoginSenha = con.queryForList("select ds_email, ds_senha from tb_usuario where ds_email = '" + this.email + "' and ds_senha='" + this.senha + "'");
        return !listarLoginSenha.isEmpty();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
