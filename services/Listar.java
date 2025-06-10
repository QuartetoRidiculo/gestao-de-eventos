package services;

import models.Evento;
import models.Organizador;
import models.Participante;
import utils.Utils;

import javax.swing.*;
import java.util.ArrayList;

public class Listar {

    public static void listarEventos(ArrayList<Evento> eventos) {
        //---------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Laço de repetição que irá garantir que o usuario clique em alguma opção, caso o mesmo não clique, um pop-up informativo irá aparecerer para alertá-lo e voltará ao inicio.
            int eventoEscolhido = Utils.exibirNomeEventos(eventos);

            if(eventoEscolhido == -2){
                JOptionPane.showMessageDialog(null, "Nenhuma opção selecionada, tente novamente!");
                return;
            }

            JOptionPane.showMessageDialog(null, String.format(
                    "Relatório de Participantes - Evento: %s\nData: %s\nLocal: %s\nOrganizador: %s\n\nTotal participantes: %s",
                    eventos.get(eventoEscolhido).getNome(),
                    eventos.get(eventoEscolhido).getData(),
                    eventos.get(eventoEscolhido).getLocal(),
                    eventos.get(eventoEscolhido).getOrganizadores(),
                    eventos.get(eventoEscolhido).getParticipantes().size()));
    }

    public static void listarPartcipantes(ArrayList<Evento> eventos){

        int eventoEsclhido = Utils.exibirNomeEventos(eventos);

        ArrayList<Participante> participantes = eventos.get(eventoEsclhido).getParticipantes();
        String listaP = "";

        for (int c = 0; c < participantes.size(); c++) {
            listaP += participantes.get(c).getNome() + "\n";
        }
        JOptionPane.showMessageDialog(null,listaP);
    }
    
    public static void listarOrganizadores(ArrayList<Evento> eventos) {

        int eventoEsclhido = Utils.exibirNomeEventos(eventos);

        ArrayList<Organizador> organizadores = eventos.get(eventoEsclhido).getOrganizadores();
        String listaO = "";

        for (int c = 0; c < organizadores.size(); c++) {
            listaO += organizadores.get(c).getNome() + "\n";
        }
        JOptionPane.showMessageDialog(null, listaO);
    }
}

