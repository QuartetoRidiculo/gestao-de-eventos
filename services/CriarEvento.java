package services;

import java.util.ArrayList;

import javax.swing.*;

import models.Evento;
import models.Organizador;

public class CriarEvento {
    public static void criarEvento(ArrayList<Evento> eventos) {
        ArrayList<Organizador> organizadores = new ArrayList<>();

        String quantidadeOrg = JOptionPane.showInputDialog(null, "Digite a quantidade de organizadores:");

        if (quantidadeOrg == null)
            return;

        while (!quantidadeOrg.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Digite uma quantidade válida.");

            quantidadeOrg = JOptionPane.showInputDialog(null, "Digite a quantidade de organizadores:");

            if (quantidadeOrg == null)
                return;
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
            while (true) {
                int infoOrg = JOptionPane.showConfirmDialog(null, painelOrganizador,
                        String.format("Informações do organizador %s:", i + 1), JOptionPane.OK_CANCEL_OPTION);

                if (infoOrg != JOptionPane.OK_OPTION) {
                    String novaQuantidade = JOptionPane.showInputDialog(null, "Digite a quantidade de organizadores:");

                    if (novaQuantidade == null)
                        return;

                    while (!novaQuantidade.matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "Digite uma quantidade válida.");
                        novaQuantidade = JOptionPane.showInputDialog(null, "Digite a quantidade de organizadores:");
                        if (novaQuantidade == null)
                            return;
                    }

                    quantInt = Integer.parseInt(novaQuantidade);
                    i = -1;
                    break;
                }

                String nome = nomeOrg.getText().trim();
                String idadeA = idadeOrg.getText().trim();
                String cpf = cpfOrg.getText().trim();
                String cargo = cargoOrg.getText().trim();

                if (nome.isEmpty() || idadeA.isEmpty() || cpf.isEmpty() || cargo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
                    continue;
                }

                if (!nome.matches("[\\p{L} ]+")) {
                    JOptionPane.showMessageDialog(null, "Nome inválido.");
                    continue;
                }

                if (!cargo.matches("[\\p{L} ]+")) {
                    JOptionPane.showMessageDialog(null, "Cargo inválido.");
                    continue;
                }

                if (!idadeA.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Idade inválida.");
                    continue;
                }

                if (!cpf.matches("\\d{11}")) {
                    JOptionPane.showMessageDialog(null, "CPF inválido.");
                    continue;
                }

                int idade = Integer.parseInt(idadeA);

                Organizador organizador = new Organizador(nome, idade, cpf, cargo);
                organizadores.add(organizador);

                // Limpa os campos
                nomeOrg.setText("");
                idadeOrg.setText("");
                cpfOrg.setText("");
                cargoOrg.setText("");
                break;
            }
        }

        // Criando evento
        String nomeEvento = JOptionPane.showInputDialog(null, "Digite o nome do evento:");

        if (nomeEvento == null)
            return;

        while (nomeEvento.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor, insira o nome do evento.");

            nomeEvento = JOptionPane.showInputDialog(null, "Digite o nome do evento:");

            if (nomeEvento == null)
                return;

        }

        String data = "";

        // Criando os campos do texto da data
        JTextField diaA = new JTextField();
        JTextField mesB = new JTextField();
        JTextField anoC = new JTextField();

        JPanel painelData = new JPanel(new java.awt.GridLayout(3, 2, 3, 5));
        painelData.add(new JLabel("Dia:"));
        painelData.add(diaA);

        painelData.add(new JLabel("Mês:"));
        painelData.add(mesB);

        painelData.add(new JLabel("Ano:"));
        painelData.add(anoC);

        int dataDigito = JOptionPane.showConfirmDialog(null, painelData, "Digite a data:",
                JOptionPane.OK_CANCEL_OPTION);

        if (dataDigito == -1)
            return;

        if (dataDigito == JOptionPane.OK_OPTION) {
            while (true) {
                String dia = diaA.getText().trim();
                String mes = mesB.getText().trim();
                String ano = anoC.getText().trim();

                boolean valido = true;

                if (dia.isEmpty() || mes.isEmpty() || ano.isEmpty() || !dia.matches("\\d+") || !mes.matches("\\d+")
                        || !ano.matches("\\d+")) {
                    valido = false;
                }

                int d = 0, m = 0, a = 0;
                if (valido) {
                    d = Integer.parseInt(dia);
                    m = Integer.parseInt(mes);
                    a = Integer.parseInt(ano);

                    if (m < 1 || m > 12 || d < 1 || a < 1) {
                        valido = false;
                    } else {
                        int[] diasPorMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

                        if ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0)) {
                            diasPorMes[1] = 29;
                        }

                        if (d > diasPorMes[m - 1]) {
                            valido = false;
                        }
                    }
                }

                if (!valido) {
                    JOptionPane.showMessageDialog(null, "Data inválida. Tente novamente.");
                    dataDigito = JOptionPane.showConfirmDialog(null, painelData, "Digite a data:",
                            JOptionPane.OK_CANCEL_OPTION);

                    if (dataDigito == -1)
                        return;

                    if (dataDigito != JOptionPane.OK_OPTION) {
                        System.exit(0);
                    }
                } else {
                    data = String.format("%02d/%02d/%04d", d, m, a);
                    break;
                }
            }
        }

        String local = JOptionPane.showInputDialog(null, "Digite o nome do local: ");

        if (local == null)
            return;

        while (local.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor, insira o local.");

            local = JOptionPane.showInputDialog(null, "Digite o nome do local: ");

            if (local == null)
                return;
        }

        Evento evento = new Evento(nomeEvento, data, local, organizadores);

        eventos.add(evento);
    }
}
