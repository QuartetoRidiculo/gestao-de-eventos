package actions;

import models.Evento;
import models.Participante;
import utils.Utils;

import javax.swing.*;
import java.util.ArrayList;

public class GerarCertificado {
    public static void gerarCertificado(ArrayList<Evento> eventos) {
        if (eventos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há eventos cadastrados.");
            return;
        }

        String nome = JOptionPane.showInputDialog(null, "Informe o nome do participante:");
        if (nome == null || nome.trim().isEmpty()) return;

        // Lista os nomes dos eventos para seleção
        ArrayList<String> nomesEventos = new ArrayList<>();
        for (Evento ev : eventos) {
            nomesEventos.add(ev.getNome() + " - " + ev.getData());
        }

        int evEscolhido = Utils.exibirMenu(nomesEventos);
        if (evEscolhido == -1) return;

        Evento evento = eventos.get(evEscolhido);
        ArrayList<Participante> participantes = evento.getParticipantes();
        Participante participante = null;

        for (Participante p : participantes) {
            if (p.getNome().equalsIgnoreCase(nome.trim())) {
                participante = p;
                break;
            }
        }

        if (participante == null) {
            JOptionPane.showMessageDialog(null, "Participante não encontrado neste evento.");
            return;
        }

        String certificado = "CERTIFICADO DE PARTICIPAÇÃO\n\n" +
                "Certificamos que " + participante.getNome() + ",\n" +
                "portador do CPF " + participante.getCpf() + ", com idade de " + participante.getIdade() + " anos,\n" +
                "participou do evento \"" + evento.getNome() + "\"\n" +
                "realizado em " + evento.getData() + ".\n\n" +
                "Parabéns pela sua participação!\n\n" +
                "______________________________\n" +
                "Organização do Evento";

        JOptionPane.showMessageDialog(null, certificado, "Certificado", JOptionPane.INFORMATION_MESSAGE);
    }
}
