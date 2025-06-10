package models;

import javax.swing.*;
import java.util.ArrayList;

public class Organizador implements Pessoa {
    private int id;
    private String nome;
    private int idade;
    private ArrayList<Evento> eventos;
    private String cargo;

    public Organizador(int id, String nome, int idade, String cargo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public static void criandoOrganizador(ArrayList<Organizador> organizadores){

        int idOrg = 0;

        String quantidadeOrg = JOptionPane.showInputDialog(null,"Digite a quantidade de organizadores:");

        while(!quantidadeOrg.matches("\\d+")){

            JOptionPane.showMessageDialog(null,"Digite uma quantidade válida.");

            quantidadeOrg = JOptionPane.showInputDialog(null,"Digite a quantidade de organizadores:");

        }

        int quantInt = Integer.parseInt(quantidadeOrg);

        //Criando os campos de texto dos dados do organizador
        JTextField nomeOrg = new JTextField();
        JTextField idadeOrg = new JTextField();
        JTextField cpfOrg = new JTextField();
        JTextField cargoOrg = new JTextField();

        JPanel painelOrganizador = new JPanel(new java.awt.GridLayout(4,2,3,5));
        painelOrganizador.add(new JLabel("Nome: "));
        painelOrganizador.add(nomeOrg);

        painelOrganizador.add(new JLabel("Idade: "));
        painelOrganizador.add(idadeOrg);

        painelOrganizador.add(new JLabel("CPF: "));
        painelOrganizador.add(cpfOrg);

        painelOrganizador.add(new JLabel("Cargo: "));
        painelOrganizador.add(cargoOrg);

        for(int i = 0; i < quantInt; i++){

            int infoOrg = JOptionPane.showConfirmDialog(null,painelOrganizador,
                    String.format("Informações do organizador %s:",i + 1),JOptionPane.OK_CANCEL_OPTION);

            String nome = nomeOrg.getText().trim();
            String idadeA = idadeOrg.getText().trim();
            String cpf = cpfOrg.getText().trim();
            String cargo = cargoOrg.getText().trim();

            while (nome.isEmpty() || idadeA.isEmpty() || cpf.isEmpty() || cargo.isEmpty() ||
                    (!nome.matches("[\\p{L} ]+") || !cargo.matches("[\\p{L} ]+") ||
                            !idadeA.matches("\\d+") || !cpf.matches("\\d+"))) {
                JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente.");

                infoOrg = JOptionPane.showConfirmDialog(null,painelOrganizador,
                        String.format("Informações do organizador %s:",i + 1),JOptionPane.OK_CANCEL_OPTION);

                nome = nomeOrg.getText().trim();
                idadeA = idadeOrg.getText().trim();
                cpf = cpfOrg.getText().trim();
                cargo = cargoOrg.getText().trim();
                int idade = Integer.parseInt(idadeA);

                Organizador organizador = new Organizador(idOrg++,nome,idade,cargo);

                organizadores.add(organizador);

            }

            nomeOrg.setText("");
            idadeOrg.setText("");
            cpfOrg.setText("");
            cargoOrg.setText("");
        }

    }
}

