import utils.Utils;

public class Main {
    public static void main(String[] args) {
        String[] opcoesMenu = {
                "Adicionar evento",
                "Adicionar colaborador",
                "Listar eventos",
                "Realizar inscrição no evento",
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
                    // Listar eventos
                    break;
                case 3:
                    // Realizar inscrição no evento
                    break;
                case 4:
                    // Gerar certificado
                    break;
                case 5:
                    // Gerar relatórios
                    break;
                default:
                    break;
            }
        }
    }
}