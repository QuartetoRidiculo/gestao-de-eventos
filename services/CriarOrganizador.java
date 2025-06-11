package services;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Organizador;

public class CriarOrganizador {
    public static void criarOrganizador(ArrayList<Organizador> organizadores) {
        String quantidadeOrg = JOptionPane.showInputDialog(null, "Digite a quantidade de organizadores:");

        while (!quantidadeOrg.matches("\\d+")) {

            JOptionPane.showMessageDialog(null, "Digite uma quantidade válida.");

            quantidadeOrg = JOptionPane.showInputDialog(null, "Digite a quantidade de organizadores:");

        }

        int quantInt = Integer.parseInt(quantidadeOrg);

        // Criando os campos de texto dos dados do organizador
        JTextField nomeOrg = new JTextField();
        JTextField idadeOrg = new JTextField();
        JTextField cpfOrg = new JTextField();
        JTextField cargoOrg = new JTextField();

        JPanel painelOrganizador = new JPanel(new java.awt.GridLayout(4, 2, 3, 5));
        painelOrganizador.add(new JLabel("Nome: "));
        painelOrganizador.add(nomeOrg);

        painelOrganizador.add(new JLabel("Idade: "));
        painelOrganizador.add(idadeOrg);

        painelOrganizador.add(new JLabel("CPF: "));
        painelOrganizador.add(cpfOrg);

        painelOrganizador.add(new JLabel("Cargo: "));
        painelOrganizador.add(cargoOrg);

        for (int i = 0; i < quantInt; i++) {

            JOptionPane.showConfirmDialog(null, painelOrganizador,
                    String.format("Informações do organizador %s:", i + 1), JOptionPane.OK_CANCEL_OPTION);

            String nome = nomeOrg.getText().trim();
            String idadeA = idadeOrg.getText().trim();
            String cpf = cpfOrg.getText().trim();
            String cargo = cargoOrg.getText().trim();

            while (nome.isEmpty() || idadeA.isEmpty() || cpf.isEmpty() || cargo.isEmpty() ||
                    (!nome.matches("[\\p{L} ]+") || !cargo.matches("[\\p{L} ]+") ||
                            !idadeA.matches("\\d+") || !cpf.matches("\\d+"))) {
                JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente.");

                JOptionPane.showConfirmDialog(null, painelOrganizador,
                        String.format("Informações do organizador %s:", i + 1), JOptionPane.OK_CANCEL_OPTION);

                nome = nomeOrg.getText().trim();
                idadeA = idadeOrg.getText().trim();
                cpf = cpfOrg.getText().trim();
                cargo = cargoOrg.getText().trim();
                int idade = Integer.parseInt(idadeA);

                Organizador organizador = new Organizador(nome, idade, cpf, cargo);

                organizadores.add(organizador);
            }

            nomeOrg.setText("");
            idadeOrg.setText("");
            cpfOrg.setText("");
            cargoOrg.setText("");
        }
    }
}
