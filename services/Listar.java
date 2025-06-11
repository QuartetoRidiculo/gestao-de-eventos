package services;

import models.Colaborador;
import models.Evento;
import models.Organizador;
import models.Participante;
import utils.Utils;

import javax.swing.*;
import java.util.ArrayList;

public class Listar {

    public static void listarEventos(ArrayList<Evento> eventos) {
        if (eventos == null || eventos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Não há eventos cadastrados.");
            return;
        }

        int eventoEscolhido = Utils.exibirNomeEventos(eventos);

        if (eventoEscolhido == -2) {
            JOptionPane.showMessageDialog(null, "Nenhuma opção selecionada, tente novamente!");
            return;
        }

        String organizadores = "";

        for (Organizador organizador : eventos.get(eventoEscolhido).getOrganizadores()) {
            organizadores += organizador.getNome();

            if (organizador == eventos.get(eventoEscolhido).getOrganizadores().getLast()) {
                organizadores += ".";
            } else {
                organizadores += ", ";
            }
        }

        JOptionPane.showMessageDialog(null, String.format(
                "Relatório de Participantes - Evento: %s\nData: %s\nLocal: %s\nOrganizador: %s\n\nTotal participantes: %s",
                eventos.get(eventoEscolhido).getNome(),
                eventos.get(eventoEscolhido).getData(),
                eventos.get(eventoEscolhido).getLocal(),
                organizadores,
                eventos.get(eventoEscolhido).getParticipantes().size()));
    }

    public static void listarPartcipantes(ArrayList<Evento> eventos) {
        if (eventos == null || eventos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Não há eventos cadastrados.");
            return;
        }

        int eventoEsclhido = Utils.exibirNomeEventos(eventos);

        ArrayList<Participante> participantes = eventos.get(eventoEsclhido).getParticipantes();

        if (participantes.size() == 0 || participantes == null) {
            JOptionPane.showMessageDialog(null, "Não há participantes cadastrados neste evento.");
            return;
        }

        String listaP = "";

        for (int c = 0; c < participantes.size(); c++) {
            listaP += participantes.get(c).getNome() + "\n";
        }
        JOptionPane.showMessageDialog(null, listaP);
    }

    public static void listarColaboradores(ArrayList<Evento> eventos) {
        if (eventos == null || eventos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Não há eventos cadastrados.");
            return;
        }

        int eventoEsclhido = Utils.exibirNomeEventos(eventos);

        ArrayList<Colaborador> colaboradores = eventos.get(eventoEsclhido).getColaboradores();

        if (colaboradores.size() == 0 || colaboradores == null) {
            JOptionPane.showMessageDialog(null, "Não há colaboradores cadastrados neste evento.");
            return;
        }

        String listaC = "";

        for (int c = 0; c < colaboradores.size(); c++) {
            listaC += colaboradores.get(c).getNome() + "\n";
        }
        JOptionPane.showMessageDialog(null, listaC);
    }
}
