/*
 * José Alison
 * Darllan Cabral
 * Gustavo Travassos
 * Rodrigo Silveira
*/

import java.util.ArrayList;

import models.Evento;
import models.Organizador;
import models.Participante;
import services.GerarCertificado;
import services.GerarRelatorio;
import utils.Utils;

public class Main {
    public static void main(String[] args) {
        ArrayList<Evento> eventos = new ArrayList<>();

        // EVENTO 1:

        ArrayList<Organizador> organizadores1 = new ArrayList<>();

        organizadores1.add(new Organizador("organizador1", 32, "dev front end"));
        organizadores1.add(new Organizador("organizador2", 23, "dev back end"));

        Evento evento1 = new Evento("evento1", "13/06/2025", "Unifacisa", organizadores1);

        ArrayList<Participante> participantes1 = new ArrayList<>();

        participantes1.add(new Participante("alison", 17));
        participantes1.add(new Participante("gustavo", 19));

        evento1.setParticipantes(participantes1);

        // EVENTO 2:

        ArrayList<Organizador> organizadores2 = new ArrayList<>();

        organizadores2.add(new Organizador("organizador1", 23, "dev fullstack"));

        Evento evento2 = new Evento("evento2", "17/02/2024", "IFPB", organizadores2);

        ArrayList<Participante> participantes2 = new ArrayList<>();

        participantes2.add(new Participante("darllan", 17));
        participantes2.add(new Participante("rodrigo", 19));

        // evento2.setParticipantes(participantes2);

        eventos.add(evento1);
        eventos.add(evento2);

        ArrayList<String> opcoesMenu = new ArrayList<>();

        opcoesMenu.add("Adicionar evento");
        opcoesMenu.add("Adicionar colaborador");
        opcoesMenu.add("Realizar inscrição no evento");
        opcoesMenu.add("Listar eventos");
        opcoesMenu.add("Listar colaboradores");
        opcoesMenu.add("Listar participantes");
        opcoesMenu.add("Gerar certificado");
        opcoesMenu.add("Gerar relatório de participantes por evento");

        int escolha = -2;

        while (escolha != -1) {
            escolha = Utils.exibirMenu(opcoesMenu);

            switch (escolha) {
                case 0:
                    // Adicionar evento
                    break;
                case 1:
                    // Adicionar colaborador
                    break;
                case 2:
                    // Realizar inscrição no evento
                    break;
                case 3:
                    // Listar eventos
                    break;
                case 4:
                    // Listar colaboradores
                    break;
                case 5:
                    // Listar participantes
                    break;
                case 6:
                    GerarCertificado.gerarCertificado(eventos);
                    break;
                case 7:
                    GerarRelatorio.gerarRelatorio(eventos);
                    break;
                default:
                    break;
            }
        }
    }
}