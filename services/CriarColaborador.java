package services;

import java.util.ArrayList;

import javax.swing.*;

import models.Colaborador;
import models.Evento;
import utils.Utils;

public class CriarColaborador {
    public static void adicionarColaborador(ArrayList<Evento> eventos) {
        if (eventos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há eventos cadastrados.");
            return;

        }

        JTextField nomeColaborador = new JTextField();
        JTextField idadeCol = new JTextField();
        JTextField funcaoColaborador = new JTextField();

        JPanel painelOrganizadorCol = new JPanel(new java.awt.GridLayout(3, 2, 3, 5));
        painelOrganizadorCol.add(new JLabel("Nome do Colaborador: "));
        painelOrganizadorCol.add(nomeColaborador);

        painelOrganizadorCol.add(new JLabel("Idade do Colaborador: "));
        painelOrganizadorCol.add(idadeCol);

        painelOrganizadorCol.add(new JLabel("Função do Colaborador: "));
        painelOrganizadorCol.add(funcaoColaborador);

        String nome = "";
        int idade = 0;
        String funcao = "";
        boolean dadosValidos = false;

        while (!dadosValidos) {
            int infoCol = JOptionPane.showConfirmDialog(null, painelOrganizadorCol,
                    "Informações do colaborador", JOptionPane.OK_CANCEL_OPTION);

            if (infoCol != JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(null, "Cadastro cancelado.");
                break;
            }

            nome = nomeColaborador.getText().trim();
            String idadeTexto = idadeCol.getText().trim();
            funcao = funcaoColaborador.getText().trim();

            if (nome.isEmpty() || funcao.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Insira informações válidas.");
                continue;
            }

            try {
                idade = Integer.parseInt(idadeTexto);
                if (idade <= 0) {
                    JOptionPane.showMessageDialog(null, "Insira informações válidas.");
                    continue;
                }

                dadosValidos = true;

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira informações válidas.");
            }
        }

        ArrayList<Colaborador> colaboradores = new ArrayList<>();

        Colaborador colaborador = new Colaborador(nome, idade, funcao);

        colaboradores.add(colaborador);

        int escolha = Utils.exibirNomeEventos(eventos);

        if (escolha == -1)
            return;

        eventos.get(escolha).setColaboradores(colaboradores);
    }
}
