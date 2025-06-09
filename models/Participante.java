package models;

import javax.swing.JOptionPane;


public class Participante {
    private static int contadorId = 1;

    private int id;
    private String nome;
    private int idade;
    private String cpf;
    private Evento[] eventos;

    public Participante(int id, String nome, int idade, String cpf) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.eventos = new Evento[0];
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public Evento[] getEventos() {
        return eventos;
    }

    public void setEventos(Evento[] eventos) {
        this.eventos = eventos;
    }

    public static Participante criarParticipante(Evento[] listaEventos) {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do participante:");
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome inválido. Operação cancelada.");
            return null;
        }

        String idadeStr;
        while (true) {
            idadeStr = JOptionPane.showInputDialog(null, "Digite a idade:");
            if (idadeStr == null) return null;
            if (idadeStr.trim().matches("\\d+")) break;
            else JOptionPane.showMessageDialog(null, "Digite somente números.");
        }
        int idade = Integer.parseInt(idadeStr.trim());

        String cpfStr;
        while (true) {
            cpfStr = JOptionPane.showInputDialog(null, "Digite o CPF:");
            if (cpfStr == null) return null;
            if (cpfStr.trim().matches("\\d+")) break;
            else JOptionPane.showMessageDialog(null, "Digite somente números.");
        }

        Participante novo = new Participante(contadorId++, nome.trim(), idade, cpfStr.trim());

        // Escolher evento
        if (listaEventos != null && listaEventos.length > 0) {
            String[] nomesEventos = new String[listaEventos.length];
            for (int i = 0; i < listaEventos.length; i++) {
                nomesEventos[i] = listaEventos[i].getNome() + " - " + listaEventos[i].getData();
            }

            String escolha = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha um evento para se inscrever:",
                    "Escolha de Evento",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    nomesEventos,
                    nomesEventos[0]
            );

            if (escolha != null) {
                for (Evento ev : listaEventos) {
                    String nomeCompleto = ev.getNome() + " - " + ev.getData();
                    if (nomeCompleto.equals(escolha)) {
                        Evento[] novoArray = new Evento[1];
                        novoArray[0] = ev;
                        novo.setEventos(novoArray);
                        break;
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null,
                "Participante cadastrado:\n" +
                        "ID: " + novo.getId() + "\n" +
                        "Nome: " + novo.getNome() + "\n" +
                        "Idade: " + novo.getIdade() + "\n" +
                        "CPF: " + novo.getCpf() + "\n" +
                        (novo.getEventos().length > 0 ? "Evento: " + novo.getEventos()[0].getNome() : "Nenhum evento escolhido")
        );

        return novo;
    }

    // Gera certificado
    public void gerarCertificado() {
        if (eventos.length == 0) {
            JOptionPane.showMessageDialog(null, "Este participante não está inscrito em nenhum evento.");
            return;
        }

        Evento evento = eventos[0];

        String certificado = "CERTIFICADO DE PARTICIPAÇÃO\n\n" +
                "Certificamos que " + nome + ",\n" +
                "portador do CPF " + cpf + ", com idade de " + idade + " anos,\n" +
                "participou do evento \"" + evento.getNome() + "\"\n" +
                "realizado em " + evento.getData() + ".\n\n" +
                "Parabéns pela sua participação!\n\n" +
                "______________________________\n" +
                "Organização do Evento";

        JOptionPane.showMessageDialog(null, certificado, "Certificado", JOptionPane.INFORMATION_MESSAGE);
    }

    // Busca nome
    public static void gerarCertificadoPorNome(String nomeBuscado, Participante[] participantes) {
        for (Participante p : participantes) {
            if (p != null && p.getNome().equalsIgnoreCase(nomeBuscado.trim())) {
                p.gerarCertificado();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Participante \"" + nomeBuscado + "\" não encontrado.");
    }
}

