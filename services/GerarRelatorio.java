package services;

import java.util.ArrayList;

import models.Evento;

public class GerarRelatorio {
    public static void gerarRelatorio(ArrayList<Evento> eventos) {
        int escolha = utils.Utils.exibirNomeEventos(eventos);

        if (escolha == -1)
            return;

        Evento evento = eventos.get(escolha);

        evento.gerarRelatorioParticipantes();
    }
}
