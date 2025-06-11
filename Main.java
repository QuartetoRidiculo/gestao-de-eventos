import java.util.ArrayList;

import models.Evento;
import services.CriarColaborador;
import services.CriarEvento;
import services.CriarParticipante;
import services.GerarCertificado;
import services.GerarRelatorio;
import services.Listar;
import utils.Utils;

public class Main {
    public static void main(String[] args) {
        ArrayList<Evento> eventos = new ArrayList<>();

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
                    CriarEvento.criarEvento(eventos);
                    break;
                case 1:
                    // Adicionar colaborador
                    CriarColaborador.adicionarColaborador(eventos);
                    break;
                case 2:
                    // Realizar inscrição no evento
                    CriarParticipante.criarParticipante(eventos);
                    break;
                case 3:
                    // Listar eventos
                    Listar.listarEventos(eventos);
                    break;
                case 4:
                    // Listar colaboradores
                    Listar.listarColaboradores(eventos);
                    break;
                case 5:
                    // Listar participantes
                    Listar.listarPartcipantes(eventos);
                    break;
                case 6:
                    // Gerar certificado
                    GerarCertificado.gerarCertificado(eventos);
                    break;
                case 7:
                    // Gerar relatórios
                    GerarRelatorio.gerarRelatorio(eventos);
                    break;
                default:
                    break;
            }
        }
    }
}