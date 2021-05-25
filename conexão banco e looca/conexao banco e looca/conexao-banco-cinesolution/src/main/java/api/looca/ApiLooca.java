/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.looca;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.servicos.ServicosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author luik
 */
public class ApiLooca {

    Looca looca = new Looca();

    Sistema sistema = looca.getSistema();
    Memoria memoria = looca.getMemoria();
    Processador processador = looca.getProcessador();
    Temperatura temperatura = looca.getTemperatura();
    DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
    ServicosGroup grupoDeServicos = looca.getGrupoDeServicos();
    ProcessosGroup grupoDeProcessos = looca.getGrupoDeProcessos();

    public String nomeSistemaOperacional(){
        return sistema.getSistemaOperacional();
    }
    
    public Double usoProcessador() {
        return Double.valueOf((String.format("%.1f", processador.getUso())).replaceAll(",", "."));
    }
    
    public String nomeProcessador(){
        return processador.getNome();
    }

    public Double totalDisco1() {
        return Double.valueOf((grupoDeDiscos.getVolumes().get(0).getTotal()) / 1000000000);
    }

    public Double totalDisco2() {
        if (grupoDeDiscos.getVolumes().size() > 1) {
            return Double.valueOf((grupoDeDiscos.getVolumes().get(1).getTotal()) / 1000000000);
        } else {
            return 0.0;
        }
    }

    public Double totalDisponivelDisco1() {
        if (grupoDeDiscos.getVolumes().size() < 1) {
            return 0.0;
        } else {
            return Double.valueOf(grupoDeDiscos.getVolumes().get(0).getDisponivel() / 1000000000);
        }
    }

    public Double totalDisponivelDisco2() {
        if (grupoDeDiscos.getVolumes().size() > 1) {
            return Double.valueOf(grupoDeDiscos.getVolumes().get(1).getDisponivel() / 1000000000);
        } else {
            return 0.0;
        }
    }

    public Double usoDisco1() {
        if (grupoDeDiscos.getVolumes().size() < 1) {
            return 0.0;
        } else {
            Double total = this.totalDisco1();
            Double totalDisponivel = this.totalDisponivelDisco1();
            return Double.valueOf(String.format("%.1f", ((total - totalDisponivel) * 100) / total).replaceAll(",", "."));
        }

    }

    public Double usoDisco2() {
        if (grupoDeDiscos.getVolumes().size() > 1) {
            Double total = this.totalDisco2();
            Double totalDisponivel = this.totalDisponivelDisco2();
            return Double.valueOf(String.format("%.1f", ((total - totalDisponivel) * 100) / total).replaceAll(",", "."));
        } else {
            return 0.0;
        }
    }
    
    public Double totalRam(){
        return Double.valueOf(memoria.getTotal() / 1000000000);
    }

    public Double totalDisponivelRam() {
        return Double.valueOf(memoria.getDisponivel() / 1000000000);
    }

    public Double usoRam() {
        return Double.valueOf(String.format("%.1f", Double.valueOf(memoria.getEmUso() * 100 / memoria.getTotal())).replaceAll(",", "."));
    }

    public String data() {
        Date dataDeHoje;
        dataDeHoje = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(dataDeHoje);
    }
}
