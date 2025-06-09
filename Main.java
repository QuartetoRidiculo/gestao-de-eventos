import java.util.ArrayList;

import models.Evento;
import models.Organizador;
import utils.Utils;

public class Main {
    public static void main(String[] args) {
        ArrayList<Evento> eventos = new ArrayList<>();
        ArrayList<Organizador> organizadores = new ArrayList<>();
  
        Organizador organizador1 = new Organizador(1, "organizador1", 32, "dev front end");
        Organizador organizador2 = new Organizador(2, "organizador2", 23, "dev back end");

        organizadores.add(organizador1);
        organizadores.add(organizador2);

        Evento evento1 = new Evento(1, "evento1", "13/06/2025", "Unifacista", organizadores);

        eventos.add(evento1);

        String[] opcoesMenu = {
                "Adicionar evento",
                "Adicionar colaborador",
                "Realizar inscrição no evento",
                "Listar eventos",
                "Listar colaboradores",
                "Listar participantes",
                "Gerar certificado",
                "Gerar relatórios"
        };

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