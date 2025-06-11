package services;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.Evento;

public class GerarRelatorio {
    public static void gerarRelatorio(ArrayList<Evento> eventos) {
        if (eventos == null || eventos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Não há eventos cadastrados.");
            return;
        }

        int escolha = utils.Utils.exibirNomeEventos(eventos);

        if (escolha == -1)
            return;

        Evento evento = eventos.get(escolha);

        evento.gerarRelatorioParticipantes();
    }
}
