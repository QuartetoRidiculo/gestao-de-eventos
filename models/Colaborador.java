package models;

import javax.swing.*;
import java.util.ArrayList;
import utils.Utils;

public class Colaborador implements Pessoa {
    private int id;
    private String nome;
    private int idade;
    private String funcao;
    private ArrayList<Evento> eventos;


    public Colaborador(int id, String nome, int idade, String funcao) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.funcao = funcao;
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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public static void adicionarColaborador(ArrayList<Evento> eventos,ArrayList<Colaborador> colaboradores){

        int idCol = 0;

        if(eventos.isEmpty()){

            JOptionPane.showMessageDialog(null,"Não há eventos cadastrados.");
            return;

        }

        JTextField nomeColaborador = new JTextField();
        JTextField idadeCol = new JTextField();
        JTextField funcaoColaborador = new JTextField();

        JPanel painelOrganizadorCol = new JPanel(new java.awt.GridLayout(3,2,3,5));
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

        Colaborador colaborador = new Colaborador(idCol++,nome,idade,funcao);

        ArrayList<Colaborador> colaboradoresA = new ArrayList<>();

        colaboradoresA.add(colaborador);

        int escolha = Utils.exibirNomeEventos(eventos);

        if(escolha == -1){

            return;

        }

        eventos.get(escolha).setColaboradores(colaboradoresA);






    }

}
