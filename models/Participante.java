package models;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Participante {
    private static int contadorId = 1;

    private int id;
    private String nome;
    private int idade;
    private String cpf;
    private ArrayList<Evento> eventos;

    public Participante(int id, String nome, int idade, String cpf) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.eventos = new ArrayList<>();
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

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public static void criarParticipante(ArrayList<Evento> listaEventos) {
        if (listaEventos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há eventos cadastrados.");
           return;
        }

        String nome = JOptionPane.showInputDialog(null, "Digite o nome do participante:");
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome inválido. Operação cancelada.");
            return;
        }

        String idadeStr;
        while (true) {
            idadeStr = JOptionPane.showInputDialog(null, "Digite a idade:");
            if (idadeStr == null)
                return;
            if (idadeStr.trim().matches("\\d+"))
                break;
            else
                JOptionPane.showMessageDialog(null, "Digite somente números.");
        }
        int idade = Integer.parseInt(idadeStr.trim());

        String cpfStr;
        while (true) {
            cpfStr = JOptionPane.showInputDialog(null, "Digite o CPF:");
            if (cpfStr == null)
                return;
            if (cpfStr.trim().matches("\\d+"))
                break;
            else
                JOptionPane.showMessageDialog(null, "Digite somente números.");
        }

        Participante novo = new Participante(contadorId++, nome.trim(), idade, cpfStr.trim());

        // Escolher evento
        if (listaEventos != null && listaEventos.size() > 0) {
            String[] nomesEventos = new String[listaEventos.size()];
            for (int i = 0; i < listaEventos.size(); i++) {
                nomesEventos[i] = listaEventos.get(i).getNome() + " - " + listaEventos.get(i).getData();
            }

            String escolha = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha um evento para se inscrever:",
                    "Escolha de Evento",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    nomesEventos,
                    nomesEventos[0]);

            if (escolha != null) {
                for (Evento ev : listaEventos) {
                    String nomeCompleto = ev.getNome() + " - " + ev.getData();
                    if (nomeCompleto.equals(escolha)) {
                        novo.getEventos().add(ev);
                        ev.adicionarParticipante(novo);
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
                        (novo.getEventos().size() > 0 ? "Evento: " + novo.getEventos().get(0).getNome()
                                : "Nenhum evento escolhido"));
    }
}