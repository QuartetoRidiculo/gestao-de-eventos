package services;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.Evento;
import models.Participante;
import utils.Utils;

public class CriarParticipante {
    public static void criarParticipante(ArrayList<Evento> eventos) {
        if (eventos.isEmpty()) {
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

        String cpf;
        while (true) {
            cpf = JOptionPane.showInputDialog(null, "Digite o CPF:");
            if (cpf == null)
                return;
            if (cpf.trim().matches("\\d+"))
                break;
            else
                JOptionPane.showMessageDialog(null, "Digite somente números.");
        }

        Participante participante = new Participante(nome, idade, cpf);

        // Escolher evento
        if (eventos != null && eventos.size() > 0) {
            int escolha = Utils.exibirNomeEventos(eventos);

            if (escolha == -1)
                return;

            Evento evento = eventos.get(escolha);

            evento.adicionarParticipante(participante);

            JOptionPane.showMessageDialog(null,
                    "Participante cadastrado:\n" +
                            "Nome: " + participante.getNome() + "\n" +
                            "Idade: " + participante.getIdade() + "\n" +
                            "CPF: " + participante.getCpf() + "\n" +
                            "Evento: " + evento.getNome());
        }
    }
}
