package utils;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;

import models.Evento;

public class Utils {

    public static int exibirMenu(ArrayList<String> opcoesMenu) {
        // Converte ArrayList para array de String
        String[] opcoesArray = opcoesMenu.toArray(new String[0]);

        // Lista com as opções
        JList<String> listaOpcoes = new JList<>(opcoesArray);
        listaOpcoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaOpcoes.setVisibleRowCount(Math.min(opcoesArray.length, 10));
        listaOpcoes.setFont(new Font("Arial", Font.PLAIN, 18));

        // Painel com rolagem
        JScrollPane scrollPane = new JScrollPane(listaOpcoes);
        scrollPane.setPreferredSize(new Dimension(400, 220));

        // Exibição do diálogo
        int resposta = JOptionPane.showConfirmDialog(
                null,
                scrollPane,
                "Escolha um serviço:",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        // Retornos possíveis
        if (resposta == JOptionPane.OK_OPTION) {
            int selecionado = listaOpcoes.getSelectedIndex();
            return (selecionado != -1) ? selecionado : -2; // OK mas nada selecionado
        }

        return -1; // Cancelado
    }

    public static int exibirNomeEventos(ArrayList<Evento> eventos) {
        ArrayList<String> nomesEventos = new ArrayList<>();
        for (Evento evento : eventos) {
            nomesEventos.add(evento.getNome() + " - " + evento.getData());
        }

        return exibirMenu(nomesEventos);
    }
}
