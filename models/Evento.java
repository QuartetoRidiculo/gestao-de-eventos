package models;

import javax.swing.*;
import java.util.ArrayList;

public class Evento implements EventoInterface {
    private int id;
    private String nome;
    private String data;
    private String local;
    private ArrayList<Organizador> organizadores;
    private ArrayList<Participante> participantes;
    private ArrayList<Colaborador> colaboradores;

    public Evento(int id, String nome, String data, String local, ArrayList<Organizador> organizadores) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.organizadores = organizadores;
        this.participantes = new ArrayList<>();
        this.colaboradores = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public ArrayList<Organizador> getOrganizadores() {
        return organizadores;
    }

    public void setOrganizadores(ArrayList<Organizador> organizadores) {
        this.organizadores = organizadores;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    public ArrayList<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(ArrayList<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public static void criarEvento(ArrayList<Organizador> organizadores, ArrayList<Evento> eventos) {

        int idOrg = 0;
        int idEve = 0;

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

            int infoOrg = JOptionPane.showConfirmDialog(null, painelOrganizador,
                    String.format("Informações do organizador %s:", i + 1), JOptionPane.OK_CANCEL_OPTION);

            String nome = nomeOrg.getText().trim();
            String idadeA = idadeOrg.getText().trim();
            String cpf = cpfOrg.getText().trim();
            String cargo = cargoOrg.getText().trim();
            int idade = Integer.parseInt(idadeA);

            while (nome.isEmpty() || idadeA.isEmpty() || cpf.isEmpty() || cargo.isEmpty() ||
                    (!nome.matches("[\\p{L} ]+") || !cargo.matches("[\\p{L} ]+") ||
                            !idadeA.matches("\\d+") || !cpf.matches("\\d{11}"))) {
                JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente.");

                infoOrg = JOptionPane.showConfirmDialog(null, painelOrganizador,
                        String.format("Informações do organizador %s:", i + 1), JOptionPane.OK_CANCEL_OPTION);

                nome = nomeOrg.getText().trim();
                idadeA = idadeOrg.getText().trim();
                cpf = cpfOrg.getText().trim();
                cargo = cargoOrg.getText().trim();
                idade = Integer.parseInt(idadeA);
            }

            Organizador organizador = new Organizador(nome, idade, idOrg++, cargo);

            organizadores.add(organizador);

            nomeOrg.setText("");
            idadeOrg.setText("");
            cpfOrg.setText("");
            cargoOrg.setText("");
        }

        // Criando evento
        String nomeEvento = JOptionPane.showInputDialog(null, "Digite o nome do evento:");

        while (nomeEvento.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor, insira o nome do evento.");

            nomeEvento = JOptionPane.showInputDialog(null, "Digite o nome do evento:");

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

        while (local.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Por favor, insira o local.");

            local = JOptionPane.showInputDialog(null, "Digite o nome do local: ");

        }

        Evento evento = new Evento(idEve++, nomeEvento, data, local, organizadores);

        eventos.add(evento);

    }

    public void adicionarParticipante(Participante novo) {

        participantes.add(novo);

    }

    public void gerarRelatorioParticipantes() {
        String relatorio = "Relatório de Participantes do Evento: " + nome + "\n";
        if (participantes == null || participantes.isEmpty()) {
            relatorio += "Nenhum participante cadastrado.";
            JOptionPane.showMessageDialog(null, relatorio);
            return;
        }

        String listaDeParticipantes = "";

        for (Participante p : participantes) {
            listaDeParticipantes += "- " + p.getNome() + "\n";
        }

        relatorio += listaDeParticipantes;

        JOptionPane.showMessageDialog(null, relatorio);
    }
}
