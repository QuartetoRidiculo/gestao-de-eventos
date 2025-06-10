import java.util.ArrayList;

import models.Colaborador;
import models.Evento;
import models.Organizador;
import utils.Utils;

public class Main {
    public static void main(String[] args) {
        ArrayList<Evento> eventos = new ArrayList<>();
        ArrayList<Organizador> organizadores = new ArrayList<>();
        ArrayList<Colaborador> colaboradores = new ArrayList<>();

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
                    Evento.criarEvento(organizadores,eventos);
                    break;
                case 1:
                    // Adicionar colaborador
                    Colaborador.adicionarColaborador(eventos,colaboradores);
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
                    // Gerar certificado
                    break;
                case 7:
                    // Gerar relatórios
                    break;
                default:
                    break;
            }
        }
    }
}