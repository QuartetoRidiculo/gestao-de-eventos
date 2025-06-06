package utils;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

public class Utils {
    public static int exibirMenu(String[] opcoesMenu) {
        // Lista com as opções
        JList<String> listaOpcoes = new JList<>(opcoesMenu);
        listaOpcoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaOpcoes.setVisibleRowCount(Math.min(opcoesMenu.length, 10)); // evita tela muito longa
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

        // Se clicou OK e NÃO selecionou alguma opção
        if (resposta == JOptionPane.OK_OPTION && listaOpcoes.getSelectedIndex() == -1) {
            return -2;
        }

        // Se clicou OK e selecionou alguma opção
        if (resposta == JOptionPane.OK_OPTION && listaOpcoes.getSelectedIndex() != -1) {
            return listaOpcoes.getSelectedIndex();
        }

        // Cancelado ou nada selecionado
        return -1;
    }
}
